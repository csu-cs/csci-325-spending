package csu.csci325;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
/**
 * Created by N'dia on 11/11/2015.
 */
public class StartPanel extends JPanel{
    private JLabel welcome;
    private JButton setup;
    private JButton addExpense;
    private JButton tracking;
    private JButton userProfile;

    public StartPanel() {
        //setLayout(new GridLayout(1,4));
        //setLayout(new GridBagLayout());
        //JPanel buttonsPanel = new JPanel(new GridLayout(1,4));

        welcome = new JLabel ("SPENDING TRACKER");
        welcome.setFont (new Font ("Arial", Font.BOLD,32));

        setup = new JButton ("Setup");
        addExpense = new JButton ("Add Expense");
        tracking = new JButton ("Tracking");
        userProfile = new JButton ("User Profile");

        ButtonListener listener = new ButtonListener();
        setup.addActionListener (listener);
        addExpense.addActionListener(listener);
        tracking.addActionListener(listener);
        userProfile.addActionListener(listener); //(new userProfileListener())


        JPanel welcomePane = new JPanel();
        //welcomePane.setLayout(new BoxLayout(welcomePane, BoxLayout.PAGE_AXIS));
        welcomePane.setLayout(new GridBagLayout());
        GridBagConstraints c0 = new GridBagConstraints();
        c0.fill = GridBagConstraints.VERTICAL;
        //welcomePane.add(Box.createRigidArea(new Dimension(0, 50)));
        c0.ipady = 75;
        c0.weightx = 0.0;
        c0.weighty = 1.0;
        c0.gridwidth = 5;
        c0.gridx = 0;
        c0.gridy = 0;
        welcomePane.add(welcome, c0);
        //welcomePane.add(Box.createRigidArea(new Dimension(0, 100)));
        //welcomePane.setVisible(true);

        //JPanel buttonsPane = new JPanel();
        //buttonsPane.setLayout(new BoxLayout(buttonsPane, BoxLayout.LINE_AXIS));
        //buttonsPane.add(Box.createHorizontalGlue());
        c0.gridx = 1;
        c0.gridy = 1;
        welcomePane.add(setup, c0);
        c0.gridx = 2;
        c0.gridy = 1;
        welcomePane.add(addExpense, c0);
        c0.gridx = 3;
        c0.gridy = 1;
        welcomePane.add(tracking,c0);
        c0.gridx = 4;
        c0.gridy = 1;
        welcomePane.add(userProfile, c0);
        //buttonsPane.setVisible(true);

        //Container contentPane = new Container();
        //Container contentPane = getContentPane();
        add(welcomePane);
        //add(welcomePane, BorderLayout.CENTER);
        //add(buttonsPane, BorderLayout.SOUTH);

    }
    private class ButtonListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == setup) {
                new SetupFrame();
                //startFrame.setVisible(false);


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
            //else;
        }
    }
}
