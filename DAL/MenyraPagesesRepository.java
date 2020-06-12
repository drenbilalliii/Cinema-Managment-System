/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import BLL.MenyraPageses;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author Dren
 */
public class MenyraPagesesRepository extends EntMngClass implements MenyraPagesesInterface{

    @Override
    public void create(MenyraPageses menyrapageses) throws ShitjeException {
        try{
            em.getTransaction().begin();
            em.persist(menyrapageses);
            em.getTransaction().commit();
        }catch(Throwable thro){
            if(thro.getMessage().contains("2627")){
            
              throw new ShitjeException("E dhëna egziston !");
            }
        else{
                throw new ShitjeException("Create : "+thro.getClass()+" - "+thro.getMessage());
                }
        }
    }

    @Override
    public void edit(MenyraPageses menyrapageses) throws ShitjeException {
        em.getTransaction().begin();
            em.merge(menyrapageses);
            em.getTransaction().commit();
    }

    @Override
    public void delete(MenyraPageses menyrapageses) throws ShitjeException {
            em.getTransaction().begin();
            em.remove(menyrapageses);
            em.getTransaction().commit();
    }

    @Override
    public List<MenyraPageses> findAll() throws ShitjeException {
        return (List<MenyraPageses>)em.createNamedQuery("MenyraPageses.findAll").getResultList();
    }
    
     public List<MenyraPageses> fetchSomeValues (int first,int second){
        Query query = em.createQuery("Select p MenyraPageses p").setFirstResult(first);
        query.setMaxResults(second);
        return (List<MenyraPageses>)query.getResultList();
         
         
    
    
}
     
}