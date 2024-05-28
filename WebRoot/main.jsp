<%@ page language="java" import="dao.*" pageEncoding="UTF-8"%>
<%@ page language="java" import="java.util.*"%>
<%@page import="util.Info"%>
<%@ taglib prefix="ssm" uri="http://ssm" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="Mosaddek">
    <meta name="keyword" content="FlatLab, Dashboard, Bootstrap, Admin, Template, Theme, Responsive, Fluid, Retina">


    <title>中国旅游网站-后台管理</title>

    <!-- Bootstrap core CSS -->
    <link href="htstyle/css/bootstrap.min.css" rel="stylesheet">
    <link href="htstyle/css/bootstrap-reset.css" rel="stylesheet">
    <!--external css-->
    <link href="htstyle/font-awesome/css/font-awesome.css" rel="stylesheet"/>
    <!-- Custom styles for this template -->
    <link href="htstyle/css/style.css" rel="stylesheet">
</head>

<body>

<section id="container" class="">
    <!--header start-->
    <header class="header white-bg">
        <div class="sidebar-toggle-box">
            <div data-original-title="Toggle Navigation" data-placement="right" class="icon-reorder tooltips"></div>
        </div>
        <!--logo start-->
        <a href="javascript:;" class="logo">中国旅游网站</a>
        <!--logo end-->
        <!--<div class="nav notify-row" id="top_menu">
            &lt;!&ndash;  notification start &ndash;&gt;
            <ul class="nav top-menu">
                &lt;!&ndash; settings start &ndash;&gt;
                <li class="dropdown">
                    <a data-toggle="dropdown" class="dropdown-toggle" href="#">
                        <i class="icon-tasks"></i>
                        <span class="badge bg-success">0</span>
                    </a>
                    <ul class="dropdown-menu extended tasks-bar">
                        <div class="notify-arrow notify-arrow-green"></div>
                        <li>
                            <p class="green">You have 6 pending tasks</p>
                        </li>
                        <li>
                            <a href="#">
                                <div class="task-info">
                                    <div class="desc">Dashboard v1.3</div>
                                    <div class="percent">40%</div>
                                </div>
                                <div class="progress progress-striped">
                                    <div class="progress-bar progress-bar-success" role="progressbar" aria-valuenow="40" aria-valuemin="0" aria-valuemax="100" style="width: 40%">
                                        <span class="sr-only">40% Complete (success)</span>
                                    </div>
                                </div>
                            </a>
                        </li>
                        <li class="external">
                            <a href="#">See All Tasks</a>
                        </li>
                    </ul>
                </li>
                &lt;!&ndash; settings end &ndash;&gt;
                &lt;!&ndash; inbox dropdown start&ndash;&gt;
                <li id="header_inbox_bar" class="dropdown">
                    <a data-toggle="dropdown" class="dropdown-toggle" href="#">
                        <i class="icon-envelope-alt"></i>
                        <span class="badge bg-important">5</span>
                    </a>
                    <ul class="dropdown-menu extended inbox">
                        <div class="notify-arrow notify-arrow-red"></div>
                        <li>
                            <p class="red">You have 5 new messages</p>
                        </li>
                        <li>
                            <a href="#">
                                <span class="photo"><img alt="avatar" src="img/avatar-mini.jpg"></span>
                                <span class="subject">
                                <span class="from">Jonathan Smith</span>
                                <span class="time">Just now</span>
                                </span>
                                <span class="message">
                                    Hello, this is an example msg.
                                </span>
                            </a>
                        </li>
                        <li>
                            <a href="#">See all messages</a>
                        </li>
                    </ul>
                </li>
                &lt;!&ndash; inbox dropdown end &ndash;&gt;
                &lt;!&ndash; notification dropdown start&ndash;&gt;
                <li id="header_notification_bar" class="dropdown">
                    <a data-toggle="dropdown" class="dropdown-toggle" href="#">

                        <i class="icon-bell-alt"></i>
                        <span class="badge bg-warning">7</span>
                    </a>
                    <ul class="dropdown-menu extended notification">
                        <div class="notify-arrow notify-arrow-yellow"></div>
                        <li>
                            <p class="yellow">You have 7 new notifications</p>
                        </li>
                        <li>
                            <a href="#">
                                <span class="label label-danger"><i class="icon-bolt"></i></span>
                                Server #3 overloaded.
                                <span class="small italic">34 mins</span>
                            </a>
                        </li>
                        <li>
                            <a href="#">
                                <span class="label label-warning"><i class="icon-bell"></i></span>
                                Server #10 not respoding.
                                <span class="small italic">1 Hours</span>
                            </a>
                        </li>
                        <li>
                            <a href="#">
                                <span class="label label-danger"><i class="icon-bolt"></i></span>
                                Database overloaded 24%.
                                <span class="small italic">4 hrs</span>
                            </a>
                        </li>
                        <li>
                            <a href="#">
                                <span class="label label-success"><i class="icon-plus"></i></span>
                                New user registered.
                                <span class="small italic">Just now</span>
                            </a>
                        </li>
                        <li>
                            <a href="#">
                                <span class="label label-info"><i class="icon-bullhorn"></i></span>
                                Application error.
                                <span class="small italic">10 mins</span>
                            </a>
                        </li>
                        <li>
                            <a href="#">See all notifications</a>
                        </li>
                    </ul>
                </li>
                &lt;!&ndash; notification dropdown end &ndash;&gt;
            </ul>
            &lt;!&ndash;  notification end &ndash;&gt;
        </div>-->
        <div class="top-nav ">
            <!--search & user info start-->
            <ul class="nav pull-right top-menu">
                <!--<li>
                    <input type="text" class="form-control search" placeholder="Search">
                </li>-->
                <!-- user login dropdown start-->
                <li class="dropdown">
                    <a data-toggle="dropdown" class="dropdown-toggle" href="#">
                        <c:choose>
