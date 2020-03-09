package com.siscontable.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import com.siscontable.dao.MovimientoFacade;
import com.siscontable.entities.Movimiento;

@ManagedBean
@SessionScoped
public class MovimientoController {
	
	private Movimiento m;
	private MovimientoFacade mf;
	private List<Movimiento> listaMovimiento;
	private List<Movimiento> listaAll;
	public Object valor;
	
	
	public List<Movimiento> getListaAll() {
		this.listaAll = mf.mostrar();
		return listaAll;
	}
	public void setListaAll(List<Movimiento> listaAll) {
		this.listaAll = listaAll;
	}
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
		mostrarAll();
		agregado();
	}
	
	public void mensaje(String respuesta) {
		FacesMessage mensaje = new FacesMessage(respuesta);
		FacesContext.getCurrentInstance().addMessage(null, mensaje);
	}
	
	public List<Movimiento> mostrar(){
		this.listaMovimiento = new ArrayList<Movimiento>();
		/*String valor = "OE001";
		System.out.println("cantidad:"+mf.lista1(valor).size());
		return this.listaMovimiento = mf.lista1(valor);
		*/
		return this.listaMovimiento = mf.listaLike1();
	}
	
	public String agregado() {
		String variable="";
		if(mf.listaLike1().size() == 0 || mf.listaLike1().isEmpty()) {
			variable="OE001";
			System.out.println("persiste:"+variable);
		} else {
		int cont = (mf.listaLike1().size())+(1);
		 variable="OE00"+cont;
		 System.out.println("persiste:"+variable);
		}
		 return variable;
	}
	
	public List<Movimiento> mostrarAll(){
		this.listaAll = new ArrayList<Movimiento>();
		return listaAll = mf.mostrar();
	}
	
	
	
	
}
