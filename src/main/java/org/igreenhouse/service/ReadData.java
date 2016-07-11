package org.igreenhouse.service;

import org.omg.IOP.Encoding;

import java.util.concurrent.BlockingQueue;

/**
 * Created by holten on 2016/7/11.
 */
public class ReadData implements Runnable {
    private BlockingQueue byteQueue;

    public ReadData(BlockingQueue byteQueue) {
        this.byteQueue = byteQueue;
    }

    @Override
    public void run() {
        byte[] bytes = new byte[1024];
        int index = 0;
        boolean valid = false;
        while (true) {
            try {
                byte data = (byte) byteQueue.take();
                if (data == 65) valid = true;
                if (valid) bytes[index++] = data;
                if (data == 90) {
                    valid = false;
                    System.out.println(index+":"+new String(bytes,0,index));
                    index=0;
                }
            } catch (InterruptedException e) {
            }
        }
    }
}
