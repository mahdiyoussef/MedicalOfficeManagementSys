/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBConnection;

import java.sql.*;

/**
 *
 * @author AZA
 */
public class DBConnection {
    private DBConnection() throws ClassNotFoundException, SQLException{
        try{
            Class.forName("oracle.jdbc.OracleDriver");
        }
        catch(Exception e){
            System.out.println("error");
            System.out.println(e.getMessage());
        }
    }
    private static Connection con=null;
    public static Connection getInstance(){
        if(con==null){
            try{
                con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","0635785791");
            }
            catch(Exception e){
                System.out.println(e.getMessage());
            }
        }
        return con;
    }
}
