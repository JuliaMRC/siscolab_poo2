/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package siscolab_db;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Julia
 */
public class EspecialidadeFacade {

    @PersistenceContext(unitName = "TestePU")
    private EntityManager em;

    protected EntityManager getEntityManager() {
        return em;
    }
    
}
