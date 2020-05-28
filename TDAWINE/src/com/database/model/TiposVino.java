package com.database.model;
// Generated 20-dic-2017 10:10:06 by Hibernate Tools 5.2.5.Final

import java.util.HashSet;
import java.util.Set;

/**
 * TiposVino generated by hbm2java
 */
public class TiposVino implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer idTiposVino;
	private String descripcion;
	private Set vinos = new HashSet(0);

	public TiposVino() {
	}

	public TiposVino(String descripcion) {
		this.descripcion = descripcion;
	}

	public TiposVino(String descripcion, Set vinos) {
		this.descripcion = descripcion;
		this.vinos = vinos;
	}

	public Integer getIdTiposVino() {
		return this.idTiposVino;
	}

	public void setIdTiposVino(Integer idTiposVino) {
		this.idTiposVino = idTiposVino;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Set getVinos() {
		return this.vinos;
	}

	public void setVinos(Set vinos) {
		this.vinos = vinos;
	}

}
