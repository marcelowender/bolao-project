package br.com.bolao.webapi.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Data;

@Data
@Entity
@Table(name = "competicao")
@EntityListeners(AuditingEntityListener.class)
public class Competicao implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID_COMPETICAO")
	private Long id;

	@Column(name = "NOME_COMPETICAO")
	@NotBlank
	private String nomeCompeticao;

	@Column(name = "DATA_INICIO_COMPETICAO", nullable = false, updatable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataInicioCompeticao;

	@Column(name = "DATA_FIM_COMPETICAO")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataFimCompeticao;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "competicao")
	@JsonManagedReference (value="competicao-liga")
	private List<Liga> liga;

}
