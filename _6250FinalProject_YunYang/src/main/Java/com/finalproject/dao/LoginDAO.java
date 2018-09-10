package com.finalproject.dao;

import com.finalproject.exception.LoginException;
import com.finalproject.pojo.Login;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository("logindaoobj")
public class LoginDAO {
    public Login checkLog(String username) throws LoginException {
        try {
            LogDAO.getSession().beginTransaction();
            Query q = LogDAO.getSession().createQuery("from Login as l where l.username = :username");
            q.setString("username", username);
            q.setMaxResults(1);
            Login l = (Login) q.uniqueResult();
            LogDAO.close();
            //System.out.println("test l:"+l);
            return l;
        } catch (HibernateException e) {
            LogDAO.rollback();
            throw new LoginException("Exception while check login: " + e.getMessage());

        }
    }

    public ArrayList<Login> allpeople() throws LoginException{
        try {
            LogDAO.getSession().beginTransaction();
            Query q = LogDAO.getSession().createQuery("from Login");
            ArrayList<Login> users = (ArrayList<Login>) q.list();
            LogDAO.close();
            return users;
        } catch (HibernateException e) {
            LogDAO.rollback();
            throw new LoginException("Exception while check login: " + e.getMessage());

        }
    }

    public int delete(int id) throws LoginException{
        try {
            LogDAO.getSession().beginTransaction();
            Query q = LogDAO.getSession().createQuery("delete from Login as l where l.id = :id");
            q.setInteger("id", id);
            int d = q.executeUpdate();
            LogDAO.close();
            return d;
        } catch (HibernateException e) {
            LogDAO.rollback();
            throw new LoginException("Exception while check login: " + e.getMessage());

        }
    }

    //use later
    public void register(Login l) throws LoginException{
        try {
            LogDAO.getSession().beginTransaction();
            LogDAO.getSession().save(l);
            LogDAO.getSession().getTransaction().commit();
            LogDAO.close();
        } catch (HibernateException e) {
            LogDAO.rollback();
            throw new LoginException("Exception while register: " + e.getMessage());
        }
    }
}
