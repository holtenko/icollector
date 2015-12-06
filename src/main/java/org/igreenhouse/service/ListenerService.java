package org.igreenhouse.service;

import gnu.io.SerialPort;
import gnu.io.SerialPortEventListener;
import org.igreenhouse.util.SerialPortUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.TooManyListenersException;


/**
 * Created by AllenKO on 2015/11/3.
 * 操作监听器的类
 */
public class ListenerService {
    private static final Logger LOGGER = LoggerFactory.getLogger(ListenerService.class);

    /**
     * 添加监听器
     *
     * @param port     串口对象
     * @param listener 串口监听器
     */
    public static void addListener(SerialPort port, SerialPortEventListener listener) {
        try {
            // 给串口添加监听器
            port.addEventListener(listener);
            // 设置当有数据到达时唤醒监听接收线程
            port.notifyOnDataAvailable(true);
            port.notifyOnBreakInterrupt(true);
            System.out.println("Add listeners to " + port.getName() + " sucessfully !");
        } catch (TooManyListenersException e) {
            LOGGER.error("There is too many listeners !", e);
        }
    }

    /**
     * 移除监听器
     *
     * @param port 串口对象
     */
    public static void removeListener(SerialPort port) {
        // 移除监听器
        port.notifyOnDataAvailable(false);
        port.notifyOnBreakInterrupt(false);
        port.removeEventListener();

        SerialPortUtil.closePort(port);

        System.out.println("Remove listener of "+port.getName()+" sucessfully !");
    }
}
