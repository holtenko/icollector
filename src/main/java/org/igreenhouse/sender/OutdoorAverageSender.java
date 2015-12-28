package org.igreenhouse.sender;

import gnu.io.SerialPort;
import org.igreenhouse.domain.Indoor;
import org.igreenhouse.domain.Outdoor;
import org.igreenhouse.service.DataInService;
import org.igreenhouse.service.DataOutService;
import org.igreenhouse.service.DataProcessService;
import org.igreenhouse.util.SerialPortUtil;

import java.sql.Timestamp;
import java.util.TimerTask;

/**
 * Created by AllenKO on 2015/10/30.
 * 发送室外数据采集命令相关的类
 */
public class OutdoorAverageSender implements Runnable {
    /**
     * 向串口发送获取室外数据命令
     */
    private void getandsaveAverageData() {
        DataOutService.saveOutdoor(DataProcessService.outdoorDataProcess());
        System.out.println("Get & Save outdoor average data successfully at " + new Timestamp(System.currentTimeMillis()));
    }

    @Override
    public void run() {
        getandsaveAverageData();
    }
}
