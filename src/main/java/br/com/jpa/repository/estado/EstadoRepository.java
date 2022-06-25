package br.com.jpa.repository.estado;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.jpa.model.Estado;

@Repository
public interface EstadoRepository extends JpaRepository<Estado, Integer> {

	@Query("from Estado a join fetch a.regiao")
	public List<Estado> listarTodosEstadosComFetch();
	
	@Query("from Estado a join a.regiao")
	public List<Estado> listarTodosEstadosSemFetch();
}

