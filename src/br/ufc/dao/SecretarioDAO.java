package br.ufc.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import br.ufc.model.Secretario;

@Repository
public class SecretarioDAO {
	@PersistenceContext
	private EntityManager manager;

	public boolean inserir(Secretario secretario) {
		if (secretario != null) {
			manager.persist(secretario);
			return true;
		}
		return false;
	}

	public Secretario recuperar(Long id) {
		Secretario secretario = manager.find(Secretario.class, id);
		return secretario;
	}

	public boolean alterar(Secretario secretario) {
		if (secretario != null) {
			manager.merge(secretario);
			return true;
		}
		return false;
	}

	public boolean remover(Long id) {
		Secretario secretario = recuperar(id);
		if (secretario != null) {
			manager.remove(secretario);
			return true;
		}
		return false;
	}

	public List<Secretario> listar() {
		String hql = "select a from secretario as a";
		List<Secretario> secretarios = manager
				.createQuery(hql, Secretario.class).getResultList();
		return secretarios;
	}

	public Secretario getSecretarioPorLogin(String matricula) {
		String hql = "select s from secretario as s where matricula = :param_matricula";

		Query query = manager.createQuery(hql);
		query.setParameter("param_matricula", matricula);

		@SuppressWarnings("unchecked")
		List<Secretario> secretarios = query.getResultList();

		if (secretarios.isEmpty())
			return null;

		return secretarios.get(0);
	}
}
