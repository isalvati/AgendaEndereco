package br.caelum.vpator.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.jboss.logging.Logger;

import br.com.caelum.vraptor.controller.EnderecoController;
import br.com.caelum.vraptor.modelo.Pessoa;

public class PessoaDAO {
private Session session;
private static Logger LOGGER = Logger.getLogger(PessoaDAO.class);
	
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
	
	public Pessoa findPessoa (int id) {
		Pessoa p = new Pessoa();
		LOGGER.info("pessoaDAO LOGIN: " + id);
		abrirConexao();
		//Criteria crit = this.session.createCriteria(Pessoa.class);
		p = this.session.find(Pessoa.class, id);
		fecharConexao();
		return p;
	}
	
	public Pessoa findPessoa (String login) {
		Pessoa p = new Pessoa();
		LOGGER.info("pessoaDAO ID: " + login);
		abrirConexao();
		//Criteria crit = this.session.createCriteria(Pessoa.class);
		p = this.session.createQuery("select p from Pessoa p where p.login = :login", Pessoa.class)
		.setParameter("login", login)
		.getSingleResult();
		fecharConexao();
		return p;
	}
}
