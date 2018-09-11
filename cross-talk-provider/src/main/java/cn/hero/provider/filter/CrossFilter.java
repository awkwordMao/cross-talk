package cn.hero.provider.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebFilter(urlPatterns = "/toaddcross")
public class CrossFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println(servletRequest.getAttribute("userName"));
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        System.out.println(httpServletRequest.getAttribute("userName"));
        if(servletRequest.getAttribute("userName").equals("")){
            String path = "/tologin";
            httpServletRequest.getRequestDispatcher(path).forward(servletRequest, servletResponse);
        }else{
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }

    @Override
    public void destroy() {

    }
}
