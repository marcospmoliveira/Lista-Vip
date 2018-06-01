package br.com.marcos.ListaVip.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

@Entity
public class Convidado {
	@Id
	@GeneratedValue
	private Long id;
	@NotEmpty
	private String nome;
	@NotEmpty
	private String email;
	@NotEmpty
	private String telefone;

	public Convidado() {

	}

	public Convidado(@NotEmpty String nome, @NotEmpty String email, @NotEmpty String telefone) {
		super();
		this.nome = nome;
		this.email = email;
		this.telefone = telefone;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

}
