/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apoorva;
import java.sql.*;

/**
 *
 * @author sheetal
 */
public class Apoorva {

    /**
     * @param args the command line arguments
     */
   public static Connection connectDB(){
       try
        {
           Class.forName("com.mysql.jdbc.Driver"); 
           Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql?zeroDateTimeBehavior=convertToNull","root","");
            System.out.println("Database connected succesfully");
            return con;
        }
        catch(Exception e)
        {
          System.out.println(e.getMessage());  
          return null;
        }
    }
    public static void main(String[] args) {
    }
    
}
