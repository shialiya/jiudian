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
    <link rel="stylesheet" href="lib/layui/css/layui.css" media="all">
    <link rel="stylesheet" href="./css/xadmin.css">
    <link href="css/bootstrap/3.3.6/bootstrap.min.css" rel="stylesheet">
    <link href="css/back/style.css" rel="stylesheet">
    <script src="js/jquery-3.3.1/jquery-3.3.1.min.js"></script>
	<script src="js/bootstrap/3.3.6/bootstrap.min.js"></script>
    <script type="text/javascript" src="./lib/layui/layui.js" charset="utf-8"></script>
    <script type="text/javascript" src="./js/xadmin.js"></script>
     <script>
    	layui.use('laydate',function(){
    	var laydate = layui.laydate;
    	var myDate = new Date();
    	laydate.render({elem: '#ciDate',min:'${myDate.toLocaleDateString()}'
		});
			laydate.render({elem:'#coDate'	,min:'${myDate.toLocaleDateString()}'	
			});
    	});
    </script>
    <script>
        function currencyFormat(fld, milSep, decSep, e) {
            var sep = 0;
            var key = '';
            var i = j = 0;
            var len = len2 = 0;
            var strCheck = '0123456789';
            var aux = aux2 = '';
            var whichCode = (window.Event) ? e.which : e.keyCode;
            if (whichCode == 13) return true; 
            key = String.fromCharCode(whichCode); 
            if (strCheck.indexOf(key) == -1) return false; // Not a valid key
            len = fld.value.length;
            for(i = 0; i < len; i++)
            if ((fld.value.charAt(i) != '0') && (fld.value.charAt(i) != decSep)) break;
            aux = '';
            for(; i < len; i++)
            if (strCheck.indexOf(fld.value.charAt(i))!=-1) aux += fld.value.charAt(i);
            aux += key;
            len = aux.length;
            if (len == 0) fld.value = '';
            if (len == 1) fld.value = '0'+ decSep + '0' + aux;
            if (len == 2) fld.value = '0'+ decSep + aux;
            if (len > 2) {
            aux2 = '';
            for (j = 0, i = len - 3; i >= 0; i--) {
            if (j == 3) {
            aux2 += milSep;
            j = 0;
            }
            aux2 += aux.charAt(i);
            j++;
            }
            fld.value = '';
            len2 = aux2.length;
            for (i = len2 - 1; i >= 0; i--)
            fld.value += aux2.charAt(i);
            fld.value += decSep + aux.substr(len - 2, len);
            }
            return false;
        }
    </script> 
</head>
<body>
    <div class="x-nav">
      <span class="layui-breadcrumb">
        <a href="">首页</a>
        <a href="">房价管理</a>
        <a>
          <cite>每日房价</cite></a>
      </span>
      
    </div>
    <div  class="x-body">
        <form class="layui-form layui-col-md12 x-so" method="post" action="search_daily_rate">
              <div class="layui-row">
        <input type="text" class="layui-input" name="ciDate" id="ciDate" placeholder="入住日期" value="${info.ciDate}" required="" lay-verify="fdk">
        <input type="text" class="layui-input" name="coDate" id="coDate" placeholder="离店日期" value="${info.coDate}" required="" lay-verify="fdk">
  	      <input class="layui-input" type="number" placeholder="房间数"  value="${info.rest}" name="rest" id="rest" required="" lay-verify="number">
           <div class="layui-inline">
          <select name="rateType" id="rateType"  lay-search>
          <option value="">房价类型</option>
          <c:forEach items="${s}" var='b'>
          	 <option value='${b.code}'<c:if test="${b.code eq info.rateType}">selected="selected"</c:if>>${b.code} - ${b.name}</option>
          </c:forEach>
        </select>
        </div>
		<div class="layui-inline">
		 <select name="rmType" id="rmType"  lay-search>
          <option value="">客房类型</option>
          <c:forEach items="${r}" var='b'>
          	 <option value='${b.code}' <c:if test="${b.code eq info.rmType}">selected="selected"</c:if>>${b.code} - ${b.name}</option>
          </c:forEach>
        </select>
		</div>
          <button class="layui-btn"  lay-submit="" lay-filter="sreach" ><i class="layui-icon">&#xe615;</i></button>
          </div>
        </form>
        
        <c:choose>
        <c:when test="${sum == 0}">
        <h1>该日期不适用</h1>
        </c:when>
        <c:otherwise>
		
        <table class="layui-table">
        <thead>
          <tr>
            <th>日期</th>
            <th>房价类型</th>
            <th>房型</th>
            <th>剩余房间数</th>
            <th>价格</th>
            <th>操作</th>
            </tr>
        </thead>
        <tbody>
        <c:forEach items="${list}" var="c">
          <tr>
           <td >${c.ddate}</td>
            <td>${c.rateType}</td>
            <td>${c.rmType}</td>
            <td>${c.rest}</td>
            <td>¥ ${c.rate}</td>
            <td class="td-manage">
              <a title="查看"  onclick="x_admin_show('编辑','rate_rule_edit?id=${c.refRule}')" href="javascript:;">
                <i class="layui-icon">&#xe63c;</i>
              </a>
            </td>
          </tr>
        </c:forEach>
        	<tr>
            <td>免费取消期限:${d}</td>
            <td></td>
			<td></td>
			 <td></td>
            <td>总房费: ¥ ${sum}</td>
           
            <td >
              <button class="layui-btn layui-btn-warm" onclick="delAll()">预订</button>
            </td>
            </tr>
        </tbody>
      </table>
       </c:otherwise>
        </c:choose>
      </div>
     
    <script>
    layui.use(['form','layer'], function(){
        $ = layui.jquery;
      var form = layui.form
      ,layer = layui.layer;
    
      //自定义验证规则
      form.verify({
        
        fdk:function(value){
        	if($('#ciDate').val()>=$('#coDate').val()){
        	return '开始日期不能大于结束日期';
        	}
        }});	
      });
    </script>
   <script >
   function delAll (argument) {
	      var data = tableCheck.getData();
	  		var rmType=document.getElementById("rmType").value;
	  		var rateType=document.getElementById("rateType").value;
	  		var rest=document.getElementById("rest").value
	  		
	  	 	var ciDate=document.getElementById("ciDate").value;
	  		var coDate=document.getElementById("coDate").value; 
	  		/*  +"&freeCancelDate="+${d}  */
	  	 	x_admin_show("添加预订","show_rsv_add?rmType="+rmType+"&ciDate="+ciDate+"&coDate="+coDate+"&rateType="+rateType+"&sum="+${sum}+"&rest="+rest);
   }
	</script>
   
  </body>
</html>