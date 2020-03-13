package com.siscontable.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import com.siscontable.dao.EmpresaDao;
import com.siscontable.dao.EstadoDao;
import com.siscontable.dao.PaisDao;
import com.siscontable.entities.Empresa;
import com.siscontable.entities.Estado;
import com.siscontable.entities.Pais;

@ManagedBean
@RequestScoped
public class EmpresaController {
	private Empresa empresa;
	private EmpresaDao empDao;
	public List<Empresa> ListEmp;
	
	
	private Pais pais;
	private PaisDao paisFacade;
	public List<Pais> listaPais;
	
	private Estado est;
	private EstadoDao estfacade;
	public List<Estado> listaEstado;
	
	
	int idpaiss;
	int idesta;
	

	@PostConstruct
	public void init() {
		empresa = new Empresa();
		empDao = new EmpresaDao();
		
		est = new Estado();
		estfacade = new EstadoDao();
		
		pais = new Pais();
		paisFacade = new PaisDao();

		idpaiss=0;
		idesta=0;
		
		mostrar();
		selectPais();
		selectEstado();
		
	}
	
	public void mostrar() {
		ListEmp = new ArrayList<Empresa>();
		ListEmp = empDao.mostrar();
	}
	
	
	public void guardar() {
		try {
			Pais idpa = new Pais();
			idpa.setIdPais(idpaiss);
			
			Estado idest = new Estado();
			idest.setIdEstado(idesta);
			empresa.setEstado(idest);
			
			empresa.setFechaCreacion(new Date());
			
			empDao.guardar(empresa);
			mensaje("Se creo la empresa correctamente");
			
			empresa = new Empresa();
			idesta = 0;
			idpaiss = 0;
			
		} catch (Exception e) {
			mensaje("Algo a fallado");
		}
	}
	
	public void modificar() {
		try {
			empDao.modificar(empresa);
			mensaje("Se modifico la empresa correctamente");
		} catch (Exception e) {
			mensaje("Algo a fallado");
		}
	}
	
	public void eliminar() {
		try {
			empDao.eliminar(empresa);
			mensaje("Se a borrado la empresa correctamente");
		} catch (Exception e) {
			mensaje("Algo a fallado");
		}
	}
	
	public void buscarId(Empresa id) {
		empDao.findById(id);
	}
	
	public void mensaje(String respuesta) {
		FacesMessage mensaje = new  FacesMessage(respuesta);
		FacesContext.getCurrentInstance().addMessage(null, mensaje);
	}
	
	public List<Estado> selectEstado() {
		this.listaEstado = new ArrayList<Estado>();
		return this.listaEstado = estfacade.mostrar();
		
	}
	
	public List<Pais> selectPais(){
		this.listaPais = new ArrayList<Pais>();
		return this.listaPais = paisFacade.mostrar();
	}
	
	
	public String ira() {
		return "login.xhtml";
	}

	
	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	public EmpresaDao getEmpDao() {
		return empDao;
	}

	public void setEmpDao(EmpresaDao empDao) {
		this.empDao = empDao;
	}

	public List<Empresa> getListEmp() {
		return ListEmp;
	}

	public void setListEmp(List<Empresa> listEmp) {
		ListEmp = listEmp;
	}

	public int getIdpaiss() {
		return idpaiss;
	}

	public void setIdpaiss(int idpaiss) {
		this.idpaiss = idpaiss;
	}

	public int getIdesta() {
		return idesta;
	}

	public void setIdesta(int idesta) {
		this.idesta = idesta;
	}
	
	
	
}
