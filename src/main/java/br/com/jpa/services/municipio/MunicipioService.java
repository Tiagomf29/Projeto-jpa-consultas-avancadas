package br.com.jpa.services.municipio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.jpa.dto.MunicipiosCustomizadosDTO;
import br.com.jpa.model.Municipio;
import br.com.jpa.repository.municipio.MunicipioRepositoryCustom;
import br.com.jpa.repository.municipio.MunicipioRespository;

@Service
public class MunicipioService {

	@Autowired
	private MunicipioRepositoryCustom municipioRepositoryCustom;
	
	@Autowired
	private MunicipioRespository municipioRespository;
	
	public List<MunicipiosCustomizadosDTO> listar(){
		
		return municipioRepositoryCustom.listaMunicipiosCustomizadosDTO();
	}
	
	public List<Municipio> listarModel(){
		
		return municipioRespository.listarMunicipios();
	}
	
}
