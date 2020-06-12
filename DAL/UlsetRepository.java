/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import BLL.Ulset;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author Dren
 */
public class UlsetRepository extends EntMngClass implements UlsetInterface {

    @Override
    public void create(Ulset ulset) throws FilmiException {
        try{
            em.getTransaction().begin();
            em.persist(ulset);
            em.getTransaction().commit();
        }catch(Throwable thro){
            if(thro.getMessage().contains("2627")){
            
              throw new FilmiException("E dhëna egziston !");
            }
        else{
                throw new FilmiException("Create : "+thro.getClass()+" - "+thro.getMessage());
                }
        }
    }

    @Override
    public void edit(Ulset ulset) throws FilmiException {
            em.getTransaction().begin();
            em.merge(ulset);
            em.getTransaction().commit();
    }

    @Override
    public void delete(Ulset ulset) throws FilmiException {
            em.getTransaction().begin();
            em.remove(ulset);
            em.getTransaction().commit();
    }

    @Override
    public List<Ulset> findAll() throws FilmiException {
        return (List<Ulset>)em.createNamedQuery("Ulset.findAll").getResultList();
    }
    
    
     public List<Ulset> fetchSomeValues (int first,int second){
        Query query = em.createQuery("Select u from Ulset u").setFirstResult(first);
        query.setMaxResults(second);
        return (List<Ulset>)query.getResultList();
         
         
     }
}