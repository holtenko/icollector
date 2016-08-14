package org.igreenhouse.service;

import gnu.io.SerialPort;
import gnu.io.SerialPortEventListener;
import org.igreenhouse.comm.CommListener;
import org.igreenhouse.util.SerialPortUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.TooManyListenersException;
import java.util.concurrent.BlockingQueue;

/**
 * Created by holten.gao on 2016/7/12.
 */
public class SampleDataService {
	private final Logger logger = LoggerFactory.getLogger(SampleDataService.class);

	public void sampleData(SerialPort port, BlockingQueue byteQueue) {
		addListener(port, new CommListener(port, byteQueue));
	}
	/**
	 * 添加监听器
	 *
	 * @param port 串口对象
	 * @param listener 串口监听器
	 */
	private void addListener(SerialPort port, SerialPortEventListener listener) {
		try {
			// 给串口添加监听器
			port.addEventListener(listener);
			// 设置当有数据到达时唤醒监听接收线程
			port.notifyOnDataAvailable(true);
			port.notifyOnBreakInterrupt(true);
			logger.info("Add listener to {} successfully !", port.getName());
		} catch (TooManyListenersException e) {
			logger.error("There are too many listeners !", e);
		}
	}

	/**
	 * 移除监听器
	 *
	 * @param port 串口对象
	 */
	private void removeListener(SerialPort port) {
		// 移除监听器
		port.notifyOnDataAvailable(false);
		port.notifyOnBreakInterrupt(false);
		port.removeEventListener();

		SerialPortUtil.closePort(port);
		logger.info("Remove listener of {} successfully !", port.getName());
	}
}
