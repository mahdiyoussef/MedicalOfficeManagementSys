/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Medcine;

import java.util.ArrayList;
import DBConnection.DBConnection;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author AZA
 */
public class MedcinesDB implements MedcinesDAO {
    private Connection DB;
    private Statement St;
    private ResultSet rst;
    private int NumberMd=0;
    public MedcinesDB(){
        try{
            DB =DBConnection.getInstance();
            St=DB.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        
    }
    @Override
    public  void addMedicines(Medcine m) {
        try {
            St.executeUpdate("insert into medcine values("+m.getId()+","+m.getVersion()+",'"+m.getTitre()+"','"+m.getNom()+"','"+m.getPrenom()+"')");
            St.executeUpdate("commit");
            System.out.println("Added");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void updateMedcine(Medcine m) {               
        try {
            St.executeUpdate("update medcine set version="+m.getVersion()+",titre='"+m.getTitre()+"',nom='"+m.getNom()+"',prenom='"+m.getPrenom()+"' where id="+m.getId());
            St.executeUpdate("commit");
            System.out.println(m.getId()+" is updated");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void deleteMedcine(Medcine m) {
        try{
            St.executeUpdate("delete from creneaux where id_medcine="+m.getId());
            St.executeUpdate("delete from medcine where id="+m.getId());
            St.executeUpdate("commit");
            System.out.println(m.getId()+" is deleted");
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public String[][] AllMedcines() {
        String[][] medcines = new String[numberOfMedcines()][];
        int it=0;
        try{
            rst=St.executeQuery("select * from medcine");
            while(rst.next()){
                medcines[it]=new String[]{
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
        return medcines;
    }
    @Override
    public int numberOfMedcines(){
        int n = 0;
        try {
            rst=St.executeQuery("select count(*) from medcine");
            while(rst.next()) {
                n=rst.getInt(1);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return n;
    }

    @Override
    public Medcine MedcineById(int id) {
        Medcine M=null;
        try {
            rst=St.executeQuery("select * from medcine where id="+id);
            while(rst.next()){
                M=new Medcine(rst.getInt("id"),rst.getInt("version"),rst.getString("titre"),rst.getString("nom"),rst.getString("prenom"));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return M;
    }
    
}
