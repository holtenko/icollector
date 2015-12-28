package org.igreenhouse.main;

import gnu.io.SerialPort;
import org.igreenhouse.initiate.Configuration;
import org.igreenhouse.initiate.DBconf;
import org.igreenhouse.listener.IndoorListener;
import org.igreenhouse.listener.OutdoorListener;
import org.igreenhouse.sender.IndoorAverageSender;
import org.igreenhouse.sender.OutdoorAverageSender;
import org.igreenhouse.sender.OutdoorSender;
import org.igreenhouse.service.ListenerService;
import org.igreenhouse.uploader.CloudUploader;
import org.igreenhouse.util.SerialPortUtil;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;


public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println("Current Local Database:" + DBconf.db_name + " User:" + DBconf.db_username + " URL:" + DBconf.db_url);
        System.out.println("Current Cloud Database:" + DBconf.clouddb_name + " User:" + DBconf.clouddb_username + " URL:" + DBconf.clouddb_url);

        ArrayList<String> portList = SerialPortUtil.findPort();
        System.out.println("There is " + portList.size() + " device connected.");

        ScheduledThreadPoolExecutor executor = new ScheduledThreadPoolExecutor(5);

        if (0 == portList.size()) {//没识别到串口的情况
            System.out.println("ERROR:No SerialPort Detected,Please check!");
            System.exit(0);
        } else if (1 == portList.size()) {//只识别了一个串口的情况
            System.out.println("WARING:only one SerialPort Detected");
            System.out.println("Please ENTER the option:");
            System.out.println("Indoor:  1");
            System.out.println("Outdoor: 2");
            Scanner sc = new Scanner(System.in);
            while (true) {
                int option = sc.nextInt();
                if (1 == option) {
                    String ZCPortName = portList.get(Configuration.ZCNum);
                    SerialPort ZCPort = SerialPortUtil.openPort(ZCPortName, 115200);
                    ListenerService.addListener(ZCPort, new IndoorListener(ZCPort));
                    System.out.println("Start collect indoor data at " + new Timestamp(System.currentTimeMillis()));

                    //开启平均室内数据的定时任务
                    IndoorAverageSender indoorAverageSender = new IndoorAverageSender();
                    executor.scheduleAtFixedRate(indoorAverageSender, Configuration.AverageAcqDelay, Configuration.AverageAcqCycle, TimeUnit.SECONDS);
                    break;
                } else if (2 == option) {
                    String WeatherStationPortName = portList.get(Configuration.WeatherStationNum);
                    SerialPort WeatherStationPort = SerialPortUtil.openPort(WeatherStationPortName, 9600);
                    ListenerService.addListener(WeatherStationPort, new OutdoorListener(WeatherStationPort));

                    //开启获取室外数据的定时任务
                    OutdoorSender outdoorSender = new OutdoorSender(WeatherStationPort);
                    executor.scheduleAtFixedRate(outdoorSender, Configuration.OutdoorAcqDelay, Configuration.OutdoorAcqCycle, TimeUnit.SECONDS);
                    //开启平均室外数据的定时任务
                    OutdoorAverageSender outdoorAverageSender = new OutdoorAverageSender();
                    executor.scheduleAtFixedRate(outdoorAverageSender, Configuration.AverageAcqDelay, Configuration.AverageAcqCycle, TimeUnit.SECONDS);
                    break;
                } else {
                    System.out.println("ERROR: ENTER corrected option:");
                }
            }
        } else {//识别两个及以上串口的情况
            String ZCPortName = portList.get(Configuration.ZCNum);
            String WeatherStationPortName = portList.get(Configuration.WeatherStationNum);
            System.out.println("Please ENTER the option:");
            System.out.println("Indoor:  1");
            System.out.println("Outdoor: 2");
            System.out.println("Both:    3");
            Scanner sc = new Scanner(System.in);
            while (true) {
                int option = sc.nextInt();
                if (1 == option) {
                    SerialPort ZCPort = SerialPortUtil.openPort(ZCPortName, 115200);
                    ListenerService.addListener(ZCPort, new IndoorListener(ZCPort));
                    System.out.println("Start collect indoor data at " + new Timestamp(System.currentTimeMillis()));
                    //开启平均室内数据的定时任务
                    IndoorAverageSender indoorAverageSender = new IndoorAverageSender();
                    executor.scheduleAtFixedRate(indoorAverageSender, Configuration.AverageAcqDelay, Configuration.AverageAcqCycle, TimeUnit.SECONDS);
                    break;
                } else if (2 == option) {
                    SerialPort WeatherStationPort = SerialPortUtil.openPort(WeatherStationPortName, 9600);//打开串口
                    ListenerService.addListener(WeatherStationPort, new OutdoorListener(WeatherStationPort));//添加监听器
                    //开启获取室外数据的定时任务
                    OutdoorSender outdoorSender = new OutdoorSender(WeatherStationPort);
                    executor.scheduleAtFixedRate(outdoorSender, Configuration.OutdoorAcqDelay, Configuration.OutdoorAcqCycle, TimeUnit.SECONDS);
                    //开启平均室外数据的定时任务
                    OutdoorAverageSender outdoorAverageSender = new OutdoorAverageSender();
                    executor.scheduleAtFixedRate(outdoorAverageSender, Configuration.AverageAcqDelay, Configuration.AverageAcqCycle, TimeUnit.SECONDS);
                    break;
                } else if (3 == option) {
                    SerialPort ZCPort = SerialPortUtil.openPort(ZCPortName, 115200);
                    ListenerService.addListener(ZCPort, new IndoorListener(ZCPort));
                    SerialPort WeatherStationPort = SerialPortUtil.openPort(WeatherStationPortName, 9600);
                    ListenerService.addListener(WeatherStationPort, new OutdoorListener(WeatherStationPort));

                    //开启获取室外数据的定时任务
                    OutdoorSender outdoorSender = new OutdoorSender(WeatherStationPort);
                    executor.scheduleAtFixedRate(outdoorSender, Configuration.OutdoorAcqDelay, Configuration.OutdoorAcqCycle, TimeUnit.SECONDS);
                    System.out.println("Start collect all data at " + new Timestamp(System.currentTimeMillis()));
                    //开启平均室内数据的定时任务
                    IndoorAverageSender indoorAverageSender = new IndoorAverageSender();
                    executor.scheduleAtFixedRate(indoorAverageSender, Configuration.AverageAcqDelay, Configuration.AverageAcqCycle, TimeUnit.SECONDS);
                    //开启平均室外数据的定时任务
                    OutdoorAverageSender outdoorAverageSender = new OutdoorAverageSender();
                    executor.scheduleAtFixedRate(outdoorAverageSender, Configuration.AverageAcqDelay, Configuration.AverageAcqCycle, TimeUnit.SECONDS);
                    break;
                } else {
                    System.out.println("ERROR: ENTER corrected option:");
                }
            }
        }
        //开启上传定时任务
        CloudUploader cloudUploader = new CloudUploader();
        executor.scheduleAtFixedRate(cloudUploader, Configuration.UploadDelay, Configuration.UploadCycle, TimeUnit.SECONDS);
    }
}