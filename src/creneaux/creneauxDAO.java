/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package creneaux;

import java.util.ArrayList;

/**
 *
 * @author AZA
 */
public interface creneauxDAO {
    public void addCreneau(creneaux c);
    public void updateCreneau(creneaux c);
    public void deletecreneau(creneaux c);
    public ArrayList<creneaux> AllCreneaux();
    public creneaux searchCreneau(int id);
    public int CreneauxNumber();
}
