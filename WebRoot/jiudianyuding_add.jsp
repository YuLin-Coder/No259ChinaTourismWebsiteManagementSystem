<%@ page language="java" import="dao.*" pageEncoding="UTF-8"%>
<%@ page language="java" import="java.util.*"%>
<%@page import="util.Info"%>
<%@ taglib prefix="ssm" uri="http://ssm" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ include file="head.jsp" %>
<script src="js/jquery.validate.js"></script>
<script src="js/datepicker/WdatePicker.js"></script>

<div style="padding: 10px">




<div class="container"><!-- 使用bootstrap css框架，container定宽，并剧中 https://v3.bootcss.com/css/#overview-container -->

    <div class="panel panel-default">
        <div class="panel-heading">
            添加酒店预定:
        </div>
        <div class="panel-body">
            <form action="jiudianyudinginsert.do" method="post" name="form1" id="form1"><!-- form 标签开始 -->
    
                                                        <div class="form-group">
    <div class="row">
        <label style="max-width: 120px;min-height:18px;text-align: right" class="col-sm-2 hiddex-xs">预定单号</label>
        <div class="col-sm-10">
            
                                                    <input type="text" class="form-control" placeholder="输入预定单号" style="width:150px;" readonly="readonly" id="yudingdanhao" name="yudingdanhao" value="${Info.getID()}"/>                                            
        </div>
        
    </div>
</div>
                                                        <div class="form-group">
    <div class="row">
        <label style="max-width: 120px;min-height:18px;text-align: right" class="col-sm-2 hiddex-xs">酒店编号</label>
        <div class="col-sm-10">
            
                                                    ${readMap.jiudianbianhao}<input type="hidden" id="jiudianbianhao" name="jiudianbianhao" value="${Info.html(readMap.jiudianbianhao)}"/>                                            
        </div>
        
    </div>
</div>
                                                        <div class="form-group">
    <div class="row">
        <label style="max-width: 120px;min-height:18px;text-align: right" class="col-sm-2 hiddex-xs">酒店名称</label>
        <div class="col-sm-10">
            
                                                    ${readMap.jiudianmingcheng}<input type="hidden" id="jiudianmingcheng" name="jiudianmingcheng" value="${Info.html(readMap.jiudianmingcheng)}"/>                                            
        </div>
        
    </div>
</div>
                                                        <div class="form-group">
    <div class="row">
        <label style="max-width: 120px;min-height:18px;text-align: right" class="col-sm-2 hiddex-xs">酒店类型</label>
        <div class="col-sm-10">
            
                                                    ${readMap.jiudianleixing}<input type="hidden" id="jiudianleixing" name="jiudianleixing" value="${Info.html(readMap.jiudianleixing)}"/>                                            
        </div>
        
    </div>
</div>
                                                        <div class="form-group">
    <div class="row">
        <label style="max-width: 120px;min-height:18px;text-align: right" class="col-sm-2 hiddex-xs">客房类型</label>
        <div class="col-sm-10">
            
                                                    ${readMap.kefangleixing}<input type="hidden" id="kefangleixing" name="kefangleixing" value="${Info.html(readMap.kefangleixing)}"/>                                            
        </div>
        
    </div>
</div>
                                                        <div class="form-group">
    <div class="row">
        <label style="max-width: 120px;min-height:18px;text-align: right" class="col-sm-2 hiddex-xs">客房图片</label>
        <div class="col-sm-10">
            
                                                    <c:choose>
<c:when test="${'' == readMap.kefangtupian }">
-</c:when><c:otherwise><img width="100" src="${readMap.kefangtupian}"/></c:otherwise></c:choose><input type="hidden" id="kefangtupian" name="kefangtupian" value="${Info.html(readMap.kefangtupian)}"/>                                            
        </div>
        
    </div>
