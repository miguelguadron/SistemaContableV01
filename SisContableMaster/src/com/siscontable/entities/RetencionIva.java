package com.siscontable.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the retencion_iva database table.
 * 
 */
@Entity
@Table(name="retencion_iva")
@NamedQuery(name="RetencionIva.findAll", query="SELECT r FROM RetencionIva r")
public class RetencionIva implements Serializable {
	private static final long serialVersionUID = 1L;
	private int idRetencion;
	private String descripcion;
	private BigDecimal iva;
	private BigDecimal neto;
	private String nombre;
	private String numero;
	private BigDecimal reteIva;
	private BigDecimal total;
	private List<CreditoFiscal> creditoFiscals;

	public RetencionIva() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_retencion")
	public int getIdRetencion() {
		return this.idRetencion;
	}

	public void setIdRetencion(int idRetencion) {
		this.idRetencion = idRetencion;
	}


	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	public BigDecimal getIva() {
		return this.iva;
	}

	public void setIva(BigDecimal iva) {
		this.iva = iva;
	}


	public BigDecimal getNeto() {
		return this.neto;
	}

	public void setNeto(BigDecimal neto) {
		this.neto = neto;
	}


	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getNumero() {
		return this.numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}


	@Column(name="rete_iva")
	public BigDecimal getReteIva() {
		return this.reteIva;
	}

	public void setReteIva(BigDecimal reteIva) {
		this.reteIva = reteIva;
	}


	public BigDecimal getTotal() {
		return this.total;
	}

	public void setTotal(BigDecimal total) {
		this.total = total;
	}


	//bi-directional many-to-one association to CreditoFiscal
	@OneToMany(mappedBy="retencionIva", fetch=FetchType.EAGER)
	public List<CreditoFiscal> getCreditoFiscals() {
		return this.creditoFiscals;
	}

	public void setCreditoFiscals(List<CreditoFiscal> creditoFiscals) {
		this.creditoFiscals = creditoFiscals;
	}

	public CreditoFiscal addCreditoFiscal(CreditoFiscal creditoFiscal) {
		getCreditoFiscals().add(creditoFiscal);
		creditoFiscal.setRetencionIva(this);

		return creditoFiscal;
	}

	public CreditoFiscal removeCreditoFiscal(CreditoFiscal creditoFiscal) {
		getCreditoFiscals().remove(creditoFiscal);
		creditoFiscal.setRetencionIva(null);

		return creditoFiscal;
	}

}