package br.ufc.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import br.ufc.model.Aluno;

@Repository
public class AlunoDAO {
	@PersistenceContext
	private EntityManager manager;
	
	public boolean inserir(Aluno aluno) {
		if (aluno != null) {
			manager.persist(aluno);
			return true;
		}
		return false;
	}
	
	public Aluno recuperar(Long id) {
		Aluno aluno = manager.find(Aluno.class, id);
		return aluno;
	}
	
	public boolean alterar(Aluno aluno) {
		if (aluno != null) {
			manager.merge(aluno);
			return true;
		}
		return false;
	}
	
	public boolean remover(Long id) {
		Aluno aluno = recuperar(id);
		if (aluno != null) {
			manager.remove(aluno);
			return true;
		}
		return false;
	}
	
	public List<Aluno> listar() {
		String hql = "select a from aluno as a";
		List<Aluno> alunos = manager.createQuery(hql, Aluno.class).getResultList();
		return alunos;
	}
	
	public Aluno getAlunoPorLogin(String matricula){
		String hql = "select a from aluno as a where matricula = :param_matricula";
		
		Query query = manager.createQuery(hql);
		query.setParameter("param_matricula", matricula);
		
		@SuppressWarnings("unchecked")
		List<Aluno> alunos = query.getResultList();
		
		if (alunos.isEmpty())
			return null;
		
		return alunos.get(0);
	}

	public void utilizarTicket(Aluno aluno) {
		
	}

}
