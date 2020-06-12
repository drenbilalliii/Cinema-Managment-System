/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import BLL.Ulset;
import java.util.List;

/**
 *
 * @author Dren
 */
public interface UlsetInterface {
    
    public void create(Ulset ulset)throws FilmiException;
    public void edit(Ulset ulset) throws FilmiException;
    public void delete(Ulset ulset) throws FilmiException;
    public List<Ulset> findAll() throws FilmiException;
    
}
