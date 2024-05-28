package com.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import util.Request;
import com.spring.entity.Admins;
import com.spring.service.AdminsService;

import com.spring.entity.Yonghu;
import com.spring.service.YonghuService;


@Controller
public class UserController extends BaseController{

        @Resource
    private AdminsService adminsService;
        @Resource
    private YonghuService yonghuService;
    
    /**
     * 登录页面
     * @return
     */
    @RequestMapping("/login")
    public String Index()
    {
        return "login";
    }

    /**
     * 退出
     * @return
     */
    @RequestMapping("/logout")
    public String Logout()
    {
        request.getSession().invalidate();
        return showSuccess("退出成功" , "./");
    }

    /**
     * 处理前端提交的登录信息
     * @param isAdmin
     * @param username
     * @param pwd
     * @param cx
     * @return
     */
    protected String authLoginUser(boolean isAdmin,String username , String pwd,String cx)
    {
        if(username == null || "".equals(username) ){
            return showError( "账号不允许为空" );
        }
        if(pwd == null || "".equals(pwd) ){
            return showError( "密码不允许为空" );
        }
        if(cx == null){
            return showError( "请选中登录类型" );
        }

        String random = (String) request.getSession().getAttribute("random");
        String pagerandom = request.getParameter("pagerandom") == null ? "" : request.getParameter("pagerandom");

        if(request.getParameter("a") !=null && !pagerandom.equals(random)){
            return showError( "验证码不正确" );
        }


        if (cx.equals("管理员")) {
            Admins user = adminsService.login(username , pwd);
            if(user == null){
                return showError("用户名或密码错误");
            }
                        session.setAttribute("id" , user.getId());
            session.setAttribute("username" , user.getUsername());
            session.setAttribute("cx" , cx);
            session.setAttribute("login" , cx);
                        session.setAttribute("username", user.getUsername());
                        session.setAttribute("pwd", user.getPwd());
            
        }
        if (cx.equals("用户")) {
            Yonghu user = yonghuService.login(username , pwd);
            if(user == null){
                return showError("用户名或密码错误");
            }
                        session.setAttribute("id" , user.getId());
            session.setAttribute("username" , user.getYonghuming());
            session.setAttribute("cx" , cx);
            session.setAttribute("login" , cx);
                        session.setAttribute("yonghuming", user.getYonghuming());
                        session.setAttribute("mima", user.getMima());
                        session.setAttribute("xingming", user.getXingming());
                        session.setAttribute("xingbie", user.getXingbie());
                        session.setAttribute("shouji", user.getShouji());
                        session.setAttribute("youxiang", user.getYouxiang());
                        session.setAttribute("shenfenzheng", user.getShenfenzheng());
                        session.setAttribute("touxiang", user.getTouxiang());
            
        }

        String referer = request.getParameter("referer");
        if(referer == null){
            if(isAdmin){
                referer = "./main.do";
            }else{
                referer = "./";
            }
        }
        return showSuccess("登录成功" , referer);
    }
    @RequestMapping("/main")
    public String main() {
        return "main";
    }
    @RequestMapping("/sy")
    public String sy() {
        return "sy";
    }

    @RequestMapping("/mygo")
    public String mygo() {
        return "mygo";
    }
    @RequestMapping("/top")
    public String top() {
        return "top";
    }
    @RequestMapping("/authLogin")
    public String authLogin()
    {
        String username = Request.get("username");
        String pwd  = Request.get("pwd");
        String cx = Request.get("cx");
        return authLoginUser(false , username,pwd,cx);
    }

    /**
     * 处理login.jsp页面的模块
     * @return
     */
    @RequestMapping("/authAdminLogin")
    public String authAdminLogin()
    {
        String username = Request.get("username");
        String pwd  = Request.get("pwd");
        String cx = Request.get("cx");
        return authLoginUser(true , username,pwd,cx);
    }

    /**
     * 修改密码界面
     * @return
     */
    @RequestMapping("/mod")
    public String mod()
    {
        return "mod";
    }

    /**
     * 处理修改密码
     * @return
     */
    @RequestMapping("/editPassword")
    public String editPassword()
    {
        String username = request.getSession().getAttribute("username").toString();
        String cx = request.getSession().getAttribute("login").toString();
        String oldPassword = Request.get("oldPassword");
        String newPwd  = Request.get("newPwd");
        String newPwd2 = Request.get("newPwd2");

        if(!newPwd.equals(newPwd2)){
            return showError("两次密码不一致");
        }

        if (cx.equals("管理员")) {
            Admins user = adminsService.login(username , oldPassword);
            if(user == null){
                return showError("原密码不正确");
            }
            adminsService.updatePassword(user.getId() , newPwd);
        }
        if (cx.equals("用户")) {
            Yonghu user = yonghuService.login(username , oldPassword);
            if(user == null){
                return showError("原密码不正确");
            }
            yonghuService.updatePassword(user.getId() , newPwd);
        }
        return showSuccess("修改密码成功" , "./mod.do");
    }
}
