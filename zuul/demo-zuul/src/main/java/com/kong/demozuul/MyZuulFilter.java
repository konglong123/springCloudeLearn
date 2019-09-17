package com.kong.demozuul;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import javax.servlet.http.HttpServletRequest;

/**
 * @program: demo-zuul
 * @description:
 * @author: Mr.Kong
 * @create: 2019-09-16 13:44
 **/
public class MyZuulFilter extends ZuulFilter {
    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 1;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
        System.out.println("In myPreFilter");
        RequestContext ctx=RequestContext.getCurrentContext();
        HttpServletRequest request=ctx.getRequest();
        String url=request.getRequestURI();
        System.out.println(url);
        if (url.indexOf("hello")==-1){
            System.out.println("Blocked by preFilter");
            ctx.setSendZuulResponse(false);
            ctx.setResponseStatusCode(404);
        }
        return null;
    }
}
