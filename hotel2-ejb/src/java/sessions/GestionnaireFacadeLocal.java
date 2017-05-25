/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessions;

import entities.Gestionnaire;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author MANAGER
 */
@Local
public interface GestionnaireFacadeLocal {

    void create(Gestionnaire gestionnaire);

    void edit(Gestionnaire gestionnaire);

    void remove(Gestionnaire gestionnaire);

    Gestionnaire find(Object id);

    List<Gestionnaire> findAll();

    List<Gestionnaire> findRange(int[] range);

    int count();
    
}
