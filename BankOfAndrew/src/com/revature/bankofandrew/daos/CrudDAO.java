package com.revature.bankofandrew.daos;



import com.revature.bankofandrew.util.collections.List;

public interface CrudDAO<T> {

		// CRUD: Create, Read, Update, Delete

		// Create
		T create(T newObj);
		
		// Read
		List<T> findAll();
		T findById(String id);
		
		// Update
		boolean update(T updatedObj);
		
		// Delete
		boolean delete(String id);

			}