/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webanalytic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/**
 *
 * @author ASUS
 */
public class B6B5 {
    private String name;
    private int id;
    Statement stat = null;
    Connection con = null;
    String username = "root";
    String password= "";
    String dbURL = "jdbc:mysql://localhost:3306/users";
    public void setName(String name){
        this.name = name;
    }
    public void setId(int id){
        this.id = id;
    }
    public String getName(){
        return this.name;
    }
    public int getId(){
        return this.id;
    }
    public void statement() throws ClassNotFoundException, SQLException{
        Class.forName("com.mysql.jdbc.Driver");
        con = DriverManager.getConnection(dbURL, username, password);
        stat = con.createStatement();
    }
    public void retrieveFromDB() throws SQLException {
        ResultSet res = stat.executeQuery("SELECT * FROM b6b");  
        while(res.next()){
            String names = res.getString("name");
            System.out.println(names);
        }
    }
}
class Mainss{
    public static void main(String[] args) {
        B6B5 object = new B6B5();
        try{
           object.statement();
           object.retrieveFromDB();
        }
        catch(Exception e){
            System.out.println(e);
       }
    }
}
