package org.igreenhouse.views;

import org.igreenhouse.threads.ShowDataThread;

import javax.swing.*;

import java.awt.Component;
import java.util.HashMap;

/**
 * Created by holten on 2016/7/12.
 */
public class MainForm {
    private JPanel MainPanel;
    private JTextField RouteCount1;
    private JTextField RouteCount2;
    private JTextField RouteCount3;
    private JTextField RouteCount4;
    private JTextField RouteValue1;
    private JTextField RouteValue2;
    private JTextField RouteValue3;
    private JTextField RouteValue4;
    private JTextField RouteCount5;
    private JTextField RouteCount6;
    private JTextField RouteValue6;
    private JTextField EndCount1;
    private JTextField EndCount6;
    private JTextField RouteCount7;
    private JTextField RouteCount8;
    private JTextField RouteCount9;
    private JTextField EndCount2;
    private JTextField EndCount3;
    private JTextField EndCount4;
    private JTextField EndCount5;
    private JTextField EndCount7;
    private JTextField EndCount8;
    private JTextField EndCount9;
    private JTextField EndCount10;
    private JTextField EndCount11;
    private JTextField EndCount12;
    private JTextField EndCount13;
    private JTextField EndCount14;
    private JTextField EndCount15;
    private JTextField EndCount16;
    private JTextField EndCount17;
    private JTextField EndCount18;
    private JTextField EndCount19;
    private JTextField EndCount20;
    private JTextField EndCount21;
    private JTextField EndCount22;
    private JTextField EndCount23;
    private JTextField EndCount24;
    private JTextField EndCount25;
    private JTextField EndCount26;
    private JTextField EndCount27;
    private JTextField EndCount28;
    private JTextField EndCount29;
    private JTextField EndCount30;
    private JTextField RouteValue5;
    private JTextField RouteValue7;
    private JTextField RouteValue8;
    private JTextField RouteValue9;
    private JTextField EndValue1;
    private JTextField EndValue2;
    private JTextField EndValue3;
    private JTextField EndValue4;
    private JTextField EndValue5;
    private JTextField EndValue6;
    private JTextField EndValue7;
    private JTextField EndValue8;
    private JTextField EndValue9;
    private JTextField EndValue10;
    private JTextField EndValue11;
    private JTextField EndValue12;
    private JTextField EndValue13;
    private JTextField EndValue14;
    private JTextField EndValue15;
    private JTextField EndValue16;
    private JTextField EndValue17;
    private JTextField EndValue18;
    private JTextField EndValue19;
    private JTextField EndValue20;
    private JTextField EndValue21;
    private JTextField EndValue22;
    private JTextField EndValue23;
    private JTextField EndValue24;
    private JTextField EndValue25;
    private JTextField EndValue26;
    private JTextField EndValue27;
    private JTextField EndValue28;
    private JTextField EndValue29;
    private JTextField EndValue30;
    private JLabel RouteLable;
    private JLabel EndLable;
    private JTextField OutCount;
    private JTextField OutValue;
    private JTextField SolarCount;
    private JTextField SolarValue;
    private JTextField RainfallCount;
    private JTextField RainfallValue;
    private static HashMap<String, JTextField> deviceMap;

    public MainForm() {
        deviceMap = new HashMap();
        Component[] components = MainPanel.getComponents();
        for (Component com : components) {
            if (com.getClass() == JTextField.class) {
                JTextField jtf = (JTextField) com;
                deviceMap.put(jtf.getName(), jtf);
            }
        }
    }

    public JPanel getMainPanel() {
        return MainPanel;
    }

    public HashMap<String, JTextField> getDeviceMap() {
        return deviceMap;
    }
}
