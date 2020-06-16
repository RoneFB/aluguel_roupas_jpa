package br.gov.sp.fatec.aluguel_roupas.entity;

import java.util.Set;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="rou_roupa")
@AttributeOverride(name = "id", column = @Column(name = "alu_id"))
public class Roupa extends BaseEntity{
	
	
	
	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "roupas")
	private Set<Aluguel> aluguel;
	
	@Column(name="rou_tipo")
	private String tipo;
	
	@Column(name="rou_cor")
	private String cor;
	
	@Column(name="rou_tamanho")
	private String tamanho;
	
	@Column(name="rou_preco")
	private double preco;
	
	public Roupa(String tipo, String cor, String tamanho, double preco) {
		super();
		this.tipo = tipo;
		this.cor = cor;
		this.tamanho = tamanho;
		this.preco = preco;
	}
	
	

	public Roupa() {
		super();
	}

	public Set<Aluguel> getAluguel() {
		return aluguel;
	}

	public void setAluguel(Set<Aluguel> aluguel) {
		this.aluguel = aluguel;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public String getTamanho() {
		return tamanho;
	}

	public void setTamanho(String tamanho) {
		this.tamanho = tamanho;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}
	
	
}
