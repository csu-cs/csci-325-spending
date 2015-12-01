package csu.csci325;

import java.util.ArrayList;

public class UserInfo {
    private String mUserName;
    private double mIncome;
    private double mRent;
    private double mFood;
    private double mEntertainment;
    private double mLoans;
    private double mSavings;
    private double mCredit;
    private double mFuel;
    private String mManName;
    private double mManual;
    private double total;

    public static ArrayList<Object> userInfoList = new ArrayList<>();

    public static UserInfo user1 = new UserInfo("user1", 0.0, 0.0, 0.0, 0.0,
    0.0, 0.0, 0.0,0.0, "manual", 0.0);
    public static UserInfo user2 = new UserInfo("user2", 0.0, 0.0, 0.0, 0.0,
            0.0, 0.0, 0.0,0.0, "manual", 0.0);
    public static UserInfo user3 = new UserInfo("user3", 0.0, 0.0, 0.0, 0.0,
            0.0, 0.0, 0.0,0.0, "manual", 0.0);


    public UserInfo (String user, Double income, Double rent, Double food, Double enter,
                     Double loans, Double savings, Double credit, Double fuel, String name, Double manual){
        mUserName = user;
        mIncome = income;
        mRent = rent;
        mFood = food;
        mEntertainment = enter;
        mLoans = loans;
        mSavings = savings;
        mCredit = credit;
        mFuel = fuel;
        mManName = name;
        mManual = manual;
    }

    public static void addData(UserInfo user){
        userInfoList.add(user);
    }

    void removeData(int index) {
        userInfoList.remove(index);
    }

    //====================================================================
    //                              SETTERS
    //====================================================================
    void setmIncome( double in) {
        user1.mIncome = in;
    }
    void setmRent(double re) {
        mRent = re;
    }
    void setmFood(double fo) {
        mFood = fo;
    }
    void setmEntertainment(double en) {
        mEntertainment = en;
    }
    void setmLoans(double lo) { mLoans = lo;}
    void setmSavings(double sa) {
        mSavings = sa;
    }
    void setmCredit(double cr){mCredit = cr;}
    void setmFuel(double fu){mFuel = fu;}
    void setmManual(double ma){mManual = ma;}

    //====================================================================
    //                              GETTERS
    //====================================================================

    public double getmIncome() {
        return mIncome;
    }
    public double getmRent() {
        return mRent;
    }
    public double getmFood() {
        return mFood;
    }
    public double getmEntertainment() {
        return mEntertainment;
    }
    public double getmLoans() {
        return mLoans;
    }
    public double getmSavings() {
        return mSavings;
    }
    public double getmCredit() {
        return mCredit;
    }
    public double getmFuel() {
        return mFuel;
    }
    public double getmManual() {
        return mManual;
    }

    static void infoToString(int userNum) {
        if (userNum == 1)
            System.out.println("Username:" + user1.mUserName +
                    ", \n Income: $" + user1.mIncome +
                    ", \n Rent: $" + user1.mRent +
                    ", \n Food: $" + user1.mFood +
                    ", \n Entertainment: $" + user1.mEntertainment +
                    ", \n Loans: $" + user1.mLoans +
                    ", \n Savings: $" + user1.mSavings +
                    ", \n Credit: $" + user1.mCredit +
                    ", \n Fuel: $" + user1.mFuel +
                    ",\n" + user1.mManName + ": $" + user1.mManual);
        if (userNum == 2)
            System.out.println(user2.mUserName + ", " + user2.mIncome);
        if (userNum == 3)
            System.out.println(user3.mUserName + ", " + user3.mIncome);


    }

}
