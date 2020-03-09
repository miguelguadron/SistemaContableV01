package com.siscontable.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import com.siscontable.dao.CargoDao;
import com.siscontable.entities.Cargo;

@ManagedBean
@RequestScoped
public class CargoController {
	
	private Cargo cargo;
	private CargoDao cargodao;
	public List<Cargo> listaCargo;
	
	@PostConstruct
	public void init() {
		cargo = new Cargo();
		cargodao = new CargoDao();
		
		mostrar();
	}
	
	public void mostrar() {
		listaCargo = new ArrayList<Cargo>();
		listaCargo = cargodao.mostrar();
		
	}
	
	

	public Cargo getCargo() {
		return cargo;
	}

	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}

	public CargoDao getCargodao() {
		return cargodao;
	}

	public void setCargodao(CargoDao cargodao) {
		this.cargodao = cargodao;
	}

	public List<Cargo> getListaCargo() {
		return listaCargo;
	}

	public void setListaCargo(List<Cargo> listaCargo) {
		this.listaCargo = listaCargo;
	}
	
	
}
