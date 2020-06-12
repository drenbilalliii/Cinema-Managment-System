/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import BLL.Roli;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author Dren
 */
public class RoliRepository  extends EntMngClass implements RoliInterface{

    @Override
    public void create(Roli roli) throws PerdoruesiException {
        try{
            em.getTransaction().begin();
            em.persist(roli);
            em.getTransaction().commit();
        }catch(Throwable thro){
            if(thro.getMessage().contains("2627")){
            
              throw new PerdoruesiException("E dhëna egziston !");
            }
        else{
                throw new PerdoruesiException("Create : "+thro.getClass()+" - "+thro.getMessage());
                }
        }
    }

    @Override
    public void edit(Roli roli) throws PerdoruesiException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Roli roli) throws PerdoruesiException {
            em.getTransaction().begin();
            em.remove(roli);
            em.getTransaction().commit();
    }

    @Override
    public List<Roli> findAll() throws PerdoruesiException {
        return (List<Roli>)em.createNamedQuery("Roli.findAll").getResultList();
    }
    
        
     public List<Roli> fetchSomeValues (int first,int second){
        Query query = em.createQuery("Select r Roli r").setFirstResult(first);
        query.setMaxResults(second);
        return (List<Roli>)query.getResultList();
         
         
    
    
}
    
    
}
