package com.finalproject.dao;

import com.finalproject.exception.PlaceException;
import com.finalproject.exception.SalesException;
import com.finalproject.pojo.Customer;
import com.finalproject.pojo.Place;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository("placedaoobj")
public class PlaceDAO {

    public ArrayList<Place> allPlace() throws PlaceException {
        try {
            PDAO.getSession().beginTransaction();
            Query q = PDAO.getSession().createQuery("from Place");
            ArrayList<Place> cs = (ArrayList<Place>) q.list();
            PDAO.close();
            return cs;
        } catch (HibernateException e) {
            PDAO.rollback();
            throw new PlaceException("Exception while searching: " + e.getMessage());

        }
    }

    public void addPlace(Place p) throws PlaceException {
        try {
            PDAO.getSession().beginTransaction();
            PDAO.getSession().save(p);
            PDAO.getSession().getTransaction().commit();
            PDAO.close();
        } catch (HibernateException e) {
            PDAO.rollback();
            throw new PlaceException("Exception while adding: " + e.getMessage());
        }
    }

    public Place selectPlace(int id) throws PlaceException{
        try {
            PDAO.getSession().beginTransaction();
            Query q = PDAO.getSession().createQuery("from Place as f where f.id = :id");
            q.setInteger("id", id);
            q.setMaxResults(1);
            Place l = (Place) q.uniqueResult();
            PDAO.close();
            //System.out.println("test l:"+l);
            return l;
        } catch (HibernateException e) {
            PDAO.rollback();
            throw new PlaceException("Exception while check login: " + e.getMessage());

        }
    }

    public int deletePlace(int id) throws PlaceException{
        try {
            PDAO.getSession().beginTransaction();
            Query q = PDAO.getSession().createQuery("delete from Place as l where l.id = :id");
            q.setInteger("id", id);
            int d = q.executeUpdate();
            PDAO.close();
            return d;
        } catch (HibernateException e) {
            PDAO.rollback();
            throw new PlaceException("Exception while check login: " + e.getMessage());

        }
    }
}
