package com.finalproject.dao;

import com.finalproject.exception.SalesException;
import com.finalproject.pojo.Customer;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository("salesdaoobj")
public class SalesDAO {

    public ArrayList<Customer> allCustomer() throws SalesException{
        try {
            SLDAO.getSession().beginTransaction();
            Query q = SLDAO.getSession().createQuery("from Customer");
            ArrayList<Customer> cs = (ArrayList<Customer>) q.list();
            SLDAO.close();
            return cs;
        } catch (HibernateException e) {
            SLDAO.rollback();
            throw new SalesException("Exception while searching: " + e.getMessage());

        }
    }

    public void addCustomer(Customer l) throws SalesException{
        try {
            SLDAO.getSession().beginTransaction();
            SLDAO.getSession().save(l);
            SLDAO.getSession().getTransaction().commit();
            SLDAO.close();
        } catch (HibernateException e) {
            SLDAO.rollback();
            throw new SalesException("Exception while adding: " + e.getMessage());
        }
    }

    public Customer select(int cid) throws SalesException {
        try {
            SLDAO.getSession().beginTransaction();
            Query q = SLDAO.getSession().createQuery("from Customer as f where f.cid = :cid");
            q.setInteger("cid", cid);
            q.setMaxResults(1);
            Customer l = (Customer) q.uniqueResult();
            SLDAO.close();
            //System.out.println("test l:"+l);
            return l;
        } catch (HibernateException e) {
            SLDAO.rollback();
            throw new SalesException("Exception while check login: " + e.getMessage());

        }
    }

    public int updateEmail(int cid, String email) throws SalesException{
        try {
            SLDAO.getSession().beginTransaction();
            Query q = SLDAO.getSession().createQuery("update Customer as f set f.email=:email where f.cid = :cid");
            q.setString("email", email);
            q.setInteger("cid", cid);
            int d = q.executeUpdate();
            SLDAO.close();
            return d;
        } catch (HibernateException e) {
            SLDAO.rollback();
            throw new SalesException("Exception while check login: " + e.getMessage());

        }
    }

    public int delete(int cid) throws SalesException{
        try {
            SLDAO.getSession().beginTransaction();
            Query q = SLDAO.getSession().createQuery("delete from Customer as c where c.cid = :cid");
            q.setInteger("cid", cid);
            int d = q.executeUpdate();
            SLDAO.close();
            return d;
        } catch (HibernateException e) {
            SLDAO.rollback();
            throw new SalesException("Exception while check login: " + e.getMessage());

        }
    }
}
