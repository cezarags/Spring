package com.redesocial.api.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.redesocial.api.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
	
	
	

	public Optional<Usuario> findByEmail(String userName);

}
