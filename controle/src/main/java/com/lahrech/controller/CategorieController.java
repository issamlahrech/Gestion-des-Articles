package com.lahrech.controller;

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

import com.lahrech.entities.Categorie;
import com.lahrech.service.CategorieService;
@RestController
@RequestMapping("/api/Categories")
public class CategorieController {
	@Autowired
	private CategorieService service;

	@GetMapping
	public List<Categorie> findAllCategorie() {
		return service.findAll();
	}
	
	@PostMapping
	public Categorie createCategorie(@RequestBody Categorie categorie) {
		categorie.setId(0);
		return service.create(categorie);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Object> findById(@PathVariable long id) {
		Categorie Categorie = service.findById(id);
		if (Categorie == null) {
			return new ResponseEntity<Object>("Categorie avec ID = " + id + " n'existe pas", HttpStatus.BAD_REQUEST);
		} else {
			return ResponseEntity.ok(Categorie);
		}
	}

	@PutMapping("/{id}")
	public ResponseEntity<Object> updateCategorie(@PathVariable long id, @RequestBody Categorie newCategorie) {
		Categorie oldCategorie = service.findById(id);
		if (oldCategorie == null) {
			return new ResponseEntity<Object>("Categorie avec ID = " + id + " n'existe pas", HttpStatus.BAD_REQUEST);
		} else {
			newCategorie.setId(id);
			return ResponseEntity.ok(service.update(newCategorie));
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleteCategorie(@PathVariable long id) {
		Categorie categorie = service.findById(id);
		if (categorie == null) {
			return new ResponseEntity<Object>("Categorie avec ID = " + id + " n'existe pas", HttpStatus.BAD_REQUEST);
		} else {
			service.delete(categorie);
			return ResponseEntity.ok("filière supprimée");
		}
	}

}
