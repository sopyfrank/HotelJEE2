/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessions;

import entities.Categoriechambre;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author MANAGER
 */
@Stateless
public class CategoriechambreFacade extends AbstractFacade<Categoriechambre> implements CategoriechambreFacadeLocal {

    @PersistenceContext(unitName = "hotel2-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CategoriechambreFacade() {
        super(Categoriechambre.class);
    }
    
}
