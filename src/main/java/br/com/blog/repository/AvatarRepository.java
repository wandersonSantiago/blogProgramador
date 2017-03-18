package br.com.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.blog.entity.Avatar;

public interface AvatarRepository extends JpaRepository<Avatar, Long> {

}
