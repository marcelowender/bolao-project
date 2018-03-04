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
@Table(name = "jogo")
@EntityListeners(AuditingEntityListener.class)
public class Jogo implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID_JOGO")
	private Long id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_COMPETICAO", nullable = false)
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	private Competicao competicao;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_CLUBE_MANDANTE", nullable = false)
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	private Clube clubeMandante;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_CLUBE_VISITANTE", nullable = false)
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private Clube clubeVisitante;

	@Column(name = "GOLS_MANDANTE")
	private Integer golsMandante;

	@Column(name = "GOLS_VISITANTE")
	private Integer golsVisitante;

	@Column(name = "DATA_JOGO")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataJogo;

}
