package csu.csci325;

import java.sql.*;

/**
 * Created by N'dia on 11/30/2015.
 */
public class Database {
    //public Database() {
    public static void main( String args[]){
        Connection c = null;
        Statement stmt = null;
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:test.db");
            System.out.println("Opened database successfully");

            stmt = c.createStatement();
            String sql = "CREATE TABLE USERINFO " +
                    "(ID INT PRIMARY KEY          NOT NULL," +
                    "USER            TEXT         NOT NULL," +
                    "INCOME          DOUBLE          NOT NULL," +
                    "TOTALEXPENSE    DOUBLE, " +
                    "RENTEXPENSE     DOUBLE, " +
                    "FOODEXPENSE     DOUBLE, " +
                    "ENTEREXPENSE    DOUBLE, " +
                    "LOANSEXPENSE    DOUBLE, " +
                    "SAVINGSEXPENSE  DOUBLE, " +
                    "CREDITEXPENSE   DOUBLE, " +
                    "FUELEXPENSE     DOUBLE, " +
                    "MANUALEXPENSE   DOUBLE)";
            stmt.executeUpdate(sql);
            stmt.close();
            c.close();
        } catch (Exception e) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
       System.out.println("Table created successfully");


    }
}
