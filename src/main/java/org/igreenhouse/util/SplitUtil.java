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
     * @return 分割完成后的字节数组
     */
    public static byte[][] splitBytes(byte[] bytes, byte start, int length) {
        ArrayList<Integer> startIndex = new ArrayList<>();//数据包起始索引List

        //遍历整个数组获得数据包起始的索引
        int index = 0;
        for (byte b : bytes) {
            if (b == start) {
                startIndex.add(index);
            }
            index++;
        }
        //按照数据包起始和结尾索引分割数组
        byte[][] packs = new byte[startIndex.size()][];
        for (int i = 0; i < startIndex.size(); i++) {
            packs[i]=copyBytes(bytes,startIndex.get(i),length);
        }
        return packs;
    }

    private static byte[] copyBytes(byte[] bytes, int startIndex, int length){
        byte[] dest=new byte[length];
        for(int i=0;i<length;i++){
            dest[i]=bytes[startIndex+i];
        }
        return dest;
    }

}
