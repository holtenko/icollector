package org.igreenhouse.listener;

import gnu.io.SerialPort;
import gnu.io.SerialPortEvent;
import gnu.io.SerialPortEventListener;

import org.igreenhouse.domain.DataIn;
import org.igreenhouse.sender.IndoorSender;
import org.igreenhouse.service.DataInService;
import org.igreenhouse.service.DeviceService;
import org.igreenhouse.util.SerialPortUtil;
import org.igreenhouse.util.SplitUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Timestamp;


/**
 * Created by AllenKO on 2015/10/30.
 * 室内数据监听器
 */
public class IndoorListener implements SerialPortEventListener {
    private static final Logger LOGGER = LoggerFactory.getLogger(IndoorListener.class);

    private SerialPort serialPort;
    private InputStream inStream;
    private SerialPortUtil serialPortUtil = new SerialPortUtil();

    /**
     * 构造器获得串口对象
     *
     * @param serialPort
     */
    public IndoorListener(SerialPort serialPort) {
        this.serialPort = serialPort;
        try {
            this.inStream = new BufferedInputStream(serialPort.getInputStream(), 1024);// 获取输入流
        } catch (IOException e) {
            LOGGER.error("Get inputStream failed !", e);
        }
    }


    @Override
    public void serialEvent(SerialPortEvent serialPortEvent) {
        switch (serialPortEvent.getEventType()) {
            case SerialPortEvent.BI: // 10通讯中断
            case SerialPortEvent.OE: // 7溢位错误
            case SerialPortEvent.FE: // 9帧错误
            case SerialPortEvent.PE: // 8奇偶校验错
            case SerialPortEvent.CD: // 6载波检测
            case SerialPortEvent.CTS: // 3清除发送
            case SerialPortEvent.DSR: // 4数据设备准备好
            case SerialPortEvent.RI: // 5振铃指示
            case SerialPortEvent.OUTPUT_BUFFER_EMPTY: // 2输出缓冲区已清空
                break;
            case SerialPortEvent.DATA_AVAILABLE: // 1  读到可用数据时激活
            {
                //数据到达时延迟500ms缓存数据
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                byte[] data = serialPortUtil.readFromPort(inStream);
                IndoorSender indoorSender = new IndoorSender(serialPort);
                //判断数据包是否准备完成
                if (indoorSender.isDataReady(data)) {
                    byte[][] indoorBytes = SplitUtil.splitBytes(data, (byte) 58, (byte) 35);
                    for (int i = 0; i < indoorBytes.length; i++) {
                        DataIn dataIn = DataInService.parseDataIn(indoorBytes[i]);
                        if (DataInService.saveDataIn(dataIn)) {
                            System.out.println("Insert indoor data into database successfully at " + new Timestamp(System.currentTimeMillis()));
                            DeviceService.saveDeviceStatus(dataIn);
                        } else {
                            LOGGER.error("Insert indoor data into database failed !");
                        }
                    }
                }
                break;
            }

        }
    }

}
