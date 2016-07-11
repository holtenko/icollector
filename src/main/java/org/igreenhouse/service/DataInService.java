package org.igreenhouse.service;

/**
 * Created by AllenKO on 2015/11/3.
 * 用于操作室内数据的类
 */
public class DataInService {
    public static final int parseDataIn(byte[] dataInBytes) {
        int serialIdBytes = dataInBytes[1];// 建立设备串口id字节数组
        int serialId = (serialIdBytes/16*10)+(serialIdBytes%16);
        return serialId;
    }
}
