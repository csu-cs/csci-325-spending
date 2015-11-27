package csu.csci325;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static csu.csci325.Category.incomeCat;

public class SetupFrame extends JFrame{
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

    private JLabel warning;
    private JLabel update;


    public CategoryList catList = new CategoryList();
    //static JPanel setupPane = new JPanel();


    private JButton setup;
    private JButton addExpense;
    private JButton tracking;
    private JButton userProfile;



    public SetupFrame() {
        JFrame setupFrame = new JFrame("Setup Panel");

        setupFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        setupFrame.setPreferredSize(new Dimension(400, 500));
        SetupPanel setupPanel = new SetupPanel();
        setupFrame.getContentPane().add(setupPanel);

        setupFrame.pack();
        setupFrame.setVisible(true);
    }

    public class SetupPanel extends JPanel {
        public SetupPanel(){
            title = new JLabel("Setup");
            title.setFont(new Font("Arial", Font.BOLD, 28));

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

            SetupListener checkCategories = new SetupListener();
            monthlyIncome.addActionListener(checkCategories);
            rent.addActionListener(checkCategories);
            food.addActionListener(checkCategories);
            entertain.addActionListener(checkCategories);
            loans.addActionListener(checkCategories);
            savings.addActionListener(checkCategories);
            credit.addActionListener(checkCategories);
            fuel.addActionListener(checkCategories);
            manual.addActionListener(checkCategories);
            submit1.addActionListener(checkCategories);

            warning = new JLabel();
            update = new JLabel();


            setup = new JButton("Setup");
            addExpense = new JButton("Add Expense");
            tracking = new JButton("Tracking");
            userProfile = new JButton("User Profile");

            ButtonListener listener = new ButtonListener();
            setup.addActionListener(listener);
            addExpense.addActionListener(listener);
            tracking.addActionListener(listener);
            userProfile.addActionListener(listener); //(new userProfileListener())


            //PANELS
            JPanel incomePane = new JPanel();
            incomePane.setLayout(new BoxLayout(incomePane, BoxLayout.Y_AXIS));
            //incomePane.add(Box.createRigidArea(new Dimension(0, 30)));
            JLabel monthlyLabel = new JLabel("<html>Enter your Monthly Income in decimal format" +
                    "<br>" + "without '$' or other special characters.</html>");
            incomePane.add(monthlyLabel);
            incomePane.add(monthlyIncome);

            final JPanel selectPane = new JPanel();
            JLabel catLabel = new JLabel("Select the categories you want to track: ");
            selectPane.add(catLabel);
            selectPane.setLayout(new BoxLayout(selectPane, BoxLayout.Y_AXIS));
            selectPane.add(rent);
            selectPane.add(food);
            selectPane.add(entertain);
            selectPane.add(loans);
            selectPane.add(savings);
            selectPane.add(credit);
            selectPane.add(fuel);
            selectPane.add(manual);
            //MOVE DOWN TO ACTION LISTENER
            if (manual.isSelected()) {
                selectPane.add(manualcat);
            }
            selectPane.add(submit1);
            selectPane.add(warning);
            selectPane.add(update);

            JPanel buttonsPane = new JPanel();
            buttonsPane.setLayout(new BoxLayout(buttonsPane, BoxLayout.LINE_AXIS));
            buttonsPane.add(Box.createHorizontalGlue());
            buttonsPane.add(setup);
            buttonsPane.add(addExpense);
            buttonsPane.add(tracking);
            buttonsPane.add(userProfile);
            //buttonsPane.setVisible(true);

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

            /*c.gridwidth = GridBagConstraints.REMAINDER;
            c.weightx = 1.0;
            c.weighty = 1;
            c.gridx = 0;
            c.gridy = 4;
            setupPane.add(priorityPane, c);*/

            /*c.gridwidth = 1;
            c.weightx = 1.0;
            c.weighty = 1.0;
            c.gridx = 0;
            c.gridy = 4;
            setupPane.add(setup, c);
            c.gridwidth = 1;
            c.gridx = 1;
            c.gridy = 4;
            setupPane.add(addExpense, c);
            c.gridwidth = 1;
            c.gridx = 2;
            c.gridy = 4;
            setupPane.add(tracking, c);
            c.gridwidth = 1;
            c.gridx = 3;
            c.gridy = 4;
            setupPane.add(userProfile, c);*/

            add(setupPane);
        }

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

    public class SetupListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            double income;

            if (e.getSource() == submit1) {
                //SHOW ERROR MESSAGE IF TEXT BOX IS EMPTY

                if (monthlyIncome.getText().isEmpty()){
                    warning.setForeground(Color.red);
                    warning.setText("Please enter an income!");
                }
                else if (monthlyIncome != null){
                    try {
                        Double.parseDouble(monthlyIncome.getText());
                        //System.out.println("Parse successful.");
                    }
                    catch(NumberFormatException nfe) {
                        //System.out.println("Parse unsuccessful.");
                        warning.setForeground(Color.red);
                        warning.setText("Input a decimal number without special characters.");
                    }
                    income = Double.parseDouble(monthlyIncome.getText());
                    incomeCat.mIncome = income;
                }else;


                System.out.println("Monthly Income: $" + incomeCat.mIncome);
                if(rent.isSelected()){
                    //Category rentMortgageCat = new Category();
                    catList.addString("Rent/Mortgage");
                }
                if (food.isSelected()){
                    //Category foodGroceryCat = new Category();
                    catList.addString("Food/Grocery");
                }
                if (entertain.isSelected()){
                    //Category entertainmentCat = new Category();
                    catList.addString("Entertainment");
                }
                if (loans.isSelected()){
                    //Category loansCat = new Category();
                    catList.addString("Loans");
                }
                if (savings.isSelected()) {
                    //Category savingsCat = new Category();
                    catList.addString("Savings");
                }
                if (credit.isSelected()){
                    //Category creditCardCat = new Category();
                    catList.addString("Credit");
                }
                if (fuel.isSelected()){
                    //Category fuelCat = new Category();
                    catList.addString("Fuel");
                }
                if (manual.isSelected()){
                    //Category manualCategory = new Category();
                    catList.addString("Manual");
                }

                update.setText("<html>" + "Your income is: $" + Category.incomeCat.getIncome() +
                        "<br>" + "Categories added successfully!" +
                        "<br>" + "Exit out of this window to add and" +
                        "<br>" + "track expenses.</html>");

                monthlyIncome.setText("");
            }
            //catList.ListToString();
            AddExpenseFrame.categoryArray = catList.getAsArray();
            TrackingData.activeCategories = catList.categoryList;

        }
    }

}
