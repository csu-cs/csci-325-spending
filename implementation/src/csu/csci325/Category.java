package csu.csci325;

/**
 * Created by BBrak on 11/19/2015.
 */
public class Category {
    public static Category rentMortgageCat;
    public static Category foodGroceryCat;
    public static Category entertainmentCat;
    public static Category loansCat;
    public static Category savingsCat;
    public static Category creditCat;
    public static Category fuelCat;
    public static Category manualCat;
    public double mExpense;
    public double mIncome;

    Category() {
        mIncome = 0;
        mExpense = 0;
    }

    public void setExpense(double expense){
        mExpense = expense;
    }

    public double getExpense(){
        return mExpense;
    }

    public void setIncome (double income){
        mIncome = income;
    }

    public double getIncome (){
        return mIncome;
    }

    public String toString(double input){
        String str = "";
        str += input;
        return str;
    }


}
