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

    public JCheckBox rent;
    public JCheckBox food;
    public JCheckBox entertain;
    public JCheckBox loans;
    public JCheckBox savings;
    public JCheckBox credit;
    public JCheckBox fuel;
    public JCheckBox manual;
    public JTextField manualcat;

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

        monthlyIncome = new JTextField(20);

        rent = new JCheckBox("Rent/Mortgage");
        food = new JCheckBox("Food/Grocery");
        entertain = new JCheckBox("Entertainment");
        loans = new JCheckBox("Loans");
        savings = new JCheckBox("Savings");
        credit = new JCheckBox("Credit Card");
        fuel = new JCheckBox("Fuel");
        manual = new JCheckBox("Manual Category");
        manualcat = new JTextField(20);

        submit1 = new JButton("Submit");
        setPriority = new JComboBox();
        submit2 = new JButton("Submit");

        setup = new JButton ("Setup");
        addExpense = new JButton ("Add Expense");
        tracking = new JButton ("Tracking");
        userProfile = new JButton ("User Profile");

        ButtonListener listener = new ButtonListener();
        setup.addActionListener(listener);
        addExpense.addActionListener(listener);
        tracking.addActionListener(listener);
        userProfile.addActionListener(listener); //(new userProfileListener())


        //PANELS

        /*JPanel titlePane = new JPanel();
        titlePane.setLayout(new BoxLayout(titlePane, BoxLayout.Y_AXIS));
        titlePane.add(Box.createRigidArea(new Dimension(50, 15)));
        titlePane.add(title);
        titlePane.add(Box.createRigidArea(new Dimension(0, 50)));*/

        JPanel incomePane = new JPanel();
        incomePane.setLayout(new BoxLayout(incomePane, BoxLayout.Y_AXIS));
        //incomePane.add(Box.createRigidArea(new Dimension(0, 30)));
        JLabel monthlyLabel = new JLabel("Enter your Monthly Income: ");
        incomePane.add(monthlyLabel);
        incomePane.add(monthlyIncome);
        //incomePane.add(Box.createRigidArea(new Dimension(0, 50)));

        JPanel selectPane = new JPanel();
        JLabel catLabel = new JLabel("Select the categories you want to track: ");
        selectPane.add(catLabel);
        //selectPane.setLayout(new GridLayout(2, 4));
        selectPane.add(rent);
        selectPane.add(food);
        selectPane.add(entertain);
        selectPane.add(loans);
        selectPane.add(savings);
        selectPane.add(credit);
        selectPane.add(fuel);
        selectPane.add(manual);
            if(manual.isSelected()){
                selectPane.add(manualcat);
            }
        selectPane.add(submit1);

        JPanel priorityPane = new JPanel();
        priorityPane.setLayout(new BoxLayout(priorityPane, BoxLayout.LINE_AXIS));
        JLabel priorityLabel = new JLabel("Select your top categories: ");
        priorityPane.add(priorityLabel);
        priorityPane.add(setPriority);
        priorityPane.add(Box.createHorizontalStrut(100));
        priorityPane.add(Box.createVerticalBox());
        priorityPane.add(submit2);


        JPanel buttonsPane = new JPanel();
        buttonsPane.setLayout(new BoxLayout(buttonsPane, BoxLayout.LINE_AXIS));
        buttonsPane.add(Box.createHorizontalGlue());
        buttonsPane.add(setup);
        buttonsPane.add(addExpense);
        buttonsPane.add(tracking);
        buttonsPane.add(userProfile);
        buttonsPane.setVisible(true);

        JPanel setupPane = new JPanel();
        setupPane.setLayout(new GridBagLayout());
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
        setupPane.add(title, c);

        c.gridwidth = GridBagConstraints.REMAINDER;
        c.weightx = 1.0;
        c.weighty = 1;
        c.gridx = 0;
        c.gridy = 2;
        setupPane.add(incomePane, c);

        c.gridwidth = GridBagConstraints.REMAINDER;
        c.weightx = 1.0;
        c.weighty = 1;
        c.gridx = 0;
        c.gridy = 3;
        setupPane.add(selectPane, c);

        c.gridwidth = GridBagConstraints.REMAINDER;
        c.weightx = 1.0;
        c.weighty = 1;
        c.gridx = 0;
        c.gridy = 4;
        setupPane.add(priorityPane, c);

        c.gridwidth = 1;
        c.weightx = 1.0;
        c.weighty = 1.0;
        c.gridx = 0;
        c.gridy = 5;
        setupPane.add(setup, c);
        c.gridwidth = 1;
        c.gridx = 1;
        c.gridy = 5;
        setupPane.add(addExpense, c);
        c.gridwidth = 1;
        c.gridx = 2;
        c.gridy = 5;
        setupPane.add(tracking,c);
        c.gridwidth = 1;
        c.gridx = 3;
        c.gridy = 5;
        setupPane.add(userProfile, c);

        add(setupPane);

    }
    private class ButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            /*if (e.getSource() == addExpense){
                new AddExpenseFrame();
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
