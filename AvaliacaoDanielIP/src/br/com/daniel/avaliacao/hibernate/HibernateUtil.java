
package br.com.daniel.avaliacao.hibernate;


import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;


public class HibernateUtil {
    private static final SessionFactory sessionFactory;

    static {

		org.apache.log4j.BasicConfigurator.configure();
        try {
            Configuration configuration = new Configuration().configure(MainBD.class.getResource("hibernate.cfg.xml"));
            StandardServiceRegistryBuilder registry = new StandardServiceRegistryBuilder();
            registry.applySettings(configuration.getProperties());
            
            sessionFactory = configuration.buildSessionFactory(registry.build());
        } catch (Throwable ex) {
            
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
