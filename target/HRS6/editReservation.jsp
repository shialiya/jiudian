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
</head>
<body>
<div class="x-body">
        <form id="rate_rule_add" class="layui-form" method="post" action="rsv_edit_confirm" >
        <div class="layui-form-item">
        <label  class="layui-form-label">
                  <span class="x-red">*</span>确认号码
              </label>
           <div class="layui-input-inline">
        <input type="text" class="layui-input" name="confirmID" id="confirmID"  value="${c.confirmID}" readonly="readonly" required="" lay-verify="required">
      		</div>  
        </div>
                <div class="layui-form-item">
        
  		  <div class="layui-col-xs6">
				<label  class="layui-form-label">
                  <span class="x-red">*</span>入住日期
              </label>
           <div class="layui-input-inline">
        <input type="date" class="layui-input" name="ciDate" id="ciDate"  value="${c.ciDate}" placeholder="yyyy-MM-dd" required="" lay-verify="fd">
      		</div>  		
      </div>
   		 <div class="layui-col-xs6">
      		<label  class="layui-form-label">
                  <span class="x-red">*</span>离店日期
              </label>
           <div class="layui-input-inline">
        <input type="text" class="layui-input" name="coDate"  id="coDate" value="${c.coDate}" placeholder="yyyy-MM-dd" required="" lay-verify="fd">
      </div>
   		 </div>
  		</div>
		
		<div class="layui-form-item">
			<div class="layui-col-xs6">
				<label  class="layui-form-label">
		                  <span class="x-red">*</span>房价类型
				</label>
				<div class="layui-input-inline">
					 <select name="rateType" id="rateType"  lay-search  required="" lay-verify="required">
			          <c:forEach items="${s}" var='b'>
			          	 <option value='${b.code}' <c:if test="${c.rateType eq b.code}"> selected</c:if>>${b.code} - ${b.name}</option>
			          </c:forEach>
			        </select>
              	</div>
    </div>
		          
		   	<div class="layui-col-xs6">
		      		<label  class="layui-form-label">
		                  <span class="x-red">*</span>客房类型
				</label>
		           <div class="layui-input-inline">
                <select name="rmType" id="rmType"  lay-search required="" lay-verify="required">
          <c:forEach items="${r}" var='b'>
          	 <option value='${b.code}' <c:if test="${c.rmType eq b.code}"> selected</c:if>>${b.code} - ${b.name}</option>
          </c:forEach>
        </select>
              </div>
		   	</div>
		</div>
		<div class="layui-form-item">
			<div class="layui-col-xs6">
				<label  class="layui-form-label">
		                  <span class="x-red">*</span>房间数
				</label>
				<div class="layui-input-inline">
                  <input type="number" id="quantity" value="${c.quantity}" name="quantity" required="" lay-verify="number"
                  autocomplete="off" class="layui-input">
              	</div>
		           </div>
		   	<div class="layui-col-xs6">
		      		<label  class="layui-form-label">
		                  <span class="x-red">*</span>总房费
				</label>
		          <div class="layui-input-inline">
                  <input class="layui-input" type="number" step="0.01" value="${c.amount}" readonly="readonly" id="amount" name="amount" readonly="readonly" onKeyPress="return(currencyFormat(this,'','.',event))" required="" lay-verify="required">
              </div>
		   	</div>
		</div>     
		<div class="layui-form-item">
			<div class="layui-col-xs6">
				<label  class="layui-form-label">
		                  <span class="x-red">*</span>成人数
				</label>
				<div class="layui-input-inline">
                  <input type="number" id="adults" name="adults" required="" lay-verify="number" value="${c.adults}"
                  autocomplete="off" class="layui-input">
              	</div>
		    </div>
		   	<div class="layui-col-xs6">
		      		<label  class="layui-form-label">
		                  <span class="x-red">*</span>小童数
				</label>
		          <div class="layui-input-inline">
                  <input type="number" id="child" name="child" required="" lay-verify="number" value="${c.child}"
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
					<select name="title1" lay-verify="required">
					<option value="">请选择</option> 
					  <option value='MR' <c:if test="${c.title1 eq 'MR'}"> selected</c:if> >MR</option>
					  <option value='MS'  <c:if test="${c.title1 eq 'MS'}"> selected</c:if> >MS</option>
					</select>
    			</div>
