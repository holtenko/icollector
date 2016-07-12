package org.igreenhouse.main;

import org.igreenhouse.service.ReadDataService;
import org.igreenhouse.views.MainForm;

import javax.swing.*;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * Created by allenko on 2016/5/30.
 */
public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("MainForm");
        MainForm mainForm = new MainForm();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setContentPane(mainForm.getMainPanel());
    }
}
