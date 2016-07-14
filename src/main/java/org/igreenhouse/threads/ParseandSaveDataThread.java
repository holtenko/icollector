package org.igreenhouse.threads;

import org.igreenhouse.dao.DataIn;
import org.igreenhouse.dao.DataOut;
import org.igreenhouse.service.ParseDataService;
import org.igreenhouse.service.SaveDataService;

import java.util.concurrent.BlockingQueue;

/**
 * Created by holten.gao on 2016/7/14.
 */
public class ParseAndSaveDataThread implements Runnable {

	private BlockingQueue dataQueue;// 存储数据包字符串
	private int dataType;// 数据包类型

	public ParseAndSaveDataThread(BlockingQueue dataQueue, int dataType) {
		this.dataQueue = dataQueue;
		this.dataType = dataType;
	}

	@Override
	public void run() {
		try {
			if (dataType == 0) {
				while (true) {
					byte[] dataPackage = (byte[]) dataQueue.take();
					DataIn dataIn = ParseDataService.parseDataInPackage(dataPackage);
					SaveDataService.saveDataIn(dataIn);
				}
			} else if (dataType == 1) {
				while (true) {
					byte[] dataPackage = (byte[]) dataQueue.take();
					DataOut dataOut = ParseDataService.parseDataOutPackage(dataPackage);
					SaveDataService.saveDataOut(dataOut);
				}
			}
		} catch (InterruptedException e) {
		}
	}
}
