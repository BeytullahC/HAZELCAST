/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.impl;

import dao.generic.AbstractFacade;
import dao.local.LocationsFacadeLocal;
import model.entities.Locations;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author 912867
 */
@Stateless
public class LocationsFacade extends AbstractFacade<Locations> implements LocationsFacadeLocal {
    @PersistenceContext(unitName = "HR_UNIT")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public LocationsFacade() {
        super(Locations.class);
    }
    
}
