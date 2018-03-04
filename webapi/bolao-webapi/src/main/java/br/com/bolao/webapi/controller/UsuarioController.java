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

import br.com.bolao.webapi.model.Usuario;
import br.com.bolao.webapi.repository.UsuarioRepository;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

	@Autowired
	UsuarioRepository usuarioRepository;

	@GetMapping("/usuarios")
	public Iterable<Usuario> getAllUsuarios() {
		return usuarioRepository.findAll();
	}

	@PostMapping("/create")
	public Usuario createUsuario( @RequestBody Usuario usuario) {
		return usuarioRepository.save(usuario);
	}

	@GetMapping("/get/{id}")
	public ResponseEntity<Usuario> getUsuarioById(@PathVariable(value = "id") Long usuarioId) {
		Usuario usuario = usuarioRepository.findById(usuarioId).get();
		if (usuario == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(usuario);
	}

	@PutMapping("/updade/{id}")
	public ResponseEntity<Usuario> updateUsuario(@PathVariable(value = "id") Long usuarioId,
			@Valid @RequestBody Usuario usuario) {
		Usuario objUsuario = usuarioRepository.findById(usuarioId).get();
		if (objUsuario == null) {
			return ResponseEntity.notFound().build();
		}

		objUsuario.setNomeUsuario(usuario.getNomeUsuario());
		objUsuario.setIdUsuarioFirebase(usuario.getIdUsuarioFirebase());
		//objUsuario.setUsuarioLiga(usuario.getUsuarioLiga());

		Usuario updateUsuario = usuarioRepository.save(objUsuario);
		return ResponseEntity.ok(updateUsuario);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Usuario> deleteUsuario(@PathVariable(value = "id") Long usuarioId) {
		Usuario usuario = usuarioRepository.findById(usuarioId).get();
		if (usuario == null) {
			return ResponseEntity.notFound().build();
		}

		usuarioRepository.delete(usuario);
		return ResponseEntity.ok().build();
	}

}
