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
            String sql = "CREATE TABLE COMPANY " +
                    "(ID INT PRIMARY KEY          NOT NULL," +
                    "NAME            TEXT         NOT NULL," +
                    "AGE             INT          NOT NULL," +
                    "ADDRESS         CHAR(50), " +
                    "SALARY          REAL)";
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
