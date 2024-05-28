package util;

import util.threadlocal.LocalRequestContextHolder;

import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 过滤器，将当前保存当前request response session 进入到当前线程当中
 */
public class ContentFilter extends org.springframework.web.filter.CharacterEncodingFilter {
    private FilterConfig filterConfig;

    // Handle the passed-in FilterConfig


    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        //request.setCharacterEncoding("gb2312");
        HttpServletRequest req = (HttpServletRequest) request;
        LocalRequestContextHolder.setLocalRequestContext(req,response );
        //filterChain.doFilter(request, response);

        super.doFilterInternal(request, response, filterChain);
    }

    // Process the request/response pair
    // Clean up resources
    public void destroy() {
    }
}
