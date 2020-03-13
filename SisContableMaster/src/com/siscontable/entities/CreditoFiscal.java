package com.siscontable.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the credito_fiscal database table.
 * 
 */
@Entity
@Table(name="credito_fiscal")
@NamedQuery(name="CreditoFiscal.findAll", query="SELECT c FROM CreditoFiscal c")
public class CreditoFiscal implements Serializable {
	private static final long serialVersionUID = 1L;
	private int idCredito;
	private String anio;
	private Date fechaCredito;
	private String mes;
	private RetencionIva retencionIva;
	private List<Movimiento> movimientos;

	public CreditoFiscal() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_credito")
	public int getIdCredito() {
		return this.idCredito;
	}

	public void setIdCredito(int idCredito) {
		this.idCredito = idCredito;
	}


	public String getAnio() {
		return this.anio;
	}

	public void setAnio(String anio) {
		this.anio = anio;
	}


	@Temporal(TemporalType.DATE)
	@Column(name="fecha_credito")
	public Date getFechaCredito() {
		return this.fechaCredito;
	}

	public void setFechaCredito(Date fechaCredito) {
		this.fechaCredito = fechaCredito;
	}


	public String getMes() {
		return this.mes;
	}

	public void setMes(String mes) {
		this.mes = mes;
	}


	//bi-directional many-to-one association to RetencionIva
	@ManyToOne
	@JoinColumn(name="id_retencion")
	public RetencionIva getRetencionIva() {
		return this.retencionIva;
	}

	public void setRetencionIva(RetencionIva retencionIva) {
		this.retencionIva = retencionIva;
	}


	//bi-directional many-to-one association to Movimiento
	@OneToMany(mappedBy="creditoFiscal", fetch=FetchType.EAGER)
	public List<Movimiento> getMovimientos() {
		return this.movimientos;
	}

	public void setMovimientos(List<Movimiento> movimientos) {
		this.movimientos = movimientos;
	}

	public Movimiento addMovimiento(Movimiento movimiento) {
		getMovimientos().add(movimiento);
		movimiento.setCreditoFiscal(this);

		return movimiento;
	}

	public Movimiento removeMovimiento(Movimiento movimiento) {
		getMovimientos().remove(movimiento);
		movimiento.setCreditoFiscal(null);

		return movimiento;
	}

}