package csu.csci325;

import javax.swing.*;
import java.awt.*;
import java.text.DecimalFormat;
import java.util.ArrayList;

import static csu.csci325.Category.*;

/**
 * Created by N'dia on 11/26/2015.
 */
public class TrackingData {
    public static TrackingData td = new TrackingData();
    public static ArrayList activeCategories = new ArrayList();
    private DecimalFormat numberFormat = new DecimalFormat("#.00");

    public TrackingData()  {
    }

    double getTotalExpense() {
        double totalExpense = 0;

        if (rentMortgageCat.getExpense() != 0) {
            totalExpense += rentMortgageCat.getExpense();
        }
        if (foodGroceryCat.getExpense() != 0) {
            totalExpense += foodGroceryCat.getExpense();
        }
        if (entertainmentCat.getExpense() != 0) {
            totalExpense += entertainmentCat.getExpense();
        }
        if (loansCat.getExpense() != 0) {
            totalExpense += loansCat.getExpense();
        }
        if (savingsCat.getExpense() != 0) {
            totalExpense += savingsCat.getExpense();
        }
        if (creditCat.getExpense() != 0) {
            totalExpense += creditCat.getExpense();
        }
        if (fuelCat.getExpense() != 0) {
            totalExpense += fuelCat.getExpense();
        }
        if (manualCat.getExpense() != 0) {
            totalExpense += manualCat.getExpense();
        }

        return totalExpense;
    }

    ArrayList toPieChart() {
        ArrayList<Double> percentages = new ArrayList<>();

        double total = getTotalExpense();

        if (rentMortgageCat.getExpense() != 0) {
            percentages.add((rentMortgageCat.getExpense() /total) * 100);
        }
        if (foodGroceryCat.getExpense() != 0) {
            percentages.add((foodGroceryCat.getExpense()/total) * 100);
        }
        if (entertainmentCat.getExpense() != 0) {
            percentages.add((entertainmentCat.getExpense()/total) * 100);
        }
        if (loansCat.getExpense() != 0) {
            percentages.add((loansCat.getExpense()/total) * 100);
        }
        if (savingsCat.getExpense() != 0) {
            percentages.add((savingsCat.getExpense()/total) * 100);
        }
        if (creditCat.getExpense() != 0) {
            percentages.add((creditCat.getExpense()/total) * 100);
        }
        if (fuelCat.getExpense() != 0) {
            percentages.add((fuelCat.getExpense()/total) * 100);
        }
        if (manualCat.getExpense() != 0) {
            percentages.add((manualCat.getExpense()/total) * 100);
        }

        return percentages;
    }

    ArrayList toList() {
        ArrayList<String> listValues = new ArrayList<>();

        if (rentMortgageCat.getExpense() != 0 && activeCategories.contains("Rent/Mortgage")) {
            listValues.add("Rent/Mortgage: $" + numberFormat.format(rentMortgageCat.getExpense()));
        }
        if (foodGroceryCat.getExpense() != 0 && activeCategories.contains("Food/Grocery")) {
            listValues.add("Food/Grocery: $" + numberFormat.format(foodGroceryCat.getExpense()));
        }
        if (entertainmentCat.getExpense() != 0 && activeCategories.contains("Entertainment")) {
            listValues.add("Entertainment: $" + numberFormat.format(entertainmentCat.getExpense()));
        }
        if (loansCat.getExpense() != 0 && activeCategories.contains("Loans")) {
            listValues.add("Loans: $" + numberFormat.format(loansCat.getExpense()));
        }
        if (savingsCat.getExpense() != 0 && activeCategories.contains("Savings")) {
            listValues.add("Savings: $" + numberFormat.format(savingsCat.getExpense()));
        }
        if (creditCat.getExpense() != 0 && activeCategories.contains("Credit")) {
            listValues.add("Credit: $" + numberFormat.format(creditCat.getExpense()));
        }
        if (fuelCat.getExpense() != 0 && activeCategories.contains("Fuel")) {
            listValues.add("Fuel: $" + numberFormat.format(fuelCat.getExpense()));
        }
        if (manualCat.getExpense() != 0){
            if (activeCategories.contains("Manual")){
                listValues.add("Manual: $" + numberFormat.format(manualCat.getExpense()));
            }
            else if (activeCategories.contains(SetupFrame.manualName)){
                listValues.add(SetupFrame.manualName + ": $" + numberFormat.format(manualCat.getExpense()));
            }
        }

        listValues.add("-----------------------------------------");
        listValues.add("Total expenses: $" + numberFormat.format(getTotalExpense()));
        return listValues;
    }

