package com.main;

import com.main.exception.ResponseException;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 处理异常
 */
public class CustomExceptionResolver  implements HandlerExceptionResolver {
    @Override
    public ModelAndView resolveException(
            HttpServletRequest httpServletRequest,
            HttpServletResponse httpServletResponse,
            Object o,
            Exception e
    ) {
        if(e instanceof ResponseException)
        {
            Response response = ((ResponseException) e).getResponse();
            return response.getData();
        }else{
            e.printStackTrace();
            ModelAndView view = new ModelAndView();
            view.setViewName("error");
            return view;
        }
    }
}
