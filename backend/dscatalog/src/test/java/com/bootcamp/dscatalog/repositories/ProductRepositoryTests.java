package com.bootcamp.dscatalog.repositories;

import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.bootcamp.dscatalog.entities.Product;
import com.bootcamp.dscatalog.tests.Factory;

@DataJpaTest
public class ProductRepositoryTests {
	
	@Autowired
	private ProductRepository repository;
	
	private long exintingId;
	private long nonExistingId;
	private long countTotalProducts;
	
	@BeforeEach
	void setUp() throws Exception {
		exintingId = 1L;
		nonExistingId = 1000L;
		countTotalProducts = 25L;
	}
	
	@Test
	public void saveShouldPersistWithAutoincrementWhenIdIsNull() {

		Product product = Factory.createProduct();
		product.setId(null);
		
		product = repository.save(product);
		Optional<Product> result = repository.findById(product.getId());
		
		Assertions.assertNotNull(product.getId());
		Assertions.assertEquals(countTotalProducts + 1L, product.getId());
		Assertions.assertTrue(result.isPresent());
		Assertions.assertSame(result.get(), product);
	}
	
	@Test
	public void deleteShouldDeleteObjectWhenIdExists() {
		repository.deleteById(exintingId);
		Optional<Product> result = repository.findById(exintingId);
		Assertions.assertFalse(result.isPresent());
	}
	
	@Test
	public void findByIdShouldReturnProductNotEmptyWhenIdExist() {
		Optional<Product> product = repository.findById(exintingId);
		Assertions.assertNotNull(product);
	}
	
	@Test
	public void findByIdShouldReturnProductEmptyWhenIdNotExist() {
		Optional<Product> product = repository.findById(nonExistingId);
		Assertions.assertEquals(Optional.empty(), product);
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
