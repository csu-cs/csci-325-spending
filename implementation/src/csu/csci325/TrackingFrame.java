package csu.csci325;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class TrackingFrame extends JFrame {

    private JLabel title;

    private JButton pieButton;
    private JButton exVIncomeButton;
    private JButton listButton;

    private JPanel pieChart = new JPanel();
    private JPanel exVIncomeChart = new JPanel();
    private JPanel listChart = new JPanel();
    private JPanel blankChart = new JPanel();

    private JButton setup;
    private JButton addExpense;
    private JButton tracking;
    private JButton userProfile;


    public TrackingFrame() {
        JFrame TrackingFrame = new JFrame("Tracking Panel");

        TrackingFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

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

            pieChart = new JPanel();
            exVIncomeChart = new JPanel();
            listChart = new JPanel();
            blankChart = new JPanel();

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

            //PIE CHART
            //PASS IN VALUES FROM CATEGORIES
            //WILL LIKELY BE FOR LOOPS FOR EACH CATEGORY
            ArrayList<Double> values = new ArrayList<Double>();
            values.add(new Double(10));
            values.add(new Double(20));
            values.add(new Double(30));
            values.add(new Double(15));
            values.add(new Double(15));

            ArrayList<Color> colors = new ArrayList<Color>();
            colors.add(Color.gray);
            colors.add(Color.green);
            colors.add(Color.blue);
            colors.add(Color.pink);
            colors.add(Color.yellow);

            PieChartFinal pc = new PieChartFinal(values, colors);
            pc.setSize(200,200);
            pieChart.add(pc);

            //JPanel exVIncomeChart = new JPanel();
            //JPanel listChart = new JPanel();
            //JPanel blankChart = new JPanel();
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
            c.gridheight = 5;
            c.ipady = 50;
            c.weightx = 0.0;
            c.weighty = 0.0;
            c.gridx = 0;
            c.gridy = 3;
            trackingPane.add(blankChart,c);
            trackingPane.add(pieChart,c);
            pieChart.setVisible(false);
            trackingPane.add(exVIncomeChart, c);
            exVIncomeChart.setVisible(false);
            trackingPane.add(listChart, c);
            listChart.setVisible(false);


            c.gridwidth = 1;
            c.weightx = 1.0;
            c.weighty = 1.0;
            c.gridx = 0;
            c.gridy = 8;
            trackingPane.add(setup, c);
            c.gridwidth = 1;
            c.gridx = 1;
            c.gridy = 8;
            trackingPane.add(addExpense, c);
            c.gridwidth = 1;
            c.gridx = 2;
            c.gridy = 8;
            trackingPane.add(tracking, c);
            c.gridwidth = 1;
            c.gridx = 3;
            c.gridy = 8;
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
                pieChart.setVisible(true);
                exVIncomeChart.setVisible(false);
                listChart.setVisible(false);
                blankChart.setVisible(false);

            }
            if (e.getSource() == exVIncomeButton) {
                pieChart.setVisible(false);
                exVIncomeChart.setVisible(true);
                listChart.setVisible(false);
                blankChart.setVisible(false);
            }
            if (e.getSource() == listButton) {
                pieChart.setVisible(false);
                exVIncomeChart.setVisible(false);
                listChart.setVisible(true);
                blankChart.setVisible(false);
            }
        }
    }
}
