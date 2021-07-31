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
    <link rel="stylesheet" href="lib/layui/css/layui.css" media="all">
    <link href="css/bootstrap/3.3.6/bootstrap.min.css" rel="stylesheet">
    <link href="css/back/style.css" rel="stylesheet">
    <script src="js/jquery/2.0.0/jquery.min.js"></script>
	<script src="js/bootstrap/3.3.6/bootstrap.min.js"></script>
    <script type="text/javascript" src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
    <script type="text/javascript" src="./lib/layui/layui.js" charset="utf-8"></script>
    <script type="text/javascript" src="./js/xadmin.js"></script>
     <script>
    	layui.use('laydate',function(){
    	var laydate = layui.laydate;
    		laydate.render({elem: '#fromDate'
		});
			laydate.render({elem:'#toDate'			
			})
			
    	});
    </script>
    <script >
    function checkDate() {
			var fromDate=document.getElementById("fromDate");
			var toDate=document.getElementById("toDate");
			
			if(fromDate.value.length==0) {fromDate.value="2000-01-30";}
			if(toDate.value.length==0){toDate.value="2000-01-30";}

			return true;
	}
   	
    </script>
</head>
<body>
    <div class="x-nav">
      <span class="layui-breadcrumb">
        <a href="">首页</a>
        <a href="">房价管理</a>
        <a>
          <cite>房价规则</cite></a>
      </span>
      <a class="layui-btn layui-btn-small" style="line-height:1.6em;margin-top:3px;float:right" href="rate_rule_list" title="刷新">
        <i class="layui-icon" style="line-height:30px">⥁</i></a>
    </div>
    <div class="x-body">
      <div class="layui-row">
        <form class="layui-form layui-col-md12 x-so" method="post" action="rate_rule_search" onsubmit="return checkDate();">
              		  <input type="number" class="layui-input" name="id" id="id" placeholder="编号" >       
           <input type="text" class="layui-input" name="fromDate" id="fromDate" placeholder="开始日期">
        <input type="text" class="layui-input" name="toDate" id="toDate" placeholder="结束日期" >
        <div class="layui-inline">
          <select name="rateType" id="rateType"  lay-search  >
          <option value="">房价类型</option>
          <c:forEach items="${s}" var='b'>
          	 <option value='${b.code}'>${b.code} - ${b.name}</option>
          </c:forEach>
        </select>
        </div>
		<div class="layui-inline">
		 <select name="rmType" id="rmType"  lay-search >
          <option value="">客房类型</option>
          <c:forEach items="${r}" var='b'>
          	 <option value='${b.code}'>${b.code} - ${b.name}</option>
          </c:forEach>
        </select>
		</div>
          <button class="layui-btn"  lay-submit="" lay-filter="sreach" ><i class="layui-icon">&#xe615;</i></button>
        </form>
      </div>
      <xblock>
        <button class="layui-btn layui-btn-danger" onclick="delAll()"  ><i class="layui-icon"></i>批量删除</button>
        <button class="layui-btn" onclick="x_admin_show('添加房价规则','show_rate_rule_add')"><i class="layui-icon"></i>添加</button>
        <span class="x-right" style="line-height:40px">共有数据：${total}条</span>
      </xblock>
      <table class="layui-table">
        <thead>
          <tr>
            <th rowspan="2">
              <div class="layui-unselect header layui-form-checkbox" lay-skin="primary"><i class="layui-icon">&#xe605;</i></div>
            </th>
            <th rowspan="2">编号</th>
            <th rowspan="2">开始日期</th>
            <th rowspan="2">结束日期</th>
            <th rowspan="2">房价类型</th>
            <th rowspan="2">客房类型</th>
            <th rowspan="2">价格</th>
            <th colspan="7">生效日期</th>
            <th rowspan="2">操作</th>
            </tr>
            <tr>
            <th>周一</th>
            <th>周二</th>
            <th>周三</th>
            <th>周四</th>
            <th>周五</th>
            <th>周六</th>
            <th>周日</th>
            </tr>
        </thead>
        <tbody>
        <c:forEach items="${cs}" var="c">
          <tr id="biuuu_city_list">
            <td>
              <div name='cb' class="layui-unselect layui-form-checkbox" lay-skin="primary" data-id=${c.id}><i class="layui-icon">&#xe605;</i></div>
            </td>
            <td  name='id'>${c.id}</td>
            <td >${c.fromDate}</td>
            <td >${c.toDate}</td>
            <td> <a  onclick="x_admin_show('查看','rate_type_edit?code=${c.rateType}')" href="javascript:;">${c.rateType}</a></td>
                         <td><a  onclick="x_admin_show('查看','room_type_edit?code=${c.rmType}')" href="javascript:;">${c.rmType}</a></td>
            
            <td >${c.rate}</td>
            <td>
				<c:if test="${c.mon}"><i class="layui-icon layui-icon-circle-dot" style="color:pink"></i></c:if>
			</td>
			<td>
				<c:if test="${c.tue}"><i class="layui-icon layui-icon-circle-dot" style="color: pink;"></i></c:if>
			</td>
			<td>
				<c:if test="${c.wed}"><i class="layui-icon layui-icon-circle-dot" style="color: pink;"></i></c:if>
			</td>
			<td>
				<c:if test="${c.thu}"><i class="layui-icon layui-icon-circle-dot" style="color: pink;"></i></c:if>
			</td>
			<td>
				<c:if test="${c.fri}"><i class="layui-icon layui-icon-circle-dot" style="color: pink;"></i></c:if>
			</td>
			<td>
				<c:if test="${c.sat}"><i class="layui-icon layui-icon-circle-dot" style="color: pink;"></i></c:if>
			</td>
			<td>
				<c:if test="${c.sun}"><i class="layui-icon layui-icon-circle-dot" style="color: pink;"></i></c:if>
			</td>
			 <td class="td-manage">
              <a title="查看"  onclick="x_admin_show('编辑','rate_rule_edit?id=${c.id}')" href="javascript:;">
                <i class="layui-icon">&#xe63c;</i>
              </a>
              <a deleteLink="true" title="删除" href="rate_rule_delete?id=${c.id}"  >
                <i class="layui-icon">&#xe640;</i>
              </a>
            </td>
			</tr>
           
        </c:forEach>
        </tbody>
      </table>
     <c:if test="${sear eq 1}">
      <div class="pageDiv">
        <%@include file="./adminPage.jsp" %>
      </div>
      </c:if>

    </div>
    
    <script>
      layui.use('laydate', function(){
        var laydate = layui.laydate;
        
        //执行一个laydate实例
        laydate.render({
          elem: '#start' //指定元素
        });

        //执行一个laydate实例
        laydate.render({
          elem: '#end' //指定元素
        });
      });

      

      /*用户-删除*/
      $(function(){
      		$("a").click(function(){
      			var deleteLink=$(this).attr("deleteLink");
      			if("true"==deleteLink){
      				var i=window.confirm("确认要删除吗?");
      				if(i)
      					return true;
      				return false;
      			}
      		});
      })
      



      function delAll (argument) {
      var data = tableCheck.getData();
  	if(data.length!=0){
  	var flag=window.confirm("确认要删除吗？");
     if(flag){
          console.info(data);
     $(".layui-form-checked").not('.header').parents('tr').remove();
  	 	window.location.href="rate_rule_delete_group?ids="+data;
  	}
  	}else{
	  alert("请选择一条或多条数据进行删除");
	}



//
       /*  
  
        layer.confirm('确认要删除吗？'+data,function(index){
            //捉到所有被选中的，发异步进行删除
            layer.msg('删除成功', {icon: 1});
            $(".layui-form-checked").not('.header').parents('tr').remove();
        }); */
      }
    </script>
    <script>var _hmt = _hmt || []; (function() {
        var hm = document.createElement("script");
        hm.src = "https://hm.baidu.com/hm.js?b393d153aeb26b46e9431fabaf0f6190";
        var s = document.getElementsByTagName("script")[0];
        s.parentNode.insertBefore(hm, s);
      })();</script>
  </body>
</html>