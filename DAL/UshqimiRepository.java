/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import BLL.Ushqimi;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.NoResultException;
import javax.persistence.Query;

/**
 *
 * @author Dren
 */
public class UshqimiRepository extends EntMngClass implements UshqimiInterface{

    @Override
    public void create(Ushqimi u) throws ShitjeException{
        try{
            em.getTransaction().begin();
            em.persist(u);
            em.getTransaction().commit();
        }
        catch(Throwable thro){
            if(thro.getMessage().contains("2627")){
            
                    throw new ShitjeException("E dhëna egziston !");
            }
        else{
                throw new ShitjeException("Create : "+thro.getClass()+" - "+thro.getMessage());
                }
        }
    }

    @Override
    public void edit(Ushqimi u) throws ShitjeException{
      try{
            em.getTransaction().begin();
            em.merge(u);
            em.getTransaction().commit();
        }
        catch(Throwable thro){
            if(thro.getMessage().contains("2627")){
                    throw new ShitjeException("E dhëna egziston");
            }
            else{
                throw new ShitjeException("Update: "+thro.getClass()+" - "+thro.getMessage());
            }
                
        }
    }

    @Override
    public void remove(Ushqimi u) {
        em.getTransaction().begin();
        em.remove(u);
        em.getTransaction().commit();
    }

    @Override
    public List<Ushqimi> findAll() {
        return (List<Ushqimi>)em.createNamedQuery("Ushqimi.findAll").getResultList();
    }

    @Override
    public Ushqimi findByID(Integer id) throws ShitjeException {
        Query query = em.createQuery("SELECT u FROM Ushqimi u WHERE u.ushqimiID = :id");
        query.setParameter("id", id);
        try{
            return (Ushqimi)query.getSingleResult();
        } catch (NoResultException nre) {
              throw new ShitjeException("E dhëna nuk egziston!");
        }
        
    }
    
      
     public List<Ushqimi> fetchSomeValues (int first,int second){
        Query query = em.createQuery("Select u from Ushqimi u").setFirstResult(first);
        query.setMaxResults(second);
        return (List<Ushqimi>)query.getResultList();
         
         
     }
     
     
     public  ArrayList<String> treMusketieretUshqimet() throws PerdoruesiException{
         ArrayList<String> ushqimet = new ArrayList<String>();
        String sql ="select  EmriUshqimit,Cmimi     from Ushqimi order by Cmimi desc";
            String p = null;
        int numri = 0;
        Query query = em.createNativeQuery(sql).setFirstResult(0).setMaxResults(3);
        List<Object[]> list = query.getResultList();
        
        for(Object [] obj : list){
                ushqimet.add(String.valueOf(obj[0]));
                ushqimet.add(String.valueOf(obj[1]));
        }
        
        
                return ushqimet;
    }
}
    
     

    
    //---------------------
    
