package csu.csci325;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.text.DecimalFormat;
import java.util.Objects;

import static csu.csci325.Category.*;
import static csu.csci325.UserInfo.*;

public class AddExpenseFrame extends JFrame {

    private JLabel title;

    private JLabel selectCategoryLabel;
    private JComboBox categoryBox;

    public static String[] categoryArray;

    private JLabel amountLabel;
    private JTextField amount;
    private JButton submit;

    private JLabel warningLabel = new JLabel();
    private JLabel updateLabel = new JLabel();
    private JLabel infoLabel = new JLabel();

    public String addTo = "";
    private DecimalFormat numberFormat = new DecimalFormat("#.00");

    public AddExpenseFrame() {
        JFrame addExpenseFrame = new JFrame("Add Expense Panel");

        addExpenseFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        addExpenseFrame.setPreferredSize(new Dimension(400, 425));
        AddExpensePanel addExpensePanel = new AddExpensePanel();
        addExpenseFrame.getContentPane().add(addExpensePanel).setBackground(Color.BLUE);

        addExpenseFrame.pack();
        addExpenseFrame.setVisible(true);

    }

    public class AddExpensePanel extends JPanel {
        public AddExpensePanel() {
            title = new JLabel("Add Expense", SwingConstants.CENTER);
            title.setFont(new Font("Arial", Font.BOLD, 28));
            title.setForeground(Color.BLUE);

            ComboListener comboBoxListener = new ComboListener();

            selectCategoryLabel = new JLabel("Select a category:", SwingConstants.HORIZONTAL);
            categoryBox = new JComboBox(categoryArray);
            categoryBox.addItemListener(comboBoxListener);
            categoryBox.setMaximumSize(new Dimension(175, 25));



            amountLabel = new JLabel("<html>Enter the Amount in decimal format" +
                    "<br>" + "without '$' or other special characters.</html>", SwingConstants.LEFT);
            amount = new JTextField();
            amount.setMaximumSize(new Dimension(200,25));
            submit = new JButton("Submit");

            SubmitListener sl = new SubmitListener();
            submit.addActionListener(sl);

            warningLabel = new JLabel("");
            updateLabel = new JLabel("");
            infoLabel = new JLabel("");


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
            addAmountPane.add(warningLabel);
            addAmountPane.add(updateLabel);
            addAmountPane.add(infoLabel);

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
            c.ipady = 30;
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

            addExpensePane.setBorder(BorderFactory.createLineBorder(Color.BLACK, 5));

            add(addExpensePane);
        }
    }

    public class SubmitListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            double amountToAdd;
            String warning;
            String update;
            String info;

            warningLabel.setText("");

            if(e.getSource() == submit) {
                if (amount.getText().isEmpty()){
                    warningLabel.setForeground(Color.red);
                    warningLabel.setText("Please enter an amount!");
                }
                else if (!amount.getText().isEmpty()) {
                    try {
                        Double.parseDouble(amount.getText());
                    } catch (NumberFormatException nfe) {
                        warningLabel.setForeground(Color.red);
                        warningLabel.setText("Input a decimal number without special characters.");
                    }
                }

                amountToAdd = Double.parseDouble(amount.getText());
                if (Objects.equals(addTo, "BLANK")){
                    update = "Please select a category to add to.";
                    updateLabel.setForeground(Color.RED);
                    updateLabel.setText(update);
                }
                if (Objects.equals(addTo, "RENT")) {
                    rentMortgageCat.mExpense += amountToAdd;
                    update = ("<html>" + "Amount added to Rent: $" + numberFormat.format(amountToAdd)
                            + "<br>" + "Rent total: $" + numberFormat.format(rentMortgageCat.getExpense())
                            + "<br>" + " Total expenses: $" + numberFormat.format(TrackingData.td.getTotalExpense()) + "</html>");
                    updateLabel.setText(update);
                    amount.setText("");
                    }
                else if (addTo.equals("FOOD")) {
                    foodGroceryCat.mExpense += amountToAdd;
                    update = ("<html>" + "Amount added to Food/Grocery: $" + numberFormat.format(amountToAdd)
                            + "<br>" + "Food/Grocery total: $" + numberFormat.format(foodGroceryCat.getExpense())
                            + "<br>" + " Total expenses: $" + numberFormat.format(TrackingData.td.getTotalExpense()) + "</html>");
                    updateLabel.setText(update);
                    amount.setText("");
                    }
                else if (addTo.equals("ENTERTAIN")) {
                    Category.entertainmentCat.mExpense += amountToAdd;
                    update = ("<html>" + "Amount added to Entertainment: $" + numberFormat.format(amountToAdd)
                            + "<br>" + "Entertainment total: $" + numberFormat.format(entertainmentCat.getExpense())
                            + "<br>" + " Total expenses: $" + numberFormat.format(TrackingData.td.getTotalExpense()) + "</html>");
                    updateLabel.setText(update);
                    amount.setText("");
                }
                else if (addTo.equals("LOANS")) {
                    Category.loansCat.mExpense += amountToAdd;
                    update = ("<html>" + "Amount added to Loans: $" + numberFormat.format(amountToAdd)
                            + "<br>" + "Loans total: $" + numberFormat.format(loansCat.getExpense())
                            + "<br>" + " Total expenses: $" + numberFormat.format(TrackingData.td.getTotalExpense()) + "</html>");
                    updateLabel.setText(update);
                    amount.setText("");
                }
                else if (addTo.equals("SAVINGS")) {
                    Category.savingsCat.mExpense += amountToAdd;
                    update = ("<html>" + "Amount added to Savings: $" + numberFormat.format(amountToAdd)
                            + "<br>" + "Savings total: $" + numberFormat.format(savingsCat.getExpense())
                            + "<br>" + " Total expenses: $" + numberFormat.format(TrackingData.td.getTotalExpense()) + "</html>");
                    updateLabel.setText(update);
                    amount.setText("");
                }
                else if (addTo.equals("CREDIT")) {
                    Category.creditCat.mExpense += amountToAdd;
                    update = ("<html>" + "Amount added to Credit: $" + numberFormat.format(amountToAdd)
                            + "<br>" + "Credit total: $" + numberFormat.format(creditCat.getExpense())
                            + "<br>" + " Total expenses: $" + numberFormat.format(TrackingData.td.getTotalExpense()) + "</html>");
                    updateLabel.setText(update);
                    amount.setText("");
                }
                else if (addTo.equals("FUEL")) {
                    Category.fuelCat.mExpense += amountToAdd;
                    update = ("<html>" + "Amount added to Fuel: $" + numberFormat.format(amountToAdd)
                            + "<br>" + "Fuel total: $" + numberFormat.format(fuelCat.getExpense())
                            + "<br>" + " Total expenses: $" + numberFormat.format(TrackingData.td.getTotalExpense()) + "</html>");
                    updateLabel.setText(update);
                    amount.setText("");
                }
                else if (addTo.equals("MANUAL")) {
                    Category.manualCat.mExpense += amountToAdd;
                    update = ("<html>" + "Amount added to " + SetupFrame.manualName + ": $"
                            + numberFormat.format(amountToAdd)
                            + "<br>" + SetupFrame.manualName
                            + " total: $" + numberFormat.format(manualCat.getExpense())
                            + "<br>" + " Total expenses: $" + numberFormat.format(TrackingData.td.getTotalExpense()) + "</html>");
                    updateLabel.setText(update);
                    amount.setText("");
                }
            }

