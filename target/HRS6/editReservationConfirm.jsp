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
    <script type="text/javascript" src="./js/jquery-3.3.1/jquery-3.3.1.min.js"></script>
    <script type="text/javascript" src="./lib/layui/layui.js" charset="utf-8"></script>
    <script type="text/javascript" src="./js/xadmin.js"></script>
    
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
<div class="x-body">
	<c:choose>
        <c:when test="${sum == 0}">
        <h1>该日期不适用</h1>
         <button  class="layui-btn" type="button" onClick="delAll()" >
                  返回
              </button>
        </c:when>
        <c:otherwise>
       <form id="rate_rule_add" class="layui-form" method="post" action="rsv_update" >
         <div class="layui-form-item">
        <label  class="layui-form-label">
                  <span class="x-red">*</span>确认号码
              </label>
           <div class="layui-input-inline">
        <input type="number" class="layui-input" name="confirmID" id="confirmID"  value="${c.confirmID}" readonly="readonly" required="" lay-verify="number">
      		</div>  
        </div>
        <div class="layui-form-item">
  		  <div class="layui-col-xs6">
				<label  class="layui-form-label">
                  <span class="x-red">*</span>入住日期
              </label>
           <div class="layui-input-inline">
        <input type="text" class="layui-input" name="ciDate" id="ciDate" readonly="readonly" value="${info.ciDate}" placeholder="yyyy-MM-dd" required="" lay-verify="required">
      		</div>  		
      </div>
   		 <div class="layui-col-xs6">
      		<label  class="layui-form-label">
                  <span class="x-red">*</span>离店日期
              </label>
           <div class="layui-input-inline">
        <input type="text" class="layui-input" name="coDate" readonly="readonly" id="coDate" value="${info.coDate}" placeholder="yyyy-MM-dd" required="" lay-verify="fd">
      </div>
   		 </div>
  		</div>
		
		<div class="layui-form-item">
			<div class="layui-col-xs6">
				<label  class="layui-form-label">
		                  <span class="x-red">*</span>房价类型
				</label>
				<div class="layui-input-inline">
        <input type="text" id="rateType" name="rateType" value="${info.rateType}" readonly="readonly" required="" lay-verify="required"
                  autocomplete="off" class="layui-input">
              	</div>
    </div>
		          
		   	<div class="layui-col-xs6">
		      		<label  class="layui-form-label">
		                  <span class="x-red">*</span>客房类型
				</label>
		           <div class="layui-input-inline">
                 <input type="text" id="rmType" name="rmType" value="${info.rmType}" readonly="readonly" required="" lay-verify="required"
                  autocomplete="off" class="layui-input">
              </div>
		   	</div>
		</div>
		<div class="layui-form-item">
			<div class="layui-col-xs6">
				<label  class="layui-form-label">
		                  <span class="x-red">*</span>房间数
				</label>
				<div class="layui-input-inline">
                  <input type="number" id="quantity" value="${info.rest}" name="quantity" readonly="readonly"  required="" lay-verify="number"
                  autocomplete="off" class="layui-input">
              	</div>
		           </div>
		   	<div class="layui-col-xs6">
		      		<label  class="layui-form-label">
		                  <span class="x-red">*</span>总房费
				</label>
		          <div class="layui-input-inline">
                  <input class="layui-input" type="number" step="0.01" value="${sum}" readonly="readonly" id="amount" name="amount" readonly="readonly" onKeyPress="return(currencyFormat(this,'','.',event))" required="" lay-verify="required">
              </div>
		   	</div>
		</div>     
		<div class="layui-form-item">
			<div class="layui-col-xs6">
				<label  class="layui-form-label">
		                  <span class="x-red">*</span>成人数
				</label>
				<div class="layui-input-inline">
                  <input type="number" id="adults" name="adults" required="" readonly="readonly" lay-verify="number" value="${c.adults}"
                  autocomplete="off" class="layui-input">
              	</div>
		    </div>
		   	<div class="layui-col-xs6">
		      		<label  class="layui-form-label">
		                  <span class="x-red">*</span>小童数
				</label>
		          <div class="layui-input-inline">
                  <input type="number" id="child" name="child" required="" readonly="readonly" lay-verify="number" value="${c.child}"
                  autocomplete="off" class="layui-input">
              	</div>
		   	</div>
		</div>    
		<div class="layui-form-item">
<!-- 			<div class="layui-col-xs4">
 -->				<label  class="layui-form-label">
		                  <span class="x-red">*</span>主客人
				</label>
				<div class="layui-input-inline">
					<input type="text" id="title1" name="title1" required="" lay-verify="required"
                  autocomplete="off" class="layui-input"  value="${c.title1}" readonly="readonly">
    			</div>
<!-- 		           </div>
		   	<div class="layui-col-xs8"> -->
		      		<div class="layui-input-inline">
                  <input type="text" id="name1" name="name1" value="${c.name1}" readonly="readonly" required="" lay-verify="required"
                  autocomplete="off" class="layui-input" placeholder="名">
              </div>
		   
		      	<div class="layui-input-inline">
                  <input type="text" id="surname1" name="surname1" value="${c.surname1}" readonly="readonly" required="" lay-verify="required"
                  autocomplete="off" class="layui-input" placeholder="姓">
              </div>
<!-- 		   	</div>
 -->		
 		</div>    
		<div class="layui-form-item">
