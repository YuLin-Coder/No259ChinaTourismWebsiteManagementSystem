package com.spring.controller;

import com.spring.dao.GoumaijipiaoMapper;
import com.spring.entity.Goumaijipiao;
import com.spring.service.GoumaijipiaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import tk.mybatis.mapper.entity.Example;
import util.Request;
import util.Info;
import dao.Query;
import java.util.*;



import com.spring.entity.Feijipiao;
import com.spring.service.FeijipiaoService;

/**
 * 购买机票 */
@Controller
public class GoumaijipiaoController extends BaseController
{
    @Autowired
    private GoumaijipiaoMapper dao;
    @Autowired
    private GoumaijipiaoService service;

    @Autowired
    private FeijipiaoService serviceRead;

    /**
     *  后台列表页
     *
     */
    @RequestMapping("/goumaijipiao_list")
    public String list()
    {
        // 检测是否有登录，没登录则跳转到登录页面
        if(!checkLogin()){
            return showError("尚未登录" , "./login.do");
        }

        String order = Request.get("order" , "id"); // 获取前台提交的URL参数 order  如果没有则设置为id
        String sort  = Request.get("sort" , "desc"); // 获取前台提交的URL参数 sort  如果没有则设置为desc

        Example example = new Example(Goumaijipiao.class); //  创建一个扩展搜索类
        Example.Criteria criteria = example.createCriteria();          // 创建一个扩展搜索条件类
        String where = " 1=1 ";   // 创建初始条件为：1=1
        where += getWhere();      // 从方法中获取url 上的参数，并写成 sql条件语句
        criteria.andCondition(where);   // 将条件写进上面的扩展条件类中
        if(sort.equals("desc")){        // 判断前台提交的sort 参数是否等于  desc倒序  是则使用倒序，否则使用正序
            example.orderBy(order).desc();  // 把sql 语句设置成倒序
        }else{
            example.orderBy(order).asc();   // 把 sql 设置成正序
        }
        int page = request.getParameter("page") == null ? 1 : Integer.valueOf(request.getParameter("page"));  // 获取前台提交的URL参数 page  如果没有则设置为1
        page = Math.max(1 , page);  // 取两个数的最大值，防止page 小于1
        List<Goumaijipiao> list = service.selectPageExample(example , page , 12);   // 获取当前页的行数
        // 将列表写给界面使用
        assign("list" , list);
        assign("orderby" , order);  // 把当前排序结果写进前台
        assign("sort" , sort);      // 把当前排序结果写进前台
        assign("where" , where);    // 把当前条件写给前台
        return "goumaijipiao_list";   // 使用视图文件：WebRoot\goumaijipiao_list.jsp
    }



    /**
     *  获取前台搜索框填写的内容,并组成where 语句
     */
    public String getWhere()
    {
        String where = " ";
        // 判断URL 参数feijipiaoid是否大于0
        if( Request.getInt("feijipiaoid") > 0 ) {
            // 大于0 则写入条件
            where += " AND feijipiaoid='"+Request.getInt("feijipiaoid")+"' ";
        }
        // 以下也是一样的操作，判断是否符合条件，符合则写入sql 语句
            if(!Request.get("feijipiaobianhao").equals("")) {
            where += " AND feijipiaobianhao LIKE '%"+Request.get("feijipiaobianhao")+"%' ";
        }
                if(!Request.get("qifeichengshi").equals("")) {
            where += " AND qifeichengshi LIKE '%"+Request.get("qifeichengshi")+"%' ";
        }
                if(!Request.get("shenfenzhenghao").equals("")) {
            where += " AND shenfenzhenghao LIKE '%"+Request.get("shenfenzhenghao")+"%' ";
        }
                if(!Request.get("lianxidianhua").equals("")) {
            where += " AND lianxidianhua LIKE '%"+Request.get("lianxidianhua")+"%' ";
        }
            return where;
    }

    /**
     * 购买用户列表
     */
    @RequestMapping("/goumaijipiao_list_goumaiyonghu")
    public String listgoumaiyonghu()
    {
        // 检测是否有登录，没登录则跳转到登录页面
        if(!checkLogin()){
            return showError("尚未登录" , "./login.do");
        }

        String order = Request.get("order" , "id"); // 获取前台提交的URL参数 order  如果没有则设置为id
        String sort  = Request.get("sort" , "desc"); // 获取前台提交的URL参数 sort  如果没有则设置为desc

        
        Example example = new Example(Goumaijipiao.class);  //  创建一个扩展搜索类
        Example.Criteria criteria = example.createCriteria();           // 创建一个扩展搜索条件类
        // 初始化一个条件，条件为：购买用户=当前登录用户
        String where = " goumaiyonghu='"+session.getAttribute("username")+"' ";
        where += getWhere();

        criteria.andCondition(where);   // 将条件写入
        if(sort.equals("desc")){        // 注释同list
            example.orderBy(order).desc(); // 注释同list
        }else{
            example.orderBy(order).asc(); // 注释同list
        }

        int page = request.getParameter("page") == null ? 1 : Integer.valueOf(request.getParameter("page")); // 注释同list
        page = Math.max(1 , page); // 注释同list

            List<Goumaijipiao> list = service.selectPageExample(example , page , 12);
        
        request.setAttribute("list" , list);
                assign("orderby" , order);
        assign("sort" , sort);
        assign("where" , where);
        return "goumaijipiao_list_goumaiyonghu";
    }




