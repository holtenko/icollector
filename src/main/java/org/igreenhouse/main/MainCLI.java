package org.igreenhouse.main;

import org.igreenhouse.config.Configuration;
import org.igreenhouse.service.SampleDataService;
import org.igreenhouse.threads.ReadDataFromQueueThread;
import org.igreenhouse.threads.SendOrderThread;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by holten.gao on 2016/7/13.
 */
public class MainCLI {
	public static void main(String[] args) {
		SampleDataService sampleDataService = new SampleDataService();

        ScheduledThreadPoolExecutor executor = new ScheduledThreadPoolExecutor(5);

		String ZCPortName = "";
		String WeatherStationPortName = "";

		BlockingQueue dataInBytes = new LinkedBlockingQueue();
		BlockingQueue dataOutBytes = new LinkedBlockingQueue();
		BlockingQueue dataInPackages = new LinkedBlockingQueue();
		BlockingQueue dataOutPackages = new LinkedBlockingQueue();

        //开启监听器开始采集数据
		sampleDataService.sampleData(ZCPortName, 115200, dataInBytes);
		sampleDataService.sampleData(WeatherStationPortName, 9600, dataOutBytes);

        //开始从字节流队列封装数据包到数据包队列
		new Thread(new ReadDataFromQueueThread(dataInBytes, dataInPackages, (byte) 58, (byte) 239)).start();
		new Thread(new ReadDataFromQueueThread(dataOutBytes, dataOutPackages, (byte) 58, (byte) 239)).start();



        //开启获取室外数据的定时任务
        SendOrderThread sendOrderThread=new SendOrderThread(WeatherStationPortName,9600);
        executor.scheduleAtFixedRate(sendOrderThread, Configuration.OutdoorAcqDelay, Configuration.OutdoorAcqCycle, TimeUnit.SECONDS);
	}
}
