package csu.csci325;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by N'dia on 11/11/2015.
 */
public class SetupPanel extends JPanel {
    private JLabel title;
    public JTextField monthlyIncome;
    public JCheckBox catSelection;
    public JButton submit1;
    public JComboBox setPriority;
    public JButton submit2;


    private JButton setup;
    private JButton addExpense;
    private JButton tracking;
    private JButton userProfile;

    public SetupPanel() {

        title = new JLabel ("Setup");
        title.setFont (new Font("Arial", Font.BOLD,28));

        monthlyIncome = new JTextField();
        catSelection = new JCheckBox();
        submit1 = new JButton("Submit");
        setPriority = new JComboBox();
        submit2 = new JButton("Submit");

        setup = new JButton ("Setup");
        addExpense = new JButton ("Add Expense");
        tracking = new JButton ("Tracking");
        userProfile = new JButton ("User Profile");

        ButtonListener listener = new ButtonListener();
        setup.addActionListener (listener);
        addExpense.addActionListener(listener);
        tracking.addActionListener(listener);
        userProfile.addActionListener(listener); //(new userProfileListener())


        JPanel titlePane = new JPanel();
        titlePane.setLayout(new BoxLayout(titlePane, BoxLayout.PAGE_AXIS));
        titlePane.add(Box.createRigidArea(new Dimension(0, 25)));
        titlePane.add(title);
        titlePane.add(Box.createRigidArea(new Dimension(0, 50)));
        titlePane.setVisible(true);

        JPanel dataPane = new JPanel();
        dataPane.setLayout(new BoxLayout(dataPane, BoxLayout.Y_AXIS));
        dataPane.add(monthlyIncome);
        dataPane.add(catSelection);
        dataPane.add(submit1);
        dataPane.add(setPriority);
        dataPane.add(submit2);


        JPanel buttonsPane = new JPanel();
        buttonsPane.setLayout(new BoxLayout(buttonsPane, BoxLayout.LINE_AXIS));
        buttonsPane.add(Box.createHorizontalGlue());
        buttonsPane.add(setup);
        buttonsPane.add(addExpense);
        buttonsPane.add(tracking);
        buttonsPane.add(userProfile);
        buttonsPane.setVisible(true);

        add(titlePane, BorderLayout.CENTER);
        add(dataPane,BorderLayout.NORTH);
        add(buttonsPane, BorderLayout.SOUTH);

    }
    private class ButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            /*if (e.getSource() == addExpense){
                new addExpenseFrame().setVisible(true);
                //this.dispose();
            }
            else if (e.getSource() == tracking){
                new trackingFrame().setVisible(true);
                //this.dispose();
            }
            else if (e.getSource() == userProfile){
                new userProfileFrame().setVisible(true);
                //this.dispose();
            }
            else;*/
        }
    }
}
