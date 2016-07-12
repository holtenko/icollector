package org.igreenhouse.service;

import java.util.concurrent.BlockingQueue;

/**
 * Created by holten on 2016/7/11.
 */

public class ReadDataService implements Runnable {
	private BlockingQueue byteQueue;
	private byte start;
	private byte end;

	public ReadDataService(BlockingQueue byteQueue, byte start, byte end) {
		this.byteQueue = byteQueue;
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
					if(index!=26) System.out.println("error");
					//System.out.println(index + ":" + new String(bytes, 0, index));
					index = 0;
				}
			} catch (InterruptedException e) {
			}
		}
	}
}
