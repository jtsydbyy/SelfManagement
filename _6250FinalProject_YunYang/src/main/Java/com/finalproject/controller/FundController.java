package com.finalproject.controller;

import com.finalproject.pojo.Fund;
import com.finalproject.service.AddFundValidator;
import com.finalproject.service.FundService;
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
public class FundController implements ApplicationContextAware {
    private static ApplicationContext ctx;

    @RequestMapping(value = "fundmanage.do", method = RequestMethod.GET)
    protected ModelAndView manageFund(HttpServletRequest request, HttpServletResponse response) throws Exception {
        FundService fservice = (FundService) ctx.getBean("fundserviceobj");
        int num = Integer.parseInt(request.getParameter("number"));

        if(num == 0){
            System.out.println("compantcuocuo");
            return new ModelAndView("FundCompanyError");
        }
        else{
            String id;
            if(request.getParameter("xuanze") == null)
                return new ModelAndView("FundCompanyError");
            else{
                id = request.getParameter("xuanze");
                Fund f = fservice.select(id);
                Map<String, Object> map = new HashMap<String, Object>();
                map.put("fund",f);
                return new ModelAndView("ManageFund","map",map);
            }
        }
    }


    @RequestMapping(value = "aftermanage.do", method = RequestMethod.GET)
    protected ModelAndView afterManage(HttpServletRequest request, HttpServletResponse response) throws Exception {
        FundService fservice = (FundService) ctx.getBean("fundserviceobj");
        ArrayList<Fund> fs = fservice.allFund();
        if(fs == null){
            System.out.println("comXXXXXXX");
            return new ModelAndView("FundCompanyError");
        }
        else{
            int n = fs.size();
            Map<String, Object> map = new HashMap<>();
            map.put("all", fs);
            map.put("num", n);
            return new ModelAndView("Fund Company","map",map);
        }
    }

    @RequestMapping(value = "managesucc.do", method = RequestMethod.GET)
    protected ModelAndView succManage(HttpServletRequest request, HttpServletResponse response) throws Exception {
        FundService fservice = (FundService) ctx.getBean("fundserviceobj");
        String id = request.getParameter("id");
        String p = request.getParameter("price");
        String q = request.getParameter("quantity");
        if(id == null || p == null || q == null){
            return new ModelAndView("FundCompanyError");
        }
        else{
            if(request.getParameter("dele") == null){
                boolean f = fservice.update(id, Float.parseFloat(p), Integer.parseInt(q));
                if(f == false)
                    return new ModelAndView("FundCompanyError");
                else
                    return new ModelAndView("ManageSucc");
            }
            else{
                boolean f = fservice.delete(id);
                if(f == false)
                    return new ModelAndView("FundCompanyError");
                else
                    return new ModelAndView("ManageSucc");
            }

        }

    }

    @RequestMapping(value = "addFund.do", method = RequestMethod.GET)
    protected ModelAndView toaddFund(HttpServletRequest request, HttpServletResponse response) throws Exception {
        return new ModelAndView("AddFund");

    }

    @Autowired
    @Qualifier("addfundvalidatorobj")
    AddFundValidator validator;

    @InitBinder
    private void initBinder(WebDataBinder binder) {
        binder.setValidator(validator);
    }

    @RequestMapping(value = "addsucc.do", method = RequestMethod.POST)
    protected ModelAndView addFund(
            @ModelAttribute("fund")Fund fund,
            BindingResult result) throws Exception {

        validator.validate(fund, result);

        if(result.hasErrors()){
            return new ModelAndView("FundCompanyError");
        }

        FundService fservice = (FundService) ctx.getBean("fundserviceobj");
        ArrayList<Fund> fs = fservice.allFund();
        for(Fund f : fs){
            if(fund.getName().equals(f.getName()))
                return new ModelAndView("DuplicatedFundName");
        }
        int idn;
        while(true){
            boolean t = true;
            Random r = new Random();
            idn = r.nextInt(100);
            for(Fund f : fs){
                if(idn == f.getId())
                    t = false;
            }
            if(t == true) break;
        }
        fund.setId(idn);

        fservice.addFund(fund);

        return new ModelAndView("AddSucc");

    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        ctx = applicationContext;
    }
}
