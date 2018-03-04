package br.com.bolao.webapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.bolao.webapi.model.Liga;

@Repository
public interface LigaRepository extends JpaRepository<Liga, Long> {

}
