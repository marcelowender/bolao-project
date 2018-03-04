package br.com.bolao.webapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.bolao.webapi.model.Palpite;

@Repository
public interface PalpiteRepository extends JpaRepository<Palpite, Long> {

}
