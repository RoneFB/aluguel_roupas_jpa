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
@Table(name="cli_cliente")
public class Cliente {
	
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="cli_id")
	private Long id;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy="cliente")
	private Set<Aluguel> aluguel;
	
	@Column(name="cli_nome")
	private String nome;
	
	@Column(name="cli_email")
	private String email;
	
	@Column(name="cli_cpf")
	private String cpf;
	
	@Column(name="cli_idade")
	private Integer idade;
	
	@Column(name="cli_bairro")
	private String bairro;
	
	@Column(name="cli_rua")
	private String rua;
	
	@Column(name="cli_numero")
	private Integer numero;
	
	@Column(name="cli_cidade")
	private String cidade;
	
	@Column(name="cli_telefone")
	private String telefone;
	
		public Cliente(String nome, String email, String cpf, Integer idade, String bairro, String rua, Integer numero,
			String cidade, String telefone) {
		super();
		this.nome = nome;
		this.email = email;
		this.cpf = cpf;
		this.idade = idade;
		this.bairro = bairro;
		this.rua = rua;
		this.numero = numero;
		this.cidade = cidade;
		this.telefone = telefone;
	}


	public Cliente() {
			super();
		}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}

	public Set<Aluguel> getAluguel() {
		return aluguel;
	}

	public void setAluguel(Set<Aluguel> aluguel) {
		this.aluguel = aluguel;
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

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Integer getIdade() {
		return idade;
	}

	public void setIdade(Integer idade) {
		this.idade = idade;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	
	
	
}
