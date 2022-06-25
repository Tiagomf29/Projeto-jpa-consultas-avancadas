package br.com.jpa.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Municipio {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "cod_municipio", nullable = false)
	private Integer codigoMunicipio;
	
	@ManyToOne
	@JoinColumn(name = "id_estado", foreignKey = @ForeignKey(name="fk_municipio_n1"), nullable = false)
	private Estado estado;
	
	@Column(length = 70, nullable = false)
	private String nome;
	
}
