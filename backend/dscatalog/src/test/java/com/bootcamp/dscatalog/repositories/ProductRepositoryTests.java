package com.bootcamp.dscatalog.repositories;

import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.bootcamp.dscatalog.entities.Product;

@DataJpaTest
public class ProductRepositoryTests {
	
	@Autowired
	private ProductRepository repository;
	
	private long exintingId;
	
	@BeforeEach
	void setUp() throws Exception {
		exintingId = 1L;
	}
	
	@Test
	public void deleteShouldDeleteObjectWhenIdExists() {
		repository.deleteById(exintingId);
		Optional<Product> result = repository.findById(exintingId);
		Assertions.assertFalse(result.isPresent());
	}
	
	/*
	 * @Test public void
	 * deleteShouldThrowEmptyResultDataAccessExceptionWhenIdDoesNotExist() { long
	 * nonExistingId = 1000L;
	 * 
	 * Assertions.assertThrows(EmptyResultDataAccessException.class, () -> {
	 * repository.deleteById(nonExistingId); }); }
	 */

}
