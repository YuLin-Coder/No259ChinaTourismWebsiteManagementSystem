package com.spring.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 基本控制器路由基类
 * 主要处理路由中获取 request 和 response 类，加快开发进度
 * 处理一些弹出窗口信息，返回对如使用 showError 弹出一个窗口，并警告
 *
 */
abstract public class BaseController {
    @Autowired
    protected HttpServletRequest request;
    @Autowired
    protected HttpServletResponse response;
    @Autowired
    protected HttpSession session;

    protected ModelAndView mView;
    BaseController()
    {
        //request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        //response = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getResponse();
        mView = new ModelAndView();
    }

    protected void assign(String name , Object value)
    {

        request.setAttribute(name , value);
    }

    /**
     * 实现弹出窗，主要代码，需要更改弹出窗样式请在WebRoot\message.jsp 文件中修改
     * @param message
     * @param code
     * @param jumpUrl
     * @param jumpTime
     * @return
     */
    protected String showMessage( String message , int code , String jumpUrl , int jumpTime)
    {
        assign("message" , message);
        assign("code" , code);
        assign("jumpUrl" , jumpUrl);
        assign("jumpTime" , jumpTime);

        return "message";
    }

    /**
     * 检测是否都来
     * @return
     */
    protected boolean checkLogin()
    {
        if(request.getSession().getAttribute("username") == null || "".equals(request.getSession().getAttribute("username")))
        {
            return false;
        }
        return true;
    }

    /**
     * 弹出错误窗口
     * @param message
     * @return
     */
    protected String showError(String message)
    {
        return showMessage(message , 1 , "javascript:history(-1);" , 2250);
    }

    /**
     * 弹出错误窗口
     * @param message
     * @param code
     * @return
     */
    protected String showError(String message , int code)
    {
        return showMessage(message , code , "javascript:history(-1);" , 2250);
    }

    /**
     * 弹出错误窗口
     * @param message
     * @param url
     * @return
     */
    protected String showError(String message , String url)
    {
        return showMessage(message , 1 , url , 2250);
    }

    /**
     * 弹出成功窗口
     * @param message
     * @return
     */
    protected String showSuccess(String message )
    {
        return showMessage(message , 0 , request.getHeader("referer") , 2250);
    }

    /**
     * 弹出成功窗口
     * @param message
     * @param url
     * @return
     */
    protected String showSuccess(String message , String url)
    {
        return showMessage(message , 0 , url , 2250);
    }


}
