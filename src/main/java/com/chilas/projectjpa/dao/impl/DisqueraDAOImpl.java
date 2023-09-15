/**
 * 
 */
package com.chilas.projectjpa.dao.impl;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityNotFoundException;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import org.hibernate.mapping.List;

import com.chilas.projectjpa.dao.DisqueraDAO;
import com.chilas.projectjpa.entity.Disquera;

/**
 * @author Anthony Clase que implementa las transacciones para la clase disquera
 */
public class DisqueraDAOImpl implements DisqueraDAO {



	/**
	 * 
	 *Es static y final por que trae información de persistence.xml y esto nunca va cambiar a menos de que se haga manual 
	 */
	private static final EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence
			.createEntityManagerFactory("persistenceChilas");

	@Override
	public void save(Disquera disquera) {
		
		/**
		 * 
		 */
		EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();

		
		EntityTransaction et = em.getTransaction();
		
		et.begin();
		
		try {
			em.persist(disquera);
			et.commit();
		} catch (Exception e) {
			
			if(et != null) {
				et.rollback();
			}
			e.printStackTrace();
		} finally {
			em.close();
		}
	}

	@Override
	public void update(Disquera disquera) {

		EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
		
		EntityTransaction et = em.getTransaction();
		
		et.begin();
		
		try {
			em.merge(disquera);
			et.commit();
		} catch (Exception e) {
			
			if(et != null) {
				et.rollback();
			}
			e.printStackTrace();
		} finally {
			em.close();
		}
	}

	@Override
	public void delete(Long id) {
		EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
		Disquera disqueraConsultada =  em.find(Disquera.class, id);
		EntityTransaction et = em.getTransaction();
		
		et.begin();
		
		try {
			em.remove(disqueraConsultada);
			et.commit();
		} catch (Exception e) {
			
			if(et != null) {
				et.rollback();
			}
			e.printStackTrace();
		} finally {
			em.close();
		}
	}
	
	/**
	@Override
	public List<Disquera> consultar(){
		EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
		
		TypedQuery<Disquera> queryDisquera = (TypedQuery<Disquera>) em.createQuery("FROM Disquera ORDER BY descripcion");
		
		
		return queryDisquera.getSingleResult();
	}*/

	@Override
	public Disquera consultarById(Long id) {
		EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
		Disquera disqueraConsultado = em.find(Disquera.class, id);
		
		if(disqueraConsultado == null) {
			throw new EntityNotFoundException("La disquera con el id " + id + " no se encontro");
		}
		return disqueraConsultado;
	}

}
