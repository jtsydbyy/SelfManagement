package com.finalproject.dao;

import com.finalproject.exception.FundException;
import com.finalproject.pojo.Fund;
import com.sun.org.apache.bcel.internal.generic.FADD;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository("funddaoobj")
public class FundDAO {
    public void add(Fund l) throws FundException{
        try {
            FDAO.getSession().beginTransaction();
            FDAO.getSession().save(l);
            FDAO.getSession().getTransaction().commit();
            FDAO.close();
        } catch (HibernateException e) {
            FDAO.rollback();
            throw new FundException("Exception while adding: " + e.getMessage());
        }
    }

    public ArrayList<Fund> allFund() throws FundException{
        try {
            FDAO.getSession().beginTransaction();
            Query q = FDAO.getSession().createQuery("from Fund");
            ArrayList<Fund> funds = (ArrayList<Fund>) q.list();
            FDAO.close();
            return funds;
        } catch (HibernateException e) {
            FDAO.rollback();
            throw new FundException("Exception while searching: " + e.getMessage());

        }
    }

    public int delete(int id) throws FundException{
        try {
            FDAO.getSession().beginTransaction();
            Query q = FDAO.getSession().createQuery("delete from Fund as f where f.id = :id");
            q.setInteger("id", id);
            int d = q.executeUpdate();
            FDAO.close();
            return d;
        } catch (HibernateException e) {
            FDAO.rollback();
            throw new FundException("Exception while check login: " + e.getMessage());

        }
    }

    public int updatePrice(int id, float price) throws FundException{
        try {
            FDAO.getSession().beginTransaction();
            Query q = FDAO.getSession().createQuery("update Fund as f set f.price=:price where f.id = :id");
            q.setFloat("price", price);
            q.setInteger("id", id);
            int d = q.executeUpdate();
            FDAO.close();
            return d;
        } catch (HibernateException e) {
            FDAO.rollback();
            throw new FundException("Exception while check login: " + e.getMessage());

        }
    }

    public int updateQuantity(int id, int quan) throws FundException{
        try {
            FDAO.getSession().beginTransaction();
            Query q = FDAO.getSession().createQuery("update Fund as f set f.quantity=:quantity where f.id = :id");
            q.setInteger("quantity", quan);
            q.setInteger("id", id);
            int d = q.executeUpdate();
            FDAO.close();
            return d;
        } catch (HibernateException e) {
            FDAO.rollback();
            throw new FundException("Exception while check login: " + e.getMessage());

        }
    }

    public Fund select(int id) throws FundException {
        try {
            FDAO.getSession().beginTransaction();
            Query q = FDAO.getSession().createQuery("from Fund as f where f.id = :id");
            q.setInteger("id", id);
            q.setMaxResults(1);
            Fund l = (Fund) q.uniqueResult();
            FDAO.close();
            //System.out.println("test l:"+l);
            return l;
        } catch (HibernateException e) {
            FDAO.rollback();
            throw new FundException("Exception while check login: " + e.getMessage());

        }
    }
}
