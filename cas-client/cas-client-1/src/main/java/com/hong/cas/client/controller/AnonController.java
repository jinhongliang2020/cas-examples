package com.hong.cas.client.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by hong on 2017/8/11.
 */
@Controller
@RequestMapping("/anon")
public class AnonController {


    @RequestMapping("/logout")
    public String logout(){

        return "logoutView";
    }
}
