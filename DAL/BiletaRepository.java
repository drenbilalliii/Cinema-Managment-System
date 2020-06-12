/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import BLL.Bileta;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.NoResultException;
import javax.persistence.Query;

/**
 *
 * @author Dren
 */
public class BiletaRepository extends EntMngClass implements BiletaInterface{
    
      @Override
    public void create(Bileta bileta) throws  ShitjeException{
        try{
            em.getTransaction().begin();
            em.persist(bileta);
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
    public void edit(Bileta bileta) throws ShitjeException{
      try{
            em.getTransaction().begin();
            em.merge(bileta);
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
    public void remove(Bileta bileta) {
        em.getTransaction().begin();
        em.remove(bileta);
        em.getTransaction().commit();
    }

    @Override
    public List<Bileta> findAll() {
        return (List<Bileta>)em.createNamedQuery("Bileta.findAll").getResultList();
    }

    @Override
    public Bileta findByID(Integer ID) throws ShitjeException {
        return null; //sna vyn
    }
    
     public List<Bileta> fetchSomeValues (int first,int second){
        Query query = em.createQuery("Select b from Bileta b").setFirstResult(first);
        query.setMaxResults(second);
        return (List<Bileta>)query.getResultList();
         
         
     }
     //cila sall eshte perdorur me se shumti
     
     public  String []maxSalla() throws PerdoruesiException{
        String sql ="select p.SallaID ,count(*) as NumriPerseritjes from Bileta p\n" +
"group by SallaID\n" +
"having count(*) =(select max(NumriPerseritjes) from\n" +
"(select SallaID,count(*) as NumriPerseritjes from Bileta group by SallaID)Bileta)";
        Integer p = null;
        int numri = 0;
        Query query = em.createNativeQuery(sql);
        List<Object[]> list = query.getResultList();
        
        for(Object [] obj : list){
                 p = (Integer) obj[0];
                 numri = (int) obj[1];
        }
        
                return new String[]{String.valueOf(p),String.valueOf(numri)};
    }

    
      public  String []minSalla() throws PerdoruesiException{
        String sql ="select p.SallaID ,count(*) as NumriPerseritjes from Bileta p\n" +
"group by SallaID\n" +
"having count(*) =(select min(NumriPerseritjes) from\n" +
"(select SallaID,count(*) as NumriPerseritjes from Bileta group by SallaID)Bileta)";
            Integer p = null;
        int numri = 0;
        Query query = em.createNativeQuery(sql);
        List<Object[]> list = query.getResultList();
        
        for(Object [] obj : list){
                 p = (Integer)obj[0]; // sallaID
                 numri = (int) obj[1];
        }
        
                return new String[]{String.valueOf(p),String.valueOf(numri)};
    }
      
      

     
     public static void main(String[] args) {
        
          try {
              BiletaRepository b = new BiletaRepository();
              String result [] = b.maxSalla();
              
             String emri = result[0];
             Integer numri = Integer.parseInt(result[1]);
             
              System.out.println(emri);
              System.out.println(numri);
              
              
          } catch (PerdoruesiException ex) {
              Logger.getLogger(BiletaRepository.class.getName()).log(Level.SEVERE, null, ex);
          }
         
    }
    
}

    

