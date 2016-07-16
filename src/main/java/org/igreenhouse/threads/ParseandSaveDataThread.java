package org.igreenhouse.threads;

import org.igreenhouse.service.ParseAndSaveDataService;

import java.util.Map;
import java.util.concurrent.BlockingQueue;

/**
 * Created by holten.gao on 2016/7/14.
 */
public class ParseAndSaveDataThread implements Runnable {

    private BlockingQueue dataQueue;// 存储数据包字符串
    private int dataType;// 数据包类型

    public ParseAndSaveDataThread(BlockingQueue dataQueue, int dataType) {
        this.dataQueue = dataQueue;
        this.dataType = dataType;
    }

    @Override
    public void run() {
        try {
            if (dataType == 0) {
                while (true) {
                    Map<String, Object> dataMap = (Map) dataQueue.take();
                    ParseAndSaveDataService.parseIndoorPackage(dataMap);
                }
            } else if (dataType == 1) {
                while (true) {
                    Map<String, Object> dataMap = (Map) dataQueue.take();
                    ParseAndSaveDataService.parseOutdoorPackage(dataMap);
                }
            }else if(dataType==2){
                while (true) {
                    Map<String, Object> dataMap = (Map) dataQueue.take();
                    ParseAndSaveDataService.parseSolarRadiationPackage(dataMap);
                }
            }
        } catch (InterruptedException e) {
        }
    }
}
