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

import br.com.bolao.webapi.model.Liga;
import br.com.bolao.webapi.repository.LigaRepository;

@RestController
@RequestMapping("/liga")
public class LigaController {

	@Autowired
	LigaRepository ligaRepository;

	@GetMapping("/ligas")
	public Iterable<Liga> getAllLigas() {
		return ligaRepository.findAll();
	}

	@PostMapping("/create")
	public Liga createLiga(@Valid @RequestBody Liga liga) {
		return ligaRepository.save(liga);
	}

	@GetMapping("/get/{id}")
	public ResponseEntity<Liga> getLigaById(@PathVariable(value = "id") Long ligaId) {
		Liga liga = ligaRepository.findById(ligaId).get();
		if (liga == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(liga);
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<Liga> updateLiga(@PathVariable(value = "id") Long ligaId, @Valid @RequestBody Liga liga) {
		Liga objLiga = ligaRepository.findById(ligaId).get();
		if (objLiga == null) {
			return ResponseEntity.notFound().build();
		}
		objLiga.setNomeLiga(liga.getNomeLiga());
		objLiga.setUsuarioLiga(liga.getUsuarioLiga());
		objLiga.setCompeticao(liga.getCompeticao());

		Liga updateLiga = ligaRepository.save(objLiga);
		return ResponseEntity.ok(updateLiga);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Liga> deleteLiga(@PathVariable(value = "id") Long ligaId) {
		Liga liga = ligaRepository.findById(ligaId).get();
		if (liga == null) {
			return ResponseEntity.notFound().build();
		}

		ligaRepository.delete(liga);
		return ResponseEntity.ok().build();
	}

}
