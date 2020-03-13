package com.siscontable.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import com.siscontable.dao.SalarioFacade;
import com.siscontable.entities.SueldoFijo;

@ManagedBean
@RequestScoped
public class SueldoController {
	
	private SueldoFijo salario;
	private SalarioFacade salarioFacade;
	public List<SueldoFijo> Listsalario;
	
	@PostConstruct
	public void init() {
		salario = new SueldoFijo();
		salarioFacade = new SalarioFacade();
	}
	
	public void mostrar() {
		Listsalario = new ArrayList<SueldoFijo>();
		Listsalario = salarioFacade.mostrar();
	}
	
	public void guardar() {
		try {
			salario.setFechaCreacion(new Date());
			salarioFacade.guardar(salario);
			mensaje("exito");
		} catch (Exception e) {
			mensaje("algo fallo");
		}
	}
	
	public void mensaje(String respuesta) {
		FacesMessage mensaje = new  FacesMessage(respuesta);
		FacesContext.getCurrentInstance().addMessage(null, mensaje);
	}
}
