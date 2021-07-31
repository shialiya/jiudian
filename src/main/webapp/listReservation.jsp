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
     <script>
    	layui.use('laydate',function(){
    	var laydate = layui.laydate;
    		laydate.render({elem: '#ciDate'
		});
			laydate.render({elem:'#coDate'			
			});
			laydate.render({elem:'#madeDate'})
    	});
    </script>
    <script >
    function checkDate() {
			var ciDate=document.getElementById("ciDate");
			var ciDatev=ciDate.value;
			var coDate=document.getElementById("coDate");
			var coDatev=coDate.value;
			var madeDate=document.getElementById("madeDate");
			var madeDatev=madeDate.value;
			var n=1;
			if(ciDate.value.length==0) {ciDate.value="2000-01-30";}
			if(coDate.value.length==0){coDate.value="2000-01-30";}
			if(madeDate.value.length==0){ madeDate.value="2000-01-30";}

			return true;
	}
   	
    </script>
</head>
<body>
    <div class="x-nav">
      <span class="layui-breadcrumb">
        <a href="">首页</a>
        <a href="">预订管理</a>
        <a>
          <cite>预订列表</cite></a>
      </span>
      <a class="layui-btn layui-btn-small" style="line-height:1.6em;margin-top:3px;float:right" href="rsv_list" title="刷新">
        <i class="layui-icon" style="line-height:30px">⥁</i></a>
    </div>
    <div class="x-body">
      <div class="layui-row">
        <form class="layui-form layui-col-md12 x-so" method="post" action="search_rsv" onsubmit="return checkDate();">
          <input type="text" class="layui-input" name="ciDate" id="ciDate" placeholder="入住日期">
        <input type="text" class="layui-input" name="coDate" id="coDate" placeholder="离店日期" >
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
		  <input type="text" class="layui-input" name="name1" id="name1" placeholder="名" >
		  <input type="text" class="layui-input" name="surname1" id="surname1" placeholder="姓" >
		  <input type="text" class="layui-input" name="phone" id="phone" placeholder="电话号码"  >
		  <input type="text" class="layui-input" name="country" id="country" placeholder="电子邮箱地址" >
		<div class="layui-input-inline">
					<select name="rsvFrom" id="rsvFrom"  >
					<option value="">预订来源</option>
					  <option value='TEL'>TEL</option>
					  <option value='SPG'>SPG</option>
					  <option value='EMAIL'>EMAIL</option>
					  <option value='FAX'>FAX</option>
					  <option value='CTRIP'>CTRIP</option>
					  <option value='FLIGGY'>FLIGGY</option>					  
					</select>
    			</div>
    			<div class="layui-input-inline">
					<select name="status" id="status" >
					<option value="">状态</option>
					  <option value='Pending' >Pending</option>
					  <option value='Confirmed' >Confirmed</option>
					  <option value='Canceled'>Canceled</option>
					</select>
    			</div>
		  <input type="number" class="layui-input" name="confirmID" id="confirmID" placeholder="确认号码" >
    	 <input type="text" class="layui-input" name="madeDate" id="madeDate" placeholder="预订日期" >
          <button   class="layui-btn" lay-submit=""><i class="layui-icon">&#xe615;</i></button>
          
        </form>
      </div>
      <xblock>
        <span  style="line-height:40px">共有数据：${total}条  <a href="xx.jsp">滴滴</a></span>
      </xblock>
      <table class="layui-table">
        <thead>
          <tr>
            
            <th>确认号码</th>
            <th>入住日期</th>
            <th>离店日期</th>
            <th>客人姓名</th>
            <th>同住人姓名</th>
            <th>客房类型</th>
            <th>房价类型</th>
            <th>总金额</th>
            <th>状态</th>
            <th>操作</th>
            </tr>
        </thead>
        <tbody>
        <c:forEach items="${cs}" var="c">
          <tr   >
            
            <td name='confirmID'>${c.confirmID}</td>
            <td>${c.ciDate}</td>
            <td>${c.coDate}</td>
            <td>${c.name1} ${c.surname1} ${c.title1}</td>
            <td>${c.name2} ${c.surname2} ${c.title12}</td>
            <td><a  onclick="x_admin_show('查看','room_type_edit?code=${c.rmType}')" href="javascript:;">${c.rmType}</a></td>
            <td> <a  onclick="x_admin_show('查看','rate_type_edit?code=${c.rateType}')" href="javascript:;">${c.rateType}</a></td>
            <td>${c.amount}</td>
            <td <c:if test="${c.status eq 'Canceled'}">style="background-color:red"</c:if>
            <c:if test="${c.status eq 'Pending'}">style="background-color:yellow"</c:if>
            <c:if test="${c.status eq 'Confirmed'}">style="background-color:green"</c:if>
            >${c.status}</td>
            <td class="td-manage">
              <a title="查看"  onclick="x_admin_show('编辑','rsv_edit?id=${c.confirmID}')" href="javascript:;">
                <i class="layui-icon">&#xe63c;</i>
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
     
      
      
    </script>
   
   
  </body>
</html>