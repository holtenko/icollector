package org.igreenhouse.threads;

import gnu.io.SerialPort;
import org.igreenhouse.comm.CommSender;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by holten.gao on 2016/7/13.
 */
public class SendSolarRadiationOrderThread implements Runnable {
    private final Logger logger = LoggerFactory.getLogger(SendSolarRadiationOrderThread.class);
    private SerialPort serialPort;
    private CommSender commSender;

    public SendSolarRadiationOrderThread(SerialPort serialPort) {
        this.serialPort = serialPort;
        commSender = new CommSender(serialPort);
    }

    @Override
    public void run() {
        logger.info("SendSolarRadiationOrderThread Run...");
        commSender.getSolarRadiationData();
    }
}
