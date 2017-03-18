package br.com.blog.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import br.com.blog.enuns.TipoCategoria;

@Entity
@Table(name = "categorias")
public class Categoria extends AbstractAuditoria<Long> {

	@NotBlank
	@Length(min = 3, max = 30)
	@Column(nullable = false, unique = true, length = 30)
	private String descricao;
	
	@Enumerated(EnumType.STRING)
	private TipoCategoria tipo;
	

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public TipoCategoria getTipo() {
		return tipo;
	}

	public void setTipo(TipoCategoria tipo) {
		this.tipo = tipo;
	}

	
}
