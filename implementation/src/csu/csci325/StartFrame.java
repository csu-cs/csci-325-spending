package csu.csci325;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StartFrame extends JFrame {
    public JLabel welcome;
    public JLabel subtitle;
    public JButton setup;
    private JButton addExpense;
    private JButton tracking;
    private JButton userProfile;

    //public static void main (String[] args){
    public StartFrame() {
        final JFrame startFrame = new JFrame ("Start Panel");
        startFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        startFrame.setPreferredSize(new Dimension(400, 300));
        StartPanel startPanel = new StartPanel();
        startFrame.getContentPane().add(startPanel);

        startFrame.pack();
        startFrame.setVisible(true);
    }
    public class StartPanel extends JPanel {
        public StartPanel() {
            welcome = new JLabel("SPENDING TRACKER");
            welcome.setFont(new Font("Arial", Font.BOLD, 32));

            subtitle = new JLabel("Easily keep track of your expenses");
            subtitle.setFont(new Font("Arial", Font.ITALIC, 18));

            setup = new JButton("Setup");
            addExpense = new JButton("Add Expense");
            tracking = new JButton("Tracking");
            userProfile = new JButton("User Profile");

            ButtonListener listener = new ButtonListener();
            setup.addActionListener(listener);
            addExpense.addActionListener(listener);
            tracking.addActionListener(listener);
            userProfile.addActionListener(listener); //(new userProfileListener())


            /*JPanel welcomePane = new JPanel();
            welcomePane.setLayout(new BoxLayout(welcomePane, BoxLayout.PAGE_AXIS));
            welcomePane.add(Box.createRigidArea(new Dimension(0, 50)));
            welcomePane.add(welcome);
            welcomePane.add(Box.createRigidArea(new Dimension(0, 100)));
            //welcomePane.setVisible(true);

            JPanel buttonsPane = new JPanel();
            buttonsPane.setLayout(new BoxLayout(buttonsPane, BoxLayout.LINE_AXIS));
            buttonsPane.add(Box.createHorizontalGlue());
            buttonsPane.add(setup);
            buttonsPane.add(addExpense);
            buttonsPane.add(tracking);
            buttonsPane.add(userProfile);
            buttonsPane.setVisible(true);

            //Container contentPane = new Container();
            //Container contentPane = getContentPane();
            add(welcomePane, BorderLayout.CENTER);
            add(buttonsPane, BorderLayout.SOUTH);*/

            JPanel welcomePane = new JPanel();
            welcomePane.setLayout(new GridBagLayout());
            GridBagConstraints c0 = new GridBagConstraints();
            c0.fill = GridBagConstraints.BOTH;

            c0.weightx = .5;
            c0.weighty = .5;
            c0.gridx = 0;
            c0.gridy = 0;
            c0.gridx = 1;
            c0.gridy = 0;
            c0.gridx = 2;
            c0.gridy = 0;
            c0.gridx = 3;
            c0.gridy = 0;


            c0.gridwidth = GridBagConstraints.REMAINDER;
            c0.gridheight = 1;
            c0.ipady = 40;
            c0.weightx = 1.0;
            c0.weighty = 1.0;
            c0.gridx = 0;
            c0.gridy = 1;
            welcomePane.add(welcome, c0);

            c0.gridwidth = GridBagConstraints.REMAINDER;
            c0.ipady = 45;
            c0.weightx = 1.0;
            c0.weighty = 1.0;
            c0.gridx = 0;
            c0.gridy = 2;
            welcomePane.add(subtitle, c0);

            c0.gridwidth = 1;
            c0.weightx = 1.0;
            c0.weighty = 1.0;
            c0.gridx = 0;
            c0.gridy = 3;
            welcomePane.add(setup, c0);
            c0.gridwidth = 1;
            c0.gridx = 1;
            c0.gridy = 3;
            welcomePane.add(addExpense, c0);
            c0.gridwidth = 1;
            c0.gridx = 2;
            c0.gridy = 3;
            welcomePane.add(tracking,c0);
            c0.gridwidth = 1;
            c0.gridx = 3;
            c0.gridy = 3;
            welcomePane.add(userProfile, c0);

            add(welcomePane);
        }
    }
    public class ButtonListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == setup) {
                new SetupFrame();
                dispose();
            }/*
            else if (e.getSource() == addExpense){
                new addExpenseFrame().setVisible(true);
                this.dispose();
            }
            else if (e.getSource() == tracking){
                new trackingFrame().setVisible(true);
                this.dispose();
            }
            else if (e.getSource() == userProfile){
                new userProfileFrame().setVisible(true);
                this.dispose();
            }*/
            else;
        }
    }

}
