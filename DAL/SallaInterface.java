/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;
import BLL.Sallat;
import java.util.List;
/**
 *
 * @author Dren
 */
public interface SallaInterface {
    
    public void create(Sallat s)throws FilmiException;
    public void edit(Sallat s) throws FilmiException;
    public void delete(Sallat s) throws FilmiException;
    public List<Sallat> findAll() throws FilmiException;
    public Sallat findById(Integer SallaID) throws FilmiException;
    
}
