package com.kong.demoeurekaservercaller.demoeurekaservercaller.entity;

import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.Server;

import java.util.List;

/**
 * @program: demo-eureka-server-caller-ribbon
 * @description: 自定义ribbon规则,随机
 * @author: Mr.Kong
 * @create: 2019-09-10 15:34
 **/
public class RibbonRuLe implements IRule {
    private ILoadBalancer iLoadBalancer;

    @Override
    public Server choose(Object o) {
        int number=(int)(Math.random()*3);
        System.out.println("choose the number is :"+number);
        List<Server> servers=iLoadBalancer.getAllServers();
        return servers.get(number);
    }

    @Override
    public void setLoadBalancer(ILoadBalancer iLoadBalancer) {
        this.iLoadBalancer=iLoadBalancer;
    }

    @Override
    public ILoadBalancer getLoadBalancer() {
        return iLoadBalancer;
    }
}
