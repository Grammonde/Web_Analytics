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
 * @author Grammode
 */
public class promptNameId {
    public static void main(String[] args) {
        String dbURL = "jdbc:mysql://localhost:3306/users";
        String username = "root";
        String password = "";
        Scanner inp = new Scanner(System.in);
        String all = inp.nextLine();
        String temp[] = all.split(",");
        int id2 = Integer.parseInt(temp[0]);
        String name2 = temp[1];

        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(dbURL, username, password);
            Statement st = con.createStatement();
            st.execute("INSERT INTO log (id, name) VALUES ('"+id2+"', '"+name2+"');");
            ResultSet res = st.executeQuery("SELECT * FROM log");
            while(res.next()){
                int id1 = res.getInt("id");
                String name1 = res.getString("name");
                System.out.println(id1 + "  " + name1 );
            }
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
}
