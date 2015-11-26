package csu.csci325;

import java.util.ArrayList;

import static csu.csci325.Category.*;

/**
 * Created by N'dia on 11/26/2015.
 */
public class TrackingData {
    public static TrackingData td = new TrackingData();
    public double totalExpense;

    public TrackingData()  {
    }

    double getTotalExpense() {
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
        ArrayList<Double> percentages = new ArrayList<Double>();
        if (rentMortgageCat.getExpense() != 0) {
            percentages.add((rentMortgageCat.getExpense()/totalExpense) * 100);
        }
        if (foodGroceryCat.getExpense() != 0) {
            percentages.add((foodGroceryCat.getExpense()/totalExpense) * 100);
        }
        if (entertainmentCat.getExpense() != 0) {
            percentages.add((entertainmentCat.getExpense()/totalExpense) * 100);
        }
        if (loansCat.getExpense() != 0) {
            percentages.add((loansCat.getExpense()/totalExpense) * 100);
        }
        if (savingsCat.getExpense() != 0) {
            percentages.add((savingsCat.getExpense()/totalExpense) * 100);
        }
        if (creditCat.getExpense() != 0) {
            percentages.add((creditCat.getExpense()/totalExpense) * 100);
        }
        if (foodGroceryCat.getExpense() != 0) {
            percentages.add((fuelCat.getExpense()/totalExpense) * 100);
        }
        if (manualCat.getExpense() != 0) {
            percentages.add((manualCat.getExpense()/totalExpense) * 100);
        }
        System.out.println(percentages.size());
        return percentages;
    }

    ArrayList toList() {
        //MAKE SURE CAT IS IN catList before adding
        ArrayList<String> listValues = new ArrayList<String>();
        if (rentMortgageCat.getExpense() != 0) {
            listValues.add("Rent/Mortgage: $" + rentMortgageCat.getExpense());
        }
        if (foodGroceryCat.getExpense() != 0) {
            listValues.add("Rent/Mortgage: $" + rentMortgageCat.getExpense());
        }
        if (entertainmentCat.getExpense() != 0) {
            listValues.add("Rent/Mortgage: $" + rentMortgageCat.getExpense());
        }
        if (loansCat.getExpense() != 0) {
            listValues.add("Rent/Mortgage: $" + rentMortgageCat.getExpense());
        }
        if (savingsCat.getExpense() != 0) {
            listValues.add("Rent/Mortgage: $" + rentMortgageCat.getExpense());
        }
        if (creditCat.getExpense() != 0) {
            listValues.add("Rent/Mortgage: $" + rentMortgageCat.getExpense());
        }
        if (foodGroceryCat.getExpense() != 0) {
            listValues.add("Rent/Mortgage: $" + rentMortgageCat.getExpense());
        }
        if (manualCat.getExpense() != 0) {
            listValues.add("Rent/Mortgage: $" + rentMortgageCat.getExpense());
        }
        return listValues;
    }
}
