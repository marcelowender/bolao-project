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

import br.com.bolao.webapi.model.Jogo;
import br.com.bolao.webapi.repository.JogoRepository;

@RestController
@RequestMapping("/jogo")
public class JogoController {

	@Autowired
	JogoRepository jogoRepository;

	@GetMapping("/jogos")
	public Iterable<Jogo> getAllJogos() {
		return jogoRepository.findAll();
	}

	@PostMapping("/create")
	public Jogo createJogo(@Valid @RequestBody Jogo jogo) {
		return jogoRepository.save(jogo);
	}

	@GetMapping("/get/{id}")
	public ResponseEntity<Jogo> getJogoById(@PathVariable(value = "id") Long jogoId) {
		Jogo jogo = jogoRepository.findById(jogoId).get();
		if (jogo == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(jogo);
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<Jogo> updateJogo(@PathVariable(value = "id") Long jogoId, @Valid @RequestBody Jogo jogo) {
		Jogo objJogo = jogoRepository.findById(jogoId).get();
		if (objJogo == null) {
			return ResponseEntity.notFound().build();
		}
		objJogo.setCompeticao(jogo.getCompeticao());
		objJogo.setDataJogo(jogo.getDataJogo());

		objJogo.setClubeMandante(jogo.getClubeMandante());
		objJogo.setClubeVisitante(jogo.getClubeVisitante());

		objJogo.setGolsMandante(jogo.getGolsMandante());
		objJogo.setGolsVisitante(jogo.getGolsVisitante());

		Jogo updateJogo = jogoRepository.save(objJogo);
		return ResponseEntity.ok(updateJogo);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Jogo> deleteJogo(@PathVariable(value = "id") Long jogoId) {
		Jogo jogo = jogoRepository.findById(jogoId).get();
		if (jogo == null) {
			return ResponseEntity.notFound().build();
		}

		jogoRepository.delete(jogo);
		return ResponseEntity.ok().build();
	}

}
