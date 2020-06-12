/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import BLL.Zhanri;
import java.util.List;

/**
 *
 * @author Dren
 */
public interface ZhanriInterface {
     public void create(Zhanri zhanri)throws FilmiException;
    public void edit(Zhanri zhanri) throws FilmiException;
    public void delete(Zhanri zhanri) throws FilmiException;
    public List<Zhanri> findAll() throws FilmiException;
    public Zhanri findById(Integer zhanriID) throws FilmiException;
    
}
