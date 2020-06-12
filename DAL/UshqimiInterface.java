/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import BLL.Ushqimi;
import java.util.List;

/**
 *
 * @author Dren
 */
public interface UshqimiInterface {
    
    void create(Ushqimi u) throws ShitjeException;
    void edit(Ushqimi s) throws ShitjeException;
    void remove(Ushqimi s) throws ShitjeException;
    List<Ushqimi> findAll();
    Ushqimi findByID(Integer i) throws ShitjeException;
}
