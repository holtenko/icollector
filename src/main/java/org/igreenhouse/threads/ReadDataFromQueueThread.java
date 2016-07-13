package org.igreenhouse.threads;

import java.util.Arrays;
import java.util.concurrent.BlockingQueue;

/**
 * Created by holten on 2016/7/11.
 */

public class ReadDataFromQueueThread implements Runnable {
	private BlockingQueue byteQueue;// 存储字节流队列
	private BlockingQueue dataQueue;// 存储数据包字符串
	private byte start;// 数据包头
	private byte end;// 数据包尾

	public ReadDataFromQueueThread(BlockingQueue byteQueue, BlockingQueue dataQueue, byte start, byte end) {
		this.byteQueue = byteQueue;
		this.dataQueue = dataQueue;
		this.start = start;
		this.end = end;
	}

	@Override
	public void run() {
		byte[] bytes = new byte[1024];
		int index = 0;
		boolean valid = false;
		while (true) {
			try {
				byte data = (byte) byteQueue.take();
				if (data == start)
					valid = true;
				if (valid)
					bytes[index++] = data;
				if (data == end) {
					valid = false;
					byte[] dataPackage = Arrays.copyOf(bytes, index + 1);
					dataQueue.put(dataPackage);
					index = 0;// 重置索引
				}
			} catch (InterruptedException e) {
			}
		}
	}
}