package com.spring.controller;



import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController extends BaseController{

    // 首页
    @RequestMapping("/index")
    public String Index()
    {
        return "index";
    }



}
