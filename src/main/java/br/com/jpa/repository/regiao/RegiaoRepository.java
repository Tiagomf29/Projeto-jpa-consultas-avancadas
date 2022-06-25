package br.com.jpa.repository.regiao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.jpa.model.Regiao;

@Repository
public interface RegiaoRepository extends JpaRepository<Regiao, Integer>{

	@Query("from Regiao")
	public List<Regiao> listarTodasRegioesQuery();
	
	@Query(value = "select * from Regiao", nativeQuery = true)
	public List<Regiao> listarTodasRegioesNativeQuery();
	
	public List<Regiao> findByNomeContaining(String nome);

}
