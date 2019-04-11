package com.hbt.semillero.dto;

import java.io.Serializable;

public class MarcaDTO implements Serializable {

	/**
	 *  DTO de la marca de un vehiculo
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * variables de la marca
	 */
	private Long idMarca;
	private String nombre;
	
	//********* GETTERSS Y SETTERS **************
	public Long getIdMarca() {
		
		return idMarca;
	}
	public void setIdMarca(Long idMarca) {
		this.idMarca = idMarca;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

}