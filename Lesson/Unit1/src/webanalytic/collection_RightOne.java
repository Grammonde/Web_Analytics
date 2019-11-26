/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webanalytic;

import java.util.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

/**
 *
 * @author ASUS
 */
public class collection_RightOne {
        public static void main(String[] args) {
        String dbURL = "jdbc:mysql://localhost:3306/users";
        String username = "root";
        String password = "";
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(dbURL, username, password);
            Statement st = con.createStatement();
            Scanner inp = new Scanner(System.in);
            ArrayList<connection> list = new ArrayList();
            connection obj = new connection();
            int time = inp.nextInt();
            for(int i = 1; i <= time; i++){
                obj.setId(inp.nextInt());
                obj.setName(inp.next());
                list.add(obj);
            }
            for(connection object:list){
                String insert = "INSERT INTO log(id, name) VALUES('"+object.getId()+"', '"+object.getName()+"')";
                st.execute(insert);
            }
//            ResultSet res = st.executeQuery("SELECT * FROM log");
//            while(res.next()){
//                int id2 = res.getInt("id");
//                String name2 = res.getString("name");
//                System.out.println(id2 + "  " + name2 );
//            }
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
}
class connection{
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
