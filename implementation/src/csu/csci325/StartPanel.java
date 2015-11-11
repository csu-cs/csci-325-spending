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
        welcome = new JLabel ("SPENDING TRACKER");
        welcome.setFont (new Font ("Arial", Font.BOLD,32));

        setup = new JButton ("Setup");
        addExpense = new JButton ("Add Expense");
        tracking = new JButton ("Tracking");
        userProfile = new JButton ("User Profile");

        setup.addActionListener (new setupListener());
        addExpense.addActionListener(new addExpenseListener());
        tracking.addActionListener(new trackingListener());
        userProfile.addActionListener(new userProfileListener());

        add(setup);
        add(addExpense);
        add(tracking);
        add(userProfile);
        add(welcome);
    }

    private class setupListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {

        }
    }
    private class addExpenseListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {

        }
    }
    private class trackingListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

        }
    }
    private class userProfileListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

        }
    }
}
