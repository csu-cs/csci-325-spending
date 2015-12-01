package csu.csci325;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StartFrame extends JFrame {
    private JLabel welcome;
    private JLabel subtitle;
    private JLabel startLabel;
    private JButton setup;
    private JButton addExpense;
    private JButton tracking;
    private JButton userProfile;

    private JPanel blankChart = new JPanel();

    public static void main(String[] args) {
        StartFrame startFrame = new StartFrame();
    }

    public StartFrame() {
        final JFrame startFrame = new JFrame ("Start Panel");
        startFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        startFrame.setPreferredSize(new Dimension(400, 425));

        StartPanel startPanel = new StartPanel();
        startFrame.getContentPane().add(startPanel).setBackground(Color.BLUE);

        startFrame.pack();
        startFrame.setVisible(true);
    }
    public class StartPanel extends JPanel {
        public StartPanel() {
            welcome = new JLabel("SPENDING TRACKER", SwingConstants.CENTER);
            welcome.setFont(new Font("Arial", Font.BOLD, 32));
            welcome.setForeground(Color.BLUE);

            subtitle = new JLabel("Easily keep track of your expenses.", SwingConstants.CENTER);
            subtitle.setFont(new Font("Arial", Font.ITALIC, 18));

            startLabel = new JLabel("Start by pressing the Setup button below.", SwingConstants.CENTER);
            startLabel.setFont(new Font("Arial", Font.PLAIN, 18));
            startLabel.setForeground(Color.RED);

            setup = new JButton("Setup");
            addExpense = new JButton("Add Expense");
            tracking = new JButton("Tracking");
            userProfile = new JButton("User Profile");

            ButtonListener listener = new ButtonListener();
            setup.addActionListener(listener);
            addExpense.addActionListener(listener);
            tracking.addActionListener(listener);
            userProfile.addActionListener(listener); //(new userProfileListener())

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
            c0.ipady = 45;
            c0.weightx = 1.0;
            c0.weighty = 1.0;
            c0.gridx = 0;
            c0.gridy = 3;
            welcomePane.add(startLabel, c0);

            c0.gridwidth = GridBagConstraints.REMAINDER;
            c0.gridheight = 9;
            c0.ipady = 55;
            c0.weightx = 0.0;
            c0.weighty = 0.0;
            c0.gridx = 0;
            c0.gridy = 4;
            welcomePane.add(blankChart, c0);

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

            welcomePane.setBorder(BorderFactory.createLineBorder(Color.BLACK, 5));

            add(welcomePane);
        }
    }
    public class ButtonListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == setup) {
                new SetupFrame();
                startLabel.setForeground(Color.BLUE);
                startLabel.setFont(new Font("Arial", Font.PLAIN, 12));
                startLabel.setText("You can still change your income and categories in Setup!");
            }
            else if (e.getSource() == addExpense){
                if (AddExpenseFrame.categoryArray == null){
                    startLabel.setForeground(Color.RED);
                    startLabel.setFont(new Font("Arial", Font.CENTER_BASELINE, 12));
                    startLabel.setText("<html>You need to set up your income and categories in Setup" +
                            "<br>" + "before adding any expenses!");
                }
                else
                    new AddExpenseFrame();


            }
            else if (e.getSource() == tracking){
                new TrackingFrame();

            }
            else if (e.getSource() == userProfile){
                new UserProfileFrame();
            }
        }
    }

}
