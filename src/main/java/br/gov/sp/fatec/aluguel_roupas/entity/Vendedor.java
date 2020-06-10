package br.gov.sp.fatec.aluguel_roupas.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "usu_usuario")
public class Vendedor {
	
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="usu_id")
	private Long id;
	
	@Column(name="usu_nome")
	private String nome;
	
	@Column(name="usu_email")
	private String email;
	
	@Column(name="usu_senha")
	private String senha;

	@OneToMany(fetch = FetchType.LAZY, mappedBy="vendedor")
	private Set<Aluguel> aluguel;

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

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Set<Aluguel> getAluguel() {
		return aluguel;
	}

	public void setAluguel(Set<Aluguel> aluguel) {
		this.aluguel = aluguel;
	}
	
	
}
