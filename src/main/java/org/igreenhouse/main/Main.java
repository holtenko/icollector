package org.igreenhouse.main;

import gnu.io.SerialPort;
import org.igreenhouse.initiate.Configuration;
import org.igreenhouse.listener.IndoorListener;
import org.igreenhouse.listener.OutdoorListener;
import org.igreenhouse.sender.AverageSender;
import org.igreenhouse.sender.OutdoorSender;
import org.igreenhouse.service.ListenerService;
import org.igreenhouse.uploader.CloudUploader;
import org.igreenhouse.util.SerialPortUtil;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;


public class Main {
    public static void main(String[] args) throws Exception {
        ArrayList<String> portList = SerialPortUtil.findPort();
        if (0 == portList.size()) {
            System.out.println("ERROR:No SerialPort Detected,Please check!");
        } else if (1 == portList.size()) {
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
                    break;
                } else if (2 == option) {
                    String WeatherStationPortName = portList.get(Configuration.WeatherStationNum);
                    SerialPort WeatherStationPort = SerialPortUtil.openPort(WeatherStationPortName, 9600);
                    ListenerService.addListener(WeatherStationPort, new OutdoorListener(WeatherStationPort));
                    TimerTask getOutdoorDataTask = new OutdoorSender(WeatherStationPort);
                    Timer getOutdoorCycle = new Timer(true);
                    getOutdoorCycle.scheduleAtFixedRate(getOutdoorDataTask, Configuration.OutdoorAcqDelay, Configuration.OutdoorAcqCycle);
                    break;
                } else {
                    System.out.println("ERROR: ENTER corrected option:");
                }
            }
        } else if (2 == portList.size()) {
            System.out.println("Please make sure ZC connect to the first SerialPort!");

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
                    break;
                } else if (2 == option) {
                    SerialPort WeatherStationPort = SerialPortUtil.openPort(WeatherStationPortName, 9600);
                    ListenerService.addListener(WeatherStationPort, new OutdoorListener(WeatherStationPort));
                    TimerTask getOutdoorDataTask = new OutdoorSender(WeatherStationPort);
                    Timer getOutdoorCycle = new Timer(true);
                    getOutdoorCycle.scheduleAtFixedRate(getOutdoorDataTask, Configuration.OutdoorAcqDelay, Configuration.OutdoorAcqCycle);
                    break;
                } else if (3 == option) {
                    SerialPort ZCPort = SerialPortUtil.openPort(ZCPortName, 115200);
                    ListenerService.addListener(ZCPort, new IndoorListener(ZCPort));
                    SerialPort WeatherStationPort = SerialPortUtil.openPort(WeatherStationPortName, 9600);
                    ListenerService.addListener(WeatherStationPort, new OutdoorListener(WeatherStationPort));
                    TimerTask getOutdoorDataTask = new OutdoorSender(WeatherStationPort);
                    Timer getOutdoorCycle = new Timer(true);
                    getOutdoorCycle.scheduleAtFixedRate(getOutdoorDataTask, Configuration.OutdoorAcqDelay, Configuration.OutdoorAcqCycle);
                    System.out.println("Start collect all data at " + new Timestamp(System.currentTimeMillis()));
                    break;
                } else {
                    System.out.println("ERROR: ENTER corrected option:");
                }
            }
            TimerTask getAverageDataTask = new AverageSender();
            Timer getAverageDataCycle = new Timer(true);
            getAverageDataCycle.scheduleAtFixedRate(getAverageDataTask, Configuration.AverageAcqDelay, Configuration.AverageAcqCycle);

            TimerTask uploadTask = new CloudUploader();
            Timer uploadCycle = new Timer(true);
            uploadCycle.scheduleAtFixedRate(uploadTask, Configuration.UploadDelay, Configuration.UploadCycle);
        }
    }
}