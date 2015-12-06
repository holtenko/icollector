package org.igreenhouse.uploader;

import org.igreenhouse.service.DataInService;
import org.igreenhouse.service.DataOutService;
import org.igreenhouse.service.DataProcessService;
import org.igreenhouse.service.UploadService;

import java.sql.Timestamp;
import java.util.TimerTask;

/**
 * Created by AllenKO on 2015/10/30.
 * 发送室外数据采集命令相关的类
 */
public class CloudUploader extends TimerTask {

    @Override
    public void run() {
        int[] uploadinfo = UploadService.uploadToCloud();
        if (0 == uploadinfo[1]) {
            System.out.println("Upload " + uploadinfo[0] + " records successfully at " + new Timestamp(System.currentTimeMillis()));
        } else {
            System.out.println("WARNING: Upload " + uploadinfo[1] + " records failure at " + new Timestamp(System.currentTimeMillis()));
        }
    }
}
