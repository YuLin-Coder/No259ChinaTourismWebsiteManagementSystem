<%@ page language="java" import="dao.*" pageEncoding="UTF-8"%>
<%@ page language="java" import="java.util.*"%>
<%@page import="util.Info"%>
<%@ taglib prefix="ssm" uri="http://ssm" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<li class="sub-menu">
    <a href="javascript:;" class="">
        <i class="icon-user"></i>
        <span>酒店预定</span>
        <span class="arrow"></span>
    </a>
    <ul class="sub">
                        <li><a class="" href="jiudianyuding_list_yudingyonghu.do" target="main">酒店预定查询</a></li>
                        <li><a class="" href="pingjia_list_pingjiayonghu.do" target="main">酒店评价查询</a></li>
            </ul>
</li>
<li class="sub-menu">
    <a href="javascript:;" class="">
        <i class="icon-user"></i>
        <span>飞机票</span>
        <span class="arrow"></span>
    </a>
    <ul class="sub">
                        <li><a class="" href="goumaijipiao_list_goumaiyonghu.do" target="main">购买机票查询</a></li>
            </ul>
</li>
<li class="sub-menu">
    <a href="javascript:;" class="">
        <i class="icon-user"></i>
        <span>个人中心</span>
        <span class="arrow"></span>
    </a>
    <ul class="sub">
                        <li><a class="" href="yonghu_updtself.do" target="main">修改个人资料</a></li>
                        <li><a class="" href="mod.do" target="main">修改密码</a></li>
                        <li><a class="" href="shoucangjilu_list2.do" target="main">我的收藏</a></li>
            </ul>
</li>
