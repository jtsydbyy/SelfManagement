package com.finalproject.controller;

import com.finalproject.dao.SLDAO;
import com.finalproject.pojo.Customer;
import com.finalproject.service.AddCustomerValidator;
import com.finalproject.service.AddFundValidator;
import com.finalproject.service.SalesService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@Controller
public class SalesController implements ApplicationContextAware {
    private static ApplicationContext ctx;

    @RequestMapping(value = "toSales.do", method = RequestMethod.GET)
    protected ModelAndView toSales(HttpServletRequest request, HttpServletResponse response) throws Exception {
        return new ModelAndView("Salesman");
    }

    @RequestMapping(value = "toCustomer.do", method = RequestMethod.GET)
    protected ModelAndView toCustomer(HttpServletRequest request, HttpServletResponse response) throws Exception {
        SalesService ss = (SalesService) ctx.getBean("salesserviceobj");
        ArrayList<Customer> cs = ss.allCustomer();
        if(cs == null){
            return new ModelAndView("SLError");
        }
        else{
            int n = cs.size();
            Map<String, Object> map = new HashMap<>();
            map.put("all", cs);
            map.put("num",n);
            return new ModelAndView("SLCustomer","map",map);
        }
    }


    @Autowired
    @Qualifier("addcustomervalidatorobj")
    AddCustomerValidator validator;

    @InitBinder
    private void initBinder(WebDataBinder binder) {
        binder.setValidator(validator);
    }

    @RequestMapping(value = "addCustomer.do", method = RequestMethod.POST)
    protected ModelAndView addCustomer(
            @ModelAttribute("customer")Customer customer,
            BindingResult result) throws Exception {

        validator.validate(customer, result);

        if(result.hasErrors()){
            return new ModelAndView("SLCUSError");
        }
        SalesService ss = (SalesService) ctx.getBean("salesserviceobj");
        ArrayList<Customer> cs = ss.allCustomer();

        int idn;
        while(true){
            boolean t = true;
            Random r = new Random();
            idn = r.nextInt(100);
            for(Customer f : cs){
                if(idn == f.getCid())
                    t = false;
            }
            if(t == true) break;
        }
        customer.setCid(idn);
        ss.addCustomer(customer);
        return new ModelAndView("SLAddSucc");
    }



    @RequestMapping(value = "manageCustomer.do", method = RequestMethod.GET)
    protected ModelAndView manageFund(HttpServletRequest request, HttpServletResponse response) throws Exception {
        SalesService ss = (SalesService) ctx.getBean("salesserviceobj");
        int num = Integer.parseInt(request.getParameter("number"));

        if(num == 0){
            System.out.println("compantcuocuo2");
            return new ModelAndView("SLCUSError");
        }
        else{
            String cid;
            if(request.getParameter("xuanze") == null)
                return new ModelAndView("SLCUSError");
            else{
                cid = request.getParameter("xuanze");
                Customer f = ss.select(cid);
                Map<String, Object> map = new HashMap<String, Object>();
                map.put("customer",f);
                return new ModelAndView("ManageCustomer","map",map);
            }
        }
    }

    @RequestMapping(value = "manageCustomerSucc.do", method = RequestMethod.GET)
    protected ModelAndView succManage(HttpServletRequest request, HttpServletResponse response) throws Exception {
        SalesService ss = (SalesService) ctx.getBean("salesserviceobj");
        String cid = request.getParameter("cid");
        String p = request.getParameter("email");
        if(cid == null || p == null){
            return new ModelAndView("SLCUSError");
        }
        else{
            if(request.getParameter("dele") == null){
                boolean f = ss.update(cid, p);
                if(f == false)
                    return new ModelAndView("SLCUSError");
                else
                    return new ModelAndView("ManageCustomerSucc");
            }
            else{
                boolean f = ss.delete(cid);
                if(f == false)
                    return new ModelAndView("SLCUSError");
                else
                    return new ModelAndView("ManageCustomerSucc");
            }

        }

    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        ctx = applicationContext;
    }
}
