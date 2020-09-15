package com.redesocial.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.redesocial.api.model.Tema;
import com.redesocial.api.repository.TemaRepository;

@RestController
@RequestMapping("/tema")
@CrossOrigin("*")

public class TemaController {
	
	@Autowired
	private TemaRepository treposi;
	
	@GetMapping
	public ResponseEntity<List<Tema>> Listar(){
		return ResponseEntity.ok(treposi.findAll());	
		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Tema> pegarId(@PathVariable long id){
		return treposi.findById(id)
				.map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
		
	}
	
	@PostMapping
	public ResponseEntity<Tema> post (@RequestBody Tema tema){
		return ResponseEntity.status(HttpStatus.CREATED).body(treposi.save(tema));
		
	}
	@PutMapping
	public ResponseEntity<Tema> put (@RequestBody Tema tema){
		return ResponseEntity.status(HttpStatus.OK).body(treposi.save(tema));
	}
	
	@DeleteMapping("/{id}")
	public void  delete (@PathVariable long id) {
		treposi.deleteById(id);
		
	}
	
		
	
	
	
	
	

}
