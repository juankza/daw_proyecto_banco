
package com.fpmislata.daw2.persistence.dao.impl.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.context.internal.ThreadLocalSessionContext;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtil {
    private static SessionFactory sessionFactory;

    public static synchronized void buildSessionFactory() {
        Configuration configuration = new Configuration();
        configuration.configure();
        configuration.setProperty("hibernate.current_session_context_class", "thread");
        
        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
        sessionFactory = configuration.buildSessionFactory(serviceRegistry);
    }

    public static SessionFactory getSessionFactory() {
        if(sessionFactory == null || sessionFactory.isClosed()) {
            buildSessionFactory();
        }
        return sessionFactory;
    }

    public static void closeSessionFactory() {
        if(sessionFactory != null || !sessionFactory.isClosed()) {
            sessionFactory.close();
        }
    }
    
    public static void openSessionAndBindToThread() {
        Session session = sessionFactory.openSession();
        ThreadLocalSessionContext.bind(session);
    }
    
    public static void closeSessionAndUnbindFromThread() {
        Session session = ThreadLocalSessionContext.unbind(sessionFactory);
        
        if ((session != null) && session.isOpen()) {
            session.close();
        }
    }
    
}
