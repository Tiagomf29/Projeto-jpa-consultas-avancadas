package br.com.jpa.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
@Table(name = "municipio_populacao")
public class MunicipioPopulacao {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer Id;
	
	@ManyToOne
	@JoinColumn(name = "id_municipio", foreignKey = @ForeignKey(name="fk_municipio_populacao_n1"), nullable = false)
	private Municipio municipio;
	
	@Column(nullable = false)
	private Integer populacao;
}
