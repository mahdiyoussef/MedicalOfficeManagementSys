/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rv;

import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author AZA
 */
public interface rvDAO {
    public void addRv(rv rv);
    public void updateRv(rv rv);
    public void deleteRv(rv rv);
    public rv rvById(int id);
    public ArrayList<rv> AllRv();
    public int rvNumber();
    public String[][] fullAppointement();
}
