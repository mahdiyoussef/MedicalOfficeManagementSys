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
            System.out.println(rv.getCreneaux().getId());
            //St.executeUpdate("delete from creneaux where ID="+rv.getCreneaux().getId());
            St.executeUpdate("delete from rv where id="+rv.getId());
            St.executeUpdate("commit");
        } catch (Exception e) {
            System.out.println("function problem");
            System.out.println(e.getMessage());
        }
    }

    @Override
    public rv rvById(int id) {
        rv rv=null;
        try {
            RS=St.executeQuery("select * from rv where id="+id);
            while(RS.next()){
                rv=new rv(RS.getInt("id"),RS.getString("jour"),new clientDB().clientById(RS.getInt("id_client")),new creneauxDB().searchCreneau(RS.getInt("id_creneaux")));
            }
        } catch (Exception e) {
            System.out.println("Constructor by id");
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
        int n=rvNumber();
        String[][] data=new String[n][];
        int it=0;
        try {
            
            RS=St.executeQuery("select r.id as rid,r.jour as rjour ,c.hdebut as chdebut,c.hfin as chfin,c.mdebut as cmdebut,c.mfin as cmfin,cl.nom ||' ' ||cl.prenom as clientfullname,md.nom||' ' ||md.prenom as medcinefullname from rv r,creneaux c,client cl,medcine md where r.id_creneaux =c.id and r.id_client=cl.id and c.id_medcine=md.id");
            while(RS.next()){
                data[it]=new String[]{
                    String.valueOf(RS.getInt("RID")),
                    RS.getString("RJOUR"),
                    String.valueOf(RS.getInt("CHDEBUT")),
                    String.valueOf(RS.getInt("CHFIN")),
                    String.valueOf(RS.getInt("CMDEBUT")),
                    String.valueOf(RS.getInt("CMFIN")),
                    RS.getString("CLIENTFULLNAME"),
                    RS.getString("MEDCINEFULLNAME")
                };
                
                it++;
                
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return data;
    }
    
}
