package csu.csci325;

import javax.swing.JFrame;

public class StartFrame {
    public static void main (String[] args){
        JFrame startFrame = new JFrame ("Start Panel");
        startFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        StartPanel startPanel = new StartPanel();
        startFrame.getContentPane().add(startPanel);

        startFrame.pack();
        startFrame.setVisible(true);
    }
}