            if (TrackingData.td.getTotalExpense() > Category.incomeCat.getIncome()){
                warning = "Warning: you have exceeded your income of $" + numberFormat.format(Category.incomeCat.getIncome());
                warningLabel.setForeground(Color.red);
                warningLabel.setText(warning);
            }
            info = ("<html>" + "Add another expense"
            + "<br>" + "or close this window and click"
            + "<br>" + "Tracking to view the tracking charts." + "</html>");
            infoLabel.setForeground(Color.blue);
            infoLabel.setText(info);

            if (UserProfileFrame.userID == 1) {
                user1.setmIncome(incomeCat.getIncome());
                user1.setmRent(rentMortgageCat.getExpense());
                user1.setmFood(foodGroceryCat.getExpense());
                user1.setmEntertainment(entertainmentCat.getExpense());
                user1.setmLoans(loansCat.getExpense());
                user1.setmSavings(savingsCat.getExpense());
                user1.setmCredit(creditCat.getExpense());
                user1.setmFuel(fuelCat.getExpense());
                user1.setmManual(manualCat.getExpense());
            }
            if (UserProfileFrame.userID == 2) {
                user2.setmIncome(incomeCat.getIncome());
                user2.setmRent(rentMortgageCat.getExpense());
                user2.setmFood(foodGroceryCat.getExpense());
                user2.setmEntertainment(entertainmentCat.getExpense());
                user2.setmLoans(loansCat.getExpense());
                user2.setmSavings(savingsCat.getExpense());
                user2.setmCredit(creditCat.getExpense());
                user2.setmFuel(fuelCat.getExpense());
                user2.setmManual(manualCat.getExpense());
            }
        }
    }

    public class ComboListener implements ItemListener{
        @Override
        public void itemStateChanged(ItemEvent e) {
            JComboBox cb = (JComboBox) e.getSource();
            if (cb.getSelectedItem().equals(" ")){
                addTo = "BLANK";
            }
            else if (cb.getSelectedItem().equals("Rent/Mortgage")) {
                addTo = "RENT";
            }
            else if (cb.getSelectedItem().equals("Food/Grocery")) {
                addTo = "FOOD";
            }
            else if (cb.getSelectedItem().equals("Entertainment")) {
                addTo = "ENTERTAIN";
            }
            else if (cb.getSelectedItem().equals("Loans")) {
                addTo = "LOANS";
            }
            else if (cb.getSelectedItem().equals("Savings")) {
                addTo = "SAVINGS";
            }
            else if (cb.getSelectedItem().equals("Credit")) {
                addTo = "CREDIT";
            }
            else if (cb.getSelectedItem().equals("Fuel")) {
                addTo = "FUEL";
            }
            else if (cb.getSelectedItem().equals("Manual") || cb.getSelectedItem().equals(SetupFrame.manualName)) {
                addTo = "MANUAL";
            }
        }
    }
}
