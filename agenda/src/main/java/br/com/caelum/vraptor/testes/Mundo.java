package br.com.caelum.vraptor.testes;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Path;


@Controller
public class Mundo {
	
	@Path("/boasVindas")
	public void boasVindas () {
		System.out.println("Olá Mundo!");
	}

}
