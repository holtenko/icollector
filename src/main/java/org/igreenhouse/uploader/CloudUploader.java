package org.igreenhouse.uploader;

import org.igreenhouse.service.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Timestamp;
import java.util.TimerTask;

/**
 * Created by AllenKO on 2015/10/30.
 * 发送室外数据采集命令相关的类
 */
public class CloudUploader implements Runnable {
    private static final Logger LOGGER = LoggerFactory.getLogger(CloudUploader.class);

    @Override
    public void run() {
        int[] uploadInfo = UploadService.uploadToCloud();
        int fallNum = uploadInfo[0] - uploadInfo[1];//上传失败的记录的数量
        if (0 == fallNum) {
            System.out.println("Upload " + uploadInfo[0] + " records successfully at " + new Timestamp(System.currentTimeMillis()));
        } else {
            LOGGER.error("WARNING: Upload " + fallNum + " records failure ");
        }
    }
}
