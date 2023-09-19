package com.chilas.projectjpa.dao;

import java.util.List;

import com.chilas.projectjpa.entity.SubGenero;

/**
 * @author Anthony
 * Interface DAO que realiza el CRUD con JPA para la tabla subgenero.
 */
public interface SubGeneroDAO {

	/**
	 * Metodo que permite guardar un subgenero
	 * @param subGenero {@link SubGenero} objeto a guardar 
	 */
	void guardar(SubGenero subGenero);
	
	/**
	 * Metodo que permite actualizar un subgenero
	 * @param subGenero {@link SubGenero} objeto a actualizar 
	 */
	void actualizar(SubGenero subGenero);
	
	
	/**
	 * Metodo que permite eliminar un subgenero
	 * @param id {@link SubGenero} objeto a eliminar 
	 */
	void eliminar(Long id);
	
	
	/**
	 * Metodo que permite consultar la lista de subgenero
	 * @return {@link List} lista de subgeneros consultados
	 */
	List<SubGenero> consultar();
	
	
	/**
	 * Metodo que permite consultar un subgenero a partir de su id
	 * @param id {@link SubGenero} identificador del subgenero a consultar 
	 * @return {@link SubGenero} un objeto subgenero consultado
	 */
	SubGenero consultarById(Long id);
}
