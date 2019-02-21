package com.example.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Component
public class MyFilter extends ZuulFilter {
    /**
     * 定义filter的类型，有pre、route、post、error四种
     *      pre：路由之前
     *      routing：路由之时
     *      post： 路由之后
     *      error：发送错误调用
     * **/
    @Override
    public String filterType() {
        return "pre";
    }

    /**
     * 定义执行顺序，通过数字指定 ,优先级为0，数字越大，优先级越低
     * **/
    @Override
    public int filterOrder() {
        return 0;
    }

    /**
     * 定义是否需要执行该filter，true表示执行，false表示不执行
     * **/
    @Override
    public boolean shouldFilter() {
        return true;
    }

    /**
     * 定义过滤器的具体逻辑。
     * （可以验证Token，sql，nosql去判断该请求到底有没有权限访问）
     * **/
    @Override
    public Object run() throws ZuulException {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
//        log.info(String.format("%s >>> %s", request.getMethod(), request.getRequestURL().toString()));
        Object accessToken = request.getParameter("token");
        if(accessToken == null) {
//            log.warn("token is empty");
            ctx.setSendZuulResponse(false);
            ctx.setResponseStatusCode(401);
            try {
                ctx.getResponse().getWriter().write("token is empty");
            }catch (Exception e){}

            return null;
        }
//        log.info("ok");
        return null;
    }
}
