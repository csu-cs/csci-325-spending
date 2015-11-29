package csu.csci325;

/**
 * Created by BBrak on 11/28/2015.
 */
public class Users {
    private String mUserName, mPassword;

    public Users(String userName, String password){
        mUserName = userName;
        mPassword = password;
    }

    public String toString(){
        return mUserName + " " + mPassword;
    }
}
