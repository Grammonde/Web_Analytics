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
public class collection_DB {
      public static void main(String[] args) {
        int k = 0;
        String dbURL = "jdbc:mysql://localhost:3306/users";
        String username = "root";
        String password = "";
        Scanner inp = new Scanner(System.in);
        int i = inp.nextInt();
        String[] arr = new String[i];
        while(k < i){
            arr[k] = inp.next();
            k++;
        }
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(dbURL, username, password);
            Statement st = con.createStatement();
            for(int j = 0; j < arr.length; j++){
                st.execute("INSERT INTO staff (name) VALUES ('"+arr[j]+"');");
            }
            ResultSet res = st.executeQuery("SELECT * FROM staff");
            while(res.next()){
                String name1 = res.getString("name");
                System.out.println(name1);
            }
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
}

