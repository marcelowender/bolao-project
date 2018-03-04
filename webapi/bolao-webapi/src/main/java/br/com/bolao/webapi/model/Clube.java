package br.com.bolao.webapi.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.Data;

@Data
@Entity
@Table(name = "clube")
@EntityListeners(AuditingEntityListener.class)

public class Clube implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID_CLUBE")
	private Long id;

	@Column(name = "NOME_CLUBE")
	@NotBlank
	private String nomeClube;

	@Column(name = "UF_CLUBE")
	private String ufClube;

	@Column(name = "NOME_LOGO_CLUBE")
	private String nomeLogoClube;

	@Column(name = "PAIS_CLUBE")
	private String paisClube;

}
