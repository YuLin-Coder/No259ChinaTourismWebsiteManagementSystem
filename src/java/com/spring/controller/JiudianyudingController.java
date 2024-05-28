package com.spring.controller;

import com.spring.dao.JiudianyudingMapper;
import com.spring.entity.Jiudianyuding;
import com.spring.service.JiudianyudingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import tk.mybatis.mapper.entity.Example;
import util.Request;
import util.Info;
import dao.Query;
import java.util.*;



import com.spring.entity.Jiudiankefang;
import com.spring.service.JiudiankefangService;

/**
 * 酒店预定 */
@Controller
public class JiudianyudingController extends BaseController
{
    @Autowired
    private JiudianyudingMapper dao;
    @Autowired
    private JiudianyudingService service;

    @Autowired
    private JiudiankefangService serviceRead;

    /**
     *  后台列表页
     *
     */
    @RequestMapping("/jiudianyuding_list")
    public String list()
    {
        // 检测是否有登录，没登录则跳转到登录页面
        if(!checkLogin()){
            return showError("尚未登录" , "./login.do");
        }

        String order = Request.get("order" , "id"); // 获取前台提交的URL参数 order  如果没有则设置为id
        String sort  = Request.get("sort" , "desc"); // 获取前台提交的URL参数 sort  如果没有则设置为desc

        Example example = new Example(Jiudianyuding.class); //  创建一个扩展搜索类
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
        List<Jiudianyuding> list = service.selectPageExample(example , page , 12);   // 获取当前页的行数
        // 将列表写给界面使用
        assign("list" , list);
        assign("orderby" , order);  // 把当前排序结果写进前台
        assign("sort" , sort);      // 把当前排序结果写进前台
        assign("where" , where);    // 把当前条件写给前台
        return "jiudianyuding_list";   // 使用视图文件：WebRoot\jiudianyuding_list.jsp
    }



    /**
     *  获取前台搜索框填写的内容,并组成where 语句
     */
    public String getWhere()
    {
        String where = " ";
        // 判断URL 参数jiudiankefangid是否大于0
        if( Request.getInt("jiudiankefangid") > 0 ) {
            // 大于0 则写入条件
            where += " AND jiudiankefangid='"+Request.getInt("jiudiankefangid")+"' ";
        }
        // 以下也是一样的操作，判断是否符合条件，符合则写入sql 语句
            if(!Request.get("jiudianbianhao").equals("")) {
            where += " AND jiudianbianhao LIKE '%"+Request.get("jiudianbianhao")+"%' ";
        }
                if(!Request.get("jiudianmingcheng").equals("")) {
            where += " AND jiudianmingcheng LIKE '%"+Request.get("jiudianmingcheng")+"%' ";
        }
                if(!Request.get("kefangleixing").equals("")) {
            where += " AND kefangleixing ='"+Request.get("kefangleixing")+"' ";
        }
                if(!Request.get("yujiruzhushijian_start").equals("")) {
            where += " AND yujiruzhushijian >='"+Request.get("yujiruzhushijian_start")+"' ";
        }
        if(!Request.get("yujiruzhushijian_end").equals("")) {
            where += " AND yujiruzhushijian <= '"+Request.get("yujiruzhushijian_end")+"' ";
        }
                if(!Request.get("xingming").equals("")) {
            where += " AND xingming LIKE '%"+Request.get("xingming")+"%' ";
        }
            return where;
    }

    /**
     * 预定用户列表
     */
    @RequestMapping("/jiudianyuding_list_yudingyonghu")
    public String listyudingyonghu()
    {
        // 检测是否有登录，没登录则跳转到登录页面
        if(!checkLogin()){
            return showError("尚未登录" , "./login.do");
        }

        String order = Request.get("order" , "id"); // 获取前台提交的URL参数 order  如果没有则设置为id
        String sort  = Request.get("sort" , "desc"); // 获取前台提交的URL参数 sort  如果没有则设置为desc

        
        Example example = new Example(Jiudianyuding.class);  //  创建一个扩展搜索类
        Example.Criteria criteria = example.createCriteria();           // 创建一个扩展搜索条件类
        // 初始化一个条件，条件为：预定用户=当前登录用户
        String where = " yudingyonghu='"+session.getAttribute("username")+"' ";
        where += getWhere();

        criteria.andCondition(where);   // 将条件写入
        if(sort.equals("desc")){        // 注释同list
            example.orderBy(order).desc(); // 注释同list
        }else{
            example.orderBy(order).asc(); // 注释同list
        }

        int page = request.getParameter("page") == null ? 1 : Integer.valueOf(request.getParameter("page")); // 注释同list
        page = Math.max(1 , page); // 注释同list

            List<Jiudianyuding> list = service.selectPageExample(example , page , 12);
        
        request.setAttribute("list" , list);
                assign("orderby" , order);
        assign("sort" , sort);
        assign("where" , where);
        return "jiudianyuding_list_yudingyonghu";
    }




        @RequestMapping("/jiudianyuding_add")
    public String add()
    {
        int id = Request.getInt("id");  // 根据id 获取 酒店客房模块中的数据
        Jiudiankefang readMap = serviceRead.find(id);
        // 将数据行写入给前台jsp页面
        request.setAttribute("readMap" , readMap);
        return "jiudianyuding_add";
    }

