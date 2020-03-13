package com.siscontable.dao;

import java.io.Serializable;

import javax.persistence.EntityManager;

import com.siscontable.entities.Planilla;
import com.siscontable.utils.JPAUtils;

public class PlanillaFacade extends AbstractFacade<Planilla> implements Serializable{

	public PlanillaFacade() {
		super(Planilla.class);
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
