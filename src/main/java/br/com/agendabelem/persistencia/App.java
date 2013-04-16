package br.com.agendabelem.persistencia;

import br.com.agendabelem.model.Festa;
import org.hibernate.Session;

/**
 *
 * @author andre
 */
public class App {
    public static void main(String[] args) {
        System.out.println("Maven + Hibernate + MySQL");
        Session session = HibernateUtil.getSessionFactory().openSession();

//        Criando o banco de dados
//        Configuration conf = new AnnotationConfiguration();
//        conf.configure();
//        SchemaExport se = new SchemaExport(conf);
//        se.create(true, true);

        FestaDAO dao = new FestaDAO();        
        System.out.println(dao.buscarTodos());        
        
        dao.salvar(new Festa("Fronteira", 40));
        
//        session.beginTransaction();
//        Festa festa = new Festa("A Noite do Coelho Doido", 25);
//        
//        session.save(festa);
//        session.getTransaction().commit();
    }
}
