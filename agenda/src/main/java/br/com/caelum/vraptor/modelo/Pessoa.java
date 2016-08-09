package br.com.caelum.vraptor.modelo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.FlushModeType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "pessoas")
public class Pessoa implements Serializable{



	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_PESSOA")
	private int id;

	@Column(name = "LOGIN", length = 255)
	private String login;

	@Column(name = "STATUS")
	private boolean status;

	@Column(name = "NOME", length = 45)
	private String nome;

	@Column(name = "CPF", length = 14)
	private String cpf;

	@Column(name = "DATA_NASCIMENTO", length = 14)
	private String dataNascimento;

	@OneToMany(mappedBy = "pessoa",cascade = CascadeType.ALL)
	private List<Endereco> enderecos;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(String dastaNascimento) {
		this.dataNascimento = dastaNascimento;
	}

	public List<Endereco> getEnderecos() {
		return enderecos;
	}

	public void setEnderecos(List<Endereco> enderecos) {
		this.enderecos = enderecos;
	}
	
	@Override
	public String toString() {
		return "Pessoa [id=" + id + ", login=" + login + ", status=" + status + ", nome=" + nome + ", cpf=" + cpf
				+ ", dataNascimento=" + dataNascimento + ", enderecos=" + enderecos.toString() + "]";
	}

}
