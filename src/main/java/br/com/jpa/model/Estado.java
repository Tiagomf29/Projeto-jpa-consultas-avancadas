package br.com.jpa.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
@NamedQueries({@NamedQuery(name = "listarEstadosNamedQuery1",query = "select a from Estado a join fetch a.regiao where a.regiao.nome =:regiao"),
			   @NamedQuery(name = "listarEstadosNamedQuery2",query = "select a from Estado a join fetch a.regiao b where b.nome =:regiao")})
public class Estado {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(length = 60, nullable = false)
	private String nome;
	
	@Column(length = 2, nullable = false)
	private String uf;
	
	@ManyToOne
	@JoinColumn(name = "id_regiao", foreignKey = @ForeignKey(name="fk_estado_n1"), nullable = false)
	private Regiao regiao;
	
}
