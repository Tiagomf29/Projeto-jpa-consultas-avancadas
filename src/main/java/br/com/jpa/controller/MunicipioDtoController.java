package br.com.jpa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.jpa.dto.MunicipiosCustomizadosDTO;
import br.com.jpa.services.municipio.MunicipioService;

@RestController
public class MunicipioDtoController {

	@Autowired
	private MunicipioService municipioService;

	@GetMapping("/listar")
	public List<MunicipiosCustomizadosDTO> listar(){

		return municipioService.listar(); 
	}
	
}
