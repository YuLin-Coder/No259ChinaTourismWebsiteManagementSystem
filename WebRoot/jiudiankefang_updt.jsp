<%@ page language="java" import="dao.*" pageEncoding="UTF-8"%>
<%@ page language="java" import="java.util.*"%>
<%@page import="util.Info"%>
<%@ taglib prefix="ssm" uri="http://ssm" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ include file="head.jsp" %>
<script src="js/jquery.validate.js"></script>
<link rel="stylesheet" href="js/layer/theme/default/layer.css"/>
<script src="js/layer/layer.js"></script>

<div style="padding: 10px">




<div class="container"><!-- 使用bootstrap css框架，container定宽，并剧中 https://v3.bootcss.com/css/#overview-container -->

    <div class="panel panel-default">
        <div class="panel-heading">
            编辑酒店客房:
        </div>
        <div class="panel-body">
            <form action="jiudiankefangupdate.do" method="post" name="form1" id="form1"><!-- form 标签开始 -->
    
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
        <label style="max-width: 120px;min-height:18px;text-align: right" class="col-sm-2 hiddex-xs">酒店类型</label>
        <div class="col-sm-10">
            
                                                    ${mmm.jiudianleixing}<input type="hidden" id="jiudianleixing" name="jiudianleixing" value="${Info.html(mmm.jiudianleixing)}"/>                                            
        </div>
        
    </div>
</div>
                                                        <div class="form-group">
    <div class="row">
        <label style="max-width: 120px;min-height:18px;text-align: right" class="col-sm-2 hiddex-xs">客房类型</label>
        <div class="col-sm-10">
            
                                                    <select class="form-control class_kefangleixing5" data-value="${Info.html(mmm.kefangleixing)}" id="kefangleixing" name="kefangleixing" style="width:250px">
<option value="单人房">单人房</option>
<option value="双人房">双人房</option>
<option value="套房">套房</option>

</select>
<script>
$(".class_kefangleixing5").val($(".class_kefangleixing5").attr("data-value"))</script>
                                            
        </div>
        
    </div>
</div>
                                                        <div class="form-group">
    <div class="row">
        <label style="max-width: 120px;min-height:18px;text-align: right" class="col-sm-2 hiddex-xs">客房图片<span style="color: red;">*</span></label>
        <div class="col-sm-10">
            
                                                    <div class="input-group" style="width:250px">
    <input type="text" class="form-control" data-rule-required="true" data-msg-required="请填写客房图片" id="kefangtupian" name="kefangtupian" value="${Info.html(mmm.kefangtupian)}"/>

    <span class="input-group-btn"><button type="button" class="btn btn-default" onclick="layer.open({type:2,title:'上传图片',fixed:true,shadeClose:true,shade:0.5,area:['320px','150px'],content:'upload.html?result=kefangtupian'})">
    上传图片
</button></span>
</div>                                            
        </div>
        
    </div>
</div>
                                                        <div class="form-group">
    <div class="row">
        <label style="max-width: 120px;min-height:18px;text-align: right" class="col-sm-2 hiddex-xs">客房价格<span style="color: red;">*</span></label>
        <div class="col-sm-10">
            
                                                    <input type="number" class="form-control" placeholder="输入客房价格" style="width:150px;" step="0.01" data-rule-required="true" data-msg-required="请填写客房价格" number="true" data-msg-number="输入一个有效数字" id="kefangjiage" name="kefangjiage" value="${Info.html(mmm.kefangjiage)}"/>                                            
        </div>
        
    </div>
</div>
                                                        <div class="form-group">
    <div class="row">
        <label style="max-width: 120px;min-height:18px;text-align: right" class="col-sm-2 hiddex-xs">剩余客房数</label>
        <div class="col-sm-10">
            
                                                    <input type="number" class="form-control" placeholder="输入剩余客房数" style="width:150px;" number="true" data-msg-number="输入一个有效数字" id="shengyukefangshu" name="shengyukefangshu" value="${Info.html(mmm.shengyukefangshu)}"/>                                            
        </div>
        
    </div>
</div>
                                <div class="form-group">
    <div class="row">
        <label style="max-width: 120px;min-height:18px;text-align: right" class="col-sm-2 hiddex-xs"> </label>
        <div class="col-sm-10">
            
                                            <input name="id" value="${mmm.id}" type="hidden"/>
                                                <input name="jiudianid" value="${mmm.jiudianid}" type="hidden"/>
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
