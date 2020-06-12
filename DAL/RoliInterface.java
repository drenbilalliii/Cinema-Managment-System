/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import BLL.Roli;
import java.util.List;

/**
 *
 * @author Dren
 */
public interface RoliInterface {
    
    public void create(Roli roli)throws PerdoruesiException;
    public void edit(Roli roli) throws PerdoruesiException;
    public void delete(Roli roli) throws PerdoruesiException;
    public List<Roli> findAll() throws PerdoruesiException;
    
}
