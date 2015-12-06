package org.igreenhouse.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.Properties;

/**
 * Created by allenko on 15-10-29.
 */
public class PropsUtil {
    private static final Logger LOGGER = LoggerFactory.getLogger(PropsUtil.class);

    /**
     * 加载属性文件
     *
     * @param filename 文件名
     * @return 属性对象
     */
    public static Properties loadProps(String filename) {
        Properties props = null;
        InputStream inputStream = null;
        try {
            String filepath=PropsUtil.class.getProtectionDomain().getCodeSource().getLocation().getFile();
            filepath=filepath.substring(0,filepath.lastIndexOf("/")+1);
            File propfile=new File(filepath+filename);
            inputStream = new FileInputStream(propfile);
            if (inputStream == null) {
                throw new FileNotFoundException(filename + " is not found");
            }
            props = new Properties();
            props.load(inputStream);
        } catch (IOException e) {
            LOGGER.error("load DataBase Properties file failure", e);
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    LOGGER.error("close InputStream failure", e);
                }
            }
        }
        return props;
    }

    /**
     * 获取字符串属性（默认为空）
     *
     * @param props 属性对象
     * @param key   属性键名
     * @return 属性值
     */
    public static String getString(Properties props, String key) {
        return getString(props, key, "");
    }

    /**
     * 获取字符串属性（可指定默认值）
     *
     * @param props        属性对象
     * @param key          属性键名
     * @param defaultvalue 默认值
     * @return 属性值
     */
    public static String getString(Properties props, String key, String defaultvalue) {
        String value = defaultvalue;
        if (props.containsKey(key)) {
            value = props.getProperty(key);
        }
        return value;
    }

    /**
     * 获取整型数属性（可指定默认值）
     *
     * @param props        属性对象
     * @param key          属性键名
     * @param defaultvalue 默认值
     * @return 属性值
     */
    public static int getInt(Properties props, String key, int defaultvalue) {
        int value = defaultvalue;
        if (props.containsKey(key)) {
            value =Integer.parseInt(props.getProperty(key));
        }
        return value;
    }
    /**
     * 获取字符串属性（默认为空）
     *
     * @param props 属性对象
     * @param key   属性键名
     * @return 属性值
     */
    public static int getInt(Properties props, String key) {
        return getInt(props, key, 0);
    }

}
