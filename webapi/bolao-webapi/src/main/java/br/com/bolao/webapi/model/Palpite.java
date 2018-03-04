package br.com.bolao.webapi.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@Entity
@Table(name = "palpite")
@EntityListeners(AuditingEntityListener.class)
public class Palpite implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID_PALPITE")
	private Long id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_JOGO", nullable = false)
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private Jogo jogo;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_USUARIO", nullable = false)
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private Usuario usuario;

	@Column(name = "GOLS_MANDANTE")
	private int golsMandante;

	@Column(name = "GOLS_VISITANTE")
	private int golsVisitante;

	@Column(name = "DATA_PALPITE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataPalpite;

}
