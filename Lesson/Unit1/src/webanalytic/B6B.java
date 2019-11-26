/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webanalytic;
import java.util.*;
import java.sql.*;
/**
 *
 * @author Grammonde
 */
public class B6B {
    private String name;
    private int id;
    Statement st = null;
    Connection con = null;
    String dbURL = "jdbc:mysql://localhost:3306/users";
    String username = "root";
    String password = "";
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
    public void statement() throws ClassNotFoundException, SQLException{
        Class.forName("com.mysql.jdbc.Driver");
        con = DriverManager.getConnection(dbURL, username, password);
        st = con.createStatement();
    }
    public void insertIntoDB(B6B obj) throws SQLException{
        st.execute("INSERT INTO b6b(id, name) VALUES ('"+obj.getId()+"', '"+getName()+"')");
    }
}
class main{
    public static void main(String[] args) {
        B6B objects = new B6B();
        Scanner inp = new Scanner(System.in);
        System.out.println("Please enter id :");
        objects.setId(inp.nextInt());
        System.out.println("Please enter name : ");
        objects.setName(inp.next());
        try{
            objects.statement();
            objects.insertIntoDB(objects);
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
}

