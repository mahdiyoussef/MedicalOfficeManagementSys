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
            St.executeUpdate("insert into medcine values("+m.getId()+","+m.getVersion()+",'"+m.getTitre()+"','"+m.getNom()+"','"+m.getPrenom()+"'");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void updateMedcine(Medcine m) {               
        try {
            St.executeUpdate("update medcine set version="+m.getVersion()+",titre='"+m.getTitre()+"',nom='"+m.getNom()+"',prenom='"+m.getPrenom()+"' where id="+m.getId());
            System.out.println(m.getId()+" is updated");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void deleteMedcine(Medcine m) {
        try{
            St.executeUpdate("delete from medcine where id="+m.getId());
            System.out.println(m.getId()+" is deleted");
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public ArrayList<Medcine> AllMedcines() {
        ArrayList<Medcine> medcines = new ArrayList<Medcine>();
        try{
            rst=St.executeQuery("select * from medcine");
            while(rst.next()){
                medcines.add(new MedcinesDB().MedcineById(rst.getInt("id")));
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
                M=new Medcine(rst.getInt("id"),rst.getInt("version"),rst.getString("titre").charAt(0),rst.getString("nom").charAt(0),rst.getString("prenom").charAt(0));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return M;
    }
    
}
