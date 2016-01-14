
package com.fpmislata.daw2.persistence.hibernate;

import com.fpmislata.daw2.persistence.dao.impl.hibernate.HibernateUtil;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class ServletContextListenerImplHibernate implements ServletContextListener {
    
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        HibernateUtil.buildSessionFactory();
        HibernateUtil.openSessionAndBindToThread();
        System.out.println("\nSESSION OPENED...\n");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        HibernateUtil.closeSessionFactory();
        HibernateUtil.closeSessionAndUnbindFromThread();
        System.out.println("\nSESSION CLOSED...\n");
    }
    
}
