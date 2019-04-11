package com.hbt.semillero.servicios;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.hbt.semillero.dto.LineaDTO;
import com.hbt.semillero.dto.MarcaDTO;
import com.hbt.semillero.dto.PersonaDTO;
import com.hbt.semillero.dto.ResultadoDTO;
import com.hbt.semillero.entidades.Linea;
import com.hbt.semillero.entidades.Marca;
import com.hbt.semillero.entidades.Persona;
import com.hbt.semillero.servicios.interfaces.IConsultasBeanLocal;

/**
 * Clase Para crear el servicio Rest
 * @author Omar Sisa
 *
 */
@Path("/ServiciosRest")
public class ServiciosRest {
	/**
	 * variable para consultas del EJBean
	 */
	@EJB
	private IConsultasBeanLocal consultasBean;
	/**
	 * metodo para consultar todas las marcas
	 * @return
	 */
	@GET
	@Path("/consultarMarcas")
	@Produces(MediaType.APPLICATION_JSON)
	public List<MarcaDTO> consultarMarcas(){
		List<Marca> marcas = consultasBean.consultarMarcas();
		List<MarcaDTO> retorno = new ArrayList<MarcaDTO>();
		for (Marca marca : marcas) {
			MarcaDTO marcaDTO = construirMarcaDTO(marca);
			retorno.add(marcaDTO);
		}
		return retorno;
		
	}
	/**
	 * Metodo para consultar las lineas de una marca en epecifico
	 * @param idMarca
	 * @return
	 */
	@GET
	@Path("/consultarLineas")
	@Produces(MediaType.APPLICATION_JSON)
	public List<LineaDTO> consultarLineas(@QueryParam(value = "idMarca")Long idMarca) {
		List<Linea> lineas = consultasBean.consultarLineas(idMarca);
		List<LineaDTO> retorno = new ArrayList<LineaDTO>();
		for (Linea linea : lineas) {
			LineaDTO lineaDTO = new LineaDTO();
			lineaDTO.setIdLinea(linea.getIdLinea());
			lineaDTO.setNombre(linea.getNombre());
			lineaDTO.setCilindraje(linea.getCilindraje());
			MarcaDTO marcaDTO = construirMarcaDTO(linea.getMarca());
			lineaDTO.setMarca(marcaDTO);
			retorno.add(lineaDTO);
		}
		return retorno;
	}
	/**
	 * metodo para crear persona pasa por parametro los datos de la persona
	 * @param personaDTO
	 * @return
	 */
	@POST
	@Path("/crearPersona")
	@Produces(MediaType.APPLICATION_JSON)
	public ResultadoDTO crearPersona(PersonaDTO personaDTO){
		ResultadoDTO retorno = new ResultadoDTO();
		retorno.setExitoso(true);
		try {
			consultasBean.crearPersona(personaDTO);
		} catch (Exception e) {
			retorno.setExitoso(false);
			retorno.setMensajeError("No se pudo Ingresar a la persona");
		}
		return retorno;
	}
	
	/**
	 * Metodo para consultar todas las personas almacenadas en base de datos
	 */
	@GET
	@Path("/consultarTodasLasPersonas")
	@Produces(MediaType.APPLICATION_JSON)
	public List<PersonaDTO> consultarTodasLasPersonas() {
		List<Persona> personas = consultasBean.consultarTodasLasPersonas();
		List<PersonaDTO> retorno = new ArrayList<PersonaDTO>();
		for (Persona persona : personas) {
			PersonaDTO personaDTO = new PersonaDTO();
			personaDTO.setIdPersona(persona.getIdPersona());
			personaDTO.setNumeroIdentificacion(persona.getNumeroIdentificacion());
			personaDTO.setTipoIdentificacion(persona.getTipoIdentificacion());
			personaDTO.setNombres(persona.getNombres());
			personaDTO.setApellidos(persona.getApellidos());
			personaDTO.setNumeroTelefonico(persona.getNumeroTelefonico());
			personaDTO.setEdad(persona.getEdad());
			retorno.add(personaDTO);
		}
		return retorno;
	}
	
	/**
	 * Consulta para saber la persona con un tipo de id y un numero de id
	 * @param tipoIdentificacion 
	 * @param numeroIdentificacion 
	 * @return la persona con el mismo tipo de id y el mismo numero id
	 */
	@GET
	@Path("/consultarPersonas")
	@Produces(MediaType.APPLICATION_JSON)
	public List<PersonaDTO> consultarPersonas(@QueryParam(value = "tipoIdentificacion")String tipoIdentificacion, @QueryParam(value="numeroIdentificacion") String numeroIdentificacion) {
		List<Persona> personas = consultasBean.consultarPersonas(tipoIdentificacion, numeroIdentificacion);
		List<PersonaDTO> retorno = new ArrayList<PersonaDTO>();
		for (Persona persona : personas) {
			PersonaDTO personaDTO = new PersonaDTO();
			personaDTO.setNumeroIdentificacion(persona.getNumeroIdentificacion());
			personaDTO.setTipoIdentificacion(persona.getTipoIdentificacion());
			personaDTO.setNumeroTelefonico(persona.getNumeroTelefonico());
			personaDTO.setNombres(persona.getNombres());
			personaDTO.setApellidos(persona.getApellidos());
			personaDTO.setEdad(persona.getEdad());
			retorno.add(personaDTO);
		}
		return retorno;
	}
	/**
	 * Consulta para Editar o modificar una persona, si ingresa una persona que no existe da error
	 * @param personaDTO ingresa por parametro datos de la persona 
	 * @return proceso exitoso o no
	 */
	@POST
	@Path("/editarPersona")
	@Produces(MediaType.APPLICATION_JSON)
	public ResultadoDTO editarPersona(PersonaDTO personaDTO){
		ResultadoDTO retorno = new ResultadoDTO();
		retorno.setExitoso(true);
		try {
			consultasBean.editarPersona(personaDTO);
		} catch (Exception e) {
			retorno.setExitoso(false);
			retorno.setMensajeError("Error al editar la persona");
		}
		return retorno;
	}
	
	//Metodo construir una marcaDTO ingresando una marca
	private MarcaDTO construirMarcaDTO(Marca marca) {
		MarcaDTO marcaDTO = new MarcaDTO();
		marcaDTO.setIdMarca(marca.getIdMarca());
		marcaDTO.setNombre(marca.getNombre());
		return marcaDTO;
	}
}
