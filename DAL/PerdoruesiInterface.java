/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;


import BLL.Perdoruesi;
import java.util.List;

/**
 *
 * @author user
 */
public interface PerdoruesiInterface {
    void create(Perdoruesi s) throws PerdoruesiException;
    void edit(Perdoruesi s) throws PerdoruesiException;
    void remove(Perdoruesi s) throws PerdoruesiException;
    List<Perdoruesi> findAll() ;
    Perdoruesi findByID(Integer id) throws PerdoruesiException;
}