<c:when test="${sessionScope.touxiang != null && sessionScope.touxiang !=  '' }">

                        <img alt="" src="${sessionScope.touxiang}" style="width: 29px;height: 29px;">
                        </c:when><c:otherwise>
                        <img alt="" src="htstyle/img/avatar1_small.jpg">
                        </c:otherwise></c:choose>
                        <span class="username">${sessionScope.username}</span>
                        <b class="caret"></b>
                    </a>
                    <ul class="dropdown-menu extended logout">
                        <div class="log-arrow-up"></div>
                        <li><a href="./"><i class=" icon-suitcase"></i> 前台首页</a></li>
                        <li><a href="mod.do" target="main"><i class="icon-cog"></i> 修改密码</a></li>
                        <li><a href="sy.do" target="main"><i class="icon-bell-alt"></i> 后台首页</a></li>
                        <li><a href="logout.do" onclick="return confirm('确定退出系统？')"><i class="icon-key"></i>
                            退出系统</a></li>
                    </ul>
                </li>
                <!-- user login dropdown end -->
            </ul>
            <!--search & user info end-->
        </div>
    </header>
    <!--header end-->
    <!--sidebar start-->
    <aside>
        <div id="sidebar" class="nav-collapse ">
            <!-- sidebar menu start-->
            <ul class="sidebar-menu">
                                <c:choose>
<c:when test="${'管理员' == sessionScope.cx }">

                <%@ include file="left_guanliyuan.jsp" %>
                </c:when></c:choose>
                                <c:choose>
<c:when test="${'用户' == sessionScope.cx }">

                <%@ include file="left_yonghu.jsp" %>
                </c:when></c:choose>

            </ul>
            <!-- sidebar menu end-->
        </div>
    </aside>
    <!--sidebar end-->
    <!--main content start-->
    <section id="main-content">
        <section class="wrapper" style="">
            <iframe name="main" src="sy.do"></iframe>
        </section>
    </section>
    <!--main content end-->
</section>

<!-- js placed at the end of the document so the pages load faster -->
<script src="htstyle/js/jquery.js"></script>
<script src="htstyle/js/bootstrap.min.js"></script>
<script src="htstyle/js/jquery.scrollTo.min.js" type="text/javascript"></script>
<script src="htstyle/js/jquery.nicescroll.js" type="text/javascript"></script>

<!--common script for all pages-->
<script src="htstyle/js/common-scripts1.js"></script>
<script>

    //custom select box
    $(function () {
        $('#sidebar .sub-menu:eq(0) > a').click();
    })


</script>
</body>
</html>
