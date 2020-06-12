/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import BLL.Sallat;
import BLL.StreamingFilmat;
import java.util.List;

/**
 *
 * @author Dren
 */
public interface StreamingFilmatInterface {
     public void create(StreamingFilmat s)throws FilmiException;
    public void edit(StreamingFilmat s) throws FilmiException;
    public void delete(StreamingFilmat s) throws FilmiException;
    public List<StreamingFilmat> findAll() throws FilmiException;
    
    
}
