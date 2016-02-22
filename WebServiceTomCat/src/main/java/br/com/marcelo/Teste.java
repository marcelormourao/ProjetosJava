package br.com.marcelo;

import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("teste")
public class Teste {
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Pessoa> teste(){
		ArrayList<Pessoa> pessoas = new ArrayList<Pessoa>();
	 	pessoas.add(new Pessoa(1, "Marcelo"));
		pessoas.add(new Pessoa(2, "Eliana"));
		
		return pessoas;
	}
}
