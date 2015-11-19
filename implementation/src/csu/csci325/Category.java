package csu.csci325;

/**
 * Created by BBrak on 11/19/2015.
 */
public class Category {
    private double mExpense;
    private double mIncome;

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
