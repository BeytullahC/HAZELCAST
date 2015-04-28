/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.impl;

import dao.generic.AbstractFacade;
import dao.local.CountriesFacadeLocal;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import model.entities.Countries;

/**
 *
 * @author 912867
 */
@Stateless
public class CountriesFacade extends AbstractFacade<Countries> implements CountriesFacadeLocal {
    @PersistenceContext(unitName = "HR_TEST_UNIT")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CountriesFacade() {
        super(Countries.class);
    }
    
}
