package csu.csci325;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TrackingFrame extends JFrame {

    private JLabel title;

    private JButton pieButton;
    private JButton exVIncomeButton;
    private JButton listButton;

    boolean pieClick;
    boolean exVIncClick;
    boolean listClick;

    private JButton setup;
    private JButton addExpense;
    private JButton tracking;
    private JButton userProfile;


    public TrackingFrame() {
        JFrame TrackingFrame = new JFrame("Tracking Panel");

        TrackingFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //addExpenseFrame.setPreferredSize(new Dimension(400, 300));
        TrackingPanel trackingPanel = new TrackingPanel();
        TrackingFrame.getContentPane().add(trackingPanel);

        TrackingFrame.pack();
        TrackingFrame.setVisible(true);
    }

    public class TrackingPanel extends JPanel {
        public TrackingPanel(){
            title = new JLabel("Tracking");
            title.setFont(new Font("Arial", Font.BOLD, 28));

            pieButton = new JButton("Pie Chart View");
            exVIncomeButton = new JButton("Expense Vs. Income View");
            listButton = new JButton("List View");

            setup = new JButton("Setup");
            addExpense = new JButton("Add Expense");
            tracking = new JButton("Tracking");
            userProfile = new JButton("User Profile");

            ButtonListener listener = new ButtonListener();
            setup.addActionListener(listener);
            addExpense.addActionListener(listener);
            tracking.addActionListener(listener);
            userProfile.addActionListener(listener);

            TrackingButtonListener trackingListener = new TrackingButtonListener();
            pieButton.addActionListener(trackingListener);
            exVIncomeButton.addActionListener(trackingListener);
            listButton.addActionListener(trackingListener);

            //PANELS
            JPanel viewTypePane = new JPanel();
            viewTypePane.setLayout(new BoxLayout(viewTypePane, BoxLayout.X_AXIS));
            viewTypePane.add(pieButton);
            viewTypePane.add(exVIncomeButton);
            viewTypePane.add(listButton);

            JPanel pieChart = new JPanel();
            pieChart.add(new PieChart2());

            JPanel exVIncomeChart = new JPanel();
            JPanel listChart = new JPanel();
            JPanel buttonsPane = new JPanel();

            buttonsPane.setLayout(new BoxLayout(buttonsPane, BoxLayout.LINE_AXIS));
            buttonsPane.add(Box.createHorizontalGlue());
            buttonsPane.add(setup);
            buttonsPane.add(addExpense);
            buttonsPane.add(tracking);
            buttonsPane.add(userProfile);

            JPanel trackingPane = new JPanel();
            trackingPane.setLayout(new GridBagLayout());
            GridBagConstraints c = new GridBagConstraints();
            c.fill = GridBagConstraints.BOTH;

            c.weightx = .5;
            c.weighty = .5;
            c.gridwidth = 1;
            c.gridx = 0;
            c.gridy = 0;
            c.gridwidth = 1;
            c.gridx = 1;
            c.gridy = 0;
            c.gridwidth = 1;
            c.gridx = 2;
            c.gridy = 0;
            c.gridwidth = 1;
            c.gridx = 3;
            c.gridy = 0;
            c.gridwidth = 1;
            c.gridx = 4;
            c.gridy = 0;

            c.gridwidth = GridBagConstraints.REMAINDER;
            c.gridheight = 1;
            c.ipady = 30;
            c.weightx = 1.0;
            c.weighty = 1.0;
            c.gridx = 0;
            c.gridy = 1;
            trackingPane.add(title, c);

            c.gridwidth = GridBagConstraints.REMAINDER;
            c.gridheight = 1;
            c.ipady = 30;
            c.weightx = 1.0;
            c.weighty = 1.0;
            c.gridx = 0;
            c.gridy = 2;
            trackingPane.add(viewTypePane, c);

            c.gridwidth = GridBagConstraints.REMAINDER;
            c.gridheight = 3;
            c.ipady = 30;
            c.weightx = 1.0;
            c.weighty = 1.0;
            c.gridx = 0;
            c.gridy = 3;
            if (pieClick){
                trackingPane.add(pieChart, c);
            }else if (exVIncClick){
                trackingPane.add(exVIncomeChart, c);
            }else if (listClick){
                trackingPane.add(listChart, c);
            }

            c.gridwidth = 1;
            c.weightx = 1.0;
            c.weighty = 1.0;
            c.gridx = 0;
            c.gridy = 4;
            trackingPane.add(setup, c);
            c.gridwidth = 1;
            c.gridx = 1;
            c.gridy = 4;
            trackingPane.add(addExpense, c);
            c.gridwidth = 1;
            c.gridx = 2;
            c.gridy = 4;
            trackingPane.add(tracking, c);
            c.gridwidth = 1;
            c.gridx = 3;
            c.gridy = 4;
            trackingPane.add(userProfile, c);

            add(trackingPane);
        }
    }

    private class ButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {

        }
    }

    private class TrackingButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == pieButton) {
                pieClick = true;
                new PieChart2();
            }
            if (e.getSource() == exVIncomeButton) {
                exVIncClick = true;
                new PieChart();
            }
            if (e.getSource() == listButton) {
                listClick = true;
                new PieChart();
            }
        }
    }
}
