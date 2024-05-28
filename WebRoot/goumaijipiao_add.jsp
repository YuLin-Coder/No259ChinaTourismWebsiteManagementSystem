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
            添加购买机票:
        </div>
        <div class="panel-body">
            <form action="goumaijipiaoinsert.do" method="post" name="form1" id="form1"><!-- form 标签开始 -->
    
                                                        <div class="form-group">
    <div class="row">
        <label style="max-width: 120px;min-height:18px;text-align: right" class="col-sm-2 hiddex-xs">飞机票编号</label>
        <div class="col-sm-10">
            
                                                    ${readMap.feijipiaobianhao}<input type="hidden" id="feijipiaobianhao" name="feijipiaobianhao" value="${Info.html(readMap.feijipiaobianhao)}"/>                                            
        </div>
        
    </div>
</div>
                                                        <div class="form-group">
    <div class="row">
        <label style="max-width: 120px;min-height:18px;text-align: right" class="col-sm-2 hiddex-xs">航班号</label>
        <div class="col-sm-10">
            
                                                    ${readMap.hangbanhao}<input type="hidden" id="hangbanhao" name="hangbanhao" value="${Info.html(readMap.hangbanhao)}"/>                                            
        </div>
        
    </div>
</div>
                                                        <div class="form-group">
    <div class="row">
        <label style="max-width: 120px;min-height:18px;text-align: right" class="col-sm-2 hiddex-xs">所属航空公司</label>
        <div class="col-sm-10">
            
                                                    ${readMap.suoshuhangkonggongsi}<input type="hidden" id="suoshuhangkonggongsi" name="suoshuhangkonggongsi" value="${Info.html(readMap.suoshuhangkonggongsi)}"/>                                            
        </div>
        
    </div>
</div>
                                                        <div class="form-group">
    <div class="row">
        <label style="max-width: 120px;min-height:18px;text-align: right" class="col-sm-2 hiddex-xs">起飞时间</label>
        <div class="col-sm-10">
            
                                                    ${readMap.qifeishijian}<input type="hidden" id="qifeishijian" name="qifeishijian" value="${Info.html(readMap.qifeishijian)}"/>                                            
        </div>
        
    </div>
</div>
                                                        <div class="form-group">
    <div class="row">
        <label style="max-width: 120px;min-height:18px;text-align: right" class="col-sm-2 hiddex-xs">起飞城市</label>
        <div class="col-sm-10">
            
                                                    ${readMap.qifeichengshi}<input type="hidden" id="qifeichengshi" name="qifeichengshi" value="${Info.html(readMap.qifeichengshi)}"/>                                            
        </div>
        
    </div>
</div>
                                                        <div class="form-group">
    <div class="row">
        <label style="max-width: 120px;min-height:18px;text-align: right" class="col-sm-2 hiddex-xs">到达城市</label>
        <div class="col-sm-10">
            
                                                    ${readMap.daodachengshi}<input type="hidden" id="daodachengshi" name="daodachengshi" value="${Info.html(readMap.daodachengshi)}"/>                                            
        </div>
        
    </div>
</div>
                                                        <div class="form-group">
    <div class="row">
        <label style="max-width: 120px;min-height:18px;text-align: right" class="col-sm-2 hiddex-xs">到达时间</label>
        <div class="col-sm-10">
            
                                                    ${readMap.daodashijian}<input type="hidden" id="daodashijian" name="daodashijian" value="${Info.html(readMap.daodashijian)}"/>                                            
        </div>
        
    </div>
</div>
                                                        <div class="form-group">
    <div class="row">
        <label style="max-width: 120px;min-height:18px;text-align: right" class="col-sm-2 hiddex-xs">检票口</label>
        <div class="col-sm-10">
            
                                                    ${readMap.jianpiaokou}<input type="hidden" id="jianpiaokou" name="jianpiaokou" value="${Info.html(readMap.jianpiaokou)}"/>                                            
        </div>
        
    </div>
</div>
                                                        <div class="form-group">
    <div class="row">
        <label style="max-width: 120px;min-height:18px;text-align: right" class="col-sm-2 hiddex-xs">机票价格</label>
        <div class="col-sm-10">
            
                                                    ${readMap.jipiaojiage}<input type="hidden" id="jipiaojiage" name="jipiaojiage" value="${Info.html(readMap.jipiaojiage)}"/>                                            
        </div>
        
    </div>
</div>
                                                        <div class="form-group">
    <div class="row">
        <label style="max-width: 120px;min-height:18px;text-align: right" class="col-sm-2 hiddex-xs">身份证号<span style="color: red;">*</span></label>
        <div class="col-sm-10">
            
                                                    <input type="text" class="form-control" placeholder="输入身份证号" style="width:150px;" data-rule-required="true" data-msg-required="请填写身份证号" remote="checkno.do?checktype=insert&table=goumaijipiao&col=shenfenzhenghao" data-msg-remote="内容重复了" idcard="true" data-msg-email="请输入有效身份证号码" id="shenfenzhenghao" name="shenfenzhenghao" value=""/>                                            
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
        <label style="max-width: 120px;min-height:18px;text-align: right" class="col-sm-2 hiddex-xs">姓名<span style="color: red;">*</span></label>
        <div class="col-sm-10">
            
                                                    <input type="text" class="form-control" placeholder="输入姓名" style="width:150px;" data-rule-required="true" data-msg-required="请填写姓名" id="xingming" name="xingming" value="${sessionScope.xingming}"/>                                            
        </div>
        
    </div>
</div>
                                                        <div class="form-group">
    <div class="row">
        <label style="max-width: 120px;min-height:18px;text-align: right" class="col-sm-2 hiddex-xs">购买用户</label>
        <div class="col-sm-10">
            
                                                    <input type="text" class="form-control" placeholder="输入购买用户" style="width:150px;" readonly="readonly" id="goumaiyonghu" name="goumaiyonghu" value="${sessionScope.username}"/>                                            
        </div>
        
    </div>
</div>
                                <div class="form-group">
    <div class="row">
        <label style="max-width: 120px;min-height:18px;text-align: right" class="col-sm-2 hiddex-xs"> </label>
        <div class="col-sm-10">
            
                                                                <input type="hidden" name="feijipiaoid" value="${param.id}"/>
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
