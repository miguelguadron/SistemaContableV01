package com.siscontable.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import com.siscontable.dao.CargoDao;
import com.siscontable.dao.DepartamentoDao;
import com.siscontable.dao.EmpleadoDao;
import com.siscontable.dao.UsuarioDao;
import com.siscontable.entities.Cargo;
import com.siscontable.entities.Departamento;
import com.siscontable.entities.Empleado;
import com.siscontable.entities.Usuario;

@ManagedBean
@RequestScoped
public class EmpleadoController {
	
	private Empleado empleado;
	private EmpleadoDao empleadoDao;
	public List<Empleado> ListEmpleado;
	
	private Cargo cargo;
	private CargoDao cargoFacade;
	public List<Cargo> listacargo;
	
	private Departamento departamento;
	private DepartamentoDao depaFacade;
	public List<Departamento> listadepa;
	
	private Usuario user; 
	private UsuarioDao userFacade;
	public List<Usuario> listauser;
	
	int idcargo;
	int iddepart;
	int iduser;
	
	@PostConstruct
	public void init() {
		empleado = new Empleado();
		empleadoDao = new EmpleadoDao();
		
		cargo = new Cargo();
		cargoFacade = new CargoDao();
		
		departamento = new Departamento();
		depaFacade = new DepartamentoDao();
		
		user = new Usuario();
		userFacade = new UsuarioDao();
		
		idcargo=0;
		iddepart=0;
		iduser=0;
		mostrar();
		selectCargo();
		selectDepa();
		selectUser();
	}
	
	public void mostrar() {
		ListEmpleado = new ArrayList<Empleado>();
		ListEmpleado = empleadoDao.mostrar();
	}
	
	public void guardar() {
		try {
			Cargo ncargo = new Cargo();
			ncargo.setIdCargo(idcargo);
			empleado.setCargo(ncargo);
			
			Departamento ndep = new Departamento();
			ndep.setIdDepartamento(iddepart);
			empleado.setDepartamento(ndep);
			
			Usuario user = new Usuario();
			user.setIdUser(iduser);
			
			empleado.setUsuario(user);
			
			empleado.setFechaRegistro(new Date());
			
			empleadoDao.guardar(empleado);
			mensaje("Exito");
			empleado = new Empleado();
			idcargo =0 ;
			iddepart =0 ;
			iduser =0 ;
			
			mostrar();
		} catch (Exception e) {
			mensaje("Algo a fallado");
		}

	}
	
	public void mensaje(String respuesta) {
		FacesMessage mensaje = new  FacesMessage(respuesta);
		FacesContext.getCurrentInstance().addMessage(null, mensaje);
	}
	
	public List<Cargo> selectCargo(){
		this.listacargo = new ArrayList<Cargo>();
		return this.listacargo = cargoFacade.mostrar();
	}
	
	public List<Departamento> selectDepa(){
		this.listadepa = new ArrayList<Departamento>();
		return this.listadepa = depaFacade.mostrar();
	}
	
	public List<Usuario> selectUser(){
		this.listauser = new ArrayList<Usuario>();
		return this.listauser = userFacade.mostrar();
	}
	
	public Empleado getEmpleado() {
		return empleado;
	}
	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}
	public EmpleadoDao getEmpleadoDao() {
		return empleadoDao;
	}
	public void setEmpleadoDao(EmpleadoDao empleadoDao) {
		this.empleadoDao = empleadoDao;
	}
	public List<Empleado> getListEmpleado() {
		return ListEmpleado;
	}
	public void setListEmpleado(List<Empleado> listEmpleado) {
		ListEmpleado = listEmpleado;
	}

	
	public int getIdcargo() {
		return idcargo;
	}

	public void setIdcargo(int idcargo) {
		this.idcargo = idcargo;
	}

	public int getIddepart() {
		return iddepart;
	}

	public void setIddepart(int iddepart) {
		this.iddepart = iddepart;
	}

	public int getIduser() {
		return iduser;
	}

	public void setIduser(int iduser) {
		this.iduser = iduser;
	}
	
	
	
}
