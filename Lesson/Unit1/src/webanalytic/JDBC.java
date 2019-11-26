/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package webanalytic;

import java.sql.*;

/**
 *
 * @author Grammonde
 */
public class JDBC {
    public static void main(String args[]){
        String dbURL = "jdbc:mysql://localhost:3306/test";
        String username = "root";
        String password = "";

        try{
            //Step 1 : Load driver into the project using code :
            Class.forName("com.mysql.jdbc.Driver");
            //Step 2 : Establish connection to JAVA and DB
            Connection con = DriverManager.getConnection(dbURL, username, password);
            //Step 3 : Create statement :
            Statement st = con.createStatement();
            //Step 4 : Execute SQL commands
            st.execute("insert into 6b6 (id, name) values ('12', 'Vermillion');");
            //Step 5 : Showing results :
            ResultSet res = st.executeQuery("SELECT * FROM 6b6");
            while(res.next()){
                int id = res.getInt("id");
                String name = res.getString("name");
                System.out.println(id + " / " + name);
            }
        }catch(Exception e){
            System.out.println("NO NO NO YUON");
        } 
    }
}
