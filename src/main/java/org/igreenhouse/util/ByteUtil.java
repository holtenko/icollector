package org.igreenhouse.util;

/**
 * Created by AllenKO on 2015/10/30.
 * 操作字节相关的类
 */
public class ByteUtil {
    /**
     * byte数组转换为字符串
     *
     * @param bytes byte数组
     * @return 字符串
     */
    public static final String bytesToString(byte[] bytes) {
        return new String(bytes, 0, bytes.length);
    }

    /**
     * byte数组转换为字符串
     *
     * @param oBytes Byte数组
     * @return 字符串
     */
    public static final String bytesToString(Byte[] oBytes) {
        byte[] bytes = new byte[oBytes.length];

        for (int i = 0; i < oBytes.length; i++) {
            bytes[i] = oBytes[i];
        }
        return new String(bytes, 0, bytes.length);
    }

    /**
     * byte数组转换为整型数
     *
     * @param bytes byte数组
     * @return 整型数
     */
    public static int bytesToInt(byte[] bytes) {
        int value = 0;
        for (int i = 0; i < 4; i++) {
            int shift = (4 - 1 - i) * 8;
            value += (bytes[i] & 0x000000FF) << shift;
        }
        return value;
    }

    /**
     * byte数组转换为16进制字符串
     *
     * @param bytes byte数组
     * @return 16进制字符串
     */
    public static String bytesToHexString(byte[] bytes) {
        StringBuilder stringBuilder = new StringBuilder("");
        if (bytes == null || bytes.length <= 0) {
            return null;
        }
        for (int i = 0; i < bytes.length; i++) {
            int v = bytes[i] & 0xFF;
            String hv = Integer.toHexString(v);
            if (hv.length() < 2) {
                stringBuilder.append(0);
            }
            stringBuilder.append(hv);
        }
        return stringBuilder.toString().toUpperCase();
    }
}
