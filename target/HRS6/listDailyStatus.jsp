<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" import="java.util.*"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
    <title>酒店预订管理系统</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi" />
    <link rel="shortcut icon" href="/favicon.ico" type="image/x-icon" />
    <link rel="stylesheet" href="./css/font.css">
    <link rel="stylesheet" href="./css/xadmin.css">
    <link href="css/bootstrap/3.3.6/bootstrap.min.css" rel="stylesheet">
    <link href="css/back/style.css" rel="stylesheet">
    <script src="js/jquery/2.0.0/jquery.min.js"></script>
	<script src="js/bootstrap/3.3.6/bootstrap.min.js"></script>
    <script type="text/javascript" src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
    <script type="text/javascript" src="./lib/layui/layui.js" charset="utf-8"></script>
    <script type="text/javascript" src="./js/xadmin.js"></script>
</head>
<body>
    <div class="x-nav">
      <span class="layui-breadcrumb">
        <a href="">首页</a>
        <a href="">房态管理</a>
        <a>
          <cite>每日房态</cite></a>
      </span>
      <a class="layui-btn layui-btn-small" style="line-height:1.6em;margin-top:3px;float:right" href="list_DS" title="刷新">
        <i class="layui-icon" style="line-height:30px">⥁</i></a>
    </div>
    <div class="x-body">
      <div class="layui-row">
        <form class="layui-form layui-col-md12 x-so" method="post" action="list_DS_search">
          <input type="text" class="layui-input" name="fromDate" id="fromDate" placeholder="开始日期" required="" lay-verify="fdk">
        <input type="text" class="layui-input" name="toDate" id="toDate" placeholder="结束日期" required="" lay-verify="fdk">
             <div class="layui-inline">
		 <select name="rmType" id="rmType"  lay-search required="" lay-verify="required">
          <option value="">客房类型</option>
          <c:forEach items="${r}" var='b'>
          	 <option value='${b.code}'>${b.code} - ${b.name}</option>
          </c:forEach>
        </select>
		</div>
          <button class="layui-btn"  lay-submit="" lay-filter="sreach" ><i class="layui-icon">&#xe615;</i></button>
        </form>
      </div>
      
      <table class="layui-table">
        <thead>
          <tr>
      
            <th>日期</th>
            <th>房型名称</th>
            <th>已预订</th>
            <th>不可用</th>
            <th>剩余可预订</th>
            <th>总数</th>
            </tr>
        </thead>
        <tbody>
        <c:forEach items="${list}" var="c">
          <tr>
            
            <td name='code'>${c.ddate}</td>
            <td>${c.rmType}</td>
            <td>${c.sold}</td>
            <td>${c.other}</td>
            <td>${c.num}</td>
            <td >${c.rest}</td>
          </tr>
        </c:forEach>
        </tbody>
      </table>
      

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
   
  </body>
</html>