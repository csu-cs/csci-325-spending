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

    private JButton setup;
    private JButton addExpense;
    private JButton tracking;
    private JButton userProfile;

    public String addTo = "";

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
            categoryBox.addItemListener(comboBoxListener);


            amountLabel = new JLabel("Amount: ");
            amount = new JTextField();
            submit = new JButton("Submit");

            SubmitListener sl = new SubmitListener();
            submit.addActionListener(sl);

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
    public class SubmitListener implements ActionListener{

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
        }
    }

    public class ComboListener implements ItemListener{
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
