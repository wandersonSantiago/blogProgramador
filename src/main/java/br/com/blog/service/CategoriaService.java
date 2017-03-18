package br.com.blog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort.Order;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.blog.entity.Categoria;
import br.com.blog.repository.CategoriaRepository;

@Service
@Transactional(readOnly = true, propagation = Propagation.REQUIRED)
public class CategoriaService {

	@Autowired
	private CategoriaRepository categoriaRepository;
	
	public Page<Categoria> findByPagination(int page, int size) {		
		Pageable pageable = new PageRequest(page, size);		
		return categoriaRepository.findAllByOrderByDescricaoAsc(pageable);
	}
	
	public Iterable<Categoria> buscarTodos() {
		return categoriaRepository.findAll();
	}
	
	public List<Categoria> findAll() {
		Sort sort = new Sort(new Order(Direction.ASC, "descricao"));
		return categoriaRepository.findAll(sort);
	}
	
	public Categoria findByDescricao(String descricao) {		
		return categoriaRepository.findByDescricao(descricao);
	}
	
	public Categoria findById(Long id) {		
		return categoriaRepository.findOne(id);
	}
	
	@Transactional(readOnly = false)
	public void delete(Long id) {		
		categoriaRepository.delete(id);
	}
	
	@Transactional(readOnly = false)
	public void saveOrUpdate(Categoria categoria) {
		categoriaRepository.save(categoria);
		
		
	}

	
}
