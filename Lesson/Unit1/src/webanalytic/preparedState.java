/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webanalytic;
import java.sql.*;
import java.util.*;
/**
 *
 * @author ASUS
 */
public class preparedState {
    public static void main(String[] args) {
        b6b object = new b6b();
        Scanner inp = new Scanner(System.in);
        System.out.println("Enter your ID : ");
        int id = inp.nextInt();
        System.out.println("Enter your name : ");
        String name = inp.next();
        object.setId(id);
        object.setName(name);
        insertIntoDB(object);
    }
     public static void insertIntoDB(b6b obj){
        String dbURL = "jdbc:mysql://localhost:3306/users";
        String username = "root";
        String password  = "";
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(dbURL, username, password);
            //Step 1 : Create perpare statement
            PreparedStatement ps = con.prepareStatement("INSERT INTO b6b(id, name) VALUES(?,?)");
            //Step 2 : setData_type()
            ps.setInt(1, obj.getId());
            ps.setString(2, obj.getName());
            //Step 3 : Execute
            ps.execute();
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
}
class b6b{
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
