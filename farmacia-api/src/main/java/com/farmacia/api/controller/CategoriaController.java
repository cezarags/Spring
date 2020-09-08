package com.farmacia.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.farmacia.api.model.Categoria;
import com.farmacia.api.repository.CategoriaRepository;


@RestController
@RequestMapping("/categoria")
@CrossOrigin(origins = "*", allowedHeaders="*")
public class CategoriaController {
	
	@Autowired
	private CategoriaRepository categoreposi;
	
	@GetMapping
	public ResponseEntity<List<Categoria>>  listar(){
		return ResponseEntity.ok (categoreposi.findAll());
	
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Categoria> GetById(@PathVariable  long id){    //@path variable junta a variavel do caminho
		return categoreposi.findById(id)
				.map(resp -> ResponseEntity.ok(resp))                 // retorno caso for ok
				.orElse(ResponseEntity.notFound().build());			// retorno senão for ok							
	}
	
	
	@PostMapping
	public ResponseEntity<Categoria> post (@RequestBody Categoria categoria){
		return  ResponseEntity.status(HttpStatus.CREATED).body(categoreposi.save(categoria));
		
	}
	
	public ResponseEntity<Categoria> put (@RequestBody Categoria categoria){
		return ResponseEntity.status(HttpStatus.OK).body(categoreposi.save(categoria));
		
	}
	
	public void delete(@PathVariable long id) {
		categoreposi.deleteById(id);
		
	}
	
	
	
}
