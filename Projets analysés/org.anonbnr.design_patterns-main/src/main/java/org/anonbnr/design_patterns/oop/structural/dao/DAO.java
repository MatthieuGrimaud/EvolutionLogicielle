package org.anonbnr.design_patterns.oop.structural.dao;

import java.util.List;
import java.util.Optional;

public interface DAO<T> {
	T create(T model);
	Optional<T> findById(int id);
	List<T> findAll();
	Optional<T> update(int id, T newModel);
	boolean delete(int id);
}
