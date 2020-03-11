package com.siscontable.dao;

import java.io.Serializable;
import java.util.List;


import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.siscontable.entities.Movimiento;
import com.siscontable.utils.JPAUtils;



public class MovimientoFacade extends AbstractFacade<Movimiento> implements Serializable{
	
	private static final long serialVersionUID=1L;
	private EntityManager em;
	
	public MovimientoFacade() {
		super(Movimiento.class);
		getEntityManager();
	}
	
	protected EntityManager getEntityManager() {
		if(em==null) {
			em = JPAUtils.getEntityManagerFactory().createEntityManager();
		} return em;
	}
	
	public List<Movimiento> lista1(String valor){
		System.out.println("ESTE ES VALOR2:"+valor);
		try {
			Query q = em.createNamedQuery("Movimiento1");
			q.setParameter("1", valor);
			@SuppressWarnings("unchecked")
			List<Movimiento> list = q.getResultList();
			return list;
		} catch (Exception e) {
			System.out.println("Algo ha fallado");
			return null;
		}
	}
	
	public List<Movimiento> listaLike1(){
		try {
			Query q = em.createNamedQuery("filtrado1");
			@SuppressWarnings("unchecked")
			List<Movimiento> list = q.getResultList();
			return list;
		} catch (Exception e) {
			System.out.println("Algo ha fallado");
			return null;
		}
	}
	
	public List<Movimiento> listaLike2(){
		try {
			Query q = em.createNamedQuery("filtrado2");
			@SuppressWarnings("unchecked")
			List<Movimiento> list = q.getResultList();
			return list;
		} catch (Exception e) {
			System.out.println("Algo ha fallado");
			return null;
		}
	}
	
	public List<Movimiento> listaLike3(){
		try {
			Query q = em.createNamedQuery("filtrado3");
			@SuppressWarnings("unchecked")
			List<Movimiento> list = q.getResultList();
			return list;
		} catch (Exception e) {
			System.out.println("Algo ha fallado");
			return null;
		}
	}
	

	public Movimiento findvalor(Object valor) {
		try {
			Query q = em.createNamedQuery("Movimiento1");
			q.setParameter("1", valor);
			return (Movimiento) q.getSingleResult();
		} catch (Exception e) {
			return null;
		}
	}
	
}
