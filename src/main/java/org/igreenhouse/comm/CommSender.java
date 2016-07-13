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
	private static final byte[] ACQORDER = "#01\r#330\r".getBytes();//#01\r是采集前五个参数的命令，#330\r是采集雨量参数的命令

	public CommSender(SerialPort serialPort) {
		this.serialPort = serialPort;
	}

	public void setTime(int sample_cycle) {
		String cycleString = Integer.toHexString(sample_cycle);
		byte[] cycleBytes = hexStringToBytes(cycleString);
		byte[] CycleOrder = { 0x3A, 0x03, cycleBytes[0], cycleBytes[1], 0x00, 0x23 };
		serialPortUtil.sendToPort(serialPort, CycleOrder);
		System.out.println("Send setTime command successfully");
	}

	public void getOutdoorData(){
		serialPortUtil.sendToPort(serialPort, ACQORDER);
		System.out.println("Send getOutdoorData command successfully at " + new Timestamp(System.currentTimeMillis()));
	}

}
