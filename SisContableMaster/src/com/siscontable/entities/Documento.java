package com.siscontable.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the documento database table.
 * 
 */
@Entity
@NamedQuery(name="Documento.findAll", query="SELECT d FROM Documento d")
public class Documento implements Serializable {
	private static final long serialVersionUID = 1L;
	private int idPlanilla;
	private int estado;
	private Date fechaCreacion;
	private Date fechaFinal;
	private Date fechaInicio;
	private BigDecimal sueldoNeto;
	private Empresa empresa;
	private SueldoFijo sueldoFijo;
	private Usuario usuario;

	public Documento() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_planilla")
	public int getIdPlanilla() {
		return this.idPlanilla;
	}

	public void setIdPlanilla(int idPlanilla) {
		this.idPlanilla = idPlanilla;
	}


	public int getEstado() {
		return this.estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}


	@Temporal(TemporalType.DATE)
	@Column(name="fecha_creacion")
	public Date getFechaCreacion() {
		return this.fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}


	@Temporal(TemporalType.DATE)
	@Column(name="fecha_final")
	public Date getFechaFinal() {
		return this.fechaFinal;
	}

	public void setFechaFinal(Date fechaFinal) {
		this.fechaFinal = fechaFinal;
	}


	@Temporal(TemporalType.DATE)
	@Column(name="fecha_inicio")
	public Date getFechaInicio() {
		return this.fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}


	@Column(name="sueldo_neto")
	public BigDecimal getSueldoNeto() {
		return this.sueldoNeto;
	}

	public void setSueldoNeto(BigDecimal sueldoNeto) {
		this.sueldoNeto = sueldoNeto;
	}


	//bi-directional many-to-one association to Empresa
	@ManyToOne
	@JoinColumn(name="id_empresa")
	public Empresa getEmpresa() {
		return this.empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}


	//bi-directional many-to-one association to SueldoFijo
	@ManyToOne
	@JoinColumn(name="id_salario")
	public SueldoFijo getSueldoFijo() {
		return this.sueldoFijo;
	}

	public void setSueldoFijo(SueldoFijo sueldoFijo) {
		this.sueldoFijo = sueldoFijo;
	}


	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="id_user")
	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}