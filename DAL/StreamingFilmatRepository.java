/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import BLL.Filmi;
import BLL.StreamingFilmat;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.Query;
import org.hamcrest.Condition;

/**
 *
 * @author Dren
 */
public class StreamingFilmatRepository extends EntMngClass implements StreamingFilmatInterface {

    @Override
    public void create(StreamingFilmat streamingFilmat) throws FilmiException {
        try{
            em.getTransaction().begin();
            em.persist(streamingFilmat);
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
    public void edit(StreamingFilmat streamingFilmat) throws FilmiException {
        em.getTransaction().begin();
            em.merge(streamingFilmat);
            em.getTransaction().commit();
    }

    @Override
    public void delete(StreamingFilmat streamingFilmat) throws FilmiException {
            em.getTransaction().begin();
            em.remove(streamingFilmat);
            em.getTransaction().commit();
    }

    @Override
    public List<StreamingFilmat> findAll() throws FilmiException {
        return (List<StreamingFilmat>)em.createNamedQuery("StreamingFilmat.findAll").getResultList();
    }
    
    
    //per me pa se cili film eshte perserit ma shume nevojitet te chart aty ne fillim :)(&^)@2w
    
     public String []repeatedFilmMax() throws FilmiException{
        String sql = "select p.FilmiID  ,count(*) as NumriPerseritjes from Streaming_Filmat p group by FilmiID\n" +
"having count(*) = (select max(NumriPerseritjes) from (select FilmiID,count(*) as NumriPerseritjes from Streaming_Filmat group by FilmiID)Streaming_Filmat)";
        
                String p = null;
        int numri = 0;
        Query query = em.createNativeQuery(sql);
        List<Object[]> list = query.getResultList();
        
        for(Object [] obj : list){
                 p = String.valueOf(obj[0]); //filmi
                 numri = (int) obj[1]; //numri
        }
        
                return new String[]{p,String.valueOf(numri)};
    }
     public String []repeatedFilmMin() throws FilmiException{
        String sql = "select p.FilmiID  ,count(*) as NumriPerseritjes from Streaming_Filmat p group by FilmiID\n" +
"having count(*) = (select min(NumriPerseritjes) from (select FilmiID,count(*) as NumriPerseritjes from Streaming_Filmat group by FilmiID)Streaming_Filmat)";
        
                String p = null;
        int numri = 0;
        Query query = em.createNativeQuery(sql);
        List<Object[]> list = query.getResultList();
        
        for(Object [] obj : list){
                 p = String.valueOf(obj[0]); //filmi
                 numri = (int) obj[1]; //numri
        }
        
                return new String[]{p,String.valueOf(numri)};
    }
     
     public int countFirstWeek(){
         Query query = em.createNativeQuery("select count(*) from Streaming_Filmat where DataFilmit Between '2020-06-07' and '2020-06-14'");
         
         return (int) query.getSingleResult();
     }
     public int countSecondWeek(){
         Query query = em.createNativeQuery("select count(*) from Streaming_Filmat where DataFilmit Between '2020-06-14' and '2020-06-21'");
         
         return (int) query.getSingleResult();
     }
     public int countThirdWeek(){
         Query query = em.createNativeQuery("select count(*) from Streaming_Filmat where DataFilmit Between '2020-06-21' and '2020-06-28'");
         
         return (int) query.getSingleResult();
     }
     
     
     public static void main(String[] args) {
        
         //veq per testim a po funksionon...
         
        
        try {
            StreamingFilmatRepository streamingFilmatRepository = new StreamingFilmatRepository();
            FilmiRepository filmiRepository = new FilmiRepository();
            
            
            String [] result = streamingFilmatRepository.repeatedFilmMin();
            
           Filmi f = filmiRepository.findByID(Integer.parseInt(result[0]));
            System.out.println(f.getEmriFilmit());
            System.out.println(result[1]);
        } catch (FilmiException ex) {
            Logger.getLogger(StreamingFilmatRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
         
     }
     
       public List<StreamingFilmat> fetchSomeValues (int first,int second){
        Query query = em.createQuery("Select s from StreamingFilmat s").setFirstResult(first);
        query.setMaxResults(second);
        return (List<StreamingFilmat>)query.getResultList();
         
         
     }
    
    
    
}