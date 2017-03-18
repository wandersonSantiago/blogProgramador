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

import br.com.blog.entity.SubCategoria;
import br.com.blog.repository.SubCategoriaRepository;

@Service
@Transactional(readOnly = true, propagation = Propagation.REQUIRED)
public class SubCategoriaService {
	
	@Autowired
	private SubCategoriaRepository subCategoriaRepository;
	
	public Page<SubCategoria> findByPagination(int page, int size) {		
		Pageable pageable = new PageRequest(page, size);		
		return subCategoriaRepository.findAllByOrderByDescricaoAsc(pageable);
	}
	
	public Iterable<SubCategoria> buscarTodos() {
		return subCategoriaRepository.findAll();
	}
	
	public List<SubCategoria> findAll() {
		Sort sort = new Sort(new Order(Direction.ASC, "descricao"));
		return subCategoriaRepository.findAll(sort);
	}
	
	public SubCategoria findByDescricao(String descricao) {		
		return subCategoriaRepository.findByDescricao(descricao);
	}
	
	public SubCategoria findById(Long id) {		
		return subCategoriaRepository.findOne(id);
	}
	
	@Transactional(readOnly = false)
	public void delete(Long id) {		
		subCategoriaRepository.delete(id);
	}
	
	@Transactional(readOnly = false)
	public void saveOrUpdate(SubCategoria categoria) {
		subCategoriaRepository.save(categoria);
		
		
	}

}
