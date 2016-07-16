package org.igreenhouse.comm;

import gnu.io.SerialPort;
import org.igreenhouse.util.SerialPortUtil;

import java.sql.Timestamp;

import static org.igreenhouse.util.ByteUtil.hexStringToBytes;

/**
 * Created by Holten on 2015/10/30.
 */

/**
 * 发送相关数据的类
 */
public class CommSender {
    private SerialPortUtil serialPortUtil = new SerialPortUtil();
    private SerialPort serialPort;
    private byte[] OUTDOOR_ORDER = "#01\r".getBytes();
    private byte[] RAINFALL_ORDER = "#330\r".getBytes();
    private byte[] SOLAR_RADIATION_ORDER = "#020\r".getBytes();

    public CommSender(SerialPort serialPort) {
        this.serialPort = serialPort;
    }

    public void setTime(int sample_cycle) {
        String cycleString = Integer.toHexString(sample_cycle);
        byte[] cycleBytes = hexStringToBytes(cycleString);
        byte[] CycleOrder = {0x3A, 0x03, cycleBytes[0], cycleBytes[1], 0x00, 0x23};
        serialPortUtil.sendToPort(serialPort, CycleOrder);
        System.out.println("Send setTime command successfully");
    }

    public void getOutdoorData() {
        serialPortUtil.sendToPort(serialPort, OUTDOOR_ORDER);
        System.out.println("Send getOutdoorData command successfully at " + new Timestamp(System.currentTimeMillis()));
        serialPortUtil.sendToPort(serialPort, RAINFALL_ORDER);
        System.out.println("Send getRainfallData command successfully at " + new Timestamp(System.currentTimeMillis()));
    }

    public void getSolarRadiationData() {
        serialPortUtil.sendToPort(serialPort, SOLAR_RADIATION_ORDER);
        System.out.println("Send getSolarRadiationData command successfully at " + new Timestamp(System.currentTimeMillis()));
    }
}
