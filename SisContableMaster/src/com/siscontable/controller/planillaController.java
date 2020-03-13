package com.siscontable.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import com.siscontable.dao.PlanillaFacade;
import com.siscontable.entities.Planilla;

@ManagedBean
@RequestScoped
public class planillaController {
	
	private Planilla pla;
	private PlanillaFacade plafacade;
	public List<Planilla> listaPlanilla;
	
	@PostConstruct
	public void init() {
		pla = new Planilla();
		plafacade = new PlanillaFacade();
		
		mostrar();
		
	}
	
	public void mostrar() {
		listaPlanilla = new ArrayList<Planilla>();
		listaPlanilla = plafacade.mostrar();
	}
	
	public void findById(int idPlanilla) {
		plafacade.findById(idPlanilla);
	}
	
	public void guardar() {
		try {
			plafacade.guardar(pla);
			mensaje("Exito");
		} catch (Exception e) {
			mensaje("Algo a fallado");
		}
	}
	
	public void agregar() {
		try {
			plafacade.guardar(pla);
			mensaje("Exito");
		} catch (Exception e) {
			mensaje("Algo a fallado");
		}
	}
	
	public void modificar() {
		try {
			plafacade.modificar(pla);;
			mensaje("Exito");
		} catch (Exception e) {
			mensaje("Algo a fallado");
		}
	}
	
	public void borrar() {
		try {
			plafacade.eliminar(pla);
			mensaje("Exito");
		} catch (Exception e) {
			mensaje("Algo a fallado");
		}
	}
	
	public void mensaje(String respuesta) {
		FacesMessage mensaje = new  FacesMessage(respuesta);
		FacesContext.getCurrentInstance().addMessage(null, mensaje);
	}
	
	
}
