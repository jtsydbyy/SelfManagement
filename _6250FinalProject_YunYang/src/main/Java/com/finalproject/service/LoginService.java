package com.finalproject.service;

import com.finalproject.dao.LoginDAO;
import com.finalproject.exception.LoginException;
import com.finalproject.pojo.Login;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service("logserviceobj")
public class LoginService implements ApplicationContextAware{
    LoginDAO lgdao;
    ApplicationContext ctx;

    public Login checkLog(String username, String password) throws LoginException{
        lgdao = (LoginDAO) ctx.getBean("logindaoobj");
        Login l = (Login)lgdao.checkLog(username);
        if(l != null){
            if(l.getPassword().equals(password))
                return l;
            else
                return null;
        }
        else{
            //System.out.println("new error"+l);
            return null;
        }

    }

    public ArrayList<Login> allpeople() throws LoginException{
        lgdao = (LoginDAO) ctx.getBean("logindaoobj");
        ArrayList<Login> users = (ArrayList<Login>) lgdao.allpeople();
        return users;
    }

    public boolean delete(String id) throws LoginException{
        lgdao = (LoginDAO) ctx.getBean("logindaoobj");
        int d = lgdao.delete(Integer.parseInt(id));
        if(d == 1){
            return true;
        }
        else return false;
    }

    //use later
    public void register(Login l) throws LoginException{
        lgdao = (LoginDAO) ctx.getBean("logindaoobj");
        lgdao.register(l);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException{
        ctx = applicationContext;
    }
}
