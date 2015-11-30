package csu.csci325;

import java.util.ArrayList;
/**
 * Created by N'dia on 11/30/2015.
 */
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

    public ArrayList<Object> userInfoList = new ArrayList<Object>();
    public static UserInfo ui = new UserInfo("", 0.0, 0.0, 0.0, 0.0,
    0.0, 0.0, 0.0,0.0, "", 0.0);

    public UserInfo (String user, Double income, Double rent, Double food, Double enter,
                     Double loans, Double savings, Double credit, Double fuel, String name, Double manual){}

    void addData (){
        userInfoList.add(UserInfo.ui);
    }

    void removeData(int index) {
        userInfoList.remove(index);
    }
}
