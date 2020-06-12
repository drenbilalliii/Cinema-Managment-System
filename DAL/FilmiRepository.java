/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import BLL.Filmi;
import BLL.Perdoruesi;
import java.util.List;
import javax.persistence.NoResultException;
import javax.persistence.Query;

/**
 *
 * @author Dren
 */
public class FilmiRepository extends EntMngClass implements FilmiInterface{

    @Override
    public void create(Filmi f) throws  FilmiException{
        try{
            em.getTransaction().begin();
            em.persist(f);
            em.getTransaction().commit();
        }
        catch(Throwable thro){
            if(thro.getMessage().contains("2627")){
            
                    throw new FilmiException("E dhëna egziston !");
            }
        else{
                throw new FilmiException("Create : "+thro.getClass()+" - "+thro.getMessage());
                }
        }
    }

    @Override
    public void edit(Filmi f) throws FilmiException{
      try{
            em.getTransaction().begin();
            em.merge(f);
            em.getTransaction().commit();
        }
        catch(Throwable thro){
            if(thro.getMessage().contains("2627")){
                    throw new FilmiException("E dhëna egziston");
            }
            else{
                throw new FilmiException("Update: "+thro.getClass()+" - "+thro.getMessage());
            }
                
        }
    }

    @Override
    public void remove(Filmi f) {
        em.getTransaction().begin();
        em.remove(f);
        em.getTransaction().commit();
    }

    @Override
    public List<Filmi> findAll() {
        return (List<Filmi>)em.createNamedQuery("Filmi.findAll").getResultList();
    }

    @Override
    public Filmi findByID(Integer filmiID) throws FilmiException {
        Query query = em.createQuery("SELECT s FROM Filmi s WHERE s.filmiID = :filmiID");
        query.setParameter("filmiID", filmiID);
        try{
            return (Filmi)query.getSingleResult();
        } catch (NoResultException nre) {
              throw new FilmiException("E dhëna nuk egziston!");
        }
        
    }
    
    public List<Filmi> fetchSomeValues (int first,int second){
        Query query = em.createQuery("Select f from Filmi f").setFirstResult(first);
        query.setMaxResults(second);
        return (List<Filmi>)query.getResultList();
         
         
   
    }
    
    public  String []maxZhanri() throws PerdoruesiException{
        String sql ="select p.ZhanriID ,count(*) as NumriPerseritjes from Filmi p\n" +
"group by ZhanriID\n" +
"having count(*) =(select max(NumriPerseritjes) from\n" +
"(select ZhanriID,count(*) as NumriPerseritjes from Filmi group by ZhanriID)Filmi)";
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
    
    public  String []minZhanri() throws PerdoruesiException{
        String sql ="select p.ZhanriID ,count(*) as NumriPerseritjes from Filmi p\n" +
"group by ZhanriID\n" +
"having count(*) =(select min(NumriPerseritjes) from\n" +
"(select ZhanriID,count(*) as NumriPerseritjes from Filmi group by ZhanriID)Filmi)";
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
        
        
    }
    
    
}
