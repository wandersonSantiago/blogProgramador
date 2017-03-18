package br.com.blog.entity;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.data.jpa.domain.AbstractPersistable;

@Entity
@Table(name = "postagens")
public class Postagem extends AbstractPersistable<Long> {

	@NotBlank
	@Length(min = 5, max = 60)
	@Column(nullable = false, unique = true, length = 60)
	private String titulo;
	
	@NotBlank
	@Column(nullable = false)
	private String texto;
	
	@Column(name = "data_postagem", nullable = false)
	private Date dataPostagem;
	
	@ManyToOne
	@JoinColumn(name = "autor_id")
	private Autor autor;	
	
	//@JsonIgnore
	@ManyToOne
	@JoinColumn(name="id_subCategoria")
	private SubCategoria subcategorias;
	
	@OneToMany(mappedBy = "postagem", fetch = FetchType.EAGER)
	private List<Comentario> comentarios;

	@Override
	public void setId(Long id) {
		super.setId(id);
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	

	public Date getDataPostagem() {
		return dataPostagem;
	}

	public void setDataPostagem(Date dataPostagem) {
		this.dataPostagem = dataPostagem;
	}

	public Autor getAutor() {
		return autor;
	}

	public void setAutor(Autor autor) {
		this.autor = autor;
	}

	public SubCategoria getSubcategorias() {
		return subcategorias;
	}

	public void setSubcategorias(SubCategoria subcategorias) {
		this.subcategorias = subcategorias;
	}

	public List<Comentario> getComentarios() {
		if (comentarios != null) {
			Collections.sort(comentarios);
		}
		return comentarios;
	}

	public void setComentarios(List<Comentario> comentarios) {
		this.comentarios = comentarios;
	}
	
}

