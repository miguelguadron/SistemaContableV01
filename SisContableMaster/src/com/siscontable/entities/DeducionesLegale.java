package com.siscontable.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the deduciones_legales database table.
 * 
 */
@Entity
@Table(name="deduciones_legales")
@NamedQuery(name="DeducionesLegale.findAll", query="SELECT d FROM DeducionesLegale d")
public class DeducionesLegale implements Serializable {
	private static final long serialVersionUID = 1L;
	private int idImpuesto;
	private String atributo1;
	private String atributo2;
	private String atributo3;
	private String atributo4;
	private String atributo5;
	private Date fechaCreacion;
	private String nombreDocumento;
	private String nombreImpuesto1;
	private String nombreImpuesto2;
	private String nombreImpuesto3;
	private String nombreImpuesto4;
	private String nombreImpuesto5;
	private String nombreImpuesto6;
	private String nombreImpuesto7;
	private BigDecimal porcentaje1;
	private BigDecimal porcentaje2;
	private BigDecimal porcentaje3;
	private BigDecimal porcentaje4;
	private BigDecimal porcentaje5;
	private BigDecimal porcentaje6;
	private BigDecimal porcentaje7;
	private int sumaResta;
	private List<Configuracion> configuracions;
	private Estado estado;
	private List<Planilla> planillas;
	private List<SueldoFijo> sueldoFijos;

