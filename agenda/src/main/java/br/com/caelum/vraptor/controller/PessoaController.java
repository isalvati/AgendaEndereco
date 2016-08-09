package br.com.caelum.vraptor.controller;

import static br.com.caelum.vraptor.view.Results.json;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.jboss.logging.Logger;

import br.caelum.vpator.dao.EnderecoDAO;
import br.caelum.vpator.dao.PessoaDAO;
import br.com.caelum.vraptor.Consumes;
import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.modelo.Endereco;
import br.com.caelum.vraptor.modelo.Pessoa;
import br.com.caelum.vraptor.view.Results;
import br.com.caelum.vraptor.boilerplate.bean.Response;

@Controller
public class PessoaController {
private static Logger LOGGER = Logger.getLogger(PessoaController.class);
	
	@Inject
	private Result result;
	
	@Post
	@Path("/pessoas")
	@Consumes(value = "application/json")
	public void addPessoa(Pessoa pessoa) {
	
		
		PessoaDAO pessoaDAO = new PessoaDAO();
		
		LOGGER.info("Nome: " + pessoa.getNome());
		
		pessoaDAO.addPessoa(pessoa);
	}
	
	
	@Get("/pessoas")
	public void listarPessoas () {
		PessoaDAO pessoaDAO = new PessoaDAO();
		List<Pessoa> pessoa = new ArrayList<Pessoa>();
		pessoa = pessoaDAO.listPessoa();
		
		/*this.result.use(Results.json())
		.withoutRoot()
		.from(new Response<List<Pessoa>>(true, "", null, pessoa))
		.recursive().serialize();
		this.result.nothing();*/
		
		
		
		result.use(json()).from(pessoa).serialize();
	}
	
	
	/*@Get("/pessoas/{pessoa.id}")
	public void findPessoa (Pessoa pessoa) {
		PessoaDAO pessoaDAO = new PessoaDAO();
		Pessoa pessoa1 = new Pessoa();
		pessoa1 = pessoaDAO.findPessoa(pessoa.getId());
		LOGGER.info("ID: " + pessoa.getId());
		result.use(json()).from(pessoa1).serialize();
	}*/
	
	@Get("/pessoas/{pessoa.login}")
	public void findPessoa (Pessoa pessoa) {
		PessoaDAO pessoaDAO = new PessoaDAO();
		Pessoa pessoa1 = new Pessoa();
		pessoa1 = pessoaDAO.findPessoa(pessoa.getLogin());
		
		/*EnderecoDAO endDAO = new EnderecoDAO();
		List<Endereco> listEnd = endDAO.retornaEnderecosUsuario(pessoa1.getId());
		pessoa1.setEnderecos(listEnd);*/

		
		LOGGER.info("LOGIN: " + pessoa1.getLogin());
		LOGGER.info("Enderecos :" + pessoa1.getEnderecos().toString());
		//result.include("pessoa", pessoa);
		
		

		/*this.result.use(Results.json())
		.withoutRoot()
		.from(new Response<Pessoa>(true, "", null, pessoa))
		.recursive().serialize();
		this.result.nothing();*/
		
		result.use(json()).from(pessoa1).serialize();
		//result.use(json()).from(listEnd).serialize();
	}
	
	@Get("/pessoasEndereco/{pessoa.login}")
	public void listaEnderecosPessoa (Pessoa pessoa) {
		PessoaDAO pessoaDAO = new PessoaDAO();
		Pessoa pessoa1 = new Pessoa();
		pessoa1 = pessoaDAO.findPessoa(pessoa.getLogin());
		
		EnderecoDAO endDAO = new EnderecoDAO();
		List<Endereco> listEnd = endDAO.retornaEnderecosUsuario(pessoa1.getId());
		pessoa1.setEnderecos(listEnd);

		
		LOGGER.info("LOGIN: " + pessoa1.getLogin());
		LOGGER.info("Enderecos :" + pessoa1.getEnderecos().toString());
		//result.include("pessoa", pessoa);
		
		//result.use(json()).from(pessoa1).serialize();
		result.use(json()).from(listEnd).serialize();
	}
	
	@Get("/pessoasEndereco")
	public void listarPessoasEndereco () {
		PessoaDAO pessoaDAO = new PessoaDAO();
		List<Pessoa> pessoa = new ArrayList<Pessoa>();
		pessoa = pessoaDAO.listPessoa();
		EnderecoDAO endDAO = new EnderecoDAO();
		for(int i=0; i < pessoa.size(); i++){
			List<Endereco> listEnd = new ArrayList<Endereco>();
			listEnd = (List<Endereco>) endDAO.retornaEnderecosUsuario(pessoa.get(i).getId());
			pessoa.get(i).setEnderecos(listEnd);
			LOGGER.info("Enderecos :" + pessoa.get(i).getEnderecos().toString());
		}
		
		result.use(json()).from(pessoa).serialize();
	}
}
