package br.com.agendabelem.rest;

import br.com.agendabelem.model.Festa;
import br.com.agendabelem.persistencia.FestaDAO;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author andre
 */
@Path("/festa")
public class FestaService {
    
    List<Festa> festas = Arrays.asList(new Festa("XOC", 15), new Festa("Dead Fish", 20),
            new Festa("Dread Mar", 25), new Festa("Fronteira", 40), new Festa("Cafe com Arte", 20),
            new Festa("Scorpions", 5), new Festa("Mormaco", 15), new Festa("African Bar", 10));        
    FestaDAO dao = new FestaDAO();
    
    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Festa getFesta(@PathParam("id") String id) {
//        Festa festa = new Festa("A Noite do Coelho Doido", 30);
        return dao.buscar(id);
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Festa> buscarTodasAsFestas() {
        List<Festa> result = dao.buscarTodos();
        return result;
    }
    
    @GET
    @Path("pesquisar/{query}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Festa> buscarFestas(@PathParam("query") String query) {
        return dao.pesquisar("nome", query);
    }
    
    public List<Festa> filtrar(String nome) {
        List<Festa> resultado = new ArrayList<Festa>();
        for (Festa festa : festas) {
            String nomeFesta = festa.getNome().toLowerCase();
            if(nomeFesta.contains(nome.toLowerCase())) {
                resultado.add(festa);
            }
        }
        return resultado;
    }
    
}
