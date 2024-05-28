<%@ page language="java" import="dao.*" pageEncoding="UTF-8"%>
<%@ page language="java" import="java.util.*"%>
<%@page import="util.Info"%>
<%@ taglib prefix="ssm" uri="http://ssm" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ include file="head.jsp" %>
<script src="js/jquery.validate.js"></script>
<link rel="stylesheet" href="js/layer/theme/default/layer.css"/>
<script src="js/layer/layer.js"></script>
<link href="js/h5upload/h5upload.css" rel="stylesheet">
<script src="js/h5upload/h5upload.js"></script>
<script src="http://api.map.baidu.com/api?v=2.0&ak=AoBYL0LlRkcYBMCeay4fgpq7qaIYlKjs"></script>
<link href="js/baidumap.css" rel="stylesheet">
<script src="js/baidumap.js"></script>
<link rel="stylesheet" href="js/umeditor/themes/default/css/umeditor.css"/>
<script src="js/umeditor/umeditor.config.js"></script>
<script src="js/umeditor/umeditor.min.js"></script>

<div style="padding: 10px">




<div class="container"><!-- 使用bootstrap css框架，container定宽，并剧中 https://v3.bootcss.com/css/#overview-container -->

    <div class="panel panel-default">
        <div class="panel-heading">
            编辑景点攻略:
        </div>
        <div class="panel-body">
            <form action="jingdiangonglueupdate.do" method="post" name="form1" id="form1"><!-- form 标签开始 -->
    
                                                        <div class="form-group">
    <div class="row">
        <label style="max-width: 120px;min-height:18px;text-align: right" class="col-sm-2 hiddex-xs">景点编号</label>
        <div class="col-sm-10">
            
                                                    <input type="text" class="form-control" placeholder="输入景点编号" style="width:150px;" readonly="readonly" id="jingdianbianhao" name="jingdianbianhao" value="${Info.html(mmm.jingdianbianhao)}"/>                                            
        </div>
        
    </div>
</div>
                                                        <div class="form-group">
    <div class="row">
        <label style="max-width: 120px;min-height:18px;text-align: right" class="col-sm-2 hiddex-xs">景点名称<span style="color: red;">*</span></label>
        <div class="col-sm-10">
            
                                                    <input type="text" class="form-control" placeholder="输入景点名称" style="width:150px;" data-rule-required="true" data-msg-required="请填写景点名称" id="jingdianmingcheng" name="jingdianmingcheng" value="${Info.html(mmm.jingdianmingcheng)}"/>                                            
        </div>
        
    </div>
</div>
                                                        <div class="form-group">
    <div class="row">
        <label style="max-width: 120px;min-height:18px;text-align: right" class="col-sm-2 hiddex-xs">景点图片<span style="color: red;">*</span></label>
        <div class="col-sm-10">
            
                                                    <input type="hidden" data-rule-required="true" data-msg-required="请填写景点图片" id="jingdiantupian" name="jingdiantupian" value="${Info.html(mmm.jingdiantupian)}"/>
        <script>showUploadImages("#jingdiantupian")</script>
                                                    
        </div>
        
    </div>
</div>
                                                        <div class="form-group">
    <div class="row">
        <label style="max-width: 120px;min-height:18px;text-align: right" class="col-sm-2 hiddex-xs">所在城市<span style="color: red;">*</span></label>
        <div class="col-sm-10">
            
                                                    <input type="text" class="form-control" placeholder="输入所在城市" style="width:150px;" data-rule-required="true" data-msg-required="请填写所在城市" id="suozaichengshi" name="suozaichengshi" value="${Info.html(mmm.suozaichengshi)}"/>                                            
        </div>
        
    </div>
</div>
                                                        <div class="form-group">
    <div class="row">
        <label style="max-width: 120px;min-height:18px;text-align: right" class="col-sm-2 hiddex-xs">门票价格<span style="color: red;">*</span></label>
        <div class="col-sm-10">
            
                                                    <input type="number" class="form-control" placeholder="输入门票价格" style="width:150px;" step="0.01" data-rule-required="true" data-msg-required="请填写门票价格" number="true" data-msg-number="输入一个有效数字" id="menpiaojiage" name="menpiaojiage" value="${Info.html(mmm.menpiaojiage)}"/>                                            
        </div>
        
    </div>
</div>
                                                        <div class="form-group">
    <div class="row">
        <label style="max-width: 120px;min-height:18px;text-align: right" class="col-sm-2 hiddex-xs">开放时间<span style="color: red;">*</span></label>
        <div class="col-sm-10">
            
                                                    <input type="text" class="form-control" placeholder="输入开放时间" style="width:150px;" data-rule-required="true" data-msg-required="请填写开放时间" id="kaifangshijian" name="kaifangshijian" value="${Info.html(mmm.kaifangshijian)}"/>                                            
        </div>
        
    </div>
</div>
                                                        <div class="form-group">
    <div class="row">
        <label style="max-width: 120px;min-height:18px;text-align: right" class="col-sm-2 hiddex-xs">景点位置</label>
        <div class="col-sm-10">
            
                                                    <div class="input-address" id="jingdianweizhi_address"><input type="hidden" class="form-control" placeholder="输入景点位置" style="width:250px;" id="jingdianweizhi" name="jingdianweizhi" value="${Info.html(mmm.jingdianweizhi)}"/><input type="text" class="form-control" id="jingdianweizhi_input" style="width:250px;"/><button type="button" class="btn btn-default" id="jingdianweizhi_button" value="搜索">
    
</button></div><div id="jingdianweizhi_view" class="address" style="margin-top:10px; width:80%;height:280px;"></div><script>showSelectAddress("jingdianweizhi")</script>                                            
        </div>
        
    </div>
</div>
                                                        <div class="form-group">
    <div class="row">
        <label style="max-width: 120px;min-height:18px;text-align: right" class="col-sm-2 hiddex-xs">攻略详情</label>
        <div class="col-sm-10">
            
                                                    <textarea id="gongluexiangqing" name="gongluexiangqing" style="max-width: 750px;width:100%; height: 300px;">${Info.html(mmm.gongluexiangqing)}</textarea><script>
            (function(){
                var um = UM.getEditor('gongluexiangqing');
            })();
            </script>                                            
        </div>
        
    </div>
</div>
                                <div class="form-group">
    <div class="row">
        <label style="max-width: 120px;min-height:18px;text-align: right" class="col-sm-2 hiddex-xs"> </label>
        <div class="col-sm-10">
            
                                            <input name="id" value="${mmm.id}" type="hidden"/>
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
