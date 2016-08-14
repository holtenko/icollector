package org.igreenhouse.threads;

import org.igreenhouse.service.ParseAndSaveDataService;
import org.igreenhouse.views.MainForm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.swing.JTextField;
import java.awt.Color;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.BlockingQueue;

/**
 * Created by holten on 2016/7/16.
 */
public class ShowDataThread implements Runnable {
    private final Logger logger = LoggerFactory.getLogger(ShowDataThread.class);
    private BlockingQueue queue;
    private HashMap<String, JTextField> deviceMap;

    public ShowDataThread(MainForm mainForm) {
        queue = ParseAndSaveDataService.dataShowQueue;
        deviceMap = mainForm.getDeviceMap();
    }

    @Override
    public void run() {
        logger.info("ShowDataThread Run...");
        while (true) {
            try {
                Map<String, Object> dataShowMap = (Map) queue.take();
                long id = (long) dataShowMap.get("id");
                String type = (String) dataShowMap.get("type");
                String countTextBoxName = "";
                String valueTextBoxName = "";
                if ("in".equals(type)) {
                    if (id < 10) {
                        countTextBoxName = "RouteCount" + id;
                        valueTextBoxName = "RouteValue" + id;
                    } else {
                        countTextBoxName = "EndCount" + id;
                        valueTextBoxName = "EndValue" + id;
                    }
                } else if ("out".equals(type)) {
                    countTextBoxName = "OutCount";
                    valueTextBoxName = "OutValue";
                } else if ("rf".equals(type)) {
                    countTextBoxName = "RainfallCount";
                    valueTextBoxName = "RainfallValue";
                } else if ("sr".equals(type)) {
                    countTextBoxName = "SolarCount";
                    valueTextBoxName = "SolarValue";
                }

                JTextField countText = deviceMap.get(countTextBoxName);
                JTextField valueText = deviceMap.get(valueTextBoxName);

                int count = Integer.parseInt(countText.getText()) + 1;
                countText.setBackground(Color.WHITE);
                countText.setText(count + "");
                valueText.setText((String) dataShowMap.get("data"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