</div>
                                                        <div class="form-group">
    <div class="row">
        <label style="max-width: 120px;min-height:18px;text-align: right" class="col-sm-2 hiddex-xs">客房价格</label>
        <div class="col-sm-10">
            
                                                    ${readMap.kefangjiage}<input type="hidden" id="kefangjiage" name="kefangjiage" value="${Info.html(readMap.kefangjiage)}"/>                                            
        </div>
        
    </div>
</div>
                                                        <div class="form-group">
    <div class="row">
        <label style="max-width: 120px;min-height:18px;text-align: right" class="col-sm-2 hiddex-xs">预计入住时间<span style="color: red;">*</span></label>
        <div class="col-sm-10">
            
                                                    <input type="text" class="form-control" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',lang:'zh-cn'})" style="width:200px;" data-rule-required="true" data-msg-required="请填写预计入住时间" id="yujiruzhushijian" name="yujiruzhushijian" readonly="readonly" value=""/>                                            
        </div>
        
    </div>
</div>
                                                        <div class="form-group">
    <div class="row">
        <label style="max-width: 120px;min-height:18px;text-align: right" class="col-sm-2 hiddex-xs">预定间数<span style="color: red;">*</span></label>
        <div class="col-sm-10">
            
                                                    <input type="number" class="form-control" placeholder="输入预定间数" style="width:150px;" data-rule-required="true" data-msg-required="请填写预定间数" number="true" data-msg-number="输入一个有效数字" id="yudingjianshu" name="yudingjianshu" value=""/>                                            
        </div>
        
    </div>
</div>
                                                        <div class="form-group">
    <div class="row">
        <label style="max-width: 120px;min-height:18px;text-align: right" class="col-sm-2 hiddex-xs">联系电话<span style="color: red;">*</span></label>
        <div class="col-sm-10">
            
                                                    <input type="text" class="form-control" placeholder="输入联系电话" style="width:150px;" data-rule-required="true" data-msg-required="请填写联系电话" phone="true" data-msg-phone="请输入正确手机号码" id="lianxidianhua" name="lianxidianhua" value=""/>                                            
        </div>
        
    </div>
</div>
                                                        <div class="form-group">
    <div class="row">
        <label style="max-width: 120px;min-height:18px;text-align: right" class="col-sm-2 hiddex-xs">身份证号<span style="color: red;">*</span></label>
        <div class="col-sm-10">
            
                                                    <input type="text" class="form-control" placeholder="输入身份证号" style="width:150px;" data-rule-required="true" data-msg-required="请填写身份证号" idcard="true" data-msg-email="请输入有效身份证号码" id="shenfenzhenghao" name="shenfenzhenghao" value=""/>                                            
        </div>
        
    </div>
</div>
                                                        <div class="form-group">
    <div class="row">
        <label style="max-width: 120px;min-height:18px;text-align: right" class="col-sm-2 hiddex-xs">姓名<span style="color: red;">*</span></label>
        <div class="col-sm-10">
            
                                                    <input type="text" class="form-control" placeholder="输入姓名" style="width:150px;" data-rule-required="true" data-msg-required="请填写姓名" id="xingming" name="xingming" value="${sessionScope.xingming}"/>                                            
        </div>
        
    </div>
</div>
                                                        <div class="form-group">
    <div class="row">
        <label style="max-width: 120px;min-height:18px;text-align: right" class="col-sm-2 hiddex-xs">预定用户</label>
        <div class="col-sm-10">
            
                                                    <input type="text" class="form-control" placeholder="输入预定用户" style="width:150px;" readonly="readonly" id="yudingyonghu" name="yudingyonghu" value="${sessionScope.username}"/>                                            
        </div>
        
    </div>
</div>
                                <div class="form-group">
    <div class="row">
        <label style="max-width: 120px;min-height:18px;text-align: right" class="col-sm-2 hiddex-xs"> </label>
        <div class="col-sm-10">
            
                                                                <input type="hidden" name="jiudiankefangid" value="${param.id}"/>
                        <input name="referer" value="<%=request.getHeader("referer")%>" type="hidden"/>
                    
                                                                                                                        <input type="hidden" name="iszf" value="否"/>
                                            
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
