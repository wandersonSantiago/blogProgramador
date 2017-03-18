package br.com.blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.blog.entity.Postagem;
import br.com.blog.service.PostagemService;

@Controller
@RequestMapping("/rest/postagem")
public class PostagemController {

	@Autowired
	private PostagemService postagemService;
	
	@GetMapping
	public ResponseEntity<Iterable<Postagem>> buscarTodos() {
		return new ResponseEntity<Iterable<Postagem>>(postagemService.findAll(), HttpStatus.OK);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Postagem> buscarPorId(@PathVariable Long id) {
		return new ResponseEntity<Postagem>(postagemService.findById(id), HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<Postagem> salvar(@RequestBody @Validated Postagem postagem, BindingResult result, UriComponentsBuilder ucBuilder) {
		postagemService.saveOrUpdate(postagem);
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<>(headers, HttpStatus.CREATED);
	}

	@PutMapping
	public ResponseEntity<Postagem> alterar(@RequestBody Postagem postagem, UriComponentsBuilder ucBuilder) {
		postagemService.saveOrUpdate(postagem);
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<>(headers, HttpStatus.CREATED);
	}

	
	
	
}
