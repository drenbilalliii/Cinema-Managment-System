/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import BLL.Klienti;
import java.util.List;

/**
 *
 * @author Dren
 */
public interface KlientiInterface {
    
     public void create(Klienti klienti)throws PerdoruesiException;
    public void edit(Klienti klienti) throws PerdoruesiException;
    public void delete(Klienti klienti) throws PerdoruesiException;
    public List<Klienti> findAll() throws PerdoruesiException;
}
