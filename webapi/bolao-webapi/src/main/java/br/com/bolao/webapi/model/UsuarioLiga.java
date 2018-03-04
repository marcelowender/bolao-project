package br.com.bolao.webapi.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Data;

@Data
@Entity
@Table(name = "usuario_liga")
@EntityListeners(AuditingEntityListener.class)

public class UsuarioLiga implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@ManyToOne
	@JoinColumn(name = "ID_USUARIO")
	@JsonBackReference(value = "usuario-liga")
	private Usuario usuario;

	@Id
	@ManyToOne
	@JoinColumn(name = "ID_LIGA")
	@JsonBackReference(value = "liga-usuario")
	private Liga liga;

	@Column(name = "DATA_ENTRADA_LIGA", nullable = false, updatable = false)
	@Temporal(TemporalType.TIMESTAMP)
	@CreatedDate
	private Date dataCriacaoUsuario;

}
