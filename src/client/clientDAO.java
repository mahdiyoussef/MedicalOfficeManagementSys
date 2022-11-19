/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import Medcine.Medcine;
import java.util.ArrayList;

/**
 *
 * @author AZA
 */
public interface clientDAO {
    public void addClient(client m);
    public void updateClient(client m);
    public void deleteClient(client m);
    public String[][] AllClients();
    public int numberOfClients();
    public client clientById(int id);
}
