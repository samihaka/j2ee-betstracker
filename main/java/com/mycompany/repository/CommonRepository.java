package com.mycompany.repository;

import java.util.List;

import com.mycompany.model.exception.DBException;

public interface CommonRepository<E> {

	public E getObjectById(Class<E> c, int id);
	public List<E> getAllObjects(String query, Class<E> c) throws DBException;
	public E getObjectByName(String query, Class<E> c, String name) throws DBException;
	public void addNew(E object);
	public void updateObject(E object);
}