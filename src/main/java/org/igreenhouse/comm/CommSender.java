package org.igreenhouse.comm;

import gnu.io.SerialPort;
import org.igreenhouse.util.SerialPortUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Timestamp;

import static org.igreenhouse.util.ByteUtil.hexStringToBytes;

/**
 * Created by Holten on 2015/10/30.
 */

/**
 * 发送相关数据的类
 */
public class CommSender {
    private final Logger logger = LoggerFactory.getLogger(CommSender.class);

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
        logger.info("Send setTime command successfully");
    }

    public void getOutdoorData() {
        serialPortUtil.sendToPort(serialPort, OUTDOOR_ORDER);
        logger.info("Send getOutdoorData command successfully at {}", new Timestamp(System.currentTimeMillis()));
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        serialPortUtil.sendToPort(serialPort, RAINFALL_ORDER);
        logger.info("Send getRainfallData command successfully at {}", new Timestamp(System.currentTimeMillis()));
    }

    public void getSolarRadiationData() {
        serialPortUtil.sendToPort(serialPort, SOLAR_RADIATION_ORDER);
        logger.info("Send getSolarRadiationData command successfully at {}", new Timestamp(System.currentTimeMillis()));
    }
}
