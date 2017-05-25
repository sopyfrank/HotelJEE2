/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessions;

import entities.Servicesupp;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author MANAGER
 */
@Local
public interface ServicesuppFacadeLocal {

    void create(Servicesupp servicesupp);

    void edit(Servicesupp servicesupp);

    void remove(Servicesupp servicesupp);

    Servicesupp find(Object id);

    List<Servicesupp> findAll();

    List<Servicesupp> findRange(int[] range);

    int count();
    
}
