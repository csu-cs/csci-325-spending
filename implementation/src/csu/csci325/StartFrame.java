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

    private JPanel blankChart = new JPanel();
    //public aSetupPanel asp = new aSetupPanel();
    //public static aAddExpensePanel aap = new aAddExpensePanel();

    public StartFrame() {
        final JFrame startFrame = new JFrame ("Start Panel");
        startFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        startFrame.setPreferredSize(new Dimension(400, 400));
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

            //asp = new aSetupPanel();
            //aap = new aAddExpensePanel();
            blankChart = new JPanel();

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

            c0.gridwidth = GridBagConstraints.REMAINDER;
            c0.gridheight = 10;
            c0.ipady = 60;
            c0.weightx = 0.0;
            c0.weighty = 0.0;
            c0.gridx = 0;
            c0.gridy = 3;
            welcomePane.add(blankChart, c0);

            //welcomePane.add(asp, c0);
            //asp.setVisible(false);
            //welcomePane.add(aap, c0);
            //aap.setVisible(false);
            //aap.categoryBox.setEnabled(false);

            c0.gridwidth = 1;
            c0.weightx = 1.0;
            c0.weighty = 1.0;
            c0.gridx = 0;
            c0.gridy = 13;
            welcomePane.add(setup, c0);
            c0.gridwidth = 1;
            c0.gridx = 1;
            c0.gridy = 13;
            welcomePane.add(addExpense, c0);
            c0.gridwidth = 1;
            c0.gridx = 2;
            c0.gridy = 13;
            welcomePane.add(tracking,c0);
            c0.gridwidth = 1;
            c0.gridx = 3;
            c0.gridy = 13;
            welcomePane.add(userProfile, c0);

            add(welcomePane);
        }
    }
    public class ButtonListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == setup) {
                new SetupFrame();
                //blankChart.setVisible(false);
                //asp.setVisible(true);
                //aap.setVisible(false);
            }
            else if (e.getSource() == addExpense){
                new AddExpenseFrame();
                //blankChart.setVisible(false);
                //asp.setVisible(false);
                //aap.categoryBox.setEnabled(true);
                //aap.setVisible(true);
            }
            else if (e.getSource() == tracking){
                new TrackingFrame();

            }
            else if (e.getSource() == userProfile){
                new UserProfileFrame();
            }
            else;
        }
    }

}
