package br.caelum.vpator.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;

import br.com.caelum.vraptor.modelo.Pessoa;

public class PessoaDAO {
private Session session;
	
	private void abrirConexao() {
		this.session = SessionSingleton.getFactory().openSession();
		session.beginTransaction();
	}

	private void fecharConexao() {
		this.session.getTransaction().commit();
		this.session.close();
	}
	
	
	public void addPessoa (Pessoa pessoa) {
		abrirConexao();
		this.session.save(pessoa);
		fecharConexao();
	}
	
	public List <Pessoa> listPessoa () {
		List <Pessoa> retorno = new ArrayList <Pessoa> ();

		abrirConexao();
		Criteria crit = this.session.createCriteria(Pessoa.class);
		retorno = crit.list();
		fecharConexao();
		return retorno;
	}
}
