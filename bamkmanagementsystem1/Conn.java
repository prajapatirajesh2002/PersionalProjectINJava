/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bamkmanagementsystem1;
import java.sql.*;
 
public class Conn {
    Connection c;
    Statement s;
    
    public Conn(){
        try{
            //Class.forName(com.mysql.cj.jdbc.Driver);
            c = DriverManager.getConnection("jdbc:mysql:///bankmanagementsystem","root","Rajesh@123");
            s = c.createStatement();
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
    
}
