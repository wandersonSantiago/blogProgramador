package br.com.blog.controller;

import java.util.Arrays;

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
import br.com.blog.enuns.TipoCategoria;
import br.com.blog.service.CategoriaService;

@RestController
@RequestMapping("/rest/categoria")
public class CategoriaController {

	@Autowired
	private CategoriaService categoriaService;
	
	@GetMapping
	public ResponseEntity<Iterable<Categoria>> buscarTodos() {
		return new ResponseEntity<Iterable<Categoria>>(categoriaService.buscarTodos(), HttpStatus.OK);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Categoria> buscarPorId(@PathVariable Long id) {

		return new ResponseEntity<Categoria>(categoriaService.findById(id), HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<Categoria> salvar(@RequestBody @Validated Categoria categoria, BindingResult result, UriComponentsBuilder ucBuilder) {
		categoriaService.saveOrUpdate(categoria);
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<>(headers, HttpStatus.CREATED);
	}

	@PutMapping
	public ResponseEntity<Categoria> alterar(@RequestBody Categoria categoria, UriComponentsBuilder ucBuilder) {
		categoriaService.saveOrUpdate(categoria);
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<>(headers, HttpStatus.CREATED);
	}

	@GetMapping(value = "/tipo")
	public ResponseEntity<Iterable<TipoCategoria>> tipoCategoria() {
		return new ResponseEntity<Iterable<TipoCategoria>>(Arrays.asList(TipoCategoria.values()), HttpStatus.OK);
	}
	

}

