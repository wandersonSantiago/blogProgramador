package br.com.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.blog.entity.Comentario;

public interface ComentarioRepository extends JpaRepository<Comentario, Long> {

}
