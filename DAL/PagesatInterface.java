/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import BLL.Pagesat;
import java.util.List;

/**
 *
 * @author Dren
 */
public interface PagesatInterface {
    
    public void create(Pagesat pagesat)throws ShitjeException;
    public void edit(Pagesat pagesat) throws ShitjeException;
    public void delete(Pagesat pagesat) throws ShitjeException;
    public List<Pagesat> findAll() throws ShitjeException;
    
}
