/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import java.sql.Connection;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import org.eclipse.persistence.sessions.Session;

/**
 *
 * @author Dren
 */
public  class EntMngClass {
    EntityManager em=
    Persistence.createEntityManagerFactory("FilmixPU").createEntityManager();
    
   
  
}
    
