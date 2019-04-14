package com.hbt.semillero.servicios.ejb;



import java.util.Calendar;
import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.hbt.semillero.dto.PersonaDTO;
import com.hbt.semillero.entidades.Comprador;
import com.hbt.semillero.entidades.Linea;
import com.hbt.semillero.entidades.Marca;
import com.hbt.semillero.entidades.Persona;
import com.hbt.semillero.entidades.Vehiculo;
import com.hbt.semillero.entidades.Vendedor;
import com.hbt.semillero.servicios.interfaces.IConsultasBeanLocal;

/**
 * consultas que arroja el servicio 
 * @author Sisa
 *
 */

@Stateless
public class ConsultasBean implements IConsultasBeanLocal {
	/**
	 * atributo entitymanager para manejar la session 
	 */
	@PersistenceContext
	private EntityManager entityManager;
	
	/**
	 * consulta para conocer todas las marcas
	 */
	public List<Marca> consultarMarcas() {
		return entityManager.createQuery("select ma FROM Marca ma").getResultList();
	}
	/**
	 * consulta para conocer todas las lineas
	 */
	public List<Linea> consultarLineas(Long idMarca){
		return entityManager.createQuery("Select ln from Linea ln JOIN FETCH ln.marca where ln.marca.idMarca=:idMarca").setParameter("idMarca", idMarca).getResultList();
	}
	/**
	 * guarda persona y si es comprador guarda comprador, igual para vendedor
	 */
	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	public void crearPersona(PersonaDTO personaDTO) {
		Persona persona = new Persona();
		persona.setNombres(personaDTO.getNombres());
		persona.setApellidos(personaDTO.getApellidos());
		persona.setNumeroIdentificacion(personaDTO.getNumeroIdentificacion());
		persona.setTipoIdentificacion(personaDTO.getTipoIdentificacion());
		persona.setNumeroTelefonico(personaDTO.getNumeroTelefonico());
		persona.setEdad(personaDTO.getEdad());
		
		entityManager.persist(persona);
		//si es comprador
		if (personaDTO.isComprador()) {
			Comprador comprador = new Comprador();
			comprador.setFechaAfiliacion(Calendar.getInstance());
			comprador.setPersona(persona);
			entityManager.persist(comprador);
		}
		//si es vendedor
		if (personaDTO.isVendedor()) {
			Vendedor vendedor = new Vendedor();
			vendedor.setFechaIngreso(Calendar.getInstance());
			vendedor.setPersona(persona);
			entityManager.persist(vendedor);
		}
	}
	/**
	 * consulta para conocer todas las personas
	 */
	public List<Persona> consultarTodasLasPersonas() {
		return entityManager.createQuery("Select pr from Persona pr").getResultList();
	}
	
	/**
	 * Consulta para conocer la persona con un  tipoIdentificacion y NumeroIdentificacion 
	 * @param tipoIdentificacion   CC, TI
	 * @param numeroIdentificacion 
	 */
	public List<Persona> consultarPersonas(String tipoIdentificacion, String numeroIdentificacion) {
		return entityManager.createQuery("Select pr from Persona pr where pr.tipoIdentificacion=:tipoIdentificacion AND pr.numeroIdentificacion =: numeroIdentificacion")
	.setParameter("tipoIdentificacion", tipoIdentificacion).setParameter("numeroIdentificacion", numeroIdentificacion).getResultList();
	}
	
	/**
	 * Servicio para editar los datos de una persona, ingresando la persona.
	 * si no existe  el ID de la persona marca error
	 */
	public void editarPersona(PersonaDTO personaDTO) {
		Persona persona = entityManager.find(Persona.class, personaDTO.getIdPersona());
		persona.setNombres(personaDTO.getNombres());
		persona.setApellidos(personaDTO.getApellidos());
		persona.setNumeroIdentificacion(personaDTO.getNumeroIdentificacion());
		persona.setTipoIdentificacion(personaDTO.getTipoIdentificacion());
		persona.setNumeroTelefonico(personaDTO.getNumeroTelefonico());
		persona.setEdad(personaDTO.getEdad());
		entityManager.merge(persona);	
	}
	// vehiculos servicios
	/**
	* Consulta todos los vehiculos en la bases de datos
	 */
	public List<Vehiculo> consultarTodosVehiculos() {
		return entityManager.createQuery("Select ve from Vehiculo ve ").getResultList();
	}
	@Override
	public List<Vehiculo> consultarVehiculos(long idMarca, long idLinea) {
		return null;
	}
	
	
}