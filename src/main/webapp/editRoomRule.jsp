<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
    <title>欢迎页面-X-admin2.0</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi" />
    <link rel="shortcut icon" href="/favicon.ico" type="image/x-icon" />
    <link rel="stylesheet" href="./css/font.css">
    <link rel="stylesheet" href="./css/xadmin.css">
    <link rel="stylesheet" href="./lib/layui/css/layui.css"  media="all">
    <script type="text/javascript" src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
    <script type="text/javascript" src="./lib/layui/layui.js" charset="utf-8"></script>
    <script type="text/javascript" src="./js/xadmin.js"></script>
</head>
<body>
<div class="x-body">
        <form id="rate_rule_add" class="layui-form" method="post" action="room_rule_update" >
        <div class="layui-form-item">
              <label  class="layui-form-label">
                  <span class="x-red">*</span>编号
              </label>
            <div class="layui-input-inline">
                  <input type="number" id="id" name="id" required="" lay-verify="required"
                  autocomplete="off" class="layui-input" value="${c.id}" readonly="readonly" >
              </div>
      </div>
          <div class="layui-form-item">
              <label  class="layui-form-label">
                  <span class="x-red">*</span>开始日期
              </label>
           <div class="layui-input-inline">
        <input type="text" class="layui-input" name="fromDate" id="fromDate" placeholder="yyyy-MM-dd" required="" lay-verify="required" value=${c.fromDate}>
      </div>
          </div>
          <div class="layui-form-item">
              <label  class="layui-form-label">
                  <span class="x-red">*</span>结束日期
              </label>
           <div class="layui-input-inline">
        <input type="text" class="layui-input" name="toDate" id="toDate" placeholder="yyyy-MM-dd" required="" lay-verify="fd" value=${c.toDate}>
      </div>
          </div>
          <div class="layui-form-item">
              <label  class="layui-form-label">
                  <span class="x-red">*</span>客房类型
              </label>
              <div class="layui-input-inline">
                 <select name="rmType" id="rmType" lay-verify="required" lay-search>
          <option value="">请选择</option>
          <c:forEach items="${s}" var='b'>
          	 <option value='${b.code}' <c:if test="${b.code eq c.rmType}">selected="selected"</c:if>>${b.code}  客房数:${b.num}</option>
          </c:forEach>
        </select>
              </div>
          </div>
           <div class="layui-form-item">
              <label  class="layui-form-label">
                  <span class="x-red">*</span>不可出售房间数
              </label>
              <div class="layui-input-inline">
                  <input type="number" id="num" name="num" required="" lay-verify="number"
                  autocomplete="off" class="layui-input" value=${c.num}>
              </div>
          </div>
          <div class="layui-form-item layui-form-text">
              <label  class="layui-form-label">
                  描述
              </label>
              <div class="layui-input-block">
                  <textarea  id="notes" name="notes" class="layui-textarea">${c.notes}</textarea>
              </div>
          </div>
          <div class="layui-form-item">
              <label for="L_repass" class="layui-form-label">
              </label>
              <button  class="layui-btn" lay-filter="add" lay-submit="">
                  增加
              </button>
          </div>
      </form>
    </div>
    
    <script>
    	layui.use('laydate',function(){
    	var laydate = layui.laydate;
    		laydate.render({elem: '#fromDate'
		});
			laydate.render({elem:'#toDate'			
			})
    	});
    </script>
    <script>
        layui.use(['form','layer'], function(){
            $ = layui.jquery;
          var form = layui.form
          ,layer = layui.layer;
        
          //自定义验证规则
          form.verify({
            nikename: function(value){
              if(value.length < 5){
                return '昵称至少得5个字符啊';
              }
            }
            ,pass: [/(.+){6,12}$/, '密码必须6到12位']
            ,repass: function(value){
                if($('#L_pass').val()!=$('#L_repass').val()){
                    return '两次密码不一致';
                }
            }
            ,code:[/^[\S]{3,3}$/,'代码必须3个字母或数字，且不能出现空格']
            ,fd:function(value){
            	if($('#fromDate').val()>$('#toDate').val()){
            	return '开始日期不能大于结束日期';
            	}
            }
          });

         
          
        });
    </script>
   
   
</body>
</html>