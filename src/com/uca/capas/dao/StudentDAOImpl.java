package com.uca.capas.dao;

import java.util.List;
import java.util.logging.Logger;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.uca.capas.controller.MainController;
import com.uca.capas.domain.Student;

@Repository
public class StudentDAOImpl implements StudentDAO {
	
	static Logger log = Logger.getLogger(MainController.class.getName());

	@PersistenceContext(unitName="capas")
	private EntityManager entityManager;

	@Override
	public List<Student> findAll() throws DataAccessException {
		StringBuffer sb = new StringBuffer();
		sb.append("select * from student order by id_student");
		Query query = entityManager.createNativeQuery(sb.toString(),Student.class);
		List<Student> resulset= query.getResultList();
		
		return resulset;
	}

	@Override
	public Student findOne(Integer code) throws DataAccessException {
		Student student = entityManager.find(Student.class, code);
		return student;
	}
	
	@Override
	public Student findOne(String name) throws DataAccessException {
		Student student = entityManager.find(Student.class, name);
		return student;
	}

	@Transactional 
	public int guardar(Student s, Integer newRow) throws DataAccessException {
		try {
			if(newRow == 1) entityManager.persist(s);// crea nueva instancia dentro de la base
			else entityManager.merge(s);//actualiza datos de una instancia ya existente dentro de BD 
	
			entityManager.flush();
			log.info("se guardo a la base");
			return 1;
		}catch(Throwable e) {
			e.printStackTrace();
			return 1;
		}
		
	}

	@Transactional
	public int delete(Student s) throws DataAccessException {
		try {
			entityManager.remove(entityManager.contains(s) ? s : entityManager.merge(s));
			entityManager.flush();	
			return 1;
		}catch(Throwable e) {
			e.printStackTrace();
			return 1;
		}
	}
	
}