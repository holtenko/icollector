package org.igreenhouse.views;

import gnu.io.SerialPort;
import org.igreenhouse.listener.IndoorListener;
import org.igreenhouse.sender.IndoorSender;
import org.igreenhouse.service.ListenerService;
import org.igreenhouse.util.SerialPortUtil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.BlockingQueue;

/**
 * Created by allenko on 2016/5/30.
 */
public class MainForm {
    private JPanel MainPanel;
    private JTextField TextField;
    private JTextField a0TextField6;
    private JTextField a0TextField7;
    private JTextField a0TextField4;
    private JTextField a0TextField3;
    private JTextField a0TextField9;
    private JTextField a0TextField17;
    private JTextField a0TextField23;
    private JTextField a0TextField29;
    private JTextField a0TextField33;
    private JTextField a0TextField10;
    private JTextField a0TextField18;
    private JTextField a0TextField20;
    private JTextField a0TextField26;
    private JTextField a0TextField36;
    private JTextField a0TextField;
    private JTextField a0TextField1;
    private JTextField a0TextField5;
    private JTextField a0TextField2;
    private JTextField a0TextField8;
    private JTextField a0TextField16;
    private JTextField a0TextField22;
    private JTextField a0TextField27;
    private JTextField a0TextField32;
    private JTextField a0TextField13;
    private JTextField a0TextField14;
    private JTextField a0TextField24;
    private JTextField a0TextField30;
    private JTextField a0TextField37;
    private JTextField a0TextField12;
    private JTextField a0TextField19;
    private JTextField a0TextField21;
    private JTextField a0TextField28;
    private JTextField a0TextField34;
    private JTextField a0TextField11;
    private JTextField a0TextField15;
    private JTextField a0TextField25;
    private JTextField a0TextField31;
    private JTextField a0TextField35;
    private JPanel ZEDPanel;
    private JPanel RoutePanel;
    private JButton StartBtn;
    private JButton StopBtn;
    private JTextArea logArea;
    private JPanel LogPanel;
    private JPanel ButtonPanel;
    private JComboBox portListComboBox;
    private JScrollPane logScrollPane;
    private JTextField sample_cycle;
    private JButton setButton;
    private JTextField sample_time;

    private HashMap<String, JTextField> deviceMap;

    private BlockingQueue byteQueue;

    ArrayList<String> portList = SerialPortUtil.findPort();//串口列表
    SerialPort ZCPort;

    public MainForm(final BlockingQueue byteQueue) {
        this.byteQueue = byteQueue;
        deviceMap = new HashMap();
        JPanel[] panels = {RoutePanel, ZEDPanel};
        getComponents(panels, deviceMap);

        final MainForm mainForm = this;
        for (String portName : portList) {
            portListComboBox.addItem(portName);
        }

        StartBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ZCPort = SerialPortUtil.openPort((String) portListComboBox.getSelectedItem(), 115200);
                ListenerService.addListener(ZCPort, new IndoorListener(ZCPort, mainForm,byteQueue));
            }
        });

        setButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                IndoorSender indoorSender = new IndoorSender(ZCPort, mainForm);
                indoorSender.setTime(Integer.parseInt(sample_cycle.getText()), Integer.parseInt(sample_time.getText()));
            }
        });
    }

    private void getComponents(JPanel[] panels, HashMap map) {
        for (JPanel panel : panels) {
            Component[] components = panel.getComponents();
            for (Component com : components) {
                if (com.getClass() == JTextField.class) {
                    JTextField jtf = (JTextField) com;
                    map.put(jtf.getName(), jtf);
                }
            }
        }
    }

    public JPanel getMainPanel() {
        return MainPanel;
    }

    public HashMap<String, JTextField> getDeviceMap() {
        return deviceMap;
    }

    public JTextArea getLogArea() {
        return logArea;
    }
}
