package com.lewis.bohconfig.zk;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.cache.*;
import org.apache.curator.framework.recipes.locks.InterProcessMutex;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.data.Stat;
import org.springframework.stereotype.Component;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.CountDownLatch;

/**
 * Created by zhangminghua on 2017/1/7.
 */
@Component
public class ZKManager {
    private final CuratorFramework client;

    private ZKManager() {
        client = CuratorFrameworkFactory.builder().connectString("localhost:2181").retryPolicy(new ExponentialBackoffRetry(2000, 3))
                .sessionTimeoutMs(60 * 1000).connectionTimeoutMs(15 * 1000).namespace("bohSwitch").build();
        client.start();
    }

    public void createPersistentNode(String path, String data) {
        try {
            Stat stat = client.checkExists().forPath(path);
            if (stat == null) {
                client.create().creatingParentsIfNeeded().withMode(CreateMode.PERSISTENT).forPath(path, data.getBytes("utf-8"));
            } else {
                System.out.println(path + " 节点已经存在！不要重复创建！");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void createEphemeralNode(String path,String data){
        try {
            Stat stat = client.checkExists().forPath(path);
            if (stat == null) {
                client.create().creatingParentsIfNeeded().withMode(CreateMode.EPHEMERAL).forPath(path, data.getBytes("utf-8"));
            } else {
                System.out.println(path + " 节点已经存在！不要重复创建！");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setData(String path,String data){
        try {
            client.setData().forPath(path,data.getBytes("utf-8"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteNodeIncludeChildren(String path) {
        try {
            client.delete().deletingChildrenIfNeeded().forPath(path);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteNode(String path) {
        try {
            client.delete().forPath(path);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String readNode(String path) {
        try {
            byte[] bytes = client.getData().forPath(path);
            return new String(bytes, "utf-8");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    public static void main(String[] args) throws Exception {
        ZKManager zkManager = new ZKManager();
      /*  String path = "/jiangsu/nanjing";
        //testGenOrderNo();
        //distributionLock(zkManager.client,path);
        testPathChildCache(zkManager,path);*/
        String path ="/varParam";
        zkManager.deleteNodeIncludeChildren(path);
    }

    private static void testGenOrderNo(){
        final CountDownLatch latch = new CountDownLatch(1);
        for (int i = 0; i < 10; i++) {
            new Thread(){
                @Override
                public void run() {
                    try {
                        latch.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss|SSS");
                    String orderNo = sdf.format(new Date());
                    System.out.println("订单号："+orderNo);
                }
            }.start();
        }
        latch.countDown();
    }

    public static void distributionLock(CuratorFramework client,String path){
        final InterProcessMutex lock = new InterProcessMutex(client,path);
        final CountDownLatch latch = new CountDownLatch(1);
        for (int i = 0; i < 10; i++) {
            new Thread(){
                @Override
                public void run() {
                    try {
                        latch.await();
                        lock.acquire();
                    }catch (Exception e) {
                        e.printStackTrace();
                    }
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss|SSS");
                    String orderNo = sdf.format(new Date());
                    System.out.println("订单号："+orderNo);
                    try {
                        lock.release();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }.start();
        }
        latch.countDown();
    }

    private static void testPathChildCache(final ZKManager zkManager, final String path) throws Exception {
        PathChildrenCache cache = new PathChildrenCache(zkManager.client,path,true);
        cache.start(PathChildrenCache.StartMode.POST_INITIALIZED_EVENT);
        cache.getListenable().addListener(new PathChildrenCacheListener() {
            public void childEvent(CuratorFramework client, PathChildrenCacheEvent event) throws Exception {
                switch (event.getType()){
                    case CHILD_ADDED:
                        System.out.println("子节点新增 :"+event.getData().getPath());
                        break;
                    case CHILD_REMOVED:
                        System.out.println("子节点移除 :"+event.getData().getPath());
                        break;
                    case CHILD_UPDATED:
                        String s = zkManager.readNode(path + "/xuanwuqu");
                        System.out.println("子节点更新 :"+event.getData().getPath() +" ,new Data:"+s);
                        break;
                    default:
                        break;
                }
            }
        });
        zkManager.createEphemeralNode(path,"nanjing");
        Thread.sleep(1000);
        zkManager.createEphemeralNode(path+"/xuanwuqu","xuanwuqu");
        Thread.sleep(1000);
        zkManager.setData(path+"/xuanwuqu","xuanwuqubianle");
        zkManager.deleteNodeIncludeChildren(path+"/xuanwuqu");
        zkManager.deleteNodeIncludeChildren(path);
        Thread.sleep(2000);
    }

    private static void testNodeCache(ZKManager zkManager, String path) throws Exception {
        zkManager.createEphemeralNode(path,"nanjing");
        final NodeCache nodeCache = new NodeCache(zkManager.client,path,false);
        nodeCache.start();
        nodeCache.getListenable().addListener(new NodeCacheListener() {
            public void nodeChanged() throws Exception {
                System.out.println("节点数据发生改变,新数据为:"+ new String(nodeCache.getCurrentData().getData()));
            }
        });
        zkManager.setData(path,"jiangling");
        Thread.sleep(1000);
        zkManager.deleteNodeIncludeChildren(path);
        Thread.sleep(5000);
    }


}
