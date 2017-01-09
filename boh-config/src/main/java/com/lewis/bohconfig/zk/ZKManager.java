package com.lewis.bohconfig.zk;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.data.Stat;
import org.springframework.stereotype.Component;

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

    public void createNode(String path, String data) {
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

    public void deleteNode(String path) {
        try {
            client.delete().deletingChildrenIfNeeded().forPath(path);
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


}
