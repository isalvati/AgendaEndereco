package br.com.caelum.vraptor.modelo;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

//Define Entidade e tabela
@Entity
@Table(name = "enderecos")
public class Endereco implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_ENDERECO")
	private int id;
	
	@Column(name = "RUA",length = 255)
	private String rua;
	
	@Column(name = "BAIRRO",length = 45)
	private String bairro;
	
	@Column(name = "TELEFONE",length = 20)
	private String telefone;
	
	@ManyToOne(cascade = {CascadeType.ALL})
	@JoinColumn(name = "id_pessoa")
	private Pessoa pessoa;
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	@Override
	public String toString() {
		return "Endereco [id=" + id + ", rua=" + rua + ", bairro=" + bairro + ", telefone=" + telefone + ", pessoa="
				+ pessoa.getId() + "]";
	}
	

}
