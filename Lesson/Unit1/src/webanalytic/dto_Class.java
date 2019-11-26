/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webanalytic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

/**
 *
 * @author Grammonde
 */
public class dto_Class {
    public static void main(String[] args) {
        dto obj = new dto();
        String dbURL = "jdbc:mysql://localhost:3306/users";
        String username = "root";
        String password = "";
        Scanner inp = new Scanner(System.in);
        String all = inp.nextLine();
        String temp[] = all.split(",");
        int id1 = Integer.parseInt(temp[0]);
        String name1 = temp[1];
        obj.setName(name1);
        obj.setId(id1);
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(dbURL, username, password);
            Statement st = con.createStatement();
            st.execute("INSERT INTO log (id, name) VALUES ('"+obj.getId()+"', '"+obj.getName()+"');");
            ResultSet res = st.executeQuery("SELECT * FROM log");
            while(res.next()){
                int id2 = res.getInt("id");
                String name2 = res.getString("name");
                System.out.println(id2 + "  " + name2 );
            }
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
}
class dto{
    private String name;
    private int id;
    public String getName(){
        return this.name;
    }
    public void setName(String name){
        this.name = name;
    }
    public int getId(){
        return this.id;
    }
    public void setId(int id){
        this.id = id;
    } 
}
