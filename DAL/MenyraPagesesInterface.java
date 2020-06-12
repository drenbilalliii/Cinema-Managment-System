/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import BLL.MenyraPageses;
import java.util.List;

/**
 *
 * @author Dren
 */
public interface MenyraPagesesInterface {
    
     public void create(MenyraPageses menyrapageses)throws ShitjeException;
    public void edit(MenyraPageses menyrapageses) throws ShitjeException;
    public void delete(MenyraPageses menyrapageses) throws ShitjeException;
    public List<MenyraPageses> findAll() throws ShitjeException;
    
}
