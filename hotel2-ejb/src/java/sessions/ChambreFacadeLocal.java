/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessions;

import entities.Chambre;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author MANAGER
 */
@Local
public interface ChambreFacadeLocal {

    void create(Chambre chambre);

    void edit(Chambre chambre);

    void remove(Chambre chambre);

    Chambre find(Object id);

    List<Chambre> findAll();

    List<Chambre> findRange(int[] range);

    int count();
    
}
