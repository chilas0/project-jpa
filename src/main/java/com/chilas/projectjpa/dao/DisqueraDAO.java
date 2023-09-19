package com.chilas.projectjpa.dao;

import java.util.ArrayList;
//import java.util.List;

import com.chilas.projectjpa.entity.Disquera;

/**
 * @author Anthony
 * Interface que genera el DAO para las transacciones del CRUD a la tabla de disquera.
 */
public interface DisqueraDAO {

	
	void save(Disquera disquera);
	
	void update(Disquera disquera);
	
	void delete(Long id);
	
	//List<Disquera> consultar();
	
	Disquera consultarById(Long id);
	
	
	/**
	 * Metodo que permite consultar con JPQL la disquera a partir de una descripcion
	 * @param descripcion {@link String} descripcion de la disquera
	 * @return {@link Disquera} la disquera consultada}
	 */
	Disquera consultarByDescripcionJPQL(String descripcion);
	
	
	/**
	 * Metodo que permite consultar con SQL Nativo la disquera a partir de una descripcion
	 * @param descripcion {@link String} descripcion de la disquera
	 * @return {@link Disquera} la disquera consultada
	 */
	Disquera consultarByDescripcionNative(String descripcion);


}
