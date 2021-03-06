/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.local;

import model.entities.Departments;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author 912867
 */
@Local
public interface DepartmentsFacadeLocal {

    void create(Departments departments);

    void edit(Departments departments);

    void remove(Departments departments);

    Departments find(Object id);

    List<Departments> findAll();

    List<Departments> findRange(int[] range);

    int count();
    
}
