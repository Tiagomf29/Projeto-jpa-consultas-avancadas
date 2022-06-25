package br.com.jpa.repository.regiao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.com.jpa.model.Regiao;

@Repository
public class RegiaoRepositorioCustom {

	@Autowired
	private EntityManager entityManager;
	
	public List<Regiao> listarTodosJpql(){
		
		var jpql = "from Regiao";
		
		TypedQuery<Regiao> lista = entityManager.createQuery(jpql, Regiao.class);
		List<Regiao> listaRegiao = lista.getResultList();
		
		return listaRegiao;
	}
	
	public List<Regiao> listarTodosNamedQuery(String nome){
		
		TypedQuery<Regiao> lista = entityManager.createNamedQuery("regiaoListarTodos", Regiao.class);
		lista.setParameter("nome", nome);
		List<Regiao> listaRegiao = lista.getResultList();
		
		return listaRegiao;
	}
	
	public List<Regiao> listarTodosCriteria(){
		
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Regiao> query = builder.createQuery(Regiao.class);
		Root<Regiao> root = query.from(Regiao.class);
		query.select(root);
		TypedQuery<Regiao> lista = entityManager.createQuery(query);
		List<Regiao> listaRegiao = lista.getResultList();
		
		return listaRegiao;
	}
	
	
}
