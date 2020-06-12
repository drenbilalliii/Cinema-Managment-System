/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import BLL.Filmi;
import BLL.Zhanri;
import java.util.List;
import javax.persistence.NoResultException;
import javax.persistence.Query;

/**
 *
 * @author Dren
 */
public class ZhanriRepository extends EntMngClass implements ZhanriInterface{

    @Override
    public void create(Zhanri zhanri) throws FilmiException {
        try{
            em.getTransaction().begin();
            em.persist(zhanri);
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
    public void edit(Zhanri zhanri) throws FilmiException {
         em.getTransaction().begin();
            em.merge(zhanri);
            em.getTransaction().commit();
        
    }

    @Override
    public void delete(Zhanri zhanri) throws FilmiException {
            em.getTransaction().begin();
            em.remove(zhanri);
            em.getTransaction().commit();
    }

    @Override
    public List<Zhanri> findAll() throws FilmiException {
        return (List<Zhanri>)em.createNamedQuery("Zhanri.findAll").getResultList();
    }
    
        
     public List<Zhanri> fetchSomeValues (int first,int second){
        Query query = em.createQuery("Select z from Zhanri z").setFirstResult(first);
        query.setMaxResults(second);
        return (List<Zhanri>)query.getResultList();
         
         
    
    
}

    @Override
    public Zhanri findById(Integer zhanriID) throws FilmiException {
        Query query = em.createQuery("SELECT s FROM Zhanri s WHERE s.zhanriID =:zhanriID");
        query.setParameter("zhanriID", zhanriID);
        try{
            return (Zhanri)query.getSingleResult();
        } catch (NoResultException nre) {
              throw new FilmiException("E dhëna nuk egziston!");
        }
        
    }
}
    
    