package csu.csci325;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.text.DecimalFormat;

import static csu.csci325.Category.*;
import static csu.csci325.CategoryList.*;

public class SetupFrame extends JFrame{
    private JLabel title;
    private JTextField monthlyIncome;

    private JCheckBox rent;
    private JCheckBox food;
    private JCheckBox entertain;
    private JCheckBox loans;
    private JCheckBox savings;
    private JCheckBox credit;
    private JCheckBox fuel;
    private JCheckBox manual;
    private JTextField manualcat;
    private JButton submit1;

    private JLabel warning;
    private JLabel update;
    private JLabel listActiveCats;

    public static String manualName;
    private DecimalFormat numberFormat = new DecimalFormat("#.00");


    public SetupFrame() {
        JFrame setupFrame = new JFrame("Setup Panel");

        setupFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        setupFrame.setPreferredSize(new Dimension(600, 700));
        SetupPanel setupPanel = new SetupPanel();
        setupFrame.getContentPane().add(setupPanel).setBackground(Color.BLUE);

        setupFrame.pack();
        setupFrame.setVisible(true);
    }

    public class SetupPanel extends JPanel {
        public SetupPanel(){
            title = new JLabel("Setup", SwingConstants.CENTER);
            title.setFont(new Font("Arial", Font.BOLD, 28));
            title.setForeground(Color.BLUE);

            monthlyIncome = new JTextField();
            monthlyIncome.setMaximumSize(new Dimension(200, 25));

            rent = new JCheckBox("Rent/Mortgage");
            food = new JCheckBox("Food/Grocery");
            entertain = new JCheckBox("Entertainment");
            loans = new JCheckBox("Loans");
            savings = new JCheckBox("Savings");
            credit = new JCheckBox("Credit Card");
            fuel = new JCheckBox("Fuel");
            manual = new JCheckBox("Manual Category");

            manualcat = new JTextField();
            manualcat.setMaximumSize(new Dimension(350, 25));

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
            update.setText("<html>Your income is currently: $" + numberFormat.format(Category.incomeCat.getIncome()));

            listActiveCats = new JLabel();
            if (CategoryList.catList.categoryList.isEmpty())
                listActiveCats.setText("You currently have no active categories.");
            else
                listActiveCats.setText("<html>Your active categories: " + catList.ListToString());

            //PANELS
            JPanel incomePane = new JPanel();
            incomePane.setLayout(new BoxLayout(incomePane, BoxLayout.Y_AXIS));
            //incomePane.add(Box.createRigidArea(new Dimension(0, 30)));
            JLabel monthlyLabel = new JLabel("<html>Enter your Monthly Income in decimal <br> format"
                     + " without '$' or other special characters.</html>", SwingConstants.LEFT);
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
            selectPane.add(manualcat);
            manualcat.setVisible(true);


            selectPane.add(submit1);
            selectPane.add(warning);
            selectPane.add(update);
            selectPane.add(listActiveCats);

            //Keeps boxes checked if categories are active:
            if (catList.categoryList.contains("Rent/Mortgage")){
                rent.setSelected(true);
            }
            if (catList.categoryList.contains("Food/Grocery")){
                food.setSelected(true);
            }
            if (catList.categoryList.contains("Entertainment")){
                entertain.setSelected(true);
            }
            if (catList.categoryList.contains("Loans")){
                loans.setSelected(true);
            }
            if (catList.categoryList.contains("Savings")){
                savings.setSelected(true);
            }
            if (catList.categoryList.contains("Credit")){
                credit.setSelected(true);
            }
            if (catList.categoryList.contains("Fuel")){
                fuel.setSelected(true);
            }
            if (catList.categoryList.contains("Manual") || catList.categoryList.contains(manualName)){
                manual.setSelected(true);
            }


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

            setupPane.setBorder(BorderFactory.createLineBorder(Color.BLACK, 5));
            add(setupPane);
        }

    }

    public class SetupListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            double income;

