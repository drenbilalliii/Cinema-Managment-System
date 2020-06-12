/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;


import BLL.Perdoruesi;
import java.util.List;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.persistence.criteria.Root;

/**
 *
 * @author user
 */
public class PerdoruesiRepository extends EntMngClass implements PerdoruesiInterface{

    @Override
    public void create(Perdoruesi s) throws PerdoruesiException{
        try{
            em.getTransaction().begin();
            em.persist(s);
            em.getTransaction().commit();
        }
        catch(Throwable thro){
            if(thro.getMessage().contains("2627")){
            
                    throw new PerdoruesiException("E dhëna egziston !");
            }
        else{
                throw new PerdoruesiException("Create : "+thro.getClass()+" - "+thro.getMessage());
                }
        }
    }

    @Override
    public void edit(Perdoruesi s) throws PerdoruesiException{
      try{
            em.getTransaction().begin();
            em.merge(s);
            em.getTransaction().commit();
        }
        catch(Throwable thro){
            if(thro.getMessage().contains("2627")){
                    throw new PerdoruesiException("E dhëna egziston");
            }
            else{
                throw new PerdoruesiException("Update: "+thro.getClass()+" - "+thro.getMessage());
            }
                
        }
    }

    @Override
    public void remove(Perdoruesi s) {
        em.getTransaction().begin();
        em.remove(s);
        em.getTransaction().commit();
    }

    @Override
    public List<Perdoruesi> findAll() {
        return (List<Perdoruesi>)em.createNamedQuery("Perdoruesi.findAll").getResultList();
    }

    @Override
    public Perdoruesi findByID(Integer id) throws PerdoruesiException {
        Query query = em.createQuery("SELECT s FROM Perdoruesi s WHERE s.id = :id");
        query.setParameter("id", id);
        try{
            return (Perdoruesi)query.getSingleResult();
        } catch (NoResultException nre) {
              throw new PerdoruesiException("E dhëna nuk egziston!");
        }
        
    }

    public Perdoruesi findByUsernameAndPassword(String username, String passwordi) throws PerdoruesiException {
        Query query = em.createQuery("SELECT p FROM Perdoruesi p WHERE p.username = :username and p.passwordi = :passwordi");
        query.setParameter("username", username);
         query.setParameter("passwordi", passwordi);
        try{
            return (Perdoruesi)query.getSingleResult();
        } catch (NoResultException nre) {
              throw new PerdoruesiException("E dhëna nuk egziston!");
             
             
        }
        
        
    }
   // e harron najkush passwordin me kthy me password
    //SH*t security but whatEveeeeeeeeeeeeeeeer.
    public Perdoruesi findbyUsername(String username) throws PerdoruesiException{
        Query query = em.createQuery("SELECT p FROM Perdoruesi p WHERE p.username = :username");
      
        query.setParameter("username",username); 
     
        try{
            return (Perdoruesi)query.getSingleResult(); 
        }catch(NoResultException e){
            throw new PerdoruesiException("Nuk u gjet asnje");
        }
    }
    
    public long countRowsPerdorues() throws PerdoruesiException{
        Query query = em.createQuery("SELECT COUNT(p)from Perdoruesi p");
        try{
            return (long)query.getSingleResult();
        }catch(NoResultException e){
            throw new PerdoruesiException("N");
        }
    }
    
    //per charts ktu nevojiten 
            //2/5/2020... ora 3:27 e nates .. ska gjume jojo :$
    
    //per ma vone e kqyri kur ti boj charts ..
    public long[] securityPasswordCheckChart() throws PerdoruesiException{
        Query query = em.createQuery("Select count(p) from Perdoruesi p where LENGTH(p.passwordi) > 8");
        Query queryOther = em.createQuery("SELECT COUNT(p) from Perdoruesi p where LENGTH(p.passwordi) < 8");
        try{
            return new long[]{(long)query.getSingleResult(),(long)queryOther.getSingleResult()};
        }catch(NoResultException e){
            throw new PerdoruesiException("Erorr");
        }
    }
    //query per me kthy numer se sa llogari te adminave dhe te personelit gjenden ne databaz
    public int[] countPersonelAdminandWorker() throws PerdoruesiException{
        Query query = em.createNativeQuery("SELECT COUNT(RoliID) from Perdoruesi p where p.roliID = 1 ");
        Query queryForWorker = em.createNativeQuery("SELECT COUNT(RoliID) from Perdoruesi p where p.roliID = 2");
        
        try{
            return new int[]{(int)query.getSingleResult(),(int)queryForWorker.getSingleResult()};
        }catch(NoResultException e){
            throw new PerdoruesiException("Kerka sje");
        }

        
    }
    //username me i perseritur nuk e perdori vetem si test... e perdori me vone te Klientet
    public  String []repeatedUsername() throws PerdoruesiException{
        String sql ="	select p.Username ,count(*) as NumriPerseritjes from Perdoruesi p\n" +
"        group by Username\n" +
"          having count(*) =(select max(NumriPerseritjes) from \n" +
"            (select Username,count(*) as NumriPerseritjes from Perdoruesi group by Username) Perdoruesi)";
        String p = null;
        int numri = 0;
        Query query = em.createNativeQuery(sql);
        List<Object[]> list = query.getResultList();
        
        for(Object [] obj : list){
                 p = (String)obj[0];
                 numri = (int) obj[1];
        }
        
                return new String[]{p,String.valueOf(numri)};
    }

    
    
    //per pagination...
    
    
     public List<Perdoruesi> fetchSomeValues (int first,int second){
        Query query = em.createQuery("Select a from Perdoruesi a").setFirstResult(first);
        query.setMaxResults(second);
        return (List<Perdoruesi>)query.getResultList();
         
         
     }
    
}



