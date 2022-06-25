package br.com.jpa.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
@NamedQuery(name = "regiaoListarTodos", query = "from Regiao where nome like :nome")
public class Regiao {

	@Id
	private Integer id;
	
	@Column(length = 60, nullable = false)
	private String nome;
	
}
