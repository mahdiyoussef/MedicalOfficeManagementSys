/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rv;

import java.sql.*;
import java.util.ArrayList;
import DBConnection.DBConnection;
import client.clientDB;
import creneaux.creneauxDB;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author AZA
 */
public class rvDB implements rvDAO{
    Connection con;
    ResultSet RS;
    Statement St;
    
    public rvDB(){
        try {
            con=DBConnection.getInstance();
            St=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
    @Override
    public void addRv(rv rv) {
        try {
            St.executeUpdate("insert into rv values("+rv.getId()+",to_date('"+rv.getDate()+"','dd-mm-yy'),"+rv.getClient().getId()+","+rv.getCreneaux().getId()+")");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void updateRv(rv rv) {
        try {
            St.executeUpdate("update rv set date=to_date('"+rv.getDate()+"','dd-mm-yy'),id_client="+rv.getClient().getId()+",id_creneaux="+rv.getCreneaux().getId()+" where id="+rv.getId());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void deleteRv(rv rv) {
        try {
            St.executeUpdate("delete from rv where id="+rv.getId());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public rv rvById(int id) {
        rv rv=null;
        try {
            RS=St.executeQuery("select * from rv where id="+id);
            while(RS.next()){
                rv=new rv(RS.getInt("id"),RS.getString("date").charAt(0),new clientDB().clientById(RS.getInt("id_client")),new creneauxDB().searchCreneau(RS.getInt("id_creneaux")));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return rv;
    }

    @Override
    public ArrayList<rv> AllRv() {
        ArrayList<rv> list =new ArrayList<rv>();
        try {
            RS=St.executeQuery("select * from rv");
            while(RS.next()){
                list.add(new rvDB().rvById(RS.getInt("id")));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return list;
    }

    @Override
    public int rvNumber() {
        int n=0;
        try {
            RS=St.executeQuery("select count(*) as n from rv");
            while(RS.next()){
                n=RS.getInt("n");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return n;
    }

    @Override
    public String[][] fullAppointement() {
        String[][] data=null;
        int it=0;
        try {
            int n=rvNumber();
            RS=St.executeQuery("select r.id as rid,r.jour as rjour ,c.hdebut as chdebut,c.hfin as chfin,c.mdebut as cmdebut,c.mfin as cmfin,cl.nom+' '+cl.prenom as clientfullname,md.nom+' '+md.prenom as medcinefullname from rv r,creneaux c,client cl,medcine md where r.id_creneaux =c.id and r.id_client=cl.id and c.id_medcine=md.id");
            data=new String[8][n];
            while(RS.next()){
                data[it][0]=String.valueOf(RS.getInt("rid"));
                data[it][1]=RS.getString("rjour");
                data[it][2]=String.valueOf(RS.getInt("chdebut"));
                data[it][3]=String.valueOf(RS.getInt("chfin"));
                data[it][4]=String.valueOf(RS.getInt("cmedbut"));
                data[it][5]=String.valueOf(RS.getInt("cmfin"));
                data[it][6]=RS.getString("clientfullname");
                data[it][7]=RS.getString("medcinefullname");
                it++;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return data;
    }
    
}
