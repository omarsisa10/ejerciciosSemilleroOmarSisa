package com.hbt.semillero.servicios.ejb;


import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.hbt.semillero.entidades.Linea;
import com.hbt.semillero.entidades.Marca;
@Stateless
public class ConsultasBean {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	//consultas no necesitan una transaccionActiva
	//(never) no se ejecuta el metodo con transaccion activa
	//(TransactionAtributeType.required)  utiliza la que exista.	
	//(TransactionAtributeType.)
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public void consultar() {
		//jpa
		 entityManager.createQuery("select ma from marca ma").getResultList();
		//consulta nativa
		//ejecuta el constructor
		entityManager.createNativeQuery("select * from marca ma").getResultList();	
	
	}
	public List<Marca> consultaMarcas(){
		return entityManager.createNativeQuery("select * from marca ma").getResultList();	
	}
	// ingresar marcas y lineas
	public List<Linea> consultaLineas(Long idMarca ){
		return entityManager.createQuery("select in from linea ln where ln.marca.idLinea =:ID_LINEA").setParameter("ID_LINEA", idMarca).getResultList();	
	}
	
}
