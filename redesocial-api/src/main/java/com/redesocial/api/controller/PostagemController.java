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

import com.redesocial.api.model.Postagem;
import com.redesocial.api.repository.PostagemRepository;

@RestController
@RequestMapping("/postagens")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class PostagemController {
	
	@Autowired
	private PostagemRepository postreposi;
	
	@GetMapping
	public ResponseEntity<List<Postagem>> PegarLista(){
		return ResponseEntity.ok(postreposi.findAll());
		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Postagem> GetById(@PathVariable  long id){    //@path variable junta a variavel do caminho
		return postreposi.findById(id)
				.map(resp -> ResponseEntity.ok(resp))                 // retorno caso for ok
				.orElse(ResponseEntity.notFound().build());			// retorno senão for ok	
	
	}
		@PostMapping
		public ResponseEntity<Postagem> post (@RequestBody Postagem postagem){
			return ResponseEntity.status(HttpStatus.CREATED).body(postreposi.save(postagem));
			
		}
		@PutMapping
		public ResponseEntity<Postagem> put (@RequestBody Postagem postagem){
			return ResponseEntity.status(HttpStatus.OK).body(postreposi.save(postagem));
		}
		
		@DeleteMapping("/{id}")
		public void  delete (@PathVariable long id) {
			postreposi.deleteById(id);
			
		}
	
	
}
