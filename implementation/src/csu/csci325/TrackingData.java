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
        //System.out.println("Total Expenses: " + totalExpense);
        return totalExpense;
    }

    ArrayList toPieChart() {
        ArrayList<Double> percentages = new ArrayList<>();

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
        //System.out.println("Number of percentages: " + percentages.size());
        //System.out.println(percentages.toString());
        return percentages;
    }

    ArrayList toList() {
        ArrayList<String> listValues = new ArrayList<>();

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
        for (int i = 0; i < TrackingData.td.toPieChart().size(); i++){
            if (toPieChart().get(i).equals(rentMortgageCat.getExpense() /total * 100)) {
            namePercentage = ("Rent/Mortgage " + ((rentMortgageCat.getExpense() /total) * 100) + "%");
            }
            else if (toPieChart().get(i).equals(foodGroceryCat.getExpense() /total * 100)) {
                namePercentage = ("Food/Grocery " + ((foodGroceryCat.getExpense()/total) * 100) + "%");
            }
            else if (toPieChart().get(i).equals(entertainmentCat.getExpense() /total * 100)) {
                namePercentage = ("Entertainment " + ((entertainmentCat.getExpense()/total) * 100) + "%");
            }
            else if (toPieChart().get(i).equals(loansCat.getExpense() /total * 100)) {
                namePercentage = ("Loans " + ((loansCat.getExpense()/total) * 100) + "%");
            }
            else if (toPieChart().get(i).equals(savingsCat.getExpense() /total * 100)) {
                namePercentage = ("Savings " + ((savingsCat.getExpense()/total) * 100) + "%");
            }
            if (toPieChart().get(i).equals(creditCat.getExpense() /total * 100)) {
                namePercentage = ("Credit " + ((creditCat.getExpense()/total) * 100) + "%");
            }
            if (toPieChart().get(i).equals(fuelCat.getExpense() /total * 100)) {
                namePercentage = ("Fuel " + ((fuelCat.getExpense()/total) * 100) + "%");
            }
            if (toPieChart().get(i).equals(manualCat.getExpense() /total * 100)) {
                if (SetupFrame.manualName.isEmpty()){
                    namePercentage = ("Manual " + ((manualCat.getExpense()/total) * 100) + "%");
                }
                else
                    namePercentage = (SetupFrame.manualName + " " + ((manualCat.getExpense()/total) * 100) + "%");
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
        //pc.setSize(150, 150);
        pc.setMaximumSize(new Dimension(400,400));
        //pc.setPreferredSize(new Dimension(250,250));
        return pc;
    }

    JProgressBar createProgressBar() {
        JProgressBar pb;
        //System.out.println("Income: $" + incomeCat.getIncome());
        //System.out.println("Expense Percentage: " + (getTotalExpense() / (Category.incomeCat.getIncome() * 1)));
        pb = new JProgressBar(0,(int) Category.incomeCat.getIncome());
        pb.setValue((int) getTotalExpense());
        pb.setStringPainted(true);
        return pb;
    }
}
