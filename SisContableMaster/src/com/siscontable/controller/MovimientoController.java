package com.siscontable.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import com.siscontable.dao.DepartamentoDao;
import com.siscontable.dao.MovimientoFacade;
import com.siscontable.entities.Departamento;
import com.siscontable.entities.Movimiento;

@ManagedBean
@SessionScoped
public class MovimientoController {
	
	private Movimiento m;
	private MovimientoFacade mf;
	private Departamento d;
	private DepartamentoDao dd;
	private List<Movimiento> listaMovimiento;
	private List<Movimiento> listaMovimiento2;
	private List<Movimiento> listaMovimiento3;
	private List<Movimiento> listaAll;
	private List<Departamento> listaDepartamento;
	private int iddepa;
	public Object valor;
	public int valorDepartamento=0;
	
	
	public int getIddepa() {
		return iddepa;
	}
	public void setIddepa(int iddepa) {
		this.iddepa = iddepa;
	}
	public Departamento getD() {
		return d;
	}
	public void setD(Departamento d) {
		this.d = d;
	}
	public List<Departamento> getListaDepartamento() {
		return listaDepartamento;
	}
	public void setListaDepartamento(List<Departamento> listaDepartamento) {
		this.listaDepartamento = listaDepartamento;
	}
	public List<Movimiento> getListaMovimiento2() {
		return listaMovimiento2;
	}
	public void setListaMovimiento2(List<Movimiento> listaMovimiento2) {
		this.listaMovimiento2 = listaMovimiento2;
	}
	public List<Movimiento> getListaMovimiento3() {
		return listaMovimiento3;
	}
	public void setListaMovimiento3(List<Movimiento> listaMovimiento3) {
		this.listaMovimiento3 = listaMovimiento3;
	}
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
	
	
	public void cargarModal(int idMovimiento) {
//		this.m = m;
//		valorDepartamento = m.getDepartamento().getIdDepartamento();
//		System.out.println("valor cargado"+ m.getDepartamento().getIdDepartamento());
		mf.findById(idMovimiento);
		System.out.println(m.getCodPlanilla());
		System.out.println(idMovimiento);
		
	}
	
	
	@PostConstruct
	public void init() {
		m = new Movimiento();
		mf = new MovimientoFacade();
		d = new Departamento();
		dd = new DepartamentoDao();
		mostrar();
		mostrar2();
		mostrar3();
		mostrarDep();
		mostrarAll();
		//crear();
		//agregado();
		iddepa = valorDepartamento;
		
	}
	
	public void mensaje(String respuesta) {
		FacesMessage mensaje = new FacesMessage(respuesta);
		FacesContext.getCurrentInstance().addMessage(null, mensaje);
	}
	
	public List<Movimiento> mostrar(){
		this.listaMovimiento = new ArrayList<Movimiento>();
		return this.listaMovimiento = mf.listaLike1();
	}
	
	public List<Movimiento> mostrar2(){
	this.listaMovimiento2 = new ArrayList<Movimiento>();
	return this.listaMovimiento2 = mf.listaLike2();
	}
	
	public List<Movimiento> mostrar3(){
	this.listaMovimiento3 = new ArrayList<Movimiento>();
	return this.listaMovimiento3 = mf.listaLike3();
	}
	
	
	public void Insertar() {
		System.out.println("hola");
		String variable="";
		try {
		if(mostrar().size() == 0 || mostrar().isEmpty()) {
			variable="OE001";
			try {
				System.out.println("hola2");
				Departamento dep = new Departamento();
				dep.setIdDepartamento(iddepa);
				m.setCodPlanilla(variable);
				m.setDepartamento(dep);
				mf.guardar(m);
				mensaje("Se creo exitosamente");
			} catch (Exception e) {
				System.out.println(e.getMessage());
				mensaje("Ha ocurrido un error");
			}
			System.out.println("persiste:"+variable);
		}  else if (mostrar().size() != 0){
			
		int cont = (mostrar().size())+(1);
		 variable="OE00"+cont;
		 try {
				Departamento dep = new Departamento();
				dep.setIdDepartamento(iddepa);
				m.setCodPlanilla(variable);
				m.setDepartamento(dep);
				mf.guardar(m);
				mensaje("Se creo exitosamente");
			} catch (Exception e) {
				System.out.println(e.getMessage());
				mensaje("Ha ocurrido un error");
			}
		 System.out.println("persiste:"+variable);
		}
		} catch(Exception e) {
			System.out.println("Ha fallado pero si entro");
		}
		/*
		try {
			Departamento dep = new Departamento();
			dep.setIdDepartamento(iddepa);
			m.setCodPlanilla(variable);
			m.setDepartamento(dep);
			mf.guardar(m);
			mensaje("Se creo exitosamente");
		} catch (Exception e) {
			System.out.println(e.getMessage());
			mensaje("Ha ocurrido un error");
		}
		*/
	}
	
	public String agregado() {
		String variable="";
		if(mf.listaLike1().size() == 0 || mf.listaLike1().isEmpty()) {
			variable="OE001";
			//System.out.println("persiste:"+variable);
		} else {
		int cont = (mf.listaLike1().size())+(1);
		 variable="OE00"+cont;
		 //System.out.println("persiste:"+variable);
		} if(mf.listaLike2().size() == 0 || mf.listaLike2().isEmpty()) {
			variable="RB001";
			//System.out.println("Persiste:"+variable);
		} else {
			int cont =(mf.listaLike2().size())+(1);
			variable="RB00"+cont;
			//System.out.println("Persiste:"+variable);
		} if(mf.listaLike3().size() == 0 || mf.listaLike3().isEmpty()) {
			variable="BO001";
			//System.out.println("persiste:"+variable);
		} else {
			int cont =(mf.listaLike3().size())+(1);
			variable="B00"+cont;
			//System.out.println("Persiste:"+variable);
		}
		 return variable;
		 
	}
	
	public List<Departamento> mostrarDep(){
		this.listaDepartamento = new ArrayList<Departamento>();
		return this.listaDepartamento = dd.mostrar();
	}
	
	public List<Movimiento> mostrarAll(){
		this.listaAll = new ArrayList<Movimiento>();
		return listaAll = mf.mostrar();
	}

	
	public void limpiar() {
		iddepa = 0;
		init();
	}
	
	public void probando() {
		System.out.println("Hola estoy aqui");
		try {
			mf.guardar(m);
			m = new Movimiento();
			mf = new MovimientoFacade();
			mostrar();
			
			mensaje("Se creo exitoso");
		} catch (Exception e) {
			mensaje("No se ha podido crear"+e.getMessage());
		}
	}

	
}
