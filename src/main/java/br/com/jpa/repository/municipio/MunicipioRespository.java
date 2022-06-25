package br.com.jpa.repository.municipio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.jpa.model.Municipio;

@Repository
public interface MunicipioRespository extends JpaRepository<Municipio, Integer>{
	
	@Query("from Municipio a join a.estado b join b.regiao")
	public List<Municipio> listarMunicipios();

}
