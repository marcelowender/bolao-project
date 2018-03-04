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

import br.com.bolao.webapi.model.Clube;
import br.com.bolao.webapi.repository.ClubeRepository;

@RestController
@RequestMapping("/clube")
public class ClubeController {

	@Autowired
	ClubeRepository clubeRepository;

	@GetMapping("/clubes")
	public Iterable<Clube> getAllClubes() {
		return clubeRepository.findAll();
	}

	@PostMapping("/create")
	public Clube createClube(@Valid @RequestBody Clube clube) {
		return clubeRepository.save(clube);
	}

	@GetMapping("/get/{id}")
	public ResponseEntity<Clube> getClubeById(@PathVariable(value = "id") Long clubeId) {
		Clube clube = clubeRepository.findById(clubeId).get();
		if (clube == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(clube);
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<Clube> updateClube(@PathVariable(value = "id") Long clubeId,
			@Valid @RequestBody Clube clube) {
		Clube objClube = clubeRepository.findById(clubeId).get();
		if (objClube == null) {
			return ResponseEntity.notFound().build();
		}
		objClube.setNomeClube(clube.getNomeClube());
		objClube.setNomeLogoClube(clube.getNomeLogoClube());

		objClube.setPaisClube(clube.getPaisClube());
		objClube.setUfClube(clube.getUfClube());

		Clube updateClube = clubeRepository.save(objClube);
		return ResponseEntity.ok(updateClube);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Clube> deleteClube(@PathVariable(value = "id") Long clubeId) {
		Clube clube = clubeRepository.findById(clubeId).get();
		if (clube == null) {
			return ResponseEntity.notFound().build();
		}

		clubeRepository.delete(clube);
		return ResponseEntity.ok().build();
	}

}
