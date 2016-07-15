package org.igreenhouse.service;

import org.igreenhouse.model.DataIn;
import org.igreenhouse.model.DataOut;

/**
 * Created by holten on 2015/11/3. 用于解析数据的类
 */
public class ParseDataService {
	public static DataIn parseDataInPackage(byte[] dataPackage) {
		int serialIdBytes = dataPackage[1];// 建立设备串口id字节数组
		int serialId = (serialIdBytes / 16 * 10) + (serialIdBytes % 16);
		return null;
	}

	public static DataOut parseDataOutPackage(byte[] dataPackage) {
		return null;
	}
}
