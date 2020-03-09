package com.siscontable.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import com.siscontable.dao.MovimientoFacade;
import com.siscontable.entities.Movimiento;


@ManagedBean
@RequestScoped
public class MovimientoController {
	
	private Movimiento m;
	private MovimientoFacade mf;
	private List<Movimiento> listaMovimiento;
	
	public Movimiento getM() {
		return m;
	}
	public void setM(Movimiento m) {
		this.m = m;
	}
	public List<Movimiento> getListaMovimiento() {
		return listaMovimiento;
	}
	public void setListaMovimiento(List<Movimiento> listaMovimiento) {
		this.listaMovimiento = listaMovimiento;
	}
	
	@PostConstruct
	public void init() {
		m = new Movimiento();
		mf = new MovimientoFacade();
		mostrar();
	}
	
	public void mensaje(String respuesta) {
		FacesMessage mensaje = new FacesMessage(respuesta);
		FacesContext.getCurrentInstance().addMessage(null, mensaje);
	}
	
	public List<Movimiento> mostrar(){
		this.listaMovimiento = new ArrayList<Movimiento>();
		 return this.listaMovimiento = mf.mostrar();
	}
	
	
	
}
