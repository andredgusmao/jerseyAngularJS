package br.com.agendabelem.persistencia;

import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;

/**
 *
 * @author andre
 */
public abstract class GenericDAO<T> {
    
    protected Session session;
    protected Criteria criteria;

    public GenericDAO() {
        getSession();        
    }
    
    public boolean salvar(T t) {
        System.out.println("Salvando " + t.getClass().getSimpleName() + " no banco.");
        beginTransaction().save(t);
        commitTransaction();
        return true;
    }
    
    public boolean remover(T t) {
        System.out.println("Removendo " + t.getClass().getSimpleName() + " do banco.");        
        return true;
    }
    
    protected T buscar(Class<T> type, Long id) {
        T t = (T) this.session.load(type, id);
        System.out.println("----> " + t);
        return t;
    }
    
    protected <T> List<T> buscarTodos(Class<T> type) {
        System.out.println("Buscando todos os " + type.getSimpleName() + "s do banco.");
        this.criteria = session.createCriteria(type);
        return criteria.list();
    }
    
    public final Session getSession() {
        this.session = HibernateUtil.getSessionFactory().openSession();
        return session;
    }    

    public Session beginTransaction() {
        session.beginTransaction();
        return session;
    }
    
    public void commitTransaction() {
        session.getTransaction().commit();
    }
}
