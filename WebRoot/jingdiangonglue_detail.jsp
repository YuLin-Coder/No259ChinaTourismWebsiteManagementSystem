<%@ page language="java" import="dao.*" pageEncoding="UTF-8"%>
<%@ page language="java" import="java.util.*"%>
<%@page import="util.Info"%>
<%@ taglib prefix="ssm" uri="http://ssm" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ include file="head.jsp" %>
<link href="js/h5upload/h5upload.css" rel="stylesheet">
<script src="js/h5upload/h5upload.js"></script>
<script src="http://api.map.baidu.com/api?v=2.0&ak=AoBYL0LlRkcYBMCeay4fgpq7qaIYlKjs"></script>
<link href="js/baidumap.css" rel="stylesheet">
<script src="js/baidumap.js"></script>

<div style="padding: 10px">



<style>
    .admin-detail {
        display: flex;
        flex-wrap: wrap;
    }
    .admin-detail .detail {
        width: 50%;
        padding: 5px;
        display: flex;
        margin-bottom: 10px;
        border-bottom: 1px solid #DEDEDE;
    }
    .admin-detail .detail .detail-title {
        width: 120px;
        text-align: right;
    }
    .admin-detail .detail .detail-content {
        flex-grow: 1;
    }
    .admin-detail .detail.detail-editor {
        width: 100%;
        flex-wrap: wrap;
    }
    .admin-detail .detail.detail-editor .detail-title {
        width: 100%;
        padding: 10px;
        margin-top: 10px;
        background: #9a0606;
        color: #ffffff;
        text-align: left;
    }
    .admin-detail .detail.detail-editor .detail-content{
        padding: 10px;
    }

</style>




<div class="panel panel-default">
    <div class="panel-heading">
        景点攻略详情
    </div>
    <div class="panel-body">

        <div class="admin-detail clearfix">
                            <div class="detail detail-text">
                    <div class="detail-title">
                        景点编号：
                    </div>
                    <div class="detail-content">
                        ${map.jingdianbianhao}                    </div>
                </div>
                            <div class="detail detail-text">
                    <div class="detail-title">
                        景点名称：
                    </div>
                    <div class="detail-content">
                        ${map.jingdianmingcheng}                    </div>
                </div>
                            <div class="detail detail-images">
                    <div class="detail-title">
                        景点图片：
                    </div>
                    <div class="detail-content">
                        <fieldset class="images_box"><div id="gellay_images" class="imagesList"><script>
            var images = "${map.jingdiantupian}".split(',');
            for(var i=0;i<images.length;i++){
                var image = images[i];
                var uploadImage = '<div class="uploadImage">' +
                '<span class="thumb thumbnail"><img src="'+image+'"/></span>'+
                '</div>';
                document.writeln(uploadImage);
            }
            
</script></div></fieldset>                    </div>
                </div>
                            <div class="detail detail-text">
                    <div class="detail-title">
                        所在城市：
                    </div>
                    <div class="detail-content">
                        ${map.suozaichengshi}                    </div>
                </div>
                            <div class="detail detail-money">
                    <div class="detail-title">
                        门票价格：
                    </div>
                    <div class="detail-content">
                        ${map.menpiaojiage}                    </div>
                </div>
                            <div class="detail detail-text">
                    <div class="detail-title">
                        开放时间：
                    </div>
                    <div class="detail-content">
                        ${map.kaifangshijian}                    </div>
                </div>
                            <div class="detail detail-address">
                    <div class="detail-title">
                        景点位置：
                    </div>
                    <div class="detail-content">
                        <div id="jingdianweizhi_view" class="address" style="width: 80%;height: 350px;"></div><script>
                        try{
                            showAddressView("jingdianweizhi" , ${map.jingdianweizhi});
                        }catch (e) {
                          
                        }</script>                    </div>
                </div>
                            <div class="detail detail-editor">
                    <div class="detail-title">
                        攻略详情：
                    </div>
                    <div class="detail-content">
                        ${map.gongluexiangqing}                    </div>
                </div>
                    </div>

        <div class="button-list mt10">
            <div class="">
                <button type="button" class="btn btn-default" onclick="history.go(-1);">
    返回
                
</button>
                <button type="button" class="btn btn-default" onclick="window.print()">
    打印本页
                
</button>
            </div>
        </div>

    </div>
</div>







</div>
<%@ include file="foot.jsp" %>
