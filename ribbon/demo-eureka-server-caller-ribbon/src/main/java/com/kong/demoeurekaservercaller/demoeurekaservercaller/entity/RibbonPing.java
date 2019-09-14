package com.kong.demoeurekaservercaller.demoeurekaservercaller.entity;

import com.netflix.loadbalancer.IPing;
import com.netflix.loadbalancer.Server;

/**
 * @program: demo-eureka-server-caller-ribbon
 * @description: 测试，自定义IPing
 * @author: Mr.Kong
 * @create: 2019-09-10 15:58
 **/
public class RibbonPing implements IPing {
    @Override
    public boolean isAlive(Server server) {
        //判断依据，随机概率
        double data=Math.random();
        if (data>0.6){
            System.out.println("Server is unavailable:"+server.getPort());
            return false;
        }else {
            System.out.println("Server is available:"+server.getPort());
            return true;
        }
    }
}
