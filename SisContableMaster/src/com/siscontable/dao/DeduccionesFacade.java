package com.siscontable.dao;

import java.io.Serializable;

import javax.persistence.EntityManager;

import com.siscontable.entities.DeducionesLegale;
import com.siscontable.utils.JPAUtils;

public class DeduccionesFacade extends AbstractFacade<DeducionesLegale> implements Serializable{

	public DeduccionesFacade() {
		super(DeducionesLegale.class);
	}

	private static final long serialVersionUID = 1L;
	private EntityManager em;
	
	@Override
	protected EntityManager getEntityManager() {
		if(em == null) {
			em = JPAUtils.getEntityManagerFactory().createEntityManager(); 
		}
		return em;
	}

	
}
