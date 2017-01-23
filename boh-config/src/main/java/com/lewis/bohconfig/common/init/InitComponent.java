package com.lewis.bohconfig.common.init;

import com.lewis.bohconfig.common.business.SwitchWrapperUtil;
import com.lewis.bohconfig.common.domain.ZKNode;
import com.lewis.bohconfig.common.enumer.OperationEnum;
import com.lewis.bohconfig.common.util.ListUtil;
import com.lewis.bohconfig.domain.BohSwitchDO;
import com.lewis.bohconfig.service.BohSwitchService;
import com.lewis.bohconfig.zk.ZKManager;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;
import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by zhangminghua on 2017/1/22.
 */
@Component
public class InitComponent implements InitializingBean {

    @Resource
    private BohSwitchService bohSwitchService;

    @Resource
    private ZKManager zkManager;

    public void afterPropertiesSet() throws Exception {
        Thread t = new Thread("boh-cnf_init"){
            @Override
            public void run() {
                init();
            }
        };
        t.start();
    }

    private void init() {
        try {
            while (bohSwitchService == null) {
                TimeUnit.MILLISECONDS.sleep(50);
            }
            List<BohSwitchDO> allBohSwitches = bohSwitchService.getAllBohSwitch();
            if (ListUtil.isNotEmpty(allBohSwitches)) {
                System.out.println("【BOH-CNF 启动 检查DB和ZK上数据同步】 start");
                for (BohSwitchDO bohSwitchDO : allBohSwitches) {
                    ZKNode zkNode = SwitchWrapperUtil.wrapper(bohSwitchDO, OperationEnum.QUERY);
                    zkManager.createPersistentNode(zkNode.getPath(),zkNode.getData());
                }
                System.out.println("【BOH-CNF 启动 检查DB和ZK上数据同步】 end");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
