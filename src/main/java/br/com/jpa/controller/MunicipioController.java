package br.com.jpa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.jpa.model.Municipio;
import br.com.jpa.services.municipio.MunicipioService;

@RestController
public class MunicipioController {
	@Autowired
	private MunicipioService municipioService;

	@GetMapping("/listarModel")
	public List<Municipio> listar(){

		return municipioService.listarModel(); 
	}
}
