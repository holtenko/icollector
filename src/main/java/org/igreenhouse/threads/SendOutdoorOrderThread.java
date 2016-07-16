package org.igreenhouse.threads;

import gnu.io.SerialPort;
import org.igreenhouse.comm.CommSender;

/**
 * Created by holten.gao on 2016/7/13.
 */
public class SendOutdoorOrderThread implements Runnable {
    private SerialPort serialPort;
    private CommSender commSender;

    public SendOutdoorOrderThread(SerialPort serialPort) {
        this.serialPort = serialPort;
        commSender=new CommSender(serialPort);
    }

    @Override
    public void run() {
        commSender.getOutdoorData();
    }
}
