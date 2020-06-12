/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import BLL.Sallat;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.NoResultException;
import javax.persistence.Query;

/**
 *
 * @author Dren
 */
public class SallaRepository extends EntMngClass implements SallaInterface{

    @Override
    public void create(Sallat s) throws FilmiException {
        try{
            em.getTransaction().begin();
            em.persist(s);
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
    public void edit(Sallat s) throws FilmiException {
         em.getTransaction().begin();
            em.merge(s);
           em.getTransaction().commit();
    }
    @Override
    public void delete(Sallat s){
            em.getTransaction().begin();
            em.remove(s);
            em.getTransaction().commit();
    }

    @Override
    public List<Sallat> findAll() throws FilmiException {
        return (List<Sallat>)em.createNamedQuery("Sallat.findAll").getResultList();
    }
    
        
     public List<Sallat> fetchSomeValues (int first,int second){
        Query query = em.createQuery("Select s from Sallat s").setFirstResult(first);
        query.setMaxResults(second);
        return (List<Sallat>)query.getResultList();
         
         
    
    
}
   
    @Override
    public Sallat findById(Integer sallaID) throws FilmiException {
        Query query = em.createQuery("SELECT s FROM Sallat s WHERE s.sallaID = :sallaID");
        query.setParameter("sallaID", sallaID);
        try{
            return (Sallat)query.getSingleResult();
        } catch (NoResultException nre) {
              throw new FilmiException("E dhëna nuk egziston!");
        }
        
    }
    
     public  ArrayList<String> treMusketieret() throws PerdoruesiException{
         ArrayList<String> sallat = new ArrayList<String>();
        String sql ="select EmriSalles,KapacitetiUlseve from Sallat Order by KapacitetiUlseve desc";
            String p = null;
        int numri = 0;
        Query query = em.createNativeQuery(sql).setFirstResult(0).setMaxResults(3);
        List<Object[]> list = query.getResultList();
        
        for(Object [] obj : list){
                sallat.add((String) obj[0]);
                sallat.add(String.valueOf(obj[1]));
        }
        
        
        
                return sallat;
    }}

//        public static void main(String[] args) throws PerdoruesiException {
//        
//            SallaRepository sallaRepository = new SallaRepository();
//            
//            ArrayList<String> list = sallaRepository.treMusketieret();
//            
//            System.out.println(list);
//    }
//}

    
   