<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
    <script type="text/javascript" src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
    <script type="text/javascript" src="./lib/layui/layui.js" charset="utf-8"></script>
    <script type="text/javascript" src="./js/xadmin.js"></script>
</head>
<body>
<div class="x-body">
        <form id="addRateType" class="layui-form" method="post" action="rate_type_add" >
          <div class="layui-form-item">
              <label  class="layui-form-label">
                  <span class="x-red">*</span>房价代码
              </label>
              <div class="layui-input-inline">
                  <input type="text" id="code" name="code" required="" lay-verify="code"
                  autocomplete="off" class="layui-input">
              </div>
          </div>
          <div class="layui-form-item">
              <label  class="layui-form-label">
                  <span class="x-red">*</span>类型名称
              </label>
              <div class="layui-input-inline">
                  <input type="text" id="name" name="name" required="" lay-verify="required"
                  autocomplete="off" class="layui-input">
              </div>
          </div>
          <div class="layui-form-item">
              <label  class="layui-form-label">
                  <span class="x-red">*</span>预付
              </label>
              <div class="layui-input-inline">
					<select name="prepaid" lay-verify="required">
					<option value="">请选择</option>
					  <option value='false'>不需要</option>
					  <option value='true'>需要</option>
					</select>
    			</div>
          </div>
          <div class="layui-form-item">
              <label class="layui-form-label">
                  <span class="x-red">*</span>免费取消时限(天)
              </label>
              <div class="layui-input-inline">
                  <input type="number" id="freeCancelDate" name="freeCancelDate" required="" lay-verify="number"
                  autocomplete="off" class="layui-input">
              </div>
          </div>
          <div class="layui-form-item">
              <label  class="layui-form-label">
                  <span class="x-red">*</span>公开房价
              </label>
              <div class="layui-input-inline">
					<select name="isToAll" lay-verify="required">
					<option value="">请选择</option>
					  <option value='false'>不公开</option>
					  <option value='true'>公开</option>
					</select>
    			</div>
          </div>
          <div class="layui-form-item layui-form-text">
              <label  class="layui-form-label">
                  描述
              </label>
              <div class="layui-input-block">
                  <textarea  id="description" name="description" class="layui-textarea"></textarea>
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
          });

        
          
          
        });
    </script>
   
</body>
</html>