package com.finalproject.controller;

import com.finalproject.pojo.Customer;
import com.finalproject.pojo.Fund;
import com.finalproject.pojo.Place;
import com.finalproject.service.*;
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

import javax.jws.WebParam;
import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@Controller
public class PlaceController implements ApplicationContextAware {
    private static ApplicationContext ctx;

    @RequestMapping(value = "toOrder.do", method = RequestMethod.GET)
    protected ModelAndView toOrder(HttpServletRequest request, HttpServletResponse response) throws Exception {
        FundService fservice = (FundService) ctx.getBean("fundserviceobj");
        PlaceService plservice = (PlaceService)ctx.getBean("placeserviceobj");
        SalesService salesService = (SalesService) ctx.getBean("salesserviceobj");
        ArrayList<Fund> fs = fservice.allFund();
        ArrayList<Place> ps = plservice.allPlace();
        ArrayList<Customer> cs = salesService.allCustomer();
        if(fs == null || ps == null || cs == null){
            return new ModelAndView("SLError");
        }
        else {
            int n1 = ps.size();
            int n2 = fs.size();
            int n3 = cs.size();
            Map<String, Object> map = new HashMap<>();
            map.put("all1", ps);
            map.put("all2", fs);
            map.put("all3", cs);
            map.put("num1", n1);
            map.put("num2", n2);
            map.put("num3", n3);
            return new ModelAndView("Order", "map", map);
        }
    }

    @RequestMapping(value = "manageOrder.do", method = RequestMethod.GET)
    protected ModelAndView deleOrder(HttpServletRequest request, HttpServletResponse response) throws Exception {
        if(request.getParameter("xuanze1") == null)
            return new ModelAndView("OrderError");
        PlaceService ps = (PlaceService) ctx.getBean("placeserviceobj");
        boolean f = ps.deletePlace(request.getParameter("xuanze1"));
        if(f == true) return new ModelAndView("OrderDeleSucc");
        else return new ModelAndView("OrderError");
    }

    @Autowired
    @Qualifier("placevalidatorobj")
    PlaceValidator validator;

    @InitBinder
    private void initBinder(WebDataBinder binder) {
        binder.setValidator(validator);
    }

    @RequestMapping(value = "place.do", method = RequestMethod.POST)
    protected ModelAndView place(
            @ModelAttribute("place")Place place,
            BindingResult result) throws Exception {

        validator.validate(place, result);
        if(result.hasErrors()){
            return new ModelAndView("OrderError");
        }

        FundService fservice = (FundService) ctx.getBean("fundserviceobj");
        PlaceService ps = (PlaceService) ctx.getBean("placeserviceobj");
        SalesService salesService = (SalesService) ctx.getBean("salesserviceobj");
        ArrayList<Place> places = ps.allPlace();
        int idn;
        while(true){
            boolean t = true;
            Random r = new Random();
            idn = r.nextInt(500);
            for(Place f : places){
                if(idn == f.getId())
                    t = false;
            }
            if(t == true) break;
        }
        place.setId(idn);
        ps.addPlace(place);

        float p = 0;
        int q = 0;
        int i = 0;
        String fund = place.getFund();
        ArrayList<Fund> fs = fservice.allFund();
        for(Fund fd : fs){
            if(fd.getName().equals(fund)){
                int n = fd.getQuantity();
                q = n - place.getQuantity();
                p = fd.getPrice();
                i = fd.getId();
            }
        }
        fservice.update(String.valueOf(i),p,q);//update fund quantity

        ArrayList<Customer> cs = salesService.allCustomer();
        String email = "";
        String name = "";
        for(Customer ct : cs){
            if(ct.getCid() == place.getCust()){
                email = ct.getEmail();
                name = ct.getName();
            }
        }
        try{
        //send email
        SendEmail.sendMessage("smtp.gmail.com", "highfivetradeplatform@gmail.com",
                "highfive123", email, "Purchase Confirmation",
                "Dear " + name +", you have purchased " + fund + " successfully. " + "Quantity: " + place.getQuantity() + ".",
                "text/html;charset=gb2312");
        }catch(MessagingException e){
            //e.printStackTrace();
        }

        return new ModelAndView("OrderSucc");
    }



    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        ctx = applicationContext;
    }

}
