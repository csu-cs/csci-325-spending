package csu.csci325;

import static csu.csci325.UserInfo.*;

/**
 * Created by N'dia on 11/30/2015.
 */
public class UserTest {
    public static void main(String[] args) {
        UserInfo.addData(user1);
        UserInfo.infoToString(1);

        UserInfo.addData(user2);
        UserInfo.addData(user3);

        UserInfo.infoToString(2);
        UserInfo.infoToString(3);

    }
}
