package csu.csci325;

import javax.swing.*;
import java.awt.*;

/**
 * Created by N'dia on 11/11/2015.
 */
public class SetupFrame {
    public SetupFrame() {
        JFrame setupFrame = new JFrame("Setup Panel");

        setupFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setupFrame.setPreferredSize(new Dimension(400, 300));
        SetupPanel setupPanel = new SetupPanel();
        setupFrame.getContentPane().add(setupPanel);

        setupFrame.pack();
        setupFrame.setVisible(true);
    }
}
