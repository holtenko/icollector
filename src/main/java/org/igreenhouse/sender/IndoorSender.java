package org.igreenhouse.sender;

import gnu.io.SerialPort;
import org.igreenhouse.util.SerialPortUtil;

import java.sql.Timestamp;
import java.util.Arrays;


/**
 * Created by AllenKO on 2015/10/30.
 * 发送室内数据采集命令相关的类
 */
public class IndoorSender {
    private SerialPortUtil serialPortUtil = new SerialPortUtil();

    private static final byte[] ACQTIPS = {37, 2, 2, 38};// 数据采集完成提示
    private static final byte[] ACQORDER = {0x3A, 0x02, 0x00, 0x00, 0x00, 0x00, 0x4A, 0x23};//数据采集命令
    private SerialPort serialPort;

    public IndoorSender(SerialPort serialPort) {
        this.serialPort = serialPort;
    }

    /**
     * 向串口发送获取室内数据命令
     */
    private final void getIndoorData() {
        serialPortUtil.sendToPort(serialPort, ACQORDER);
        System.out.println("Send getIndoorData command sucessfully at "+ new Timestamp(System.currentTimeMillis()));
    }

    /**
     * 判断协调器数据是否准备完成
     *
     * @param tips 协调器返回字节ArrayList
     * @return 判断结果
     */
    public final boolean isDataReady(byte[] tips) {
        boolean isReady = Arrays.equals(tips, ACQTIPS);
        if (isReady) {
            getIndoorData();
        }
        return !isReady;
    }
}
