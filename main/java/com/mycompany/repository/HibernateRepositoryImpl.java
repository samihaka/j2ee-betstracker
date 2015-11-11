package com.mycompany.repository;

import java.util.List;





import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.mycompany.model.exception.DBException;

@Repository("commonRepository")
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class HibernateRepositoryImpl<E> implements CommonRepository<E>{

	@PersistenceContext
	private EntityManager em;
	
	/* (non-Javadoc)
	 * @see com.mycompany.repository.CommonRepository#getObject(java.lang.Class, int)
	 */
	public E getObjectById(Class<E> c, int id){
		System.out.println("entityManager: "+em);
		E object = em.find(c, id);

		return object;
	}
	
	public List<E> getAllObjects(String query, Class<E> c) throws DBException {
		List<E> objects;
		TypedQuery<E> typedQuery = em.createNamedQuery(query, c);
		
		try{
			objects = typedQuery.getResultList();
		}
		catch(IllegalArgumentException e){
			throw new DBException("error.db.invalid.query");			
		}
		catch(Exception e){
			throw new DBException("error.db.connection");
		}
		
		return objects;
	}
	
	public E getObjectByName(String query, Class<E> c, String name) throws DBException {
		E object;
		TypedQuery<E> typedQuery = em.createNamedQuery(query, c).setParameter("name", name);
		
		try{
			object = typedQuery.getSingleResult();
		}
		catch(NoResultException e){
			throw new DBException("error.db.no.result");
		}
		catch(NonUniqueResultException e){
			throw new DBException("error.db.multiple.results");	
		}
		catch(IllegalArgumentException e){
			throw new DBException("error.db.invalid.query");			
		}
		catch(Exception e){
			throw new DBException("error.db.connection");
		}
		
		return object;
	}
	
	public void addNew(E object){
		System.out.println("Add new");
		em.persist(object);
		em.flush();
		em.clear();
	}
	
	public void updateObject(E object){
		System.out.println("Update object");
		em.merge(object);
		em.flush();
		em.clear();
	}
}
