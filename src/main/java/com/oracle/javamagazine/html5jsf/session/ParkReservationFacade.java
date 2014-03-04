/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.oracle.javamagazine.html5jsf.session;

import com.oracle.javamagazine.html5jsf.entity.ParkReservation;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Juneau
 */
@Stateless
public class ParkReservationFacade extends AbstractFacade<ParkReservation> {
    @PersistenceContext(unitName = "JavaMagazine-HTML5JSF-PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ParkReservationFacade() {
        super(ParkReservation.class);
    }
    
}
