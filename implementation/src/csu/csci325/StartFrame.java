package csu.csci325;

import com.sun.deploy.uitoolkit.Window;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class StartFrame {

    //public static void main (String[] args){
        public StartFrame() {
        JFrame startFrame = new JFrame ("Start Panel");
        startFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        startFrame.setPreferredSize(new Dimension(400, 300));
        StartPanel startPanel = new StartPanel();
        startFrame.getContentPane().add(startPanel);

        startFrame.pack();
        startFrame.setVisible(true);

        //SetupFrame setupFrame =
                //new SetupFrame();
        //startFrame.setVisible(false);
    }

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
            welcomePane.setLayout(new BoxLayout(welcomePane, BoxLayout.PAGE_AXIS));
            welcomePane.add(Box.createRigidArea(new Dimension(0, 50)));
            welcomePane.add(welcome);
            welcomePane.add(Box.createRigidArea(new Dimension(0,100)));
            welcomePane.setVisible(true);

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
            add(buttonsPane, BorderLayout.SOUTH);

        }
        public class ButtonListener implements ActionListener{
            //private AccessibleComponent startFrame;

            private Window startFrame;

            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == setup) {
                    new SetupFrame();
                    startFrame.setVisible(false);
                    startFrame.dispose();
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

}