        @RequestMapping("/goumaijipiao_add")
    public String add()
    {
        int id = Request.getInt("id");  // 根据id 获取 飞机票模块中的数据
        Feijipiao readMap = serviceRead.find(id);
        // 将数据行写入给前台jsp页面
        request.setAttribute("readMap" , readMap);
        return "goumaijipiao_add";
    }

    @RequestMapping("/goumaijipiaoadd")
    public String addWeb()
    {
        if(!checkLogin()){
            return showError("尚未登录" , "./");
        }
        int id = Request.getInt("id"); // 根据id 获取 飞机票模块中的数据
        Feijipiao readMap = serviceRead.find(id);
        request.setAttribute("readMap" , readMap);
        return "goumaijipiaoadd";
    }


    @RequestMapping("/goumaijipiao_updt")
    public String updt()
    {
        int id = Request.getInt("id");
        // 获取行数据，并赋值给前台jsp页面
        Goumaijipiao mmm = service.find(id);
        request.setAttribute("mmm" , mmm);
        request.setAttribute("updtself" , 0);
        return "goumaijipiao_updt";
    }
    /**
     * 添加内容
     * @return
     */
    @RequestMapping("/goumaijipiaoinsert")
    public String insert()
    {
        String tmp="";
        Goumaijipiao post = new Goumaijipiao();  // 创建实体类
        // 设置前台提交上来的数据到实体类中
        post.setFeijipiaobianhao(Request.get("feijipiaobianhao"));

        post.setHangbanhao(Request.get("hangbanhao"));

        post.setSuoshuhangkonggongsi(Request.get("suoshuhangkonggongsi"));

        post.setQifeishijian(Request.get("qifeishijian"));

        post.setQifeichengshi(Request.get("qifeichengshi"));

        post.setDaodachengshi(Request.get("daodachengshi"));

        post.setDaodashijian(Request.get("daodashijian"));

        post.setJianpiaokou(Request.get("jianpiaokou"));

        post.setJipiaojiage(Request.getDouble("jipiaojiage"));

        post.setShenfenzhenghao(Request.get("shenfenzhenghao"));

        post.setLianxidianhua(Request.get("lianxidianhua"));

        post.setXingming(Request.get("xingming"));

        post.setGoumaiyonghu(Request.get("goumaiyonghu"));

        post.setFeijipiaoid(Request.getInt("feijipiaoid"));
        post.setIszf("否");

        
        post.setAddtime(Info.getDateStr()); // 设置添加时间
                service.insert(post); // 插入数据
        int charuid = post.getId().intValue();
        Query.execute("update feijipiao set shengyushuliang=shengyushuliang-1 where id='"+request.getParameter("feijipiaoid")+"'");



        return showSuccess("保存成功" , Request.get("referer").equals("") ? request.getHeader("referer") : Request.get("referer"));
    }

    /**
    * 更新内容
    * @return
    */
    @RequestMapping("/goumaijipiaoupdate")
    public String update()
    {
        // 创建实体类
        Goumaijipiao post = new Goumaijipiao();
        // 将前台表单数据填充到实体类
        if(!Request.get("feijipiaobianhao").equals(""))
        post.setFeijipiaobianhao(Request.get("feijipiaobianhao"));
                if(!Request.get("hangbanhao").equals(""))
        post.setHangbanhao(Request.get("hangbanhao"));
                if(!Request.get("suoshuhangkonggongsi").equals(""))
        post.setSuoshuhangkonggongsi(Request.get("suoshuhangkonggongsi"));
                if(!Request.get("qifeishijian").equals(""))
        post.setQifeishijian(Request.get("qifeishijian"));
                if(!Request.get("qifeichengshi").equals(""))
        post.setQifeichengshi(Request.get("qifeichengshi"));
                if(!Request.get("daodachengshi").equals(""))
        post.setDaodachengshi(Request.get("daodachengshi"));
                if(!Request.get("daodashijian").equals(""))
        post.setDaodashijian(Request.get("daodashijian"));
                if(!Request.get("jianpiaokou").equals(""))
        post.setJianpiaokou(Request.get("jianpiaokou"));
                if(!Request.get("jipiaojiage").equals(""))
        post.setJipiaojiage(Request.getDouble("jipiaojiage"));
            if(!Request.get("shenfenzhenghao").equals(""))
        post.setShenfenzhenghao(Request.get("shenfenzhenghao"));
                if(!Request.get("lianxidianhua").equals(""))
        post.setLianxidianhua(Request.get("lianxidianhua"));
                if(!Request.get("xingming").equals(""))
        post.setXingming(Request.get("xingming"));
                if(!Request.get("goumaiyonghu").equals(""))
        post.setGoumaiyonghu(Request.get("goumaiyonghu"));
        
        post.setId(Request.getInt("id"));
                service.update(post); // 更新数据
        int charuid = post.getId().intValue();
                        return showSuccess("保存成功" , Request.get("referer")); // 弹出保存成功，并跳转到前台提交的 referer 页面
    }
        /**
    *  删除
    */
    @RequestMapping("/goumaijipiao_delete")
    public String delete()
    {
        if(!checkLogin()){
            return showError("尚未登录");
        }
        int id = Request.getInt("id");  // 根据id 删除某行数据
        HashMap delMap = Query.make("goumaijipiao").find(id);

                service.delete(id);// 根据id 删除某行数据
                return showSuccess("删除成功",request.getHeader("referer"));//弹出删除成功，并跳回上一页
    }
}
