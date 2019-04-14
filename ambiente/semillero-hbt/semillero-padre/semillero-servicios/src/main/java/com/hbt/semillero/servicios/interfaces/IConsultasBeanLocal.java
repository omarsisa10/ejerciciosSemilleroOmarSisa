package com.hbt.semillero.servicios.interfaces;

import java.util.List;

import javax.ejb.Local;

import com.hbt.semillero.dto.PersonaDTO;
import com.hbt.semillero.entidades.Linea;
import com.hbt.semillero.entidades.Marca;
import com.hbt.semillero.entidades.Persona;
import com.hbt.semillero.entidades.Vehiculo;

/**
 * Interface para implementar, marca los metodos necesarios.
 * @author Sisa
 */

@Local
public interface IConsultasBeanLocal {
/**
 * meotodos de las consultas
 * @return
 */
	public List<Marca> consultarMarcas();
	public List<Linea> consultarLineas(Long idMarca);
	public void crearPersona(PersonaDTO personaDTO);
	public List<Persona> consultarTodasLasPersonas();
	public List<Persona> consultarPersonas( String tipoIdentificacion,String numeroIdentififacion );
	public void editarPersona(PersonaDTO personaDTO);
	public List<Vehiculo> consultarVehiculos(long idMarca, long idLinea);
	public List<Vehiculo> consultarTodosVehiculos();
}