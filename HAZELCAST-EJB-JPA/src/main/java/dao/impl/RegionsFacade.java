/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.impl;

import dao.generic.AbstractFacade;
import dao.local.RegionsFacadeLocal;
import model.entities.Regions;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author 912867
 */
@Stateless
public class RegionsFacade extends AbstractFacade<Regions> implements RegionsFacadeLocal {
    @PersistenceContext(unitName = "HR_TEST_UNIT")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public RegionsFacade() {
        super(Regions.class);
    }
    
}
