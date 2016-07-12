package org.igreenhouse.service;

import gnu.io.SerialPort;
import org.igreenhouse.listener.CommListener;
import org.igreenhouse.util.SerialPortUtil;

import java.util.concurrent.BlockingQueue;

/**
 * Created by holten.gao on 2016/7/12.
 */
public class SampleDataService {
	public void sampleData(String portName, BlockingQueue byteQueue) {
		SerialPort ZCPort = SerialPortUtil.openPort(portName, 115200);
		ListenerService.addListener(ZCPort, new CommListener(ZCPort, byteQueue));
	}

}
