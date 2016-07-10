package br.ufc.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import br.ufc.model.Cardapio;

@Repository
public class CardapioDAO {

	@PersistenceContext
	private EntityManager manager;

	public boolean inserir(Cardapio cardapio) {
		if (cardapio != null) {
			manager.persist(cardapio);
			return true;
		}
		return false;
	}

	public Cardapio recuperar(Long id) {
		Cardapio cardapio = manager.find(Cardapio.class, id);
		return cardapio;
	}

	public boolean alterar(Cardapio cardapio) {
		if (cardapio != null) {
			manager.merge(cardapio);
			return true;
		}
		return false;
	}

	public boolean remover(Long id) {
		Cardapio cardapio = recuperar(id);
		if (cardapio != null) {
			manager.remove(cardapio);
			return true;
		}
		return false;
	}

	public List<Cardapio> getCardapio(int data) {
		
		String hql = "select c from cardapio as c where c.data = :param_data";

		Query query = manager.createQuery(hql, Cardapio.class);
		query.setParameter("param_data", data);
		
		@SuppressWarnings("unchecked")
		List<Cardapio> cardapios = query.getResultList();
		return cardapios;
	}

	public List<Cardapio> listar() {
		String hql = "select c from cardapio as c";
		List<Cardapio> cardapios = manager.createQuery(hql, Cardapio.class)
				.getResultList();
		return cardapios;
	}
}
