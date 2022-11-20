/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login;

import java.sql.*;
import DBConnection.DBConnection;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author AZA
 */
public class loginDB implements loginDAO{
    Connection con;
    Statement St;
    ResultSet Rs;
    public loginDB(){
        try {
            con=DBConnection.getInstance();
            St=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public boolean checkLogin(String username, String pwd) {
        boolean v=false;
        try {
            Rs=St.executeQuery("select * from login where username='"+username+"'");
            while(Rs.next()){
                System.out.println(pwd);
                System.out.println(Rs.getString("pwd"));
                if(pwd.equals(Rs.getString("pwd"))){
                    System.out.println("logged");
                    return true;
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return v;
    }

    @Override
    public void addUser(login l) {
        try {
            St.executeUpdate("isert into login values('"+l.getId()+"','"+l.getUsername()+"','"+l.getPwd()+"')");
            St.executeUpdate("commit");
            System.out.println(l.getId()+"updated");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void updateUser(login l) {
        try {
            St.executeUpdate("update login set username="+l.getUsername()+" ,pwd="+l.getPwd()+" where id="+l.getId());
            St.executeUpdate("commit");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public login getUser(String username) {
        login l=null;
        try {
            Rs=St.executeQuery("select * from login where username='"+username+"'");
            while(Rs.next()){
                l=new login(Rs.getInt("ID"),Rs.getString("USERNAME"),Rs.getString("PWD"));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return l;
    }

    @Override
    public ArrayList<login> getAllUsers() {
        ArrayList<login> Allusers=new ArrayList<login>();
        try {
            Rs=St.executeQuery("select * from login");
            while(Rs.next()){
                Allusers.add(new loginDB().getUser(Rs.getString("username")));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return Allusers;
    }
}
