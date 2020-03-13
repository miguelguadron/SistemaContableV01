package com.siscontable.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the planilla database table.
 * 
 */
@Entity
@NamedQuery(name="Planilla.findAll", query="SELECT p FROM Planilla p")
public class Planilla implements Serializable {
	private static final long serialVersionUID = 1L;
	private int idPeriodo;
	private BigDecimal subTotal;
	private BigDecimal sueldoLiquido;
	private DeducionesLegale deducionesLegale;
	private Empleado empleado;
	private SueldoFijo sueldoFijo;

	public Planilla() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_periodo")
	public int getIdPeriodo() {
		return this.idPeriodo;
	}

	public void setIdPeriodo(int idPeriodo) {
		this.idPeriodo = idPeriodo;
	}


	@Column(name="sub_total")
	public BigDecimal getSubTotal() {
		return this.subTotal;
	}

	public void setSubTotal(BigDecimal subTotal) {
		this.subTotal = subTotal;
	}


	@Column(name="sueldo_liquido")
	public BigDecimal getSueldoLiquido() {
		return this.sueldoLiquido;
	}

	public void setSueldoLiquido(BigDecimal sueldoLiquido) {
		this.sueldoLiquido = sueldoLiquido;
	}


	//bi-directional many-to-one association to DeducionesLegale
	@ManyToOne
	@JoinColumn(name="id_impuesto")
	public DeducionesLegale getDeducionesLegale() {
		return this.deducionesLegale;
	}

	public void setDeducionesLegale(DeducionesLegale deducionesLegale) {
		this.deducionesLegale = deducionesLegale;
	}


	//bi-directional many-to-one association to Empleado
	@ManyToOne
	@JoinColumn(name="id_empleado")
	public Empleado getEmpleado() {
		return this.empleado;
	}

	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
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

}