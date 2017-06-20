package com.lucasian.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

/**
 * Esta clase crea el mapeo de la tabla ADMINISTRADOR por medio de
 * hibernate
 * 
 * @author Oscar Fernandez Alzate <oscarfdzalz@gmail.com>
 * @version 19/06/2017
 */
@Entity
@Table(name="ADMINISTRADOR")
@SequenceGenerator(name = "SOME_SEQUENCE", allocationSize = 1, sequenceName = "SQ_ADMINISTRADOR")
public class Administrador {
	
	/**
	 * Se crea el identificador del campo, añadiendo la secuencia SQ_ADMINISTRADOR como autoincrementador
	 */
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SOME_SEQUENCE")
    @Column(name = "ID", unique = true)
	private int id;
	/**
	 * Código de la administradora
	 */
	@Column(name="CODIGO")
	private String codigo;
	/**
	 * Nombre
	 */
	@Column(name="NOMBRE")
	private String nombre;
	/**
	 * Código del tipo de identificación
	 */
	@Column(name="COD_TP_ID")
	private String cod_tp_id;
	/**
	 * Numero identificación
	 */
	@Column(name="NRO_ID")
	private String nro_id;
	/**
	 * Naturaleza
	 */
	@Column(name="NATURALEZA")
	private String naturaleza;
	/**
	 * Múltiple ARP
	 */
	@Column(name="MULTIPLE_ARP")
	private int multiple_arp;
	/**
	 * FSP
	 */
	@Column(name="FSP")
	private int fsp;
	/**
	 * Fusionada
	 */
	@Column(name="FUSIONADA")
	private int fusionada;
	/**
	 * Fecha fusión
	 */
	@Column(name="FECHA_FUSION")
	@Type(type="date")
	private Date fecha_fusion;
	
	/**
	 * Constructor por defecto
	 */
	public Administrador() {
	
	}
	
	/**
	 * Se crea el constructor para cargar los valores por defecto de la clase,
	 * los cuales son las los campos de la tabla ADMINISTRADOR
	 * 
	 * @param codigo
	 * @param nombre
	 * @param cod_tp_id
	 * @param nro_id
	 * @param naturaleza
	 * @param multiple_arp
	 * @param fsp
	 * @param fusionada
	 * @param fecha_fusion
	 */
	public Administrador(String codigo, String nombre, String cod_tp_id, String nro_id, String naturaleza,
			int multiple_arp, int fsp, int fusionada, Date fecha_fusion) {
		super();
		
		this.codigo = codigo;
		this.nombre = nombre;
		this.cod_tp_id = cod_tp_id;
		this.nro_id = nro_id;
		this.naturaleza = naturaleza;
		this.multiple_arp = multiple_arp;
		this.fsp = fsp;
		this.fusionada = fusionada;
		this.fecha_fusion = fecha_fusion;
	}
	
	/**
	 * Se crea los setter y getters de los campos correspondientes a la tabla.
	 */
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getCod_tp_id() {
		return cod_tp_id;
	}
	public void setCod_tp_id(String cod_tp_id) {
		this.cod_tp_id = cod_tp_id;
	}
	public String getNro_id() {
		return nro_id;
	}
	public void setNro_id(String nro_id) {
		this.nro_id = nro_id;
	}
	public String getNaturaleza() {
		return naturaleza;
	}
	public void setNaturaleza(String naturaleza) {
		this.naturaleza = naturaleza;
	}
	public int getMultiple_arp() {
		return multiple_arp;
	}
	public void setMultiple_arp(int multiple_arp) {
		this.multiple_arp = multiple_arp;
	}
	public int getFsp() {
		return fsp;
	}
	public void setFsp(int fsp) {
		this.fsp = fsp;
	}
	public int getFusionada() {
		return fusionada;
	}
	public void setFusionada(int fusionada) {
		this.fusionada = fusionada;
	}
	public Date getFecha_fusion() {
		return fecha_fusion;
	}
	public void setFecha_fusion(Date fecha_fusion) {
		this.fecha_fusion = fecha_fusion;
	}	
}