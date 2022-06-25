package br.com.jpa.repository.estado;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.com.jpa.dto.QuantidadeEstadoPorRegiaoDto;
import br.com.jpa.model.Estado;
import br.com.jpa.model.Regiao;

@Repository
public class EstadoRepositoryCustom {

	@Autowired
	private EntityManager entityManager;
	
	public List<Estado> listaEstadosNamedQuery1(String nome){
		
		TypedQuery<Estado> lista = entityManager.createNamedQuery("listarEstadosNamedQuery1", Estado.class);
		lista.setParameter("regiao", nome);
		List<Estado> ll = lista.getResultList();
		
		return ll;
	}
	
	public List<Estado> listaEstadosNamedQuery2(String nome){
		
		TypedQuery<Estado> lista = entityManager.createNamedQuery("listarEstadosNamedQuery2", Estado.class);
		lista.setParameter("regiao", nome);
		List<Estado> ll = lista.getResultList();
		
		return ll;
	}
	
	public List<String> listaTodosNomesEstadosProjecao(){
		
		var jpql = "select a.nome from Estado a join a.regiao";
		
		TypedQuery<String> listaNomes = entityManager.createQuery(jpql, String.class);
		List<String> lista = listaNomes.getResultList();
		return lista;
	}
	
	public List<Object[]> projecaoListaQuantidadeEstadosPorRegiao(){
		
		var jpql = "select b.nome,count(*) from Estado a join a.regiao b "
				 + "group by b.nome";
		
		TypedQuery<Object[]> listaNomes = entityManager.createQuery(jpql, Object[].class);
		List<Object[]> lista = listaNomes.getResultList();
		
		return lista;
	}
	
	public List<QuantidadeEstadoPorRegiaoDto> projecaoListaQuantidadeEstadosPorRegiaoDTO(){
		
		var jpql = "select new br.com.jpa.dto.QuantidadeEstadoPorRegiaoDto(b.nome,count(*)) from Estado a join a.regiao b "
				 + "group by b.nome";
		
		TypedQuery<QuantidadeEstadoPorRegiaoDto> listaNomes = entityManager.createQuery(jpql, QuantidadeEstadoPorRegiaoDto.class);
		List<QuantidadeEstadoPorRegiaoDto> lista = listaNomes.getResultList();
		
		return lista;
	}
	
	
	public List<Estado> listaTodosEstadosCriteria(){
		
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Estado> estadoCriteria = builder.createQuery(Estado.class);
		Root<Estado> root = estadoCriteria.from(Estado.class);
		estadoCriteria.select(root);
		
		TypedQuery<Estado> lista = entityManager.createQuery(estadoCriteria);
		List<Estado> listaEstado = lista.getResultList();
		
		return listaEstado;
	}

	public List<Regiao> listarRegiaoDosEstados(Integer id){
		
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Regiao> regiao = builder.createQuery(Regiao.class);
		Root<Estado> estado = regiao.from(Estado.class);
		regiao.select(estado.get("regiao"));
		regiao.where(builder.equal(estado.get("id"), id));
		TypedQuery<Regiao> listaRegiao = entityManager.createQuery(regiao);
		List<Regiao> listaTodasRegioes = listaRegiao.getResultList();
		
		return listaTodasRegioes;
		
	}
	
	public List<Estado> listarEstadosComRegioes(){
		
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Estado> criteriaQuery = criteriaBuilder.createQuery(Estado.class);
		Root<Estado> root = criteriaQuery.from(Estado.class);
		root.fetch("regiao");
		//Join<Estado, Regiao> join = root.join("regiao");
		
		criteriaQuery.select(root);
		
		TypedQuery<Estado> estado = entityManager.createQuery(criteriaQuery);
		List<Estado> listaEstado = estado.getResultList();
		
		return listaEstado;
	}
	
}
