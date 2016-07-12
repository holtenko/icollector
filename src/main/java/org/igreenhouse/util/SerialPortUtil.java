package org.igreenhouse.util;

import gnu.io.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Enumeration;

/**
 * Created by holten on 15-10-29. 操作串口相关的类
 */
public class SerialPortUtil {

	private static final Logger logger = LoggerFactory.getLogger(SerialPortUtil.class);

	/**
	 * 查找所有可用端口
	 *
	 * @return 所有端口列表
	 */
	public static final ArrayList<String> findPort() {
		Enumeration portList = CommPortIdentifier.getPortIdentifiers();// 获得所有串口
		ArrayList<String> portNameList = new ArrayList<>();
		while (portList.hasMoreElements()) {
			CommPortIdentifier com = (CommPortIdentifier) portList.nextElement();
			switch (com.getPortType()) {
			case CommPortIdentifier.PORT_SERIAL:
				String portName = com.getName();
				portNameList.add(portName);
			}
		}
		return portNameList;
	}

	/**
	 * 打开串口
	 *
	 * @param portName 端口名称
	 * @param baudRate 波特率
	 * @return 串口对象
	 */
	public static final SerialPort openPort(String portName, int baudRate) {
		try {
			// 通过端口名识别端口
			CommPortIdentifier portIdentifier = CommPortIdentifier.getPortIdentifier(portName);
			// 打开端口，并给端口名字和一个timeout
			CommPort commPort = portIdentifier.open(portName, 2000);
			// 判断是不是串口
			if (commPort instanceof SerialPort) {
				SerialPort serialPort = (SerialPort) commPort;
				try {
					// 设置一下串口的波特率等参数
					serialPort.setSerialPortParams(baudRate, SerialPort.DATABITS_8, SerialPort.STOPBITS_1,
							SerialPort.PARITY_NONE);
				} catch (UnsupportedCommOperationException e) {
					logger.error("Set Serial Port Parameters failure.{}", e);
				}
				logger.info("Open {} successfully !", portName);
				System.out.println("Open " + portName + " successfully !");
				return serialPort;
			} else {
				logger.error("This port is not a serial port");
				return null;
			}
		} catch (NoSuchPortException | PortInUseException e) {
			logger.error("There is no {} or it's occupied!{}", portName, e);
			return null;
		}
	}

	/**
	 * 关闭串口
	 *
	 * @param serialPort 串口对象
	 */
	public static final void closePort(SerialPort serialPort) {
		String portName = serialPort.getName();
		serialPort.close();
		logger.info("Close {} successfully !", portName);
		System.out.println("Close " + portName + " sucessfully !");
	}

	/**
	 * 发送数据
	 *
	 * @param serialPort 串口对象
	 * @param order 命令字节
	 */
	public void sendToPort(SerialPort serialPort, byte[] order) {
		try {
			OutputStream out = serialPort.getOutputStream();
			out.write(order);
			out.flush();
			out.close();
		} catch (IOException e) {
			logger.error("Send to SerialPort failure", e);
		}
	}
}