	public DeducionesLegale() {
		estado = new Estado();
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_impuesto")
	public int getIdImpuesto() {
		return this.idImpuesto;
	}

	public void setIdImpuesto(int idImpuesto) {
		this.idImpuesto = idImpuesto;
	}


	public String getAtributo1() {
		return this.atributo1;
	}

	public void setAtributo1(String atributo1) {
		this.atributo1 = atributo1;
	}


	public String getAtributo2() {
		return this.atributo2;
	}

	public void setAtributo2(String atributo2) {
		this.atributo2 = atributo2;
	}


	public String getAtributo3() {
		return this.atributo3;
	}

	public void setAtributo3(String atributo3) {
		this.atributo3 = atributo3;
	}


	public String getAtributo4() {
		return this.atributo4;
	}

	public void setAtributo4(String atributo4) {
		this.atributo4 = atributo4;
	}


	public String getAtributo5() {
		return this.atributo5;
	}

	public void setAtributo5(String atributo5) {
		this.atributo5 = atributo5;
	}


	@Temporal(TemporalType.DATE)
	@Column(name="fecha_creacion")
	public Date getFechaCreacion() {
		return this.fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}


	@Column(name="nombre_documento")
	public String getNombreDocumento() {
		return this.nombreDocumento;
	}

	public void setNombreDocumento(String nombreDocumento) {
		this.nombreDocumento = nombreDocumento;
	}


	@Column(name="nombre_impuesto1")
	public String getNombreImpuesto1() {
		return this.nombreImpuesto1;
	}

	public void setNombreImpuesto1(String nombreImpuesto1) {
		this.nombreImpuesto1 = nombreImpuesto1;
	}


	@Column(name="nombre_impuesto2")
	public String getNombreImpuesto2() {
		return this.nombreImpuesto2;
	}

	public void setNombreImpuesto2(String nombreImpuesto2) {
		this.nombreImpuesto2 = nombreImpuesto2;
	}


	@Column(name="nombre_impuesto3")
	public String getNombreImpuesto3() {
		return this.nombreImpuesto3;
	}

	public void setNombreImpuesto3(String nombreImpuesto3) {
		this.nombreImpuesto3 = nombreImpuesto3;
	}


	@Column(name="nombre_impuesto4")
	public String getNombreImpuesto4() {
		return this.nombreImpuesto4;
	}

	public void setNombreImpuesto4(String nombreImpuesto4) {
		this.nombreImpuesto4 = nombreImpuesto4;
	}


	@Column(name="nombre_impuesto5")
	public String getNombreImpuesto5() {
		return this.nombreImpuesto5;
	}

	public void setNombreImpuesto5(String nombreImpuesto5) {
		this.nombreImpuesto5 = nombreImpuesto5;
	}


	@Column(name="nombre_impuesto6")
	public String getNombreImpuesto6() {
		return this.nombreImpuesto6;
	}

	public void setNombreImpuesto6(String nombreImpuesto6) {
		this.nombreImpuesto6 = nombreImpuesto6;
	}


	@Column(name="nombre_impuesto7")
	public String getNombreImpuesto7() {
		return this.nombreImpuesto7;
	}

	public void setNombreImpuesto7(String nombreImpuesto7) {
		this.nombreImpuesto7 = nombreImpuesto7;
	}


	public BigDecimal getPorcentaje1() {
		return this.porcentaje1;
	}

	public void setPorcentaje1(BigDecimal porcentaje1) {
		this.porcentaje1 = porcentaje1;
	}


	public BigDecimal getPorcentaje2() {
		return this.porcentaje2;
	}

	public void setPorcentaje2(BigDecimal porcentaje2) {
		this.porcentaje2 = porcentaje2;
	}


	public BigDecimal getPorcentaje3() {
		return this.porcentaje3;
	}

	public void setPorcentaje3(BigDecimal porcentaje3) {
		this.porcentaje3 = porcentaje3;
	}


	public BigDecimal getPorcentaje4() {
		return this.porcentaje4;
	}

	public void setPorcentaje4(BigDecimal porcentaje4) {
		this.porcentaje4 = porcentaje4;
	}


	public BigDecimal getPorcentaje5() {
		return this.porcentaje5;
	}

	public void setPorcentaje5(BigDecimal porcentaje5) {
		this.porcentaje5 = porcentaje5;
	}


	public BigDecimal getPorcentaje6() {
		return this.porcentaje6;
	}

	public void setPorcentaje6(BigDecimal porcentaje6) {
		this.porcentaje6 = porcentaje6;
	}


	public BigDecimal getPorcentaje7() {
		return this.porcentaje7;
	}

	public void setPorcentaje7(BigDecimal porcentaje7) {
		this.porcentaje7 = porcentaje7;
	}


	@Column(name="suma_resta")
	public int getSumaResta() {
		return this.sumaResta;
	}

	public void setSumaResta(int sumaResta) {
		this.sumaResta = sumaResta;
	}


	//bi-directional many-to-one association to Configuracion
	@OneToMany(mappedBy="deducionesLegale", fetch=FetchType.EAGER)
	public List<Configuracion> getConfiguracions() {
		return this.configuracions;
	}

	public void setConfiguracions(List<Configuracion> configuracions) {
		this.configuracions = configuracions;
	}

	public Configuracion addConfiguracion(Configuracion configuracion) {
		getConfiguracions().add(configuracion);
		configuracion.setDeducionesLegale(this);

		return configuracion;
	}

	public Configuracion removeConfiguracion(Configuracion configuracion) {
		getConfiguracions().remove(configuracion);
		configuracion.setDeducionesLegale(null);

		return configuracion;
	}


	//bi-directional many-to-one association to Estado
	@ManyToOne
	@JoinColumn(name="id_estado")
	public Estado getEstado() {
		return this.estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}


	//bi-directional many-to-one association to Planilla
	@OneToMany(mappedBy="deducionesLegale", fetch=FetchType.EAGER)
	public List<Planilla> getPlanillas() {
		return this.planillas;
	}

	public void setPlanillas(List<Planilla> planillas) {
		this.planillas = planillas;
	}

	public Planilla addPlanilla(Planilla planilla) {
		getPlanillas().add(planilla);
		planilla.setDeducionesLegale(this);

		return planilla;
	}

	public Planilla removePlanilla(Planilla planilla) {
		getPlanillas().remove(planilla);
		planilla.setDeducionesLegale(null);

		return planilla;
	}


	//bi-directional many-to-one association to SueldoFijo
	@OneToMany(mappedBy="deducionesLegale", fetch=FetchType.EAGER)
	public List<SueldoFijo> getSueldoFijos() {
		return this.sueldoFijos;
	}

	public void setSueldoFijos(List<SueldoFijo> sueldoFijos) {
		this.sueldoFijos = sueldoFijos;
	}

	public SueldoFijo addSueldoFijo(SueldoFijo sueldoFijo) {
		getSueldoFijos().add(sueldoFijo);
		sueldoFijo.setDeducionesLegale(this);

		return sueldoFijo;
	}

	public SueldoFijo removeSueldoFijo(SueldoFijo sueldoFijo) {
		getSueldoFijos().remove(sueldoFijo);
		sueldoFijo.setDeducionesLegale(null);

		return sueldoFijo;
	}

}