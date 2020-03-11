package com.siscontable.dao;

import java.io.Serializable;

import javax.persistence.EntityManager;

import com.siscontable.entities.SueldoFijo;
import com.siscontable.utils.JPAUtils;

public class SalarioFacade extends AbstractFacade<SueldoFijo> implements Serializable{

	public SalarioFacade() {
		super(SueldoFijo.class);
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
