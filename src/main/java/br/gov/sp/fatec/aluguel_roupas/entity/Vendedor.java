package br.gov.sp.fatec.aluguel_roupas.entity;

import java.util.Set;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "usu_usuario")
@AttributeOverride(name = "id", column = @Column(name = "usu_id"))
public class Vendedor extends BaseEntity{
	
	@Column(name="usu_nome")
	private String nome;
	
	@Column(name="usu_email")
	private String email;
	
	@Column(name="usu_senha")
	private String senha;

	@OneToMany(fetch = FetchType.LAZY, mappedBy="vendedor")
	private Set<Aluguel> aluguel;

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
