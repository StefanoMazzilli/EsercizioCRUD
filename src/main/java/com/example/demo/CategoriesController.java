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
@RequestMapping("/api/categories")
public class CategoriesController {
	
	@Autowired
	private StoreService storeService;
	
	//invio la lista delle categorie
	@GetMapping
	public List<Categories> getCategories() {
		return storeService.getCategories();
	}
	
	//aggiungo categoria
	@PostMapping
	public ResponseEntity<String> addcategory(@RequestBody Categories categoria) {
		storeService.addCategory(categoria);
		return new ResponseEntity<> ("New category created successfully", HttpStatus.CREATED);
	}
	
	//modifico una categoria esistente
	@PutMapping("/{id}")
	public ResponseEntity<String> updateCategory(@PathVariable int id, @RequestBody Categories categoriaNuova) {
		boolean updated = storeService.updateCategory(id, categoriaNuova);
		if (updated) {
			return new ResponseEntity<> ("Category updated successfully", HttpStatus.OK);
		} else {
			return new ResponseEntity<> ("Category not found", HttpStatus.NOT_FOUND);
		}
	}
	
	//elimino una categoria esistente
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteCategory(@PathVariable int id) {
		boolean deleted =storeService.deleteCategory(id);
		if (deleted) {
			return new ResponseEntity<> ("Category deleted successfully", HttpStatus.OK);
		} else {
			return new ResponseEntity<> ("Category not found", HttpStatus.NOT_FOUND);
		}
	}
}
