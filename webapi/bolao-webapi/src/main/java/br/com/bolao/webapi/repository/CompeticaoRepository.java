package br.com.bolao.webapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.bolao.webapi.model.Competicao;

@Repository
public interface CompeticaoRepository extends JpaRepository<Competicao, Long> {

}
