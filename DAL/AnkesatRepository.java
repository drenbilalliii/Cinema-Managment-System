/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import BLL.Ankesat;
import BLL.Bileta;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author Dren
 */
public class AnkesatRepository extends EntMngClass implements AnkesatInterface{
     @Override
    public void create(Ankesat ankesat) throws PerdoruesiException {
        try{
            em.getTransaction().begin();
            em.persist(ankesat);
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
    public void edit(Ankesat ankesat) throws PerdoruesiException {
       
        em.getTransaction().begin();
            em.merge(ankesat);
            em.getTransaction().commit();
    }

    @Override
    public void delete(Ankesat ankesat) throws PerdoruesiException {
            em.getTransaction().begin();
            em.remove(ankesat);
            em.getTransaction().commit();
    }

    @Override
    public List<Ankesat> findAll() throws PerdoruesiException {
        return (List<Ankesat>)em.createNamedQuery("Ankesat.findAll").getResultList();
    }
    
     public List<Ankesat> fetchSomeValues (int first,int second){
        Query query = em.createQuery("Select a from Ankesat a").setFirstResult(first);
        query.setMaxResults(second);
        return (List<Ankesat>)query.getResultList();
         
         
     }
    
    
    
}
