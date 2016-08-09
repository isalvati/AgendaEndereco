package br.caelum.vpator.dao;




import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;

import br.com.caelum.vraptor.modelo.Endereco;
import br.com.caelum.vraptor.modelo.Pessoa;


public class EnderecoDAO {
	
	private Session session;
	
	private void abrirConexao() {
		this.session = SessionSingleton.getFactory().openSession();
		session.beginTransaction();
	}

	private void fecharConexao() {
		this.session.getTransaction().commit();
		this.session.close();
	}
	
	
	public void addEndereco (Endereco end) {
		Pessoa pessoa = new Pessoa ();
		
//		Endereco endereco = new Endereco();
//		endereco.setBairro("Centro");
//		endereco.setRua("Paula a Costa");
//		endereco.setTelefone("3861-1767");
		
		pessoa.setNome("Paula");
		
		
		end.setPessoa(pessoa);
		
		
		abrirConexao();
			this.session.save(pessoa);
		fecharConexao();
		abrirConexao();
			this.session.save(end);
		fecharConexao();
	}
	
	public List <Endereco> retornaEnd () {
		List <Endereco> retorno = new ArrayList <Endereco> ();

		abrirConexao();
		Criteria crit = this.session.createCriteria(Endereco.class);
		retorno = crit.list();
		fecharConexao();


		return retorno;
	}
	
	@SuppressWarnings("unchecked")
	public List<Endereco> retornaEnderecosUsuario(int idPessoa){
		abrirConexao();
		List<Endereco> e = new ArrayList<Endereco>();
		
		e = (List<Endereco>)this.session.createSQLQuery("select * from enderecos e where e.id_pessoa = :id_pessoa")
				.setParameter("id_pessoa", idPessoa)
				.addEntity(Endereco.class).getResultList();
		
		//e = this.session.createQuery("select * from enderecos e where e.id_pessoa = :id_pessoa", Endereco.class)
		//.setParameter("id_pessoa", idPessoa)
		//.getResultList();
		fecharConexao();
		return e;
	}
	
	
}
