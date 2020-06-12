/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import BLL.Klienti;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Query;
import org.eclipse.persistence.sessions.Session;

/**
 *
 * @author Dren
 */
public class KlientiRepository extends EntMngClass implements KlientiInterface{

    @Override
    public void create(Klienti klienti) throws PerdoruesiException {
        try{
            em.getTransaction().begin();
            em.persist(klienti);
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
    public void edit(Klienti klienti) throws PerdoruesiException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Klienti klienti) throws PerdoruesiException {
            em.getTransaction().begin();
            em.remove(klienti);
            em.getTransaction().commit();
    }

    @Override
    public List<Klienti> findAll() throws PerdoruesiException {
        return (List<Klienti>)em.createNamedQuery("Klienti.findAll").getResultList();
    }
    
    
     public List<Klienti> fetchSomeValues (int first,int second){
        Query query = em.createQuery("Select k from Klienti k").setFirstResult(first);
        query.setMaxResults(second);
        return (List<Klienti>)query.getResultList();
         
         
        
     }
     
    //
     
     public  ArrayList<String> treMusketieret() throws PerdoruesiException{
         ArrayList<String> klienti = new ArrayList<String>();
        String sql ="select EmriMbiemri ,count(EmriMbiemri) as most_diqka from Klienti\n" +
"group by EmriMbiemri\n" +
"order by count(EmriMbiemri) DEsc";
            String p = null;
        int numri = 0;
        Query query = em.createNativeQuery(sql).setFirstResult(0).setMaxResults(3);
        List<Object[]> list = query.getResultList();
        
        for(Object [] obj : list){
                klienti.add((String) obj[0]);
                klienti.add(String.valueOf(obj[1]));
        }
        
        
                return klienti;
    }
     
     public Klienti findById(Integer klientiID){
         Query query = em.createQuery("SELECT k FROM Klienti k WHERE k.klientiID = :klientiID");
         query.setParameter("klientiID",klientiID);
         
         return (Klienti) query.getSingleResult();
         
         
     }
     
     public void getConnection(){
        em.getTransaction().begin();
        java.sql.Connection connection = em.unwrap(java.sql.Connection.class);
        em.getTransaction().commit();
     }

     
}
    
     
    