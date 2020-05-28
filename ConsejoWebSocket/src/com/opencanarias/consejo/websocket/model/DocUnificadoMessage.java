package com.opencanarias.consejo.websocket.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(schema = "OC3F", name = "DOC_UNIFICADO_MESSAGE")
public class DocUnificadoMessage {


	@Id
	@Column(name = "FECHA_ULTIMA_GENERACION", nullable = false)
	public Date fechaUltimaGeneracion;
	@Enumerated(EnumType.STRING)
	@Column(name = "ESTADO")
	public DocUnificadoStatus estado;
	@Column(name = "MENSAJE_ERROR", nullable = true)
	public String errorMessage;
	@Column(name = "FECHA_PROXIMA_COMPROBACION")
	public Date fechaProximaComprobacion;
	
	
	public DocUnificadoMessage() {
		
	}
	

	public DocUnificadoMessage(DocUnificadoStatus estado, Date fechaUltimaGeneracion, String errorMessage,
			Date fechaProximaComprobacion) {
		super();
		this.estado = estado;
		this.fechaUltimaGeneracion = fechaUltimaGeneracion;
		this.errorMessage = errorMessage;
		this.fechaProximaComprobacion = fechaProximaComprobacion;
	}




	public DocUnificadoStatus getEstado() {
		return estado;
	}


	public void setEstado(DocUnificadoStatus estado) {
		this.estado = estado;
	}


	public Date getFechaUltimaGeneracion() {
		return fechaUltimaGeneracion;
	}


	public void setFechaUltimaGeneracion(Date fechaUltimaGeneracion) {
		this.fechaUltimaGeneracion = fechaUltimaGeneracion;
	}


	public String getErrorMessage() {
		return errorMessage;
	}


	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}


	public Date getFechaProximaComprobacion() {
		return fechaProximaComprobacion;
	}


	public void setFechaProximaComprobacion(Date fechaProximaComprobacion) {
		this.fechaProximaComprobacion = fechaProximaComprobacion;
	}
	
	

}
