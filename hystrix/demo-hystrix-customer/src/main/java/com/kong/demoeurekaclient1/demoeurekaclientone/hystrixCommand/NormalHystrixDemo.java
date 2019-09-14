package com.kong.demoeurekaclient1.demoeurekaclientone.hystrixCommand;

import com.netflix.client.ClientFactory;
import com.netflix.client.http.HttpRequest;
import com.netflix.client.http.HttpResponse;
import com.netflix.config.ConfigurationManager;
import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.niws.client.http.RestClient;

import java.net.URI;

/**
 * @program: demo-hystrix-customer
 * @description: 测试
 * @author: Mr.Kong
 * @create: 2019-09-14 09:48
 **/
public class NormalHystrixDemo extends HystrixCommand<String> {
    RestClient client=null;
    HttpRequest request=null;

    public NormalHystrixDemo(){
        super(HystrixCommandGroupKey.Factory.asKey("demo"));
    }
    private void initRestClient(){
        client=(RestClient) ClientFactory.getNamedClient("HelloCommand");
        try{
            request=HttpRequest.newBuilder().uri(new URI("/available")).build();
        }catch (Exception e){
            e.printStackTrace();
        }
        ConfigurationManager.getConfigInstance().setProperty("HelloCommand.ribbon.listOfServers","localhost:8080");
    }

    protected String run(){
        System.out.println("in run");
        HttpResponse response;
        String result=null;
        try{
            response=client.executeWithLoadBalancer(request);
            System.out.println("status for URI:"+response.getRequestedURI()+" is "+response.getStatus());
            result=response.getEntity(String.class);
        }catch (Exception e){
            e.printStackTrace();
        }
        return "result is:"+result;
    }
}
