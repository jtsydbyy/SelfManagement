package com.finalproject.dao;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class LogDAO {
    private static final Logger log = Logger.getAnonymousLogger();

    private static final ThreadLocal sessionThread = new ThreadLocal();
    private static final SessionFactory sessionFactory = new Configuration().configure("login.cfg.xml").buildSessionFactory();

    protected LogDAO() {
    }

    public static Session getSession()
    {
        Session session = (Session) LogDAO.sessionThread.get();

        if (session == null)
        {
            session = sessionFactory.openSession();
            LogDAO.sessionThread.set(session);
        }
        return session;
    }

    protected void begin() {
        getSession().beginTransaction();
    }

    protected void commit() {
        getSession().getTransaction().commit();
    }

    protected static void rollback() {
        try {
            getSession().getTransaction().rollback();
        } catch (HibernateException e) {
            log.log(Level.WARNING, "Cannot rollback", e);
        }
        try {
            getSession().close();
        } catch (HibernateException e) {
            log.log(Level.WARNING, "Cannot close", e);
        }
        LogDAO.sessionThread.set(null);
    }

    public static void close() {
        getSession().close();
        LogDAO.sessionThread.set(null);
    }
}
