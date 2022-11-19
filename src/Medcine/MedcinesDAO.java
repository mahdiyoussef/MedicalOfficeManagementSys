/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Medcine;

import java.util.ArrayList;

/**
 *
 * @author AZA
 */
public interface MedcinesDAO {
    public void addMedicines(Medcine m);
    public void updateMedcine(Medcine m);
    public void deleteMedcine(Medcine m);
    public String[][] AllMedcines();
    public int numberOfMedcines();
    public Medcine MedcineById(int id);
}
