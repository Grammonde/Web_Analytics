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
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author ASUS
 */
public class B6B4 {
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
    public void retrieveFromDB(ArrayList<B6B4> list) throws SQLException {
        for(B6B4 objs:list){
            ResultSet res = stat.executeQuery("SELECT * FROM b6b WHERE id = '"+objs.getId()+"'"); 
            while(res.next()){
            String names = res.getString("name");
            System.out.println(names);
            }
        }
    }
}
class mains{
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        ArrayList<B6B4> list = new ArrayList();
        System.out.println("Enter the amount of time you want to view from DB : ");
        int times = inp.nextInt();
        for(int i = 1; i <= times; i++){
           B6B4 object = new B6B4();
           System.out.println("Enter id :");
           object.setId(inp.nextInt());
           list.add(object);
        }
        try{
           B6B4 object = new B6B4();
           object.statement();
           object.retrieveFromDB(list);
        }
        catch(Exception e){
            System.out.println(e);
       }
    }
}
