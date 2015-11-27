package csu.csci325;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

import static csu.csci325.Category.*;

/**
 * Created by N'dia on 11/26/2015.
 */
public class TrackingData {
    public static TrackingData td = new TrackingData();
    public static ArrayList activeCategories = new ArrayList();

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
        System.out.println("Total Expenses: " + totalExpense);
        return totalExpense;
    }

    ArrayList toPieChart() {
        ArrayList<Double> percentages = new ArrayList<Double>();

        double total = getTotalExpense();

        if (rentMortgageCat.getExpense() != 0) {
            percentages.add((rentMortgageCat.getExpense() /total) * 100);
            //System.out.println("Rent percentage: " + (rentMortgageCat.getExpense()/total) * 100);
        }
        if (foodGroceryCat.getExpense() != 0) {
            percentages.add((foodGroceryCat.getExpense()/total) * 100);
            //System.out.println("Food percentage: " + (foodGroceryCat.getExpense() / total) * 100);
        }
        if (entertainmentCat.getExpense() != 0) {
            percentages.add((entertainmentCat.getExpense()/total) * 100);
            //System.out.println("Entertainment percentage: " + (entertainmentCat.getExpense() / total) * 100);
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
        System.out.println("Number of percentages: " + percentages.size());
        System.out.println(percentages.toString());
        return percentages;
    }

    ArrayList toList() {
        ArrayList<String> listValues = new ArrayList<String>();

        if (rentMortgageCat.getExpense() != 0 && activeCategories.contains("Rent/Mortgage")) {
            listValues.add("Rent/Mortgage: $" + rentMortgageCat.getExpense());
        }
        if (foodGroceryCat.getExpense() != 0 && activeCategories.contains("Food/Grocery")) {
            listValues.add("Food/Grocery: $" + foodGroceryCat.getExpense());
        }
        if (entertainmentCat.getExpense() != 0 && activeCategories.contains("Entertainment")) {
            listValues.add("Entertainment: $" + entertainmentCat.getExpense());
        }
        if (loansCat.getExpense() != 0 && activeCategories.contains("Loans")) {
            listValues.add("Loans: $" + loansCat.getExpense());
        }
        if (savingsCat.getExpense() != 0 && activeCategories.contains("Savings")) {
            listValues.add("Savings: $" + savingsCat.getExpense());
        }
        if (creditCat.getExpense() != 0 && activeCategories.contains("Credit")) {
            listValues.add("Credit: $" + creditCat.getExpense());
        }
        if (fuelCat.getExpense() != 0 && activeCategories.contains("Fuel")) {
            listValues.add("Fuel: $" + fuelCat.getExpense());
        }
        if (manualCat.getExpense() != 0){
            if (activeCategories.contains("Manual")){
                listValues.add("Manual: $" + manualCat.getExpense());
            }
            else if (activeCategories.contains(SetupFrame.manualName)){
                listValues.add(SetupFrame.manualName + ": $" + manualCat.getExpense());
            }
        }
        return listValues;
    }

    String toTextField() {
        String str = "";
        for (int i = 0; i < toList().size(); i++){
            str += ("-" + toList().get(i) + "\n");
        }
        return str;
    }

    PieChartFinal createPieChart() {
        ArrayList values;

        values = TrackingData.td.toPieChart();

        ArrayList<Color> colors = new ArrayList<Color>();
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
        pc.setSize(150, 150);
        return pc;
    }

    JProgressBar createProgressBar() {
        JProgressBar pb = new JProgressBar();
        System.out.println("Income: $" + incomeCat.getIncome());
        System.out.println("Expense Percentage: " + (getTotalExpense() / (Category.incomeCat.getIncome() * 1)));
        pb = new JProgressBar(0,(int) Category.incomeCat.getIncome());
        pb.setValue((int) getTotalExpense());
        pb.setStringPainted(true);
        return pb;
    }
}
