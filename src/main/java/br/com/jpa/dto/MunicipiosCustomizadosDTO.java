package br.com.jpa.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
public class MunicipiosCustomizadosDTO {

	private int id;
	private int codMunicipio;
	private String nomeMunicipio;
	private String estado;
	private String uf;
	private String regiao;
	
}
