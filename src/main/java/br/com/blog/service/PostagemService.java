package br.com.blog.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.blog.entity.Postagem;
import br.com.blog.repository.PostagemRepository;

@Service
@Transactional(readOnly = true, propagation = Propagation.REQUIRED)
public class PostagemService {

	@Autowired	
	private PostagemRepository repository;
	
	public Page<Postagem> findByTituloAndAutor(int page, int size, String titulo, Long id) {
		Pageable pageable = new PageRequest(page, size);
		
		return repository.findAllByAutorIdAndTituloContainingIgnoreCaseOrderByDataPostagemDesc(pageable, id, titulo);
	}
	
	public Page<Postagem> findByTitulo(int page, int size, String titulo) {
		
		Pageable pageable = new PageRequest(page, size);
		
		return repository
				.findAllByTituloContainingIgnoreCaseOrderByDataPostagemDesc(pageable, titulo);
	}
	
	public Page<Postagem> findByTexto(int page, int size, String texto) {
		
		return repository 
				.findByTextoContainingIgnoreCaseOrderByDataPostagemDesc(
						texto, 
						new PageRequest(page, size)
				);
	}
	
	public Page<Postagem> findByPaginationByAutor(int page, int size, Long id) {
		Pageable pageable = new PageRequest(page, size);
		return repository
				.findAllByAutorIdOrderByDataPostagemDesc(pageable, id);
	}
	
	/*public Page<Postagem> findByPaginationByCategoria(int page, int size, String permalink) {
		Pageable pageable = new PageRequest(page, size);
		return repository
		//		.findAllByCategoriasPermalinkOrderByDataPostagemDesc(pageable, permalink);
	}*/
	
	public Page<Postagem> findByPagination(int page, int size) {
		
		Pageable pageable = new PageRequest(page, size);
		return repository.findAllByOrderByDataPostagemDesc(pageable);
	}
	
	public List<Postagem> findAll() {		
		return repository.findAll();
	}
	
	public List<Postagem> findByAutor(String nome) {
		
		return repository.findByAutorNome(nome);
	}

	
	
	public Postagem findById(Long id) {
		
		return repository.findOne(id);
	}
	
	@Transactional(readOnly = false)
	public void delete(Long id) {
		
		repository.delete(id);		
	}
	
	@Transactional(readOnly = false)
	public void saveOrUpdate(Postagem postagem) {
		if (postagem.getId() == null) {
			save(postagem);
		} else {
			update(postagem);
		}
	}

	private void update(Postagem postagem) {
		
		Postagem persistente = repository.findOne(postagem.getId());
		
		if (!persistente.getTitulo().equals(postagem.getTitulo())) {
			persistente.setTitulo(postagem.getTitulo());
		}
		
		if (!persistente.getTexto().equals(postagem.getTexto())) {
			persistente.setTexto(postagem.getTexto());
		}
		
		
		
		repository.save(persistente);		
	}

	private void save(Postagem postagem) {		
		
		postagem.setDataPostagem(new Date());
		
		repository.save(postagem);
	}

}
