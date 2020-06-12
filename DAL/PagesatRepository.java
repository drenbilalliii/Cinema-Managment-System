/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import BLL.Pagesat;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author Dren
 */
public class PagesatRepository extends EntMngClass implements PagesatInterface{

    @Override
    public void create(Pagesat pagesat) throws ShitjeException {
        try{
            em.getTransaction().begin();
            em.persist(pagesat);
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
    public void edit(Pagesat pagesat) throws ShitjeException {
        em.getTransaction().begin();
            em.merge(pagesat);
            em.getTransaction().commit();
    }

    @Override
    public void delete(Pagesat pagesat) throws ShitjeException {
            em.getTransaction().begin();
            em.remove(pagesat);
            em.getTransaction().commit();
    }

    @Override
    public List<Pagesat> findAll() throws ShitjeException {
        return (List<Pagesat>)em.createNamedQuery("Pagesat.findAll").getResultList();
    }
    
        
     public List<Pagesat> fetchSomeValues (int first,int second){
        Query query = em.createQuery("Select p from Pagesat p").setFirstResult(first);
        query.setMaxResults(second);
        return (List<Pagesat>)query.getResultList();
         
         
    
    
}
     public  ArrayList<String> treMusketieretPagesat() throws PerdoruesiException{
         ArrayList<String> pagesa = new ArrayList<String>();
        String sql ="select PagesatID,Shuma from Pagesat Order by shuma desc";
            String p = null;
        int numri = 0;
        Query query = em.createNativeQuery(sql).setFirstResult(0).setMaxResults(3);
        List<Object[]> list = query.getResultList();
        
        for(Object [] obj : list){
                pagesa.add(String.valueOf(obj[0]));
                pagesa.add(String.valueOf(obj[1]));
        }
        
        
                return pagesa;
    }
}
    
