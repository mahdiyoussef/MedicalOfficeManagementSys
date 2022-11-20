/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import DBConnection.DBConnection;
import Medcine.Medcine;
import Medcine.MedcinesDB;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author AZA
 */
public class clientDB implements clientDAO{
    private Connection DB;
    private Statement St;
    private ResultSet rst;
    private int NumberMd=0;
    public clientDB(){
        try{
            DB =DBConnection.getInstance();
            St=DB.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        
    }
    @Override
    public void addClient(client m) {
        try {
            St.executeUpdate("insert into client values("+m.getId()+","+m.getVersion()+",'"+m.getTitre()+"','"+m.getNom()+"','"+m.getPrenom()+"')");
            St.executeUpdate("commit");
            System.out.println("added");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void updateClient(client m) {
        try {
            St.executeUpdate("update client set version="+m.getVersion()+",titre='"+m.getTitre()+"',nom='"+m.getNom()+"',prenom='"+m.getPrenom()+"' where id="+m.getId());
            St.executeUpdate("commit");
            System.out.println(m.getId()+" is updated");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void deleteClient(client m) {
        try{
            St.executeUpdate("delete from rv where id_client="+m.getId());
            St.executeUpdate("delete from client where id="+m.getId());
            St.executeUpdate("commit");
            System.out.println(m.getId()+" is deleted");
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public String[][] AllClients() {
        int n=numberOfClients();
        String[][] clients = new String[n][];
        int it=0;
        boolean b=true;
        try{
            rst=St.executeQuery("select * from client order by id");
            while(rst.next()){
                clients[it]=new String[]{
                    String.valueOf(rst.getInt("id")),
                    String.valueOf(rst.getInt("version")),
                    rst.getString("titre"),
                    rst.getString("nom"),rst.getString("prenom")
                };
                it++;
                
            }
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        return clients;
    }

    @Override
    public int numberOfClients() {
        int n = 0;
        try {
            rst=St.executeQuery("select count(*) from client");
            while(rst.next()) {
                n=rst.getInt(1);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return n;
    }

    @Override
    public client clientById(int id) {
        client c=null;
        try {
            rst=St.executeQuery("select * from client where id="+id);
            while(rst.next()){
                c=new client(rst.getInt("id"),rst.getInt("version"),rst.getString("titre"),rst.getString("nom"),rst.getString("prenom"));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("client problem");
        }
        return c;
    }
    
    
}
