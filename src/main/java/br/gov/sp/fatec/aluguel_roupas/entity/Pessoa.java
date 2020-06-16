package br.gov.sp.fatec.aluguel_roupas.entity;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="pe_pessoa")
@AttributeOverride(name = "id", column = @Column(name = "alu_id"))
public class Pessoa extends BaseEntity{
	
	@Column(name="pe_nome")
	private String nome;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	
	
}
