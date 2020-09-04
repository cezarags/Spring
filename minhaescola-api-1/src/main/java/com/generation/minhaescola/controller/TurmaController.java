package com.generation.minhaescola.controller;

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

import com.generation.minhaescola.model.Turma;
import com.generation.minhaescola.repository.TurmaRepository;


@RestController
@RequestMapping("/turmas")
@CrossOrigin("*")

public class TurmaController {
	
	@Autowired
	private TurmaRepository  reposi;
	
	@GetMapping
	public ResponseEntity<List<Turma>> GetAll(){
		return ResponseEntity.ok(reposi.findAll());
		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Turma> GetById(@PathVariable long id){
		return reposi.findById(id)
				.map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
		
	}
	@PostMapping
	public ResponseEntity<Turma> post (@RequestBody Turma turma){
		return ResponseEntity.status(HttpStatus.CREATED).body(reposi.save(turma));
		
	}
	
	@PutMapping
	public ResponseEntity<Turma> put (@RequestBody Turma turma){
		return ResponseEntity.status(HttpStatus.OK).body(reposi.save(turma));	
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable long id) {
		reposi.deleteById(id);
		
	} 
	
	
	
	
	
	
	
	
	

}