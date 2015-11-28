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

    private JPanel pieChart = new JPanel();
    private JPanel exVIncomeChart = new JPanel();
    private JPanel listChart = new JPanel();
    private JPanel blankChart = new JPanel();

    private JLabel blankLabel = new JLabel();
    private JLabel exVILabel = new JLabel();

    private JLabel pieData = new JLabel();
    private JLabel list = new JLabel();

    //static JPanel trackingPane = new JPanel();


    public TrackingFrame() {
        JFrame TrackingFrame = new JFrame("Tracking Panel");

        TrackingFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        TrackingFrame.setPreferredSize(new Dimension(450, 500));
        TrackingPanel trackingPanel = new TrackingPanel();
        TrackingFrame.getContentPane().add(trackingPanel).setBackground(Color.BLUE);

        TrackingFrame.pack();
        TrackingFrame.setVisible(true);
    }

    public class TrackingPanel extends JPanel {
        public TrackingPanel(){
            title = new JLabel("Tracking", SwingConstants.CENTER);
            title.setFont(new Font("Arial", Font.BOLD, 28));
            title.setForeground(Color.BLUE);

            pieButton = new JButton("Pie Chart View");
            exVIncomeButton = new JButton("Expense Vs. Income View");
            listButton = new JButton("List View");

            pieChart = new JPanel();
            exVIncomeChart = new JPanel();
            listChart = new JPanel();
            blankChart = new JPanel();

            blankLabel = new JLabel("Select a button above to view the chart.");
            exVILabel = new JLabel("", SwingConstants.CENTER);

            pieData = new JLabel("");
            list = new JLabel("");


            TrackingButtonListener trackingListener = new TrackingButtonListener();
            pieButton.addActionListener(trackingListener);
            exVIncomeButton.addActionListener(trackingListener);
            listButton.addActionListener(trackingListener);

            //PANELS//
            JPanel viewTypePane = new JPanel();
            viewTypePane.setLayout(new BoxLayout(viewTypePane, BoxLayout.X_AXIS));
            viewTypePane.add(pieButton);
            viewTypePane.add(exVIncomeButton);
            viewTypePane.add(listButton);

            //BLANK CHART
            blankChart.add(blankLabel);

            //PIE CHART
            pieChart.setLayout(new BoxLayout(pieChart, BoxLayout.Y_AXIS));
            pieChart.add(TrackingData.td.createPieChart());
            pieData.setText(TrackingData.td.pieChartData());
            pieChart.add(pieData);

            //LIST CHART
            list = new JLabel(TrackingData.td.toTextField());
            list.setFont(new Font("Arial", Font.BOLD, 14));
            listChart.add(list);

            //PROGRESS BAR(Expense vs. Income)
            exVIncomeChart.setLayout(new BoxLayout(exVIncomeChart, BoxLayout.Y_AXIS));
            exVIncomeChart.add(TrackingData.td.createProgressBar());
            exVILabel.setText("<html>" + "You are currently at "
                    + ((TrackingData.td.getTotalExpense() / (Category.incomeCat.getIncome()) * 100))
                    + "%" + "<br>" +
                    "of your income of $" + Category.incomeCat.getIncome() + ".</html>");
            exVIncomeChart.add(exVILabel);

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
            c.gridheight = 15;
            c.ipady = 30;
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

            trackingPane.setBorder(BorderFactory.createLineBorder(Color.BLACK, 5));

            add(trackingPane);
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
