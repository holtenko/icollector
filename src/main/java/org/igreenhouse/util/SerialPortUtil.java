package org.igreenhouse.util;

import gnu.io.CommPort;
import gnu.io.CommPortIdentifier;
import gnu.io.SerialPort;
import gnu.io.UnsupportedCommOperationException;
import gnu.io.NoSuchPortException;
import gnu.io.PortInUseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Enumeration;

/**
 * Created by allenko on 15-10-29.
 * 操作串口相关的类
 */
public class SerialPortUtil {

    private static final Logger LOGGER = LoggerFactory.getLogger(SerialPortUtil.class);

    /**
     * 查找所有可用端口
     *
     * @return 所有端口列表
     */
    public static final ArrayList<String> findPort() {
        @SuppressWarnings("unchecked")
        Enumeration<CommPortIdentifier> portList = CommPortIdentifier.getPortIdentifiers();//获得所有串口
        ArrayList<String> portNameList = new ArrayList<>();
        //串口名字添加到List并返回
        while (portList.hasMoreElements()) {
            String portName = portList.nextElement().getName();
            portNameList.add(portName);
        }
        return portNameList;
    }

    /**
     * 打开串口
     *
     * @param portName 端口名称
     * @param baudrate 波特率
     * @return 串口对象
     */
    public static final SerialPort openPort(String portName, int baudrate) {
        try {
            //通过端口名识别端口
            CommPortIdentifier portIdentifier = CommPortIdentifier.getPortIdentifier(portName);
            //打开端口，并给端口名字和一个timeout
            CommPort commPort = portIdentifier.open(portName, 2000);
            //判断是不是串口
            if (commPort instanceof SerialPort) {
                SerialPort serialPort = (SerialPort) commPort;
                try {
                    //设置一下串口的波特率等参数
                    serialPort.setSerialPortParams(baudrate, SerialPort.DATABITS_8, SerialPort.STOPBITS_1, SerialPort.PARITY_NONE);
                } catch (UnsupportedCommOperationException e) {
                    LOGGER.error("Set Serialport Parameters failure", e);
                }
                System.out.println("Open " + portName + " sucessfully !");
                return serialPort;
            } else {
                LOGGER.error("This port is not a serialport");
                return null;
            }
        } catch (NoSuchPortException | PortInUseException e) {
            LOGGER.error("There is no " + portName + "or it's occupied!", e);
            return null;
        }
    }

    /**
     * 关闭串口
     *
     * @param serialPort 串口对象
     */
    public static final void closePort(SerialPort serialPort) {
        String portname = serialPort.getName();
        serialPort.close();
        System.out.println("Close " + portname + " sucessfully !");
    }

    /**
     * 发送数据
     *
     * @param serialPort 串口对象
     * @param order      命令字节
     */
    public void sendToPort(SerialPort serialPort, byte[] order) {
        try {
            OutputStream out = serialPort.getOutputStream();
            out.write(order);
            out.flush();
            out.close();
        } catch (IOException e) {
            LOGGER.error("Send to SerialPort failure", e);
        }
    }

    /**
     * 读取数据
     *
     * @return 字节ArrayList
     */
    public byte[] readFromPort(InputStream inStream) {
        byte[] bytes = null;
        try {
            while (true) {
                //获取buffer里的数据长度
                int bufflenth = inStream.available();
                if (0 == bufflenth) {
                    break;
                }
                bytes = new byte[bufflenth];
                inStream.read(bytes);
            }
        } catch (IOException e) {
            LOGGER.error("Read Data Failure", e);
        }
        return bytes;
    }
}
