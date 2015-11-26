package csu.csci325;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddExpenseFrame extends JFrame {

    private JLabel title;

    private JLabel selectCategoryLabel;
    private JComboBox categoryBox;

    public static String[] categoryArray;

    private JLabel amountLabel;
    private JTextField amount;
    private JButton submit;

    private JButton setup;
    private JButton addExpense;
    private JButton tracking;
    private JButton userProfile;

    public AddExpenseFrame() {
        JFrame addExpenseFrame = new JFrame("Add Expense Panel");

        addExpenseFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        //addExpenseFrame.setPreferredSize(new Dimension(400, 300));
        AddExpensePanel addExpensePanel = new AddExpensePanel();
        addExpenseFrame.getContentPane().add(addExpensePanel);

        addExpenseFrame.pack();
        addExpenseFrame.setVisible(true);

    }

    public class AddExpensePanel extends JPanel {
        public AddExpensePanel() {
            title = new JLabel("Add Expense");
            title.setFont(new Font("Arial", Font.BOLD, 28));

            ComboListener comboBoxListener = new ComboListener();

            selectCategoryLabel = new JLabel("Select category");
            categoryBox = new JComboBox(categoryArray);
            categoryBox.addActionListener(comboBoxListener);


            amountLabel = new JLabel("Amount: ");
            amount = new JTextField();
            submit = new JButton("Submit");

            submit.addActionListener(comboBoxListener);

            setup = new JButton("Setup");
            addExpense = new JButton("Add Expense");
            tracking = new JButton("Tracking");
            userProfile = new JButton("User Profile");

            ButtonListener listener = new ButtonListener();
            setup.addActionListener(listener);
            addExpense.addActionListener(listener);
            tracking.addActionListener(listener);
            userProfile.addActionListener(listener);

            //PANELS
            JPanel categoryPane = new JPanel();
            categoryPane.setLayout(new BoxLayout(categoryPane, BoxLayout.Y_AXIS));
            categoryPane.add(selectCategoryLabel);
            categoryPane.add(categoryBox);

            JPanel addAmountPane = new JPanel();
            addAmountPane.setLayout(new BoxLayout(addAmountPane, BoxLayout.Y_AXIS));
            addAmountPane.add(amountLabel);
            addAmountPane.add(amount);
            addAmountPane.add(submit);

            JPanel buttonsPane = new JPanel();
            buttonsPane.setLayout(new BoxLayout(buttonsPane, BoxLayout.LINE_AXIS));
            buttonsPane.add(Box.createHorizontalGlue());
            buttonsPane.add(setup);
            buttonsPane.add(addExpense);
            buttonsPane.add(tracking);
            buttonsPane.add(userProfile);
            //buttonsPane.setVisible(true);

            JPanel addExpensePane = new JPanel();
            addExpensePane.setLayout(new GridBagLayout());
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
            addExpensePane.add(title, c);

            c.gridwidth = GridBagConstraints.REMAINDER;
            c.weightx = 1.0;
            c.weighty = 1;
            c.gridx = 0;
            c.gridy = 2;
            addExpensePane.add(categoryPane, c);

            c.gridwidth = GridBagConstraints.REMAINDER;
            c.weightx = 1.0;
            c.weighty = 1;
            c.gridx = 0;
            c.gridy = 3;
            addExpensePane.add(addAmountPane, c);

            c.gridwidth = 1;
            c.weightx = 1.0;
            c.weighty = 1.0;
            c.gridx = 0;
            c.gridy = 4;
            addExpensePane.add(setup, c);
            c.gridwidth = 1;
            c.gridx = 1;
            c.gridy = 4;
            addExpensePane.add(addExpense, c);
            c.gridwidth = 1;
            c.gridx = 2;
            c.gridy = 4;
            addExpensePane.add(tracking, c);
            c.gridwidth = 1;
            c.gridx = 3;
            c.gridy = 4;
            addExpensePane.add(userProfile, c);

            add(addExpensePane);
        }
    }
    private class ButtonListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {

        }
    }

    public class ComboListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            double amountToAdd = 0;
            //double currentAmount;
            String addTo = "";
            Object src = e.getSource();
            //SOMEHOW GET SUBMIT BUTTON TO GATHER SELECTED ITEM AND TEXT IN TEXT FIELD

            if (src instanceof JComboBox) {
                JComboBox cb = (JComboBox) e.getSource();
                //src = cb;
                if (cb.getSelectedItem().equals("Rent/Mortgage")) {
                    addTo = "RENT";
                    //Category.rentMortgageCat.mIncome += amountToAdd;
                    //System.out.println(Category.rentMortgageCat.getExpense());
                }
                if (cb.getSelectedItem() == "Food/Grocery") {
                    addTo = "FOOD";
                    //Category.foodGroceryCat.mIncome += amountToAdd;
                    //System.out.println(Category.foodGroceryCat.getExpense());
                }
                if (cb.getSelectedItem() == "Entertainment") {
                    addTo = "ENTERTAIN";
                    //Category.entertainmentCat.mIncome += amountToAdd;
                    //System.out.println(Category.entertainmentCat.getExpense());
                }
                if (cb.getSelectedItem() == "Loans") {
                    addTo = "LOANS";
                    //Category.loansCat.mIncome += amountToAdd;
                    //System.out.println(Category.loansCat.getExpense());
                }
                if (cb.getSelectedItem() == "Savings") {
                    addTo = "SAVINGS";
                    //Category.savingsCat.mIncome += amountToAdd;
                    //System.out.println(Category.savingsCat.getExpense());
                }
                if (cb.getSelectedItem() == "Credit") {
                    addTo = "CREDIT";
                    //Category.creditCat.mIncome += amountToAdd;
                    //System.out.println(Category.creditCat.getExpense());
                }
                if (cb.getSelectedItem() == "Fuel") {
                    addTo = "FUEL";
                    //Category.fuelCat.mIncome += amountToAdd;
                    //System.out.println(Category.fuelCat.getExpense());
                }
                if (cb.getSelectedItem() == "Manual") {
                    addTo = "MANUAL";
                    //Category.manualCat.mIncome += amountToAdd;
                }
            }

            if(e.getSource() == submit) {
                amountToAdd = Double.parseDouble(amount.getText());
                switch (addTo){
                    case "RENT":
                        Category.rentMortgageCat.mExpense += amountToAdd;
                        System.out.println(amountToAdd);
                        System.out.println(Category.rentMortgageCat.mExpense);
                    case "FOOD":
                        Category.foodGroceryCat.mExpense += amountToAdd;
                        System.out.println(amountToAdd);
                        System.out.println(Category.foodGroceryCat.getExpense());
                    case "ENTERTAIN":
                        Category.entertainmentCat.mExpense += amountToAdd;
                    case "LOANS":
                        Category.loansCat.mExpense += amountToAdd;
                    case "SAVINGS":
                        Category.savingsCat.mExpense += amountToAdd;
                    case "CREDIT":
                        Category.creditCat.mExpense += amountToAdd;
                    case "FUEL":
                        Category.fuelCat.mExpense += amountToAdd;
                    case "MANUAL":
                        Category.manualCat.mExpense += amountToAdd;
                        break;
                    default: break;
                }
            }
        }
    }
}
