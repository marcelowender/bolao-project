package br.com.bolao.webapi.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.bolao.webapi.model.Competicao;
import br.com.bolao.webapi.repository.CompeticaoRepository;

@RestController
@RequestMapping("/competicao")
public class CompeticaoController {

	@Autowired
	CompeticaoRepository competicaoRepository;

	@GetMapping("/competicoes")
	public Iterable<Competicao> getAllCompeticoes() {
		return competicaoRepository.findAll();
	}

	@PostMapping("/create")
	public Competicao createCompeticao(@Valid @RequestBody Competicao competicao) {
		return competicaoRepository.save(competicao);
	}

	@GetMapping("/get/{id}")
	public ResponseEntity<Competicao> getCompeticaoById(@PathVariable(value = "id") Long competicaoId) {
		Competicao competicao = competicaoRepository.findById(competicaoId).get();
		if (competicao == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(competicao);
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<Competicao> updateCompeticao(@PathVariable(value = "id") Long competicaoId,
			@Valid @RequestBody Competicao competicao) {
		Competicao objCompeticao = competicaoRepository.findById(competicaoId).get();
		if (objCompeticao == null) {
			return ResponseEntity.notFound().build();
		}
		objCompeticao.setNomeCompeticao(competicao.getNomeCompeticao());
		objCompeticao.setDataFimCompeticao(competicao.getDataFimCompeticao());
		objCompeticao.setLiga(competicao.getLiga());

		Competicao updatedCompeticao = competicaoRepository.save(objCompeticao);
		return ResponseEntity.ok(updatedCompeticao);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Competicao> deleteCompeticao(@PathVariable(value = "id") Long competicaoId) {
		Competicao competicao = competicaoRepository.findById(competicaoId).get();
		if (competicao == null) {
			return ResponseEntity.notFound().build();
		}

		competicaoRepository.delete(competicao);
		return ResponseEntity.ok().build();
	}

}
