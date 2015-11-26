package csu.csci325;

/**
 * Created by BBrak on 11/19/2015.
 */
public class Category {
    public double mExpense;
    public double mIncome;

    public static Category rentMortgageCat = new Category();
    public static Category foodGroceryCat = new Category();
    public static Category entertainmentCat = new Category();
    public static Category loansCat = new Category();
    public static Category savingsCat = new Category();
    public static Category creditCat = new Category();
    public static Category fuelCat = new Category();
    public static Category manualCat = new Category();

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
