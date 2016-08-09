package br.com.caelum.vraptor.controller;

import javax.inject.Inject;

import static br.com.caelum.vraptor.view.Results.*;

import java.util.ArrayList;
import java.util.List;

import br.caelum.vpator.dao.EnderecoDAO;
import br.com.caelum.vraptor.Consumes;
import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.modelo.Endereco;
import br.com.caelum.vraptor.modelo.Pessoa;
import br.com.caelum.vraptor.serialization.gson.WithoutRoot;

import org.jboss.logging.Logger;

@Controller
public class EnderecoController {
	
	
	private static Logger LOGGER = Logger.getLogger(EnderecoController.class);
	
	@Inject
	private Result result;
	
	@Post
	@Path("/enderecos")
	@Consumes(value = "application/json")
	public void addEndereco(Endereco end) {
	
		
		EnderecoDAO endDAO = new EnderecoDAO();
		
		LOGGER.info("Rua :" + end.getRua());
		
		endDAO.addEndereco(end);
	}
	
	
	@Get("/enderecos")
	public void listarEnd () {
		EnderecoDAO endDAO = new EnderecoDAO();
		List<Endereco> end = new ArrayList<Endereco>();
		end = endDAO.retornaEnd();
		
		result.use(json()).from(end).serialize();
	}
	
	/*@Get("/enderecos")
	public void listarEnderecosUsuario (int idUsuario) {
		EnderecoDAO endDAO = new EnderecoDAO();
		List<Endereco> end = new ArrayList<Endereco>();
		end = endDAO.retornaEnderecosUsuario(idUsuario);
		
		result.use(json()).from(end).serialize();
	}*/

}
