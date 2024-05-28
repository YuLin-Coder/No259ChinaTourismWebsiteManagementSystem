package com.main;

import org.springframework.web.servlet.ModelAndView;

/**
 * 错误异常输出文件
 */
public class Response {
    protected ModelAndView vars    = null;

    public Response(String template)
    {
        vars = new ModelAndView();
        vars.setViewName(template);
    }

    /**
     * 写入模版变量
     * @param name
     * @param value
     */
    public void assign(String name , Object value)
    {
        vars.addObject(name , value);
    }

    /**
     * 获取视图类的模版
     * @return
     */
    public ModelAndView getData()
    {
        return vars;
    }
}
