/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessions;

import entities.Gestionnaire;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author MANAGER
 */
@Stateless
public class GestionnaireFacade extends AbstractFacade<Gestionnaire> implements GestionnaireFacadeLocal {

    @PersistenceContext(unitName = "hotel2-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public GestionnaireFacade() {
        super(Gestionnaire.class);
    }
    
}
