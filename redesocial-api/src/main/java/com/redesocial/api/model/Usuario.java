package com.redesocial.api.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="usuario")
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Size(min = 5, max = 50)
	@NotNull
	private String nome;
	
	@NotNull
	@Size(min = 5, max = 60)
	private String email;
	
	@NotNull
	@Size(min= 2, max = 100)
	private String senha;
	
	
	
	
	//Get e set

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	
	@OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL) // mapeaia o atributo tema e todas alteraçoes estão ligadas pelo cascade all
	@JsonIgnoreProperties("usuario")							// ignora a duplicidade						
	private List<Postagem> postagem;




	public List<Postagem> getPostagem() {
		return postagem;
	}

	public void setPostagem(List<Postagem> postagem) {
		this.postagem = postagem;
	}
	
	
	
	

}
