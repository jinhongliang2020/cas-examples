package com.hong.cas.client.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by hong on 2017/8/12.
 */
@Controller
@RequestMapping("/data")
public class DataController {


    @RequestMapping("/data")
    @ResponseBody
    public String data(){
        return "cas-client-3";
    }
}
