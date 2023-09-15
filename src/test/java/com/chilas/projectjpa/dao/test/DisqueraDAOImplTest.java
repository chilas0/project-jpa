/**
 * 
 */
package com.chilas.projectjpa.dao.test;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;

import com.chilas.projectjpa.dao.DisqueraDAO;
import com.chilas.projectjpa.dao.impl.DisqueraDAOImpl;
import com.chilas.projectjpa.entity.Disquera;

/**
 * 
 */
class DisqueraDAOImplTest {

	private DisqueraDAO disqeuraDAO = new DisqueraDAOImpl();
	
	/**
	 * Test method for {@link com.chilas.projectjpa.dao.impl.DisqueraDAOImpl#save(com.chilas.projectjpa.entity.Disquera)}.
	 */
	@Test
	void testSave() {
		
		Disquera disquera = new Disquera();
		disquera.setDescripcion("MegaForce");
		disquera.setFechaCreacion(LocalDateTime.now());
		disquera.setEstatus(true);
		
		this.disqeuraDAO.save(disquera);
	}

	/**
	 * Test method for {@link com.chilas.projectjpa.dao.impl.DisqueraDAOImpl#update(com.chilas.projectjpa.entity.Disquera)}.
	 */
	@Test
	void testUpdate() {
		Disquera disqueraConsultada = this.disqeuraDAO.consultarById(9L);
		
		disqueraConsultada.setDescripcion("Disquera IronMaiden");
		
		this.disqeuraDAO.update(disqueraConsultada);
	}

	/**
	 * Test method for {@link com.chilas.projectjpa.dao.impl.DisqueraDAOImpl#delete(com.chilas.projectjpa.entity.Disquera)}.
	 */
	@Test
	void testDelete() {
		Long id = 9L;
		this.disqeuraDAO.delete(id);
	}

	/**
	 * Test method for {@link com.chilas.projectjpa.dao.impl.DisqueraDAOImpl#consultarById(java.lang.Long)}.
	 */
	@Test
	void testConsultarById() {
		Disquera disquera =  this.disqeuraDAO.consultarById(10L);
		System.out.println("Disquera " + disquera.getDescripcion());
	}

}
