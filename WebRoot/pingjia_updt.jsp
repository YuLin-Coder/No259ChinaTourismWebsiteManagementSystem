<%@ page language="java" import="dao.*" pageEncoding="UTF-8"%>
<%@ page language="java" import="java.util.*"%>
<%@page import="util.Info"%>
<%@ taglib prefix="ssm" uri="http://ssm" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ include file="head.jsp" %>
<script src="js/jquery.validate.js"></script>

<div style="padding: 10px">




<div class="container"><!-- 使用bootstrap css框架，container定宽，并剧中 https://v3.bootcss.com/css/#overview-container -->

    <div class="panel panel-default">
        <div class="panel-heading">
            编辑评价:
        </div>
        <div class="panel-body">
            <form action="pingjiaupdate.do" method="post" name="form1" id="form1"><!-- form 标签开始 -->
    
                                                        <div class="form-group">
    <div class="row">
        <label style="max-width: 120px;min-height:18px;text-align: right" class="col-sm-2 hiddex-xs">酒店编号</label>
        <div class="col-sm-10">
            
                                                    ${mmm.jiudianbianhao}<input type="hidden" id="jiudianbianhao" name="jiudianbianhao" value="${Info.html(mmm.jiudianbianhao)}"/>                                            
        </div>
        
    </div>
</div>
                                                        <div class="form-group">
    <div class="row">
        <label style="max-width: 120px;min-height:18px;text-align: right" class="col-sm-2 hiddex-xs">酒店名称</label>
        <div class="col-sm-10">
            
                                                    ${mmm.jiudianmingcheng}<input type="hidden" id="jiudianmingcheng" name="jiudianmingcheng" value="${Info.html(mmm.jiudianmingcheng)}"/>                                            
        </div>
        
    </div>
</div>
                                                        <div class="form-group">
    <div class="row">
        <label style="max-width: 120px;min-height:18px;text-align: right" class="col-sm-2 hiddex-xs">评分<span style="color: red;">*</span></label>
        <div class="col-sm-10">
            
                                                    <select class="form-control class_pingfen11" data-value="${Info.html(mmm.pingfen)}" data-rule-required="true" data-msg-required="请填写评分" id="pingfen" name="pingfen" style="width:250px">
<option value="1">1</option>
<option value="2">2</option>
<option value="3">3</option>
<option value="4">4</option>
<option value="5">5</option>

</select>
<script>
$(".class_pingfen11").val($(".class_pingfen11").attr("data-value"))</script>
                                            
        </div>
        
    </div>
</div>
                                                        <div class="form-group">
    <div class="row">
        <label style="max-width: 120px;min-height:18px;text-align: right" class="col-sm-2 hiddex-xs">评价<span style="color: red;">*</span></label>
        <div class="col-sm-10">
            
                                                    <textarea style="width: 80%;height: 120px" class="form-control" placeholder="输入评价" data-rule-required="true" data-msg-required="请填写评价" id="pingjia" name="pingjia">${Info.html(mmm.pingjia)}</textarea>                                            
        </div>
        
    </div>
</div>
                                                        <div class="form-group">
    <div class="row">
        <label style="max-width: 120px;min-height:18px;text-align: right" class="col-sm-2 hiddex-xs">评价用户</label>
        <div class="col-sm-10">
            
                                                    <input type="text" class="form-control" placeholder="输入评价用户" style="width:150px;" readonly="readonly" id="pingjiayonghu" name="pingjiayonghu" value="${mmm.pingjiayonghu}"/>                                            
        </div>
        
    </div>
</div>
                                <div class="form-group">
    <div class="row">
        <label style="max-width: 120px;min-height:18px;text-align: right" class="col-sm-2 hiddex-xs"> </label>
        <div class="col-sm-10">
            
                                            <input name="id" value="${mmm.id}" type="hidden"/>
                                                <input name="jiudianyudingid" value="${mmm.jiudianyudingid}" type="hidden"/>
                                                <input name="referer" value="<%=request.getHeader("referer")%>" type="hidden"/>
                        <input name="updtself" value="${updtself}" type="hidden"/>
                                        
                    
                    <button type="submit" class="btn btn-primary" name="Submit">
    提交
</button>
                    <button type="reset" class="btn btn-default" name="Submit2">
    重置
</button>

                
        </div>
        
    </div>
</div>
            
<!--form标签结束--></form>
        </div>
    </div>

<!-- container定宽，并剧中结束 --></div>





<script>
    $(function () {
        $('#form1').validate();
    });
</script>



</div>
<%@ include file="foot.jsp" %>
