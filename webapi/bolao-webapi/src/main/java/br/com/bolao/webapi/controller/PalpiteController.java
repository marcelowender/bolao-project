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

import br.com.bolao.webapi.model.Palpite;
import br.com.bolao.webapi.repository.PalpiteRepository;

@RestController
@RequestMapping("/palpite")
public class PalpiteController {

	@Autowired
	PalpiteRepository palpiteRepository;

	@GetMapping("/palpites")
	public Iterable<Palpite> getAllPalpites() {
		return palpiteRepository.findAll();
	}

	@PostMapping("/create")
	public Palpite createPalpite(@Valid @RequestBody Palpite palpite) {
		return palpiteRepository.save(palpite);
	}

	@GetMapping("/get/{id}")
	public ResponseEntity<Palpite> getPalpiteById(@PathVariable(value = "id") Long palpiteId) {
		Palpite palpite = palpiteRepository.findById(palpiteId).get();
		if (palpite == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(palpite);
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<Palpite> updatePalpite(@PathVariable(value = "id") Long palpiteId,
			@Valid @RequestBody Palpite palpite) {
		Palpite objPalpite = palpiteRepository.findById(palpiteId).get();
		if (objPalpite == null) {
			return ResponseEntity.notFound().build();
		}

		objPalpite.setUsuario(palpite.getUsuario());
		objPalpite.setJogo(palpite.getJogo());
		objPalpite.setGolsMandante(palpite.getGolsMandante());
		objPalpite.setGolsVisitante(palpite.getGolsVisitante());
		objPalpite.setDataPalpite(palpite.getDataPalpite());

		Palpite updatePalpite = palpiteRepository.save(objPalpite);
		return ResponseEntity.ok(updatePalpite);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Palpite> deletePalpite(@PathVariable(value = "id") Long palpiteId) {
		Palpite palpite = palpiteRepository.findById(palpiteId).get();
		if (palpite == null) {
			return ResponseEntity.notFound().build();
		}

		palpiteRepository.delete(palpite);
		return ResponseEntity.ok().build();
	}

}
