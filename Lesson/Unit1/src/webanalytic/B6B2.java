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
public class B6B2 {
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
    public void insertIntoDB(ArrayList<B6B2> list) throws SQLException {
        for(B6B2 objs:list){
            String insert = "INSERT INTO b6b2(id, name) VALUES('"+objs.getId()+"', '"+objs.getName()+"')";
            stat.execute(insert);
        }
    }
}
class Main{
    public static void main(String[] args) {
        //B6B2 object = new B6B2();
        Scanner inp = new Scanner(System.in);
        ArrayList<B6B2> list = new ArrayList();
        System.out.println("Enter the amount of time you want to send to DB : ");
        int times = inp.nextInt();
        for(int i = 1; i <= times; i++){
            B6B2 object = new B6B2();
            System.out.println("ID : ");
            object.setId(inp.nextInt());
            System.out.println("Name :");
            object.setName(inp.next());
            list.add(object);
        }
        
        try{
           B6B2 object = new B6B2();
           object.statement();
           object.insertIntoDB(list);
        }
        catch(Exception e){
            System.out.println(e);
       }
    }
}
