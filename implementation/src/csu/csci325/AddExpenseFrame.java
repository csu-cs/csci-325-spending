package csu.csci325;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Objects;

import static csu.csci325.Category.*;

public class AddExpenseFrame extends JFrame {

    private JLabel title;

    private JLabel selectCategoryLabel;
    private JComboBox categoryBox;

    public static String[] categoryArray;

    private JLabel amountLabel;
    private JTextField amount;
    private JButton submit;

    //static JPanel addExpensePane = new JPanel();
    private JLabel warningLabel = new JLabel();
    private JLabel updateLabel = new JLabel();
    private JLabel infoLabel = new JLabel();

    public String addTo = "";

    public AddExpenseFrame() {
        JFrame addExpenseFrame = new JFrame("Add Expense Panel");

        addExpenseFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        addExpenseFrame.setPreferredSize(new Dimension(400, 425));
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
            categoryBox.addItemListener(comboBoxListener);


            amountLabel = new JLabel("<html>Enter the Amount in decimal format" +
                    "<br>" + "without '$' or other special characters.</html>");
            amount = new JTextField();
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
                else if (amount != null) {
                    try {
                        Double.parseDouble(amount.getText());
                        //System.out.println("Parse successful.");
                    } catch (NumberFormatException nfe) {
                        //System.out.println("Parse unsuccessful.");
                        warningLabel.setForeground(Color.red);
                        warningLabel.setText("Input a decimal number without special characters.");
                    }
                }

                amountToAdd = Double.parseDouble(amount.getText());

                //
                // System.out.println("Category: " + addTo);
                if (Objects.equals(addTo, "RENT")) {
                    rentMortgageCat.mExpense += amountToAdd;
                    //System.out.println("After adding to Rent: " + rentMortgageCat.getExpense());
                    update = ("<html>" + "Amount added to Rent: $" + amountToAdd
                            + "<br>" + "Rent total: $" + rentMortgageCat.getExpense()
                            + "<br>" + " Total expenses: $" + TrackingData.td.getTotalExpense() + "</html>");
                    updateLabel.setText(update);
                    amount.setText("");
                    }
                else if (addTo.equals("FOOD")) {
                    foodGroceryCat.mExpense += amountToAdd;
                    //System.out.println("After adding to Food: " + foodGroceryCat.getExpense());
                    update = ("<html>" + "Amount added to Food/Grocery: $" + amountToAdd
                            + "<br>" + "Food/Grocery total: $" + foodGroceryCat.getExpense()
                            + "<br>" + " Total expenses: $" + TrackingData.td.getTotalExpense() + "</html>");
                    updateLabel.setText(update);
                    amount.setText("");
                    }
                else if (addTo.equals("ENTERTAIN")) {
                    Category.entertainmentCat.mExpense += amountToAdd;
                    //System.out.println("After adding to Entertainment " + entertainmentCat.getExpense());
                    update = ("<html>" + "Amount added to Entertainment: $" + amountToAdd
                            + "<br>" + "Entertainment total: $" + entertainmentCat.getExpense()
                            + "<br>" + " Total expenses: $" + TrackingData.td.getTotalExpense() + "</html>");
                    updateLabel.setText(update);
                    amount.setText("");
                }
                else if (addTo.equals("LOANS")) {
                    Category.loansCat.mExpense += amountToAdd;
                    //System.out.println("After adding to Loans: " + loansCat.getExpense());
                    update = ("<html>" + "Amount added to Loans: $" + amountToAdd
                            + "<br>" + "Loans total: $" + loansCat.getExpense()
                            + "<br>" + " Total expenses: $" + TrackingData.td.getTotalExpense() + "</html>");
                    updateLabel.setText(update);
                    amount.setText("");
                }
                else if (addTo.equals("SAVINGS")) {
                    Category.savingsCat.mExpense += amountToAdd;
                    //System.out.println("After adding to Savings: " + savingsCat.getExpense());
                    update = ("<html>" + "Amount added to Savings: $" + amountToAdd
                            + "<br>" + "Savings total: $" + savingsCat.getExpense()
                            + "<br>" + " Total expenses: $" + TrackingData.td.getTotalExpense() + "</html>");
                    updateLabel.setText(update);
                    amount.setText("");
                }
                else if (addTo.equals("CREDIT")) {
                    Category.creditCat.mExpense += amountToAdd;
                    //System.out.println("After adding to Credit: " + creditCat.getExpense());
                    update = ("<html>" + "Amount added to Credit: $" + amountToAdd
                            + "<br>" + "Credit total: $" + creditCat.getExpense()
                            + "<br>" + " Total expenses: $" + TrackingData.td.getTotalExpense() + "</html>");
                    updateLabel.setText(update);
                    amount.setText("");
                }
                else if (addTo.equals("FUEL")) {
                    Category.fuelCat.mExpense += amountToAdd;
                    //System.out.println("After adding to Fuel: " + fuelCat.getExpense());
                    update = ("<html>" + "Amount added to Fuel: $" + amountToAdd
                            + "<br>" + "Fuel total: $" + fuelCat.getExpense()
                            + "<br>" + " Total expenses: $" + TrackingData.td.getTotalExpense() + "</html>");
                    updateLabel.setText(update);
                    amount.setText("");
                }
                else if (addTo.equals("MANUAL")) {
                    Category.manualCat.mExpense += amountToAdd;
                    //System.out.println("After adding to Manual: " + manualCat.getExpense());
                    update = ("<html>" + "Amount added to " + SetupFrame.manualName + ": $"
                            + amountToAdd
                            + "<br>" + SetupFrame.manualName
                            + " total: $" + manualCat.getExpense()
                            + "<br>" + " Total expenses: $" + TrackingData.td.getTotalExpense() + "</html>");
                    updateLabel.setText(update);
                    amount.setText("");
                }
            }
            else;

            if (TrackingData.td.getTotalExpense() > Category.incomeCat.getIncome()){
                warning = "Warning: you have exceeded your income of $" + Category.incomeCat.getIncome();
                warningLabel.setForeground(Color.red);
                warningLabel.setText(warning);
            }
            info = ("<html>" + "Add another expense"
            + "<br>" + "or close this window and click 'Tracking'"
            + "<br>" + "to view the tracking charts." + "</html>");
            infoLabel.setForeground(Color.blue);
            infoLabel.setText(info);
        }
    }

    public class ComboListener implements ItemListener{
        @Override
        public void itemStateChanged(ItemEvent e) {
            JComboBox cb = (JComboBox) e.getSource();
            //System.out.println("Manual category name: " + SetupFrame.manualName);
            if (cb.getSelectedItem().equals("Rent/Mortgage")) {
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
            else;
        }
    }
}
