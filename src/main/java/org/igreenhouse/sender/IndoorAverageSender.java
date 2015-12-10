package org.igreenhouse.sender;

import org.igreenhouse.service.DataInService;
import org.igreenhouse.service.DataOutService;
import org.igreenhouse.service.DataProcessService;

import java.sql.Timestamp;
import java.util.TimerTask;

/**
 * Created by AllenKO on 2015/10/30.
 * 发送室外数据采集命令相关的类
 */
public class IndoorAverageSender extends TimerTask {
    /**
     * 向串口发送获取室外数据命令
     */
    private void getandsaveAverageData() {
        DataInService.saveIndoor(DataProcessService.indoorDataProcess());
        System.out.println("Get & Save indoor average data successfully at "+ new Timestamp(System.currentTimeMillis()));
    }

    @Override
    public void run() {
        getandsaveAverageData();
    }
}