            if (e.getSource() == submit1) {
                if (monthlyIncome.getText().isEmpty()){
                    if (incomeCat.getIncome() > 0) {
                    }
                    else{
                    warning.setForeground(Color.red);
                    warning.setText("Please enter an income!");}
                }
                else if (!monthlyIncome.getText().isEmpty()){
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
                }
                if(rent.isSelected()){
                    if (!catList.categoryList.contains("Rent/Mortgage")){
                        catList.addString("Rent/Mortgage");
                    }

                }
                if (!rent.isSelected() && catList.categoryList.contains("Rent/Mortgage")){
                    CategoryList.catList.removeString("Rent/Mortgage");
                    rentMortgageCat.mExpense = 0;
                }

                if (food.isSelected()){
                    if (!catList.categoryList.contains("Food/Grocery")){
                        catList.addString("Food/Grocery");
                    }
                }
                if (!food.isSelected() && catList.categoryList.contains("Food/Grocery")){
                    CategoryList.catList.removeString("Food/Grocery");
                    foodGroceryCat.mExpense = 0;
                }

                if (entertain.isSelected()){
                    if (!catList.categoryList.contains("Entertainment")){
                        catList.addString("Entertainment");
                    }
                }
                if (!entertain.isSelected() && catList.categoryList.contains("Entertainment")){
                    CategoryList.catList.removeString("Entertainment");
                    entertainmentCat.mExpense = 0;
                }

                if (loans.isSelected()){
                    if (!catList.categoryList.contains("Loans")){
                        catList.addString("Loans");
                    }
                }
                if (!loans.isSelected() && catList.categoryList.contains("Loans")){
                    CategoryList.catList.removeString("Loans");
                    loansCat.mExpense = 0;
                }

                if (savings.isSelected()) {
                    if (!catList.categoryList.contains("Savings")){
                        catList.addString("Savings");
                    }
                }
                if (!savings.isSelected() && catList.categoryList.contains("Savings")){
                    CategoryList.catList.removeString("Savings");
                    savingsCat.mExpense = 0;
                }

                if (credit.isSelected()){
                    if (!catList.categoryList.contains("Credit")){
                        catList.addString("Credit");
                    }
                }
                if (!credit.isSelected() && catList.categoryList.contains("Credit")){
                    CategoryList.catList.removeString("Credit");
                    creditCat.mExpense = 0;
                }

                if (fuel.isSelected()){
                    if (!catList.categoryList.contains("Fuel")){
                        catList.addString("Fuel");
                    }
                }
                if (!fuel.isSelected() && catList.categoryList.contains("Fuel")){
                    CategoryList.catList.removeString("Fuel");
                    fuelCat.mExpense = 0;
                }

                if (manual.isSelected()){
                    if (!catList.categoryList.contains("Manual") || !catList.categoryList.contains(manualName)){
                        if (!manualcat.getText().isEmpty()){
                            manualName = manualcat.getText();
                            catList.addString(manualName);
                        }
                    }

                    manualcat.setEditable(false);
                    monthlyIncome.setEnabled(false);
                    manual.setEnabled(false);
                }
                if (!manual.isSelected() && catList.categoryList.contains("Manual")) {
                    CategoryList.catList.removeString("Manual");
                    manualCat.mExpense = 0;
                }
                    else if (!manual.isSelected() && catList.categoryList.contains(manualName)) {
                    CategoryList.catList.removeString(manualName);
                    manualCat.mExpense = 0;
                }

                AddExpenseFrame.categoryArray = catList.getAsArray();
                TrackingData.activeCategories = catList.categoryList;

                update.setForeground(Color.BLUE);
                update.setText("<html><br>" + "Your income is: $" + numberFormat.format(Category.incomeCat.getIncome()) +
                        "<br><br>" + "Categories added successfully!" +
                        "<br>" + "Exit out of this window to add and" +
                        "<br>" + "track expenses." + "</html>");
                listActiveCats.setText("<html>Your active categories: " + catList.ListToString());
                monthlyIncome.setText("");
            }
        }
    }
}
