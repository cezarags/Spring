package com.redesocial.api.controller;

import java.util.List;
import java.util.Optional;

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

import com.redesocial.api.model.UserLogin;
import com.redesocial.api.model.Usuario;
import com.redesocial.api.repository.UsuarioRepository;
import com.redesocial.api.service.UsuarioService;

@RestController
@RequestMapping("/usuarios")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UsuarioController {
	
	
	private UsuarioRepository usureposi;
	
	
	@GetMapping
	public ResponseEntity<List<Usuario>> PegarLista(){
		return ResponseEntity.ok(usureposi.findAll());
		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Usuario> GetById(@PathVariable  long id){    //@path variable junta a variavel do caminho
		return usureposi.findById(id)
				.map(resp -> ResponseEntity.ok(resp))                 // retorno caso for ok
				.orElse(ResponseEntity.notFound().build());			// retorno senão for ok	
	
	}
		@PostMapping
		public ResponseEntity<Usuario> post (@RequestBody Usuario usuario){
			return ResponseEntity.status(HttpStatus.CREATED).body(usureposi.save(usuario));
			
		}
		@PutMapping
		public ResponseEntity<Usuario> put (@RequestBody Usuario usuario){
			return ResponseEntity.status(HttpStatus.OK).body(usureposi.save(usuario));
		}
		
		@DeleteMapping("/{id}")
		public void  delete (@PathVariable long id) {
			usureposi.deleteById(id);
			
		}
		
		@Autowired
		private UsuarioService usuarioService;
		
		
		@PostMapping("/logar")
		public ResponseEntity<UserLogin> Autentication(@RequestBody Optional<UserLogin> user){
			return usuarioService.logar(user).map(resp -> ResponseEntity.ok(resp))
					.orElse(ResponseEntity.status(HttpStatus.UNAUTHORIZED).build());
			
		}
		
		
		@PostMapping("/cadastrar")
		public ResponseEntity<Usuario> postc(@RequestBody Usuario usuario){
			return ResponseEntity.status(HttpStatus.CREATED)
					.body(usuarioService.cadastrarUsuario(usuario));
			
		}
		
		
	}

	




