package com.finalproject.service;

import com.finalproject.dao.SalesDAO;
import com.finalproject.exception.SalesException;
import com.finalproject.pojo.Customer;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service("salesserviceobj")
public class SalesService implements ApplicationContextAware {

    SalesDAO sdao;
    ApplicationContext ctx;

    public ArrayList<Customer> allCustomer() throws SalesException {
        sdao = (SalesDAO) ctx.getBean("salesdaoobj");
        ArrayList<Customer> cs = sdao.allCustomer();
        return cs;
    }

    public void addCustomer(Customer c) throws SalesException{
        sdao = (SalesDAO) ctx.getBean("salesdaoobj");
        sdao.addCustomer(c);
    }


    public Customer select(String id) throws SalesException{
        sdao = (SalesDAO) ctx.getBean("salesdaoobj");
        Customer f = sdao.select(Integer.parseInt(id));
        return f;
    }

    public boolean delete(String id) throws SalesException{
        sdao = (SalesDAO) ctx.getBean("salesdaoobj");
        int d = sdao.delete(Integer.parseInt(id));
        if(d == 1){
            return true;
        }
        else return false;
    }

    public boolean update(String id, String email) throws SalesException{
        sdao = (SalesDAO) ctx.getBean("salesdaoobj");
        int d = sdao.updateEmail(Integer.parseInt(id), email);
        if(d == 1){
            return true;
        }
        else return false;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        ctx = applicationContext;
    }
}
