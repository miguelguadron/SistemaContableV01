package com.siscontable.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import com.siscontable.dao.DepartamentoDao;
import com.siscontable.entities.Departamento;

@ManagedBean
@RequestScoped
public class DepartamentoController {

	private Departamento depa;
	private DepartamentoDao depadao;
	public List<Departamento> listaDepa;
	
	@PostConstruct
	public void init() {
		depa = new Departamento();
		depadao = new DepartamentoDao();
		
		mostrar();
	}
	
	public void mostrar() {
		listaDepa = new ArrayList<Departamento>();
		listaDepa = depadao.mostrar();
	}

	public Departamento getDepa() {
		return depa;
	}

	public void setDepa(Departamento depa) {
		this.depa = depa;
	}

	public DepartamentoDao getDepadao() {
		return depadao;
	}

	public void setDepadao(DepartamentoDao depadao) {
		this.depadao = depadao;
	}

	public List<Departamento> getListaDepa() {
		return listaDepa;
	}

	public void setListaDepa(List<Departamento> listaDepa) {
		this.listaDepa = listaDepa;
	}
	
	
	
}
