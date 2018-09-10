package com.finalproject.service;

import com.finalproject.dao.FundDAO;
import com.finalproject.dao.LoginDAO;
import com.finalproject.exception.FundException;
import com.finalproject.pojo.Fund;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service("fundserviceobj")
public class FundService implements ApplicationContextAware  {

    FundDAO fdao;
    ApplicationContext ctx;

    public boolean delete(String id) throws FundException{
        fdao = (FundDAO) ctx.getBean("funddaoobj");
        int d = fdao.delete(Integer.parseInt(id));
        if(d == 1){
            return true;
        }
        else return false;
    }

    public ArrayList<Fund> allFund() throws FundException{
        fdao = (FundDAO) ctx.getBean("funddaoobj");
        ArrayList<Fund> fs = fdao.allFund();
        return fs;
    }

    public Fund select(String id) throws FundException{
        fdao = (FundDAO) ctx.getBean("funddaoobj");
        Fund f = fdao.select(Integer.parseInt(id));
        return f;
    }

    public void addFund(Fund F) throws FundException{
        fdao = (FundDAO) ctx.getBean("funddaoobj");
        fdao.add(F);
    }

    public boolean update(String id, float p, int q) throws FundException{
        fdao = (FundDAO) ctx.getBean("funddaoobj");
        boolean f = true;
        int f1 = fdao.updatePrice(Integer.parseInt(id), p);
        int f2 = fdao.updateQuantity(Integer.parseInt(id), q);
        if(f1 != 1) f = false;
        if(f2 != 1) f = false;
        return f;
    }

    public boolean updateQuantity(String id, int q) throws FundException{
        fdao = (FundDAO) ctx.getBean("funddaoobj");
        boolean f = true;
        int f2 = fdao.updateQuantity(Integer.parseInt(id), q);
        if(f2 != 1) f = false;
        return f;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        ctx = applicationContext;
    }
}
