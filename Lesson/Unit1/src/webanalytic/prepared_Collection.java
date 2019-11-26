/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webanalytic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author ASUS
 */
public class prepared_Collection {
    public static void main(String[] args) {
        b6b object = new b6b();
        ArrayList<b6b> list = new ArrayList();
        Scanner inp = new Scanner(System.in);
        int time = inp.nextInt();
        for(int i = 1; i <= time; i++){
            System.out.println("Enter your ID : ");
            int id = inp.nextInt();
            System.out.println("Enter your name : ");
            String name = inp.next();
            object.setId(id);
            object.setName(name);
            list.add(object);
        }
        prepared_Collection obj = new prepared_Collection();
        obj.insertIntoDB(list);
    }
     public void insertIntoDB(ArrayList<b6b> list){
        String dbURL = "jdbc:mysql://localhost:3306/users";
        String username = "root";
        String password  = "";
        PreparedStatement ps = null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(dbURL, username, password);
            for(b6b objs:list){
                //Step 1 : Create perpare statement
                ps = con.prepareStatement("INSERT INTO b6b(id, name) VALUES(?,?)");
                //Step 2 : setData_type()
                ps.setInt(1, objs.getId());
                ps.setString(2, objs.getName());
                //Step 3 : Execute
                ps.execute();
            }
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
}
class b6b2{
    private String name;
    private int id;
    public void setId(int id){
        this.id = id;
    }
    public void setName(String name){
        this.name = name;
    }
    public int getId(){
        return this.id;
    }
    public String getName(){
        return this.name;
    }
}
