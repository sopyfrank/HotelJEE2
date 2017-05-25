/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessions;

import entities.Receptionniste;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author MANAGER
 */
@Local
public interface ReceptionnisteFacadeLocal {

    void create(Receptionniste receptionniste);

    void edit(Receptionniste receptionniste);

    void remove(Receptionniste receptionniste);

    Receptionniste find(Object id);

    List<Receptionniste> findAll();

    List<Receptionniste> findRange(int[] range);

    int count();
    
}
