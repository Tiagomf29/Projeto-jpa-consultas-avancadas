package br.com.jpa.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
public class QuantidadeEstadoPorRegiaoDto {
	
	private String nomeRegiao;
	private Long quantidade;

}
