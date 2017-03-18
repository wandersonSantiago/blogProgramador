package br.com.blog.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.blog.entity.Postagem;

public interface PostagemRepository extends JpaRepository<Postagem, Long> {
	
	Page<Postagem> findAllByOrderByDataPostagemDesc(Pageable pageable);
	
	List<Postagem> findByAutorNome(String nome);

	//Page<Postagem> findAllByCategoriasPermalinkOrderByDataPostagemDesc(Pageable pageable, String permalink);

	Page<Postagem> findAllByAutorIdOrderByDataPostagemDesc(Pageable pageable, Long id);

	Page<Postagem> findByTextoContainingIgnoreCaseOrderByDataPostagemDesc(String texto, Pageable pageable);

	Page<Postagem> findAllByTituloContainingIgnoreCaseOrderByDataPostagemDesc(Pageable pageable, String titulo);

	Page<Postagem> findAllByAutorIdAndTituloContainingIgnoreCaseOrderByDataPostagemDesc(Pageable pageable, Long id,
			String titulo);
 
}
