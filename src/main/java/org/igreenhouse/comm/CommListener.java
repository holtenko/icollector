package org.igreenhouse.comm;

import gnu.io.SerialPort;
import gnu.io.SerialPortEvent;
import gnu.io.SerialPortEventListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.BlockingQueue;

/**
 * Created by Holten on 2015/10/30. 串口监听器
 */
public class CommListener implements SerialPortEventListener {
    private final Logger logger = LoggerFactory.getLogger(CommListener.class);

    private InputStream inStream;
    private BlockingQueue byteQueue;

    /**
     * 构造器获得串口对象和字节流存储队列
     *
     * @param serialPort 串口对象
     * @param byteQueue  存放字节流的队列
     */
    public CommListener(SerialPort serialPort, BlockingQueue byteQueue) {
        this.byteQueue = byteQueue;
        try {
            this.inStream = new BufferedInputStream(serialPort.getInputStream());// 获取输入流
        } catch (IOException e) {
            logger.error("Get inputStream failed !{}", e);
        }
    }

    @Override
    public void serialEvent(SerialPortEvent serialPortEvent) {
        switch (serialPortEvent.getEventType()) {
            case SerialPortEvent.BI: // 10通讯中断
            case SerialPortEvent.FE: // 9帧错误
            case SerialPortEvent.PE: // 8奇偶校验
            case SerialPortEvent.OE: // 7溢位错误
            case SerialPortEvent.CD: // 6载波检测
            case SerialPortEvent.RI: // 5振铃指示
            case SerialPortEvent.DSR: // 4数据设备准备好
            case SerialPortEvent.CTS: // 3清除发送
            case SerialPortEvent.OUTPUT_BUFFER_EMPTY: // 2输出缓冲区已清空
                break;
            case SerialPortEvent.DATA_AVAILABLE: // 1 读到可用数据时激活
            {
                try {
                    byte dataByte = (byte) inStream.read();
                    while (dataByte != -1) {
                        byteQueue.put(dataByte);
                        dataByte = (byte) inStream.read();
                    }
                } catch (IOException e) {
                    logger.error("Read from inputStream failed !{}", e);
                } catch (InterruptedException e) {
                    logger.error("Put data into queue failed !{}", e);
                }
                break;
            }

        }
    }

}
