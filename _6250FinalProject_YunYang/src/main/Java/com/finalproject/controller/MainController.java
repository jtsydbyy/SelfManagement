package com.finalproject.controller;

import com.finalproject.exception.LoginException;
import com.finalproject.pojo.Fund;
import com.finalproject.pojo.Login;
import com.finalproject.service.FundService;
import com.finalproject.service.LoginService;
import com.finalproject.service.RegisterValidator;
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
public class MainController implements ApplicationContextAware {
    private static ApplicationContext ctx;

    @RequestMapping(value = "/")
    public String homepage(){
        return "index";
    }

    @RequestMapping(value = "index.do")
    public String homepage1(){
        return "index";
    }

    @RequestMapping(value = "log.do", method = RequestMethod.POST)
    protected ModelAndView logIn(HttpServletRequest request, HttpServletResponse response) throws Exception {
        LoginService lgservice = (LoginService) ctx.getBean("logserviceobj");
        FundService fservice = (FundService) ctx.getBean("fundserviceobj");
        Login l = lgservice.checkLog(request.getParameter("username"), request.getParameter("password"));
        //System.out.println(request.getParameter("username")+request.getParameter("password"));
        if(l == null){
            return new ModelAndView("LoginError");
        }
        else{
            if(l.getType().equals("admin")){
                ArrayList<Login> ls = lgservice.allpeople();

                if(ls == null){
                    System.out.println("XXXXXXX");
                    return new ModelAndView("Error");
                }

                else{
                    int n = ls.size();
                    Map<String, Object> map = new HashMap<String, Object>();
                    map.put("all", ls);
                    map.put("num", n);
                    return new ModelAndView("Admin", "map", map);
                }

            }

            if(l.getType().equals("sales")) {
                return new ModelAndView("Salesman");
            }

            if(l.getType().equals("company")) {
                ArrayList<Fund> fs = fservice.allFund();
                if(fs == null){
                    System.out.println("comXXXXXXX");
                    return new ModelAndView("Error");
                }
                else{
                    int n = fs.size();
                    Map<String, Object> map = new HashMap<>();
                    map.put("all", fs);
                    map.put("num", n);
                    return new ModelAndView("Fund Company","map",map);
                }

            }
        }
        return new ModelAndView("Error");
    }

    @RequestMapping(value = "dele.do", method = RequestMethod.GET)
    protected ModelAndView allPeople(HttpServletRequest request, HttpServletResponse response) throws Exception {
        LoginService lgservice = (LoginService) ctx.getBean("logserviceobj");
        int num = Integer.parseInt(request.getParameter("number"));

        if(num == 0){
            System.out.println("cuocuocuo");
            return new ModelAndView("AdminError");
        }
        else {
            String[] ids = new String[num];
            int count;
            int j = 0;
            for (int i = 0; i < 100; i++) {
                if (request.getParameter("dele" + i) != null) {
                    ids[j] = request.getParameter("dele" + i);
                    j++;
                }
            }
            count = j;

            if(count == 0) return new ModelAndView("AdminError");

            boolean[] fs = new boolean[count];
            for (int i = 0; i < count; i++) fs[i] = false;
            boolean f = true;
            for (int i = 0; i < count; i++) {
                fs[i] = lgservice.delete(ids[i]);
            }
            for (int i = 0; i < count; i++) {
                if (fs[i] != true) f = false;
            }
            if (f == true)
                return new ModelAndView("DeleSucc");
            else return new ModelAndView("AdminError");
        }
    }

    @RequestMapping(value = "afterdele.do", method = RequestMethod.GET)
    protected ModelAndView afterDele(HttpServletRequest request, HttpServletResponse response) throws Exception {
        LoginService lgservice = (LoginService) ctx.getBean("logserviceobj");
        ArrayList<Login> ls = lgservice.allpeople();

        if(ls == null){
            System.out.println("XXXX");
            return new ModelAndView("AdminError");
        }

        else{
            int n = ls.size();
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("all", ls);
            map.put("num", n);
            return new ModelAndView("Admin", "map", map);
        }
    }

    @RequestMapping(value = "register.do", method = RequestMethod.GET)
    protected ModelAndView toRegister(){
        return new ModelAndView("Register");
    }

    @Autowired
    @Qualifier("registervalidatorobj")
    RegisterValidator validator;

    @InitBinder
    private void initBinder(WebDataBinder binder) {
        binder.setValidator(validator);
    }

    @RequestMapping(value = "register.do", method = RequestMethod.POST)
    protected ModelAndView register(
            @ModelAttribute("login")Login login,
            BindingResult result) throws Exception {


        validator.validate(login, result);

        if (result.hasErrors()) {
            return new ModelAndView("AdminError");
        }

        //my function
        LoginService lgservice = (LoginService) ctx.getBean("logserviceobj");
        ArrayList<Login> ls = lgservice.allpeople();
        for(Login lg : ls){
            if(login.getUsername().equals(lg.getUsername()))
                return new ModelAndView("DuplicatedAcc");
        }
        int idn;
        while(true){
            boolean f = true;
            Random r = new Random();
            idn = r.nextInt(100);
            for(Login lg : ls){
                if(idn == lg.getId())
                    f = false;
            }
            if(f == true) break;
        }

        login.setId(idn);

        lgservice.register(login);
        return new ModelAndView("RegisterSucc");

    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        ctx = applicationContext;
    }

}
