/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessions;

import entities.Categoriechambre;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author MANAGER
 */
@Local
public interface CategoriechambreFacadeLocal {

    void create(Categoriechambre categoriechambre);

    void edit(Categoriechambre categoriechambre);

    void remove(Categoriechambre categoriechambre);

    Categoriechambre find(Object id);

    List<Categoriechambre> findAll();

    List<Categoriechambre> findRange(int[] range);

    int count();
    
}
