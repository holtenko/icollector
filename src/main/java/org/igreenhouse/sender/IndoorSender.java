package org.igreenhouse.sender;

import gnu.io.SerialPort;
import org.igreenhouse.util.SerialPortUtil;
import org.igreenhouse.views.MainForm;

import java.sql.Timestamp;
import java.util.Arrays;

import static org.igreenhouse.util.ByteUtil.hexStringToBytes;


/**
 * Created by AllenKO on 2015/10/30.
 * 发送室内数据采集命令相关的类
 */
public class IndoorSender {
    private SerialPortUtil serialPortUtil = new SerialPortUtil();

    private SerialPort serialPort;
    private MainForm mainForm;

    public IndoorSender(SerialPort serialPort, MainForm mainForm) {
        this.serialPort = serialPort;
        this.mainForm = mainForm;
    }

    public void setTime(int sample_cycle, int sample_time) {

        String cycleString = Integer.toHexString(sample_cycle);

        byte[] cycleBytes = hexStringToBytes(cycleString);
        byte[] CycleOrder = {0x3A, 0x03, cycleBytes[0], cycleBytes[1], 0x00, 0x23};//数据采集命令

        serialPortUtil.sendToPort(serialPort, CycleOrder);
        mainForm.getLogArea().append("Send setTime command sucessfully");
        System.out.println("Send setTime command sucessfully");
    }

}
