/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mcmjp;

import Screens.*;
import java.sql.*;

/**
 *
 * @author AZA
 */
public class MCMJP {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
        Connection con=DBConnection.DBConnection.getInstance();
        ResultSet rst;
        Statement st;
        st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
        rst=st.executeQuery("select count(*) as n from medcine");
        while(rst.next()) {
            System.out.println(rst.getInt("n"));
        }
        
    }
    
}
