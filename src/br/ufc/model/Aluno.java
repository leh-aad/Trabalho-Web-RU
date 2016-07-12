package br.ufc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name = "aluno")
public class Aluno {
	
	@Id
	@GeneratedValue
	private Long id;

	@Column(name = "matricula", nullable = false)
	private String matricula;

	@Column(name = "nome", nullable = false)
	private String nome;

	@Column(name = "email", nullable = false)
	private String email;

	@Column(name = "credito", nullable = false, columnDefinition = "int default 0")
	private int credito;

	@Column(name = "curso", nullable = false)
	private String curso;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
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

	public int getCredito() {
		return credito;
	}

	public void setCredito(int credito) {
		this.credito = credito;
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}	
}
