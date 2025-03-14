package com.althaus.gemini.bootcamp.domains.contracts.services.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.dao.DuplicateKeyException;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;

import com.althaus.gemini.bootcamp.domains.contracts.repositories.CategoryRepository;
import com.althaus.gemini.bootcamp.domains.contracts.services.CategoryService;
import com.althaus.gemini.bootcamp.domains.entities.Category;
import com.althaus.gemini.bootcamp.utils.exceptions.InvalidDataException;

@Service
public class CategoryServiceImpl implements CategoryService {

	private CategoryRepository categoryRepository;
	
	
	@Override
	public Category create(Category item) throws DuplicateKeyException, InvalidDataException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Category update(Category item) throws NotFoundException, InvalidDataException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Category item) throws InvalidDataException {
		// TODO Auto-generated method stub

	}

	

	@Override
	public Optional<Category> read(Integer id) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public List<Category> readAllList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll(List<Category> entities) {
		// TODO Auto-generated method stub
		
	}

}
