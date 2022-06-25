package br.com.jpa.repository.municipio;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.com.jpa.dto.MunicipiosCustomizadosDTO;
import br.com.jpa.model.Municipio;

@Repository
public class MunicipioRepositoryCustom {

	@Autowired
	private EntityManager entityManager;
	
	public List<Object[]> listaMunicipiosCustomizados(){
		
		String jpql = "select a.id, a.codigoMunicipio, a.nome "
				+ ",b.nome,b.uf, c.nome from Municipio a join a.estado b join b.regiao c ";
		
		TypedQuery<Object[]>lista = entityManager.createQuery(jpql, Object[].class);
		List<Object[]> listaMunicipios = lista.getResultList();
		
		return listaMunicipios;
	}
	
	public List<MunicipiosCustomizadosDTO> listaMunicipiosCustomizadosDTO(){
		
		String jpql = "select new br.com.jpa.dto.MunicipiosCustomizadosDTO( a.id, a.codigoMunicipio, a.nome "
				+ ",b.nome,b.uf, c.nome) from Municipio a join a.estado b join b.regiao c order by a.id";
		
		TypedQuery<MunicipiosCustomizadosDTO>lista = entityManager.createQuery(jpql, MunicipiosCustomizadosDTO.class);
		List<MunicipiosCustomizadosDTO> listaMunicipios = lista.getResultList();
		
		return listaMunicipios;
	}
	
	public List<Object[]> listarDadosResumidosMunicipio(){
		
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Object[]> query = builder.createQuery(Object[].class);
		Root<Municipio> municipio = query.from(Municipio.class);
		query.multiselect(municipio.get("codigoMunicipio"),municipio.get("nome"));
		
		TypedQuery<Object[]> lista = entityManager.createQuery(query);
		List<Object[]> listaMunicipio = lista.getResultList();
		
		return listaMunicipio;
	}
	
	public List<Municipio> listaTodosMunicipiosCriteria(){
		
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Municipio> criteriaQuery = criteriaBuilder.createQuery(Municipio.class);
		Root<Municipio> root = criteriaQuery.from(Municipio.class);
		
		criteriaQuery.select(root);
		
		TypedQuery<Municipio> lista = entityManager.createQuery(criteriaQuery);
		List<Municipio> listaMunicipio = lista.getResultList();
		
		return listaMunicipio;
	}
	
}
