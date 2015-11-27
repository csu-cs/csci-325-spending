package csu.csci325;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Objects;

import static csu.csci325.Category.*;
import static csu.csci325.Category.manualCat;

/**
 * Created by N'dia on 11/26/2015.
 */

public class aAddExpensePanel extends JPanel {
    private JLabel title;

    private JLabel selectCategoryLabel;
    public JComboBox categoryBox;

    public static String[] categoryArray;
    public static String[] subArray = {""};

    private JLabel amountLabel;
    private JTextField amount;
    private JButton submit;

    public String addTo = "";

    public aAddExpensePanel() {
        title = new JLabel("Add Expense");
        title.setFont(new Font("Arial", Font.BOLD, 28));

        ComboListener comboBoxListener = new ComboListener();

        selectCategoryLabel = new JLabel("Select category");

        /*try {
            categoryBox = new JComboBox(categoryArray);
        }catch (NullPointerException npe){
            //categoryBox = new JComboBox(categoryArray);
            if (categoryArray == null){
            categoryBox = new JComboBox(subArray);
            }
        }
        if (categoryArray == null) {
            categoryBox = new JComboBox(subArray);
        }else
            categoryBox = new JComboBox(categoryArray);*/

        //categoryBox = new JComboBox(categoryArray);


        categoryBox.addItemListener(comboBoxListener);

        amountLabel = new JLabel("Amount: ");
        amount = new JTextField();
        submit = new JButton("Submit");

        SubmitListener sl = new SubmitListener();
        submit.addActionListener(sl);

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

    public class SubmitListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            double amountToAdd;
            if(e.getSource() == submit) {
                //NEED TO ADD EXCEPTION/WARNING IF amountToAdd IS GREATER THAN INCOME
                amountToAdd = Double.parseDouble(amount.getText());
                System.out.println("Category: " + addTo);
                if (Objects.equals(addTo, "RENT")) {
                    rentMortgageCat.mExpense += amountToAdd;
                    System.out.println("After adding to Rent: " + rentMortgageCat.getExpense());
                    amount.setText("");
                }
                else if (addTo.equals("FOOD")) {
                    foodGroceryCat.mExpense += amountToAdd;
                    System.out.println("After adding to Food: " + foodGroceryCat.getExpense());
                    amount.setText("");
                }
                else if (addTo.equals("ENTERTAIN")) {
                    Category.entertainmentCat.mExpense += amountToAdd;
                    System.out.println("After adding to Entertainment " + entertainmentCat.getExpense());
                    amount.setText("");
                }
                else if (addTo.equals("LOANS")) {
                    Category.loansCat.mExpense += amountToAdd;
                    System.out.println("After adding to Loans: " + loansCat.getExpense());
                    amount.setText("");
                }
                else if (addTo.equals("SAVINGS")) {
                    Category.savingsCat.mExpense += amountToAdd;
                    System.out.println("After adding to Savings: " + savingsCat.getExpense());
                    amount.setText("");
                }
                else if (addTo.equals("CREDIT")) {
                    Category.creditCat.mExpense += amountToAdd;
                    System.out.println("After adding to Credit: " + creditCat.getExpense());
                    amount.setText("");
                }
                else if (addTo.equals("FUEL")) {
                    Category.fuelCat.mExpense += amountToAdd;
                    System.out.println("After adding to Fuel: " + fuelCat.getExpense());
                    amount.setText("");
                }
                else if (addTo.equals("MANUAL")) {
                    Category.manualCat.mExpense += amountToAdd;
                    System.out.println("After adding to Manual: " + manualCat.getExpense());
                    amount.setText("");
                }
            }
            else;
            amount.setText("");
        }
    }

    public class ComboListener implements ItemListener {
        @Override
        public void itemStateChanged(ItemEvent e) {
            JComboBox cb = (JComboBox) e.getSource();
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
            else if (cb.getSelectedItem().equals("Manual")) {
                addTo = "MANUAL";
            }
            else;
        }
    }
}
