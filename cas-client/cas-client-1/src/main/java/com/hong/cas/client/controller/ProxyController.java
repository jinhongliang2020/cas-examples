package com.hong.cas.client.controller;

import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.security.cas.authentication.CasAuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;

/**
 * cas 无状态登录代理端.
 * Created by hong on 2017/8/12.
 */
@Controller
@RequestMapping("/proxy")
public class ProxyController {


    @RequestMapping("/")
    @ResponseBody
    public String proxy(HttpServletRequest request , HttpServletResponse response) throws IOException {
        String targetUrl = "http://localhost:9002/cas-client-3/data/data";
        // NOTE: The CasAuthenticationToken can also be obtained using SecurityContextHolder.getContext().getAuthentication()
        final CasAuthenticationToken token = (CasAuthenticationToken) request.getUserPrincipal();
        // proxyTicket could be reused to make calls to the CAS service even if the target url differs
        final String proxyTicket = token.getAssertion().getPrincipal().getProxyTicketFor(targetUrl);

        // Make a remote call using the proxy ticket
        final String serviceUrl = targetUrl + "?ticket=" + URLEncoder.encode(proxyTicket, "UTF-8");
//        String proxyResponse = CommonUtils.getResponseFromServer(serviceUrl, "UTF-8");
        OkHttpClient okHttpClient = new OkHttpClient();
        Request request1 = new Request.Builder().url(serviceUrl).build();
        Call call = okHttpClient.newCall(request1);
        Response response1 = call.execute();
        String result = response1.body().string();
        System.out.println(result);
        return result;

    }
}
