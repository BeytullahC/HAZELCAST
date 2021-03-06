/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.local;

import model.entities.Countries;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author 912867
 */
@Local
public interface CountriesFacadeLocal {

    void create(Countries countries);

    void edit(Countries countries);

    void remove(Countries countries);

    Countries find(Object id);

    List<Countries> findAll();

    List<Countries> findRange(int[] range);

    int count();
    
}
