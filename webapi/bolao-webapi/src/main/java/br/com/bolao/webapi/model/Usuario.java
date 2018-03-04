package br.com.bolao.webapi.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

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

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.Data;

@Data
@Entity
@Table(name = "usuario")
@EntityListeners(AuditingEntityListener.class)
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, 
property  = "id", 
scope     = Long.class)
public class Usuario implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID_USUARIO")
	private Long id;

	@Column(name = "ID_USUARIO_FIREBASE")
	@NotBlank
	private String idUsuarioFirebase;

	@Column(name = "NOME_USUARIO")
	@NotBlank
	private String nomeUsuario;

	@Column(name = "EMAIL")
	@NotBlank
	private String email;

	@Column(name = "LOGIN")
	@NotBlank
	private String login;

	@Column(name = "DATA_CRIACAO_USUARIO", nullable = false, updatable = false)
	@Temporal(TemporalType.TIMESTAMP)
	@CreatedDate
	private Date dataCriacaoUsuario;

	@OneToMany(mappedBy = "usuario")
	@JsonManagedReference(value="usuario-liga")
	private List<UsuarioLiga> usuarioLiga;

}
