package br.com.agendabelem.persistencia;

import br.com.agendabelem.model.Festa;
import java.util.List;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author andre
 */
public class FestaDAO extends GenericDAO<Festa> {

    public FestaDAO() {
        this.criteria = session.createCriteria(Festa.class);
    }

    public List<Festa> buscarTodos() {
        return this.buscarTodos(Festa.class);
    }
       
    public List<Festa> pesquisar(String propriedade, String valor) {
        System.out.println("Buscando todos os " + propriedade + "s do banco com valor = " + valor);
        this.criteria.add(Restrictions.like(propriedade, valor, MatchMode.ANYWHERE));
        return this.criteria.list();
    }
    
    public Festa buscar(Long id) {
        return this.buscar(Festa.class, id);
    }
    
    public Festa buscar(String id) {
        try {
            Long search = new Long(id);
            Festa resultado = this.buscar(Festa.class, search);
            return resultado;
        } catch (NumberFormatException e) {
            return new Festa();
        }
        
    }
}
