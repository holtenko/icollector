package org.igreenhouse.main;

import gnu.io.SerialPort;
import org.igreenhouse.config.Configuration;
import org.igreenhouse.service.SampleDataService;
import org.igreenhouse.threads.ParseAndSaveDataThread;
import org.igreenhouse.threads.ReadDataFromQueueThread;
import org.igreenhouse.threads.SendOutdoorOrderThread;
import org.igreenhouse.threads.SendSolarRadiationOrderThread;
import org.igreenhouse.util.SerialPortUtil;

import java.util.ArrayList;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import static org.igreenhouse.util.SerialPortUtil.findPort;

/**
 * Created by holten.gao on 2016/7/13.
 */
public class MainCLI {
    public static void main(String[] args) {
        ArrayList<String> portList = findPort();
        String ZCPortName = portList.get(Configuration.ZCNum);
        String WeatherStationPortName = portList.get(Configuration.WeatherStationNum);
        String SolarRadiationPortName = portList.get(Configuration.SolarRadiationNum);
        SerialPort ZCPort = SerialPortUtil.openPort(ZCPortName, 115200);
        SerialPort WeatherStationPort = SerialPortUtil.openPort(WeatherStationPortName, 9600);
        SerialPort SolarRadiationPort = SerialPortUtil.openPort(SolarRadiationPortName, 9600);

        indoorStart(ZCPort);
        //outdoorStart(WeatherStationPort);
        //solarRadiationStart(SolarRadiationPort);
    }

    private static void indoorStart(SerialPort port) {
        SampleDataService sampleDataService = new SampleDataService();
        BlockingQueue dataInBytes = new LinkedBlockingQueue();
        BlockingQueue dataInPackages = new LinkedBlockingQueue();
        sampleDataService.sampleData(port, dataInBytes);
        new Thread(new ReadDataFromQueueThread(dataInBytes, dataInPackages, (byte) 68, (byte) 239)).start();
        new Thread(new ParseAndSaveDataThread(dataInPackages, 0)).start();
    }

    private static void outdoorStart(SerialPort port) {
        SampleDataService sampleDataService = new SampleDataService();
        ScheduledThreadPoolExecutor executor = new ScheduledThreadPoolExecutor(5);
        BlockingQueue dataOutBytes = new LinkedBlockingQueue();
        BlockingQueue dataOutPackages = new LinkedBlockingQueue();
        sampleDataService.sampleData(port, dataOutBytes);
        new Thread(new ReadDataFromQueueThread(dataOutBytes, dataOutPackages, (byte) 62, (byte) 13)).start();
        new Thread(new ParseAndSaveDataThread(dataOutPackages, 1)).start();
        SendOutdoorOrderThread sendOutdoorOrderThread = new SendOutdoorOrderThread(port);
        executor.scheduleAtFixedRate(sendOutdoorOrderThread, Configuration.OutdoorAcqDelay,
                Configuration.OutdoorAcqCycle, TimeUnit.SECONDS);
    }

    private static void solarRadiationStart(SerialPort port) {
        SampleDataService sampleDataService = new SampleDataService();
        ScheduledThreadPoolExecutor executor = new ScheduledThreadPoolExecutor(5);
        BlockingQueue dataSolarRadiationBytes = new LinkedBlockingQueue();
        BlockingQueue dataSolarRadiationPackages = new LinkedBlockingQueue();
        sampleDataService.sampleData(port, dataSolarRadiationBytes);
        new Thread(new ReadDataFromQueueThread(dataSolarRadiationBytes, dataSolarRadiationPackages, (byte) 62, (byte) 13)).start();
        new Thread(new ParseAndSaveDataThread(dataSolarRadiationPackages, 2)).start();
        SendSolarRadiationOrderThread sendSolarRadiationOrderThread = new SendSolarRadiationOrderThread(port);
        executor.scheduleAtFixedRate(sendSolarRadiationOrderThread, Configuration.SolarRadiationAcqDelay,
                Configuration.SolarRadiationAcqCycle, TimeUnit.SECONDS);
    }
}
