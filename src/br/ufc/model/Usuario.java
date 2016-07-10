package br.ufc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "usuario")
public class Usuario {

	@Id
	@Column(name = "login", unique = true, nullable = false)
	private String login;

	@Column(name = "senha", nullable = false)
	private String senha;

	@Column(name = "tipo_usuario", nullable = false)
	private String tipoUsuario;

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getTipoUsuario() {
		return tipoUsuario;
	}

	public void setTipoUsuario(String tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}
}
