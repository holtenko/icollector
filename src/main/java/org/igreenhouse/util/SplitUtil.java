package org.igreenhouse.util;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by AllenKO on 2015/10/30.
 * 进行分割的相关类
 */
public class SplitUtil {

    /**
     * 将获得的字节数组按照包头和包尾分割成若干个字节数组
     *
     * @param bytes 获得的字节数组
     * @param start 包头字节
     * @param end   包尾字节
     * @return 分割完成后的字节数组
     */
    public static byte[][] splitBytes(byte[] bytes, byte start, byte end) {
        ArrayList<Integer> startIndex = new ArrayList<>();//数据包起始索引List
        ArrayList<Integer> endIndex = new ArrayList<>();//数据包结尾索引List

        //遍历整个数组获得数据包起始和结尾的索引
        int index = 0;
        for (byte b : bytes) {
            if (b == start) {
                startIndex.add(index);
            } else if (b == end) {
                endIndex.add(index);
            }
            index++;
        }
        //按照数据包起始和结尾索引分割数组
        byte[][] packs = new byte[startIndex.size()][];
        for (int i = 0; i < startIndex.size(); i++) {
            packs[i] = Arrays.copyOfRange(bytes, startIndex.get(i), endIndex.get(i) + 1);
        }
        return packs;
    }

    /**
     * 将字符串分割为若干个字符串
     *
     * @param srcString 原始字符串
     * @param regex     分割位置正则表达式
     * @return 分割完成后的子字符串
     */
    public static String[] splitString(String srcString, String regex) {
        return srcString.split(regex);
    }
}
