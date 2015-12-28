package org.igreenhouse.sender;

import gnu.io.SerialPort;
import org.igreenhouse.util.SerialPortUtil;

import java.sql.Timestamp;
import java.util.TimerTask;

/**
 * Created by AllenKO on 2015/10/30.
 * 发送室外数据采集命令相关的类
 */
public class OutdoorSender implements Runnable {
    private SerialPortUtil serialPortUtil = new SerialPortUtil();

    private static final byte[] ACQORDER = "#01\r#330\r".getBytes();//#01\r是采集前五个参数的命令，#330\r是采集雨量参数的命令

    private SerialPort serialPort;

    public OutdoorSender(SerialPort serialPort) {
        this.serialPort = serialPort;
    }

    /**
     * 向串口发送获取室外数据命令
     */
    private void getOutdoorData() {
        serialPortUtil.sendToPort(serialPort, ACQORDER);
        System.out.println("Send getOutdoorData command successfully at " + new Timestamp(System.currentTimeMillis()));
    }

    @Override
    public void run() {
        getOutdoorData();
    }
}