<!-- 		           </div>
		   	<div class="layui-col-xs8"> -->
		      		<div class="layui-input-inline">
                  <input type="text" id="name1" name="name1" value="${c.name1}" required="" lay-verify="required"
                  autocomplete="off" class="layui-input" placeholder="名">
              </div>
		   
		      	<div class="layui-input-inline">
                  <input type="text" id="surname1" name="surname1" value="${c.surname1}" required="" lay-verify="required"
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
					<select name="title12" >
					<option value="">请选择</option>
					  <option value='MR' <c:if test="${c.title12 eq 'MR'}"> selected</c:if> >MR</option>
					  <option value='MS' <c:if test="${c.title12 eq 'MS'}"> selected</c:if> >MS</option>
					</select>
    			</div>
		          <!--  </div>
		   	<div class="layui-col-xs8"> -->
		      		<div class="layui-input-inline">
                  <input type="text" id="name2" name="name2" value="${c.name2}"
                  autocomplete="off" class="layui-input" placeholder="名">
              </div>
		   
		      	<div class="layui-input-inline">
                  <input type="text" id="surname2" name="surname2" value="${c.surname2}"
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
					<select name="cardType" id="cardType" lay-verify="required" >
					<option value="">请选择</option>
					  <option value='No guarantee' <c:if test="${c.cardType eq 'No guarantee'}"> selected</c:if> >No guarantee</option>
					  <option value='UP' <c:if test="${c.cardType eq 'UP'}"> selected</c:if>>UP</option>
					  <option value='MASTER' <c:if test="${c.cardType eq 'MASTER'}"> selected</c:if>>MASTER</option>
					  <option value='VISA' <c:if test="${c.cardType eq 'VISA'}"> selected</c:if>>VISA</option>
					  <option value='JCB' <c:if test="${c.cardType eq 'JCB'}"> selected</c:if>>JCB</option>
					  <option value='AE' <c:if test="${c.cardType eq 'AE'}"> selected</c:if>>AE</option>					  
					</select>
    			</div>
    		<div class="layui-input-inline" >
                  <input type="text" id="cardNumber" name="cardNumber"  value="${c.cardNumber}"
                  autocomplete="off" class="layui-input" >
              </div> 
              <div class="layui-input-inline">
        <input type="text" class="layui-input" name="cardExpire" id="cardExpire" value="${c.cardExpire}" placeholder="yyyy-MM" >
      </div>
		</div>		
		<div class="layui-form-item">
			<div class="layui-col-xs6">
				<label  class="layui-form-label">
		                  <span class="x-red">*</span>联系电话
				</label>
				<div class="layui-input-inline">
                  <input type="text" id="phone" name="phone" value="${c.phone}" required="" lay-verify="phone"
                  autocomplete="off" class="layui-input" >
              </div>
		           </div>
		   	<div class="layui-col-xs6">
		      		<label  class="layui-form-label">
		                  <span class="x-red">*</span>电子邮箱
				</label>
				<div class="layui-input-inline">
                  <input type="text" id="country" name="country" value="${c.country}" required="" lay-verify="email"
                  autocomplete="off" class="layui-input" >
              </div>
              <c:if test="${c.status eq 'Confirmed'}">
              <button type="button" onclick="{location.href='send_mail?id=${c.confirmID}'}"  class="layui-btn">发送确认邮件</button>
              </c:if> 
		   	</div>
		</div>		
		<div class="layui-form-item">
			<div class="layui-col-xs6">
				<label  class="layui-form-label">
		                  <span class="x-red">*</span>来源
				</label>
				<div class="layui-input-inline">
					<select name="rsvFrom" id="rsvFrom" lay-verify="required" >
					<option value="">请选择</option>
					  <option value='TEL' <c:if test="${c.rsvFrom eq 'TEL'}"> selected</c:if>>TEL</option>
					  <option value='SPG' <c:if test="${c.rsvFrom eq 'SPG'}"> selected</c:if>>SPG</option>
					  <option value='EMAIL' <c:if test="${c.rsvFrom eq 'EMAIL'}"> selected</c:if>>EMAIL</option>
					  <option value='FAX' <c:if test="${c.rsvFrom eq 'FAX'}"> selected</c:if>>FAX</option>
					  <option value='CTRIP' <c:if test="${c.rsvFrom eq 'CTRIP'}"> selected</c:if>>CTRIP</option>
					  <option value='FLIGGY' <c:if test="${c.rsvFrom eq 'FLIGGY'}"> selected</c:if>>FLIGGY</option>					  
					</select>
    			</div>
		           </div>
		   	<div class="layui-col-xs6">
		      		<label  class="layui-form-label">
		                  <span class="x-red">*</span>状态
				</label>
		          <div class="layui-input-inline">
					<select name="status" id="status" lay-verify="required"  <c:if test="${c.status eq 'Canceled'}">readonly="readonly"</c:if>>
					<option value="">请选择</option>
					  <option value='Pending' <c:if test="${c.status eq 'Pending'}"> selected</c:if>>Pending</option>
					  <option value='Confirmed' <c:if test="${c.status eq 'Confirmed'}"> selected</c:if>>Confirmed</option>
					  <option value='Canceled' <c:if test="${c.status eq 'Canceled'}"> selected</c:if>>Canceled</option>
					</select>
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
                  autocomplete="off" class="layui-input"  value="${c.freeCancelDate}" readonly="readonly">
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
                  <textarea  id="notes" name="notes" class="layui-textarea">${c.notes}</textarea>
              </div>
          </div>
          <div class="layui-form-item">
           
              <label for="L_repass" class="layui-form-label">
              </label>
              <c:if test="${c.status != 'Canceled'}"> 
              <button  class="layui-btn"  lay-filter="add" lay-submit="">
                  下一步：确认修改信息
              </button>
             </c:if>
           </div>
      </form>
    </div>
    
    <script>
    	layui.use('laydate',function(){
    	var laydate = layui.laydate;
    	var myDate = new Date();
    	console.log(myDate.toLocaleDateString());
    		laydate.render({elem: '#ciDate',min:'${myDate.toLocaleDateString()}'
		});
			laydate.render({elem:'#coDate'	,min:'${myDate.toLocaleDateString()}'	
			});
			laydate.render({elem:'#cardExpire',type: 'month'})
    	});
    </script>
    <script >
    function DateAdd(interval, number, date) {
        switch (interval) {
        case "y ": {
            date.setFullYear(date.getFullYear() + number);
            return date;
            break;
        }
        case "q ": {
            date.setMonth(date.getMonth() + number * 3);
            return date;
            break;
        }
        case "m ": {
            date.setMonth(date.getMonth() + number);
            return date;
            break;
        }
        case "w ": {
            date.setDate(date.getDate() + number * 7);
            return date;
            break;
        }
        case "d ": {
            date.setDate(date.getDate() + number);
            return date;
            break;
        }
        case "h ": {
            date.setHours(date.getHours() + number);
            return date;
            break;
        }
        case "m ": {
            date.setMinutes(date.getMinutes() + number);
            return date;
            break;
        }
        case "s ": {
            date.setSeconds(date.getSeconds() + number);
            return date;
            break;
        }
        default: {
            date.setDate(d.getDate() + number);
            return date;
            break;
        }
        }
    }

    </script>
    <script>
        layui.use(['form','layer'], function(){
            $ = layui.jquery;
          var form = layui.form
          ,layer = layui.layer;
      	var myDate = new Date();
      	var newDate = DateAdd("d ", 1, myDate);

          //自定义验证规则
          form.verify({
            fd:function(value){
            	if($('#ciDate').val()>$('#coDate').val()){
            	return '开始日期不能大于结束日期';
            	}
            }
            /* last:function(value){
            	if(${c.ciDate}< newDate)
            		return '该预订已过最后修改期限';
            } */
          }
          
        );

 
          
          
        });
    </script>
  
   
</body>
</html>