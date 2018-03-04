package br.com.bolao.webapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.bolao.webapi.model.Jogo;

@Repository
public interface JogoRepository extends JpaRepository<Jogo, Long> {

}
