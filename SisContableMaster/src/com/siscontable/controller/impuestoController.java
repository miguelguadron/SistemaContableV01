	package com.siscontable.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import com.siscontable.dao.DeduccionesFacade;
import com.siscontable.dao.EstadoDao;
import com.siscontable.entities.DeducionesLegale;
import com.siscontable.entities.Estado;

@ManagedBean
@RequestScoped
public class impuestoController {
	
	private DeducionesLegale impuesto;
	private DeduccionesFacade impuestoFacade;
	public List<DeducionesLegale> listaimpuesto;
	
	private Estado est;
	private EstadoDao estfacade;
	public List<Estado> listaEstado;
	int idEst =0;
	
	@PostConstruct
	public void init() {
		impuesto = new DeducionesLegale();
		impuestoFacade = new DeduccionesFacade();
		
		est = new Estado();
		estfacade = new EstadoDao();
		idEst=0;
		mostrar();
		selectEstado();
	}
	
	public void mostrar() {
		listaimpuesto = new  ArrayList<DeducionesLegale>();
		listaimpuesto = impuestoFacade.mostrar();
	}
	
	public void FindById(int idImpuesto) {
		impuestoFacade.findById(idImpuesto);
	}
	
	public void guardar() {
		try {
			impuesto.setFechaCreacion(new Date());
			impuestoFacade.guardar(impuesto);
			mensaje("Exito");
			impuesto = new DeducionesLegale();
			mostrar();
		} catch (Exception e) {
			mensaje("Algo Fallo");
		}
		
	}
	
	public void modificar() {
		try {
			impuesto.setFechaCreacion(new Date());
			impuestoFacade.modificar(impuesto);
			mensaje("Exito");
			impuesto = new DeducionesLegale();
			mostrar();
		} catch (Exception e) {
			mensaje("Exito");
		}
		
	}
	
	public void eliminar(int idImpuesto) {
		try {
			impuestoFacade.eliminar(impuesto);
			mensaje("Exito");
		} catch (Exception e) {
			mensaje("Algo a fallado");
		}
	}
	
	public void mensaje(String respuesta) {
		FacesMessage mensaje = new FacesMessage(respuesta);
		FacesContext.getCurrentInstance().addMessage(null, mensaje);
		
	}
	
	public List<Estado> selectEstado() {
		this.listaEstado = new ArrayList<Estado>();
		return this.listaEstado = estfacade.mostrar();
		
	}

	public DeducionesLegale getImpuesto() {
		return impuesto;
	}

	public void setImpuesto(DeducionesLegale impuesto) {
		this.impuesto = impuesto;
	}

	public DeduccionesFacade getImpuestoFacade() {
		return impuestoFacade;
	}

	public void setImpuestoFacade(DeduccionesFacade impuestoFacade) {
		this.impuestoFacade = impuestoFacade;
	}

	public List<DeducionesLegale> getListaimpuesto() {
		return listaimpuesto;
	}

	public void setListaimpuesto(List<DeducionesLegale> listaimpuesto) {
		this.listaimpuesto = listaimpuesto;
	}

	public int getIdEst() {
		return idEst;
	}

	public void setIdEst(int idEst) {
		this.idEst = idEst;
	}
	
	
	
}
