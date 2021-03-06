package com.siscontable.dao;

import java.io.Serializable;

import javax.persistence.EntityManager;

import com.siscontable.entities.Empleado;
import com.siscontable.utils.JPAUtils;

public class EmpleadoDao extends AbstractFacade<Empleado> implements Serializable{
	
	public EmpleadoDao() {
		super(Empleado.class);
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
