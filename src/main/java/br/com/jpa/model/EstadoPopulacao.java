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

@Getter @Setter
@Entity
@Table(name = "estado_populacao")
public class EstadoPopulacao {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name = "id_estado", foreignKey = @ForeignKey(name="fk_estado_populacao_n1"), nullable = false)
	private Estado estado;
	
	@Column(nullable = false)
	private Integer populacao;
	
}
