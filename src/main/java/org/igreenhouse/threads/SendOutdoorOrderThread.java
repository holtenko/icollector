package org.igreenhouse.threads;

import gnu.io.SerialPort;
import org.igreenhouse.comm.CommSender;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by holten.gao on 2016/7/13.
 */
public class SendOutdoorOrderThread implements Runnable {
    private final Logger logger = LoggerFactory.getLogger(SendOutdoorOrderThread.class);
    private SerialPort serialPort;
    private CommSender commSender;

    public SendOutdoorOrderThread(SerialPort serialPort) {
        this.serialPort = serialPort;
        commSender = new CommSender(serialPort);
    }

    @Override
    public void run() {
        logger.info("SendOutdoorOrderThread Run...");
        commSender.getOutdoorData();
    }
}