<!-- 			<div class="layui-col-xs4">
 -->				<label  class="layui-form-label">
		               同住人
				</label>
				<div class="layui-input-inline">
					<input type="text" id="title12" name="title12" 
                  autocomplete="off" class="layui-input"  value="${c.title12}" readonly="readonly">
    			</div>
		          <!--  </div>
		   	<div class="layui-col-xs8"> -->
		      		<div class="layui-input-inline">
                  <input type="text" id="name2" name="name2" value="${c.name2}" readonly="readonly"
                  autocomplete="off" class="layui-input" placeholder="名">
              </div>
		   
		      	<div class="layui-input-inline">
                  <input type="text" id="surname2" name="surname2" value="${c.surname2}" readonly="readonly"
                  autocomplete="off" class="layui-input" placeholder="姓">
              </div>
<!-- 		   	</div>
 -->		
 		</div>
		
		          
		<div class="layui-form-item">
			<label  class="layui-form-label">
		                  <span class="x-red">*</span>担保方式
			</label>
			<div class="layui-input-inline">
					<input type="text" id="cardType" name="cardType" required="" lay-verify="required"
                  autocomplete="off" class="layui-input"  value="${c.cardType}" readonly="readonly">
    			</div>
    		<div class="layui-input-inline" >
                  <input type="text" id="cardNumber" name="cardNumber"  value="${c.cardNumber}"
                  autocomplete="off" class="layui-input" readonly="readonly" >
              </div> 
              <div class="layui-input-inline">
        <input type="text" class="layui-input" name="cardExpire" readonly="readonly" id="cardExpire" value="${c.cardExpire}" placeholder="yyyy-MM" >
      </div>
		</div>		
		<div class="layui-form-item">
			<div class="layui-col-xs6">
				<label  class="layui-form-label">
		                  <span class="x-red">*</span>联系电话
				</label>
				<div class="layui-input-inline">
                  <input type="text" id="phone" name="phone" value="${c.phone}" readonly="readonly" required="" lay-verify="phone"
                  autocomplete="off" class="layui-input" >
              </div>
		           </div>
		   	<div class="layui-col-xs6">
		      		<label  class="layui-form-label">
		                  <span class="x-red">*</span>电子邮箱
				</label>
				<div class="layui-input-inline">
                  <input type="text" id="country" name="country" readonly="readonly" value="${c.country}" required="" lay-verify="email"
                  autocomplete="off" class="layui-input" >
              </div> 
		   	</div>
		</div>		
		<div class="layui-form-item">
			<div class="layui-col-xs6">
				<label  class="layui-form-label">
		                  <span class="x-red">*</span>来源
				</label>
				<div class="layui-input-inline">
					<input type="text" id="rsvFrom" name="rsvFrom" required="" lay-verify="required"
                  autocomplete="off" class="layui-input"  value="${c.rsvFrom}" readonly="readonly">
    			</div>
		           </div>
		   	<div class="layui-col-xs6">
		      		<label  class="layui-form-label">
		                  <span class="x-red">*</span>状态
				</label>
		          <div class="layui-input-inline">
					<input type="text" id="status" name="status" required="" lay-verify="required"
                  autocomplete="off" class="layui-input"  value="${c.status}" readonly="readonly">
    			</div>
		   	</div>
		</div>	
		<div class="layui-form-item">
			<div class="layui-col-xs6">
				<label  class="layui-form-label">
		                  <span class="x-red">*</span>免费取消时限
				</label>
				    		<div class="layui-input-inline" >
				<input type="text" id="freeCancelDate" name="freeCancelDate" required="" lay-verify="required"
                  autocomplete="off" class="layui-input"  value="${d}" readonly="readonly">
		           </div>
		           </div>
		   	<div class="layui-col-xs6">
		      		<label  class="layui-form-label" >
		                  <span class="x-red">*</span>创建时间
				</label>
				<div class="layui-input-inline" >
		           <input type="text" id="madeDate" name="madeDate" required="" lay-verify="required" value="${c.madeDate}"
                  autocomplete="off" class="layui-input" readonly="readonly">
              </div> 
		   	</div>
		</div>			
          <div class="layui-form-item layui-form-text">
              <label  class="layui-form-label">
                  描述
              </label>
              <div class="layui-input-block">
                  <textarea  id="notes" name="notes" class="layui-textarea">
${c.notes}
       <c:forEach items="${list}" var="c">${c.ddate} - ${c.rate}
       </c:forEach></textarea>
              </div>
          </div>
          <div class="layui-form-item">
           
              <label for="L_repass" class="layui-form-label">
              </label>
              
               <button  class="layui-btn" type="button" onClick="delAll()" >
                  返回
              </button>
              <button  class="layui-btn" lay-filter="add" lay-submit="">
                  提交修改
              </button>
          </div>
      </form>
      </c:otherwise>
       		 </c:choose>
       		
    </div>
    
    <script>
    	layui.use('laydate',function(){
    	var laydate = layui.laydate;
    		laydate.render({elem: '#ciDate'
		});
			laydate.render({elem:'#coDate'			
			});
			laydate.render({elem:'#cardExpire',type: 'month'})
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
    <script >
   function delAll (argument) {
	      var data = document.getElementById("confirmID").value;
	  		window.location.href="rsv_edit?id="+data;
   }
	</script>
   
</body>
</html>