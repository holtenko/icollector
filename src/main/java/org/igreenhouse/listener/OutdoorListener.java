package org.igreenhouse.listener;

import gnu.io.SerialPort;
import gnu.io.SerialPortEvent;
import gnu.io.SerialPortEventListener;
import org.igreenhouse.domain.DataOut;
import org.igreenhouse.initiate.Configuration;
import org.igreenhouse.service.DataOutService;
import org.igreenhouse.util.PropsUtil;
import org.igreenhouse.util.SerialPortUtil;
import org.igreenhouse.util.SplitUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Timestamp;
import java.util.Properties;



/**
 * Created by AllenKO on 2015/10/30.
 * 室外数据监听器
 */
public class OutdoorListener implements SerialPortEventListener {
    private static final Logger LOGGER = LoggerFactory.getLogger(OutdoorListener.class);

    private InputStream inStream;
    private SerialPortUtil serialPortUtil = new SerialPortUtil();



    /**
     * 构造器获得串口对象
     *
     * @param serialPort 串口对象
     */
    public OutdoorListener(SerialPort serialPort) {
        try {
            this.inStream = new BufferedInputStream(serialPort.getInputStream());// 获取输入流
        } catch (IOException e) {
            LOGGER.error("Get inputStream failed !", e);
        }
    }

    @Override
    public void serialEvent(SerialPortEvent serialPortEvent) {
        switch (serialPortEvent.getEventType()) {
            case SerialPortEvent.BI: // 10
            case SerialPortEvent.OE: // 7
            case SerialPortEvent.FE: // 9
            case SerialPortEvent.PE: // 8
            case SerialPortEvent.CD: // 6
            case SerialPortEvent.CTS: // 3
            case SerialPortEvent.DSR: // 4
            case SerialPortEvent.RI: // 5
            case SerialPortEvent.OUTPUT_BUFFER_EMPTY: // 2
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
                byte[][] outdoorBytes = SplitUtil.splitBytes(data, (byte) 62, (byte) 13);
                DataOut dataOut = DataOutService.parseDataOut(outdoorBytes, Configuration.WeatherStationID);
                if (DataOutService.saveDataOut(dataOut)) {
                    System.out.println("Insert outdoor data into database successfully at " + new Timestamp(System.currentTimeMillis()));
                } else {
                    LOGGER.error("Insert outdoor data into database failed !");
                }
                break;
            }

        }
    }


}