    String toTextField() {
        String str = "";
        for (int i = 0; i < toList().size(); i++){
            str += ("<html>-" + toList().get(i) + "<br>");
        }
        return str;
    }

    String pieChartData() {
        String pcd = "";
        String namePercentage = "";
        String colorName;
        double total = getTotalExpense();

        //DOES NOT WORK IF TWO PERCENTAGES ARE THE EXACT SAME
        //NEEDS TO BE FIXED
        for (int i = 0; i < TrackingData.td.toPieChart().size(); i++){
            if (toPieChart().get(i).equals(rentMortgageCat.getExpense() /total * 100)) {
            namePercentage = ("Rent/Mortgage = " + (numberFormat.format((rentMortgageCat.getExpense() /total) * 100) + "%"));
            }
            else if (toPieChart().get(i).equals(foodGroceryCat.getExpense() /total * 100)) {
                namePercentage = ("Food/Grocery = " + (numberFormat.format((foodGroceryCat.getExpense()/total) * 100) + "%"));
            }
            else if (toPieChart().get(i).equals(entertainmentCat.getExpense() /total * 100)) {
                namePercentage = ("Entertainment = " + (numberFormat.format((entertainmentCat.getExpense()/total) * 100) + "%"));
            }
            else if (toPieChart().get(i).equals(loansCat.getExpense() /total * 100)) {
                namePercentage = ("Loans = " + (numberFormat.format((loansCat.getExpense()/total) * 100) + "%"));
            }
            else if (toPieChart().get(i).equals(savingsCat.getExpense() /total * 100)) {
                namePercentage = ("Savings = " + (numberFormat.format((savingsCat.getExpense()/total) * 100) + "%"));
            }
            if (toPieChart().get(i).equals(creditCat.getExpense() /total * 100)) {
                namePercentage = ("Credit = " + (numberFormat.format((creditCat.getExpense()/total) * 100) + "%"));
            }
            if (toPieChart().get(i).equals(fuelCat.getExpense() /total * 100)) {
                namePercentage = ("Fuel = " + (numberFormat.format((fuelCat.getExpense()/total) * 100) + "%"));
            }
            if (toPieChart().get(i).equals(manualCat.getExpense() /total * 100)) {
                if (SetupFrame.manualName.isEmpty()){
                    namePercentage = ("Manual = " + (numberFormat.format((manualCat.getExpense()/total) * 100) + "%"));
                }
                else
                    namePercentage = (SetupFrame.manualName + " = " + (numberFormat.format((manualCat.getExpense()/total) * 100) + "%"));
            }
            colorName = ColorUtils.colorUtils.getColorNameFromRgb(createPieChart().colors.get(i).getRed(),
                    createPieChart().colors.get(i).getGreen(), createPieChart().colors.get(i).getBlue());
            pcd += ("<html>-" + colorName + ": " + namePercentage + "<br>");
        }

        return pcd;
    }

    PieChartFinal createPieChart() {
        ArrayList values;

        values = TrackingData.td.toPieChart();

        ArrayList<Color> colors = new ArrayList<>();
        colors.add(Color.gray);
        colors.add(Color.green);
        colors.add(Color.blue);
        colors.add(Color.pink);
        colors.add(Color.yellow);
        colors.add(Color.red);
        colors.add(Color.cyan);
        colors.add(Color.black);
        colors.add(Color.orange);

        PieChartFinal pc = new PieChartFinal(values, colors);
        pc.setMaximumSize(new Dimension(400,400));

        return pc;
    }

    JProgressBar createProgressBar() {
        JProgressBar pb;
        pb = new JProgressBar(0,(int) Category.incomeCat.getIncome());
        pb.setValue((int) getTotalExpense());
        pb.setStringPainted(true);

        return pb;
    }
}
