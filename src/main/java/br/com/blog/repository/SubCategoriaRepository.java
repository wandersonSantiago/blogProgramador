package br.com.blog.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.blog.entity.SubCategoria;

public interface SubCategoriaRepository extends JpaRepository<SubCategoria, Long>{

	Page<SubCategoria> findAllByOrderByDescricaoAsc(Pageable pageable);

	SubCategoria findByDescricao(String descricao);

}
