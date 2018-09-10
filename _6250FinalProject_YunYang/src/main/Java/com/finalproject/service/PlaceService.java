package com.finalproject.service;

import com.finalproject.dao.PlaceDAO;
import com.finalproject.exception.PlaceException;
import com.finalproject.pojo.Place;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service("placeserviceobj")
public class PlaceService implements ApplicationContextAware {
    PlaceDAO pldao;
    ApplicationContext ctx;

    public void addPlace(Place p) throws PlaceException {
        pldao = (PlaceDAO) ctx.getBean("placedaoobj");
        pldao.addPlace(p);
    }

    public ArrayList<Place> allPlace() throws PlaceException {
        pldao = (PlaceDAO) ctx.getBean("placedaoobj");
        return pldao.allPlace();
    }

    public Place selectPlace(String id) throws PlaceException{
        pldao = (PlaceDAO) ctx.getBean("placedaoobj");
        return pldao.selectPlace(Integer.parseInt(id));
    }

    public boolean deletePlace(String id) throws PlaceException{
        pldao = (PlaceDAO) ctx.getBean("placedaoobj");
        return pldao.deletePlace(Integer.parseInt(id)) == 1;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        ctx = applicationContext;
    }
}
