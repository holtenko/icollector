package org.igreenhouse.threads;

import gnu.io.SerialPort;
import org.igreenhouse.comm.CommSender;
import org.igreenhouse.util.SerialPortUtil;

/**
 * Created by holten.gao on 2016/7/13.
 */
public class SendOrderThread implements Runnable {
    private SerialPort serialPort;

    public SendOrderThread(String portName,int baudRate) {
        this.serialPort = SerialPortUtil.openPort(portName, baudRate);
    }

    CommSender commSender=new CommSender(serialPort);

    @Override
    public void run() {
        commSender.getOutdoorData();
    }
}
