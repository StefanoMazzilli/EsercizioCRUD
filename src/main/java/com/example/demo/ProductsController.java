package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/products")
public class ProductsController {
	
	@Autowired
	private StoreService storeService;
	
	//invio la lista dei prodotti
	@GetMapping
	public List<Products> getProducts() {
		return storeService.getStore();
	}
	
	//aggiungo un nuovo prodotto
	@PostMapping
	public ResponseEntity<String> addProduct(@RequestBody Products product) {
		storeService.addProduct(product);
		return new ResponseEntity<>("Product added successfully", HttpStatus.CREATED);
	}
	
	//modifico un prodotto esistente
	@PutMapping("/{id}")
	public ResponseEntity<String> updateProduct(@PathVariable int id, @RequestBody Products prodottoNuovo) {
		boolean updated = storeService.updateProduct(id, prodottoNuovo);
		if (updated) {
			return new ResponseEntity<>("Product updated successfully", HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Product not found", HttpStatus.NOT_FOUND);
		}
	}
	
	//elimino un prodotto esistente
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteProduct(@PathVariable int id) {
		boolean deleted = storeService.deleteProduct(id);
		if (deleted) {
			return new ResponseEntity<> ("Product deleted successfully", HttpStatus.OK);
		} else {
			return new ResponseEntity<> ("Product not found", HttpStatus.NOT_FOUND);
		}
	}
}
