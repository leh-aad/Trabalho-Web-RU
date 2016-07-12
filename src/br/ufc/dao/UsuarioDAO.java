package br.ufc.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import br.ufc.model.Usuario;

@Repository
public class UsuarioDAO {

	@PersistenceContext
	private EntityManager manager;

	public boolean inserir(Usuario usuario) {
		if (usuario != null) {
			manager.persist(usuario);
			return true;
		}
		
		return false;
	}

	public void remover(String login) {
		Usuario u = manager.find(Usuario.class, login);
		manager.remove(u);
	}

	public boolean alterarSenha(Usuario usuario, String senhaAtual,
			String novaSenha) {
		Usuario u = autenticar(usuario.getLogin(), usuario.getSenha());
		u.setSenha(novaSenha);
		if (manager.merge(u) != null)
			return true;
		return false;
	}

	public Usuario buscarUsuario(String login) {
		Usuario usuario = manager.find(Usuario.class, login);
		return usuario;
	}

	public Usuario autenticar(String login, String senha) {
		Usuario u = buscarUsuario(login);

		if (u != null && u.getSenha().equals(senha))
			return u;

		return null;
	}
}