package org.igreenhouse.main;

import org.igreenhouse.service.ReadData;
import org.igreenhouse.views.MainForm;

import javax.swing.*;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * Created by allenko on 2016/5/30.
 */
public class Main {
    public static void main(String[] args) {
        BlockingQueue queue = new LinkedBlockingDeque();
        JFrame frame = new JFrame("MainForm");
        MainForm mainForm = new MainForm(queue);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setContentPane(mainForm.getMainPanel());
        new Thread(new ReadData(queue)).start();
    }
}
