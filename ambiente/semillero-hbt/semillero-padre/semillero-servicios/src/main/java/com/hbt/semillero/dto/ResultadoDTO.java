package com.hbt.semillero.dto;

import java.io.Serializable;

/**
 * DTO del resultado  saber si tuvo exito o no
 * @author Sisa
 *
 */
public class ResultadoDTO implements Serializable{
/**
 * para saber si la operacion realizada fue exitosa o no
 */
		private boolean exitoso;
		/**
		 * para saber el mensaje que arrojo el error
		 */	
		private String mensajeError;

		public boolean isExitoso() {
			return exitoso;
		}

		//********* GETTERSS Y SETTERS **************
		public void setExitoso(boolean exitoso) {
			this.exitoso = exitoso;
		}

		public String getMensajeError() {
			return mensajeError;
		}

		public void setMensajeError(String mensajeError) {
			this.mensajeError = mensajeError;
		}
		
		
		
			
			
}