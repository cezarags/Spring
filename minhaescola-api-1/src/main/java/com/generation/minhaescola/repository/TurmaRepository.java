package com.generation.minhaescola.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.generation.minhaescola.model.Turma;

public interface TurmaRepository extends JpaRepository<Turma, Long> {
	
	
	public List<Turma>findAllByTurmaContainingIgnoreCase(String Turma);

	

}
