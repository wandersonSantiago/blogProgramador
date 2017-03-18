package br.com.blog.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.blog.entity.Categoria;
import br.com.blog.entity.SubCategoria;
import br.com.blog.service.SubCategoriaService;

@RestController
@RequestMapping("/rest/categoria/sub")
public class SubCategoriaController {
	
	@Autowired
	private SubCategoriaService subCategoriaService;
	
	@GetMapping
	public ResponseEntity<Iterable<SubCategoria>> buscarTodos() {
		return new ResponseEntity<Iterable<SubCategoria>>(subCategoriaService.buscarTodos(), HttpStatus.OK);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<SubCategoria> buscarPorId(@PathVariable Long id) {

		return new ResponseEntity<SubCategoria>(subCategoriaService.findById(id), HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<SubCategoria> salvar(@RequestBody @Validated SubCategoria categoria, BindingResult result, UriComponentsBuilder ucBuilder) {
		subCategoriaService.saveOrUpdate(categoria);
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<>(headers, HttpStatus.CREATED);
	}

	@PutMapping
	public ResponseEntity<SubCategoria> alterar(@RequestBody SubCategoria categoria, UriComponentsBuilder ucBuilder) {
		subCategoriaService.saveOrUpdate(categoria);
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<>(headers, HttpStatus.CREATED);
	}

	

}
