/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessions;

import entities.Receptionniste;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author MANAGER
 */
@Stateless
public class ReceptionnisteFacade extends AbstractFacade<Receptionniste> implements ReceptionnisteFacadeLocal {

    @PersistenceContext(unitName = "hotel2-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ReceptionnisteFacade() {
        super(Receptionniste.class);
    }
    
}
