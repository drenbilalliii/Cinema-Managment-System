/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template biletaile, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import BLL.Bileta;
import java.util.List;

/**
 *
 * @author Dren
 */
public interface BiletaInterface {
    
    void create(Bileta bileta) throws ShitjeException;
    void edit(Bileta bileta) throws ShitjeException;
    void remove(Bileta bileta) throws ShitjeException;
    List<Bileta> findAll();
    Bileta findByID(Integer id) throws ShitjeException;
}