    @RequestMapping("/jiudianyudingadd")
    public String addWeb()
    {
        if(!checkLogin()){
            return showError("尚未登录" , "./");
        }
        int id = Request.getInt("id"); // 根据id 获取 酒店客房模块中的数据
        Jiudiankefang readMap = serviceRead.find(id);
        request.setAttribute("readMap" , readMap);
        return "jiudianyudingadd";
    }


    @RequestMapping("/jiudianyuding_updt")
    public String updt()
    {
        int id = Request.getInt("id");
        // 获取行数据，并赋值给前台jsp页面
        Jiudianyuding mmm = service.find(id);
        request.setAttribute("mmm" , mmm);
        request.setAttribute("updtself" , 0);
        return "jiudianyuding_updt";
    }
    /**
     * 添加内容
     * @return
     */
    @RequestMapping("/jiudianyudinginsert")
    public String insert()
    {
        String tmp="";
        Jiudianyuding post = new Jiudianyuding();  // 创建实体类
        // 设置前台提交上来的数据到实体类中
        post.setYudingdanhao(Request.get("yudingdanhao"));

        post.setJiudianbianhao(Request.get("jiudianbianhao"));

        post.setJiudianmingcheng(Request.get("jiudianmingcheng"));

        post.setJiudianleixing(Request.get("jiudianleixing"));

        post.setKefangleixing(Request.get("kefangleixing"));

        post.setKefangtupian(Request.get("kefangtupian"));

        post.setKefangjiage(Request.getDouble("kefangjiage"));

        post.setYujiruzhushijian(Request.get("yujiruzhushijian"));

        post.setYudingjianshu(Request.getInt("yudingjianshu"));

        post.setLianxidianhua(Request.get("lianxidianhua"));

        post.setShenfenzhenghao(Request.get("shenfenzhenghao"));

        post.setXingming(Request.get("xingming"));

        post.setYudingyonghu(Request.get("yudingyonghu"));

        post.setJiudiankefangid(Request.getInt("jiudiankefangid"));
        post.setIszf("否");

        
        post.setAddtime(Info.getDateStr()); // 设置添加时间
                service.insert(post); // 插入数据
        int charuid = post.getId().intValue();
        Query.execute("update jiudiankefang set shengyukefangshu=shengyukefangshu-'"+request.getParameter("yudingjianshu")+"' where  id='"+request.getParameter("jiudiankefangid")+"'");



        return showSuccess("保存成功" , Request.get("referer").equals("") ? request.getHeader("referer") : Request.get("referer"));
    }

    /**
    * 更新内容
    * @return
    */
    @RequestMapping("/jiudianyudingupdate")
    public String update()
    {
        // 创建实体类
        Jiudianyuding post = new Jiudianyuding();
        // 将前台表单数据填充到实体类
        if(!Request.get("yudingdanhao").equals(""))
        post.setYudingdanhao(Request.get("yudingdanhao"));
                if(!Request.get("jiudianbianhao").equals(""))
        post.setJiudianbianhao(Request.get("jiudianbianhao"));
                if(!Request.get("jiudianmingcheng").equals(""))
        post.setJiudianmingcheng(Request.get("jiudianmingcheng"));
                if(!Request.get("jiudianleixing").equals(""))
        post.setJiudianleixing(Request.get("jiudianleixing"));
                if(!Request.get("kefangleixing").equals(""))
        post.setKefangleixing(Request.get("kefangleixing"));
                if(!Request.get("kefangtupian").equals(""))
        post.setKefangtupian(Request.get("kefangtupian"));
                if(!Request.get("kefangjiage").equals(""))
        post.setKefangjiage(Request.getDouble("kefangjiage"));
            if(!Request.get("yujiruzhushijian").equals(""))
        post.setYujiruzhushijian(Request.get("yujiruzhushijian"));
                if(!Request.get("yudingjianshu").equals(""))
        post.setYudingjianshu(Request.getInt("yudingjianshu"));
            if(!Request.get("lianxidianhua").equals(""))
        post.setLianxidianhua(Request.get("lianxidianhua"));
                if(!Request.get("shenfenzhenghao").equals(""))
        post.setShenfenzhenghao(Request.get("shenfenzhenghao"));
                if(!Request.get("xingming").equals(""))
        post.setXingming(Request.get("xingming"));
                if(!Request.get("yudingyonghu").equals(""))
        post.setYudingyonghu(Request.get("yudingyonghu"));
        
        post.setId(Request.getInt("id"));
                service.update(post); // 更新数据
        int charuid = post.getId().intValue();
                        return showSuccess("保存成功" , Request.get("referer")); // 弹出保存成功，并跳转到前台提交的 referer 页面
    }
        /**
    *  删除
    */
    @RequestMapping("/jiudianyuding_delete")
    public String delete()
    {
        if(!checkLogin()){
            return showError("尚未登录");
        }
        int id = Request.getInt("id");  // 根据id 删除某行数据
        HashMap delMap = Query.make("jiudianyuding").find(id);

                service.delete(id);// 根据id 删除某行数据
                return showSuccess("删除成功",request.getHeader("referer"));//弹出删除成功，并跳回上一页
    }
}
