/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import BLL.Filmi;
import java.util.List;

/**
 *
 * @author Dren
 */
public interface  FilmiInterface {
     void create(Filmi f) throws FilmiException;
    void edit(Filmi f) throws FilmiException;
    void remove(Filmi f) throws FilmiException;
    List<Filmi> findAll();
    Filmi findByID(Integer id) throws FilmiException;
}
    
    

