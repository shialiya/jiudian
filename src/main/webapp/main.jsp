<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<title>酒店预订管理系统</title>
	<meta name="renderer" content="webkit|ie-comp|ie-stand">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi" />
    <meta http-equiv="Cache-Control" content="no-siteapp" />

    <link rel="shortcut icon" href="/favicon.ico" type="image/x-icon" />
    <link rel="stylesheet" href="./css/iconfont.css">
    <link rel="stylesheet" href="./css/demo.css">
	<link rel="stylesheet" href="./css/xadmin.css">
    <script type="text/javascript" src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
    <script src="./lib/layui/layui.js" charset="utf-8"></script>
    <script type="text/javascript" src="./js/xadmin.js"></script>
     <script type="text/javascript">
	 $(document).ready(function(){
			
			if("${power}" == ""){
	 		 window.alert("请先登录",);
	 	window.location.href="index";
	 		 }
	 		

	});
    </script>
    <script >
    function closeWebPage(){
 if (navigator.userAgent.indexOf("MSIE") > 0) {//close IE
  if (navigator.userAgent.indexOf("MSIE 6.0") > 0) {
   window.opener = null;
   window.close();
  } else {
   window.open('', '_top');
   window.top.close();
  }
 }
 else if (navigator.userAgent.indexOf("Firefox") > 0) {//close firefox
  window.location.href = 'about:blank ';
 } else {//close chrome;It is effective when it is only one.
  window.opener = null;
  window.open('', '_self');
  window.close();
 }
}

    
    </script>
</head>
<body>
	 <!-- 顶部开始 -->
    <div class="container">
        <div class="logo"><a >酒店预订管理系统</a></div>
        <div class="left_open">
            <i title="展开左侧栏" class="iconfont">&#xe6ea;</i>
        </div>
        <ul class="layui-nav right" lay-filter="">
          <li class="layui-nav-item">
            <a href="javascript:;">Hi, ${staff.name}</a>
            <dl class="layui-nav-child"> <!-- 二级菜单 -->
              <dd><a onclick="x_admin_show('个人信息','staff_person?id=${staff.id}')">个人信息</a></dd>
              <dd><a onclick="closeWebPage()">退出登录</a></dd>
             <!--  href="./login.jsp" -->
            </dl>
          </li>
        </ul>
        
    </div>
    <!-- 顶部结束 -->
    <!-- 中部开始 -->
     <!-- 左侧菜单开始 -->
    <div class="left-nav">
      <div id="side-nav">
        <ul id="nav">
            <li>
                <a href="javascript:;">
                    <i class="iconfont">&#xe6e2;</i>
                    <cite>预订管理</cite>
					<em class="layui-nav-more"></em>
                </a>
                <ul class="sub-menu">
                    <li>
                        <a _href="rsv_list">
                            <i class="iconfont">&#xe600;</i>
                            <cite>预订列表</cite>
                        </a>
                    </li >
                </ul>
            </li>
            
             <li>
                <a href="javascript:;">
                    <i class="iconfont">&#xe680;</i>
                    <cite>客房管理</cite>

                </a>
                <ul class="sub-menu">
                    <li>
                        <a _href="room_type_list">
                            <i class="iconfont">&#xe600;</i>
                            <cite>房型列表</cite>
                        </a>
                    </li >
                </ul>
            </li>
             <li>
                <a href="javascript:;">
                    <i class="iconfont">&#xea01;</i>
                    <cite>房价管理</cite>

                </a>
                <ul class="sub-menu">
                    <li>
                        <a _href="listDailyR">
                            <i class="iconfont">&#xe600;</i>
                            <cite>每日房价</cite>
                        </a>
                    </li >
                    <li>
                        <a _href="rate_type_list">
                            <i class="iconfont">&#xe600;</i>
                            <cite>房价类型</cite>
                        </a>
                    </li >
                    <li>
                        <a _href="rate_rule_list">
                            <i class="iconfont">&#xe600;</i>
                            <cite>房价规则</cite>
                        </a>
                    </li >
                </ul>
            </li>
             <li>
                <a href="javascript:;">
                    <i class="iconfont">&#xe6d2;</i>
                    <cite>房态管理</cite>

                </a>
                <ul class="sub-menu">
                    <li>
                        <a _href="list_DS">
                            <i class="iconfont">&#xe600;</i>
                            <cite>每日房态</cite>
                        </a>
                    </li >
                    <li>
                        <a _href="room_rule_list">
                            <i class="iconfont">&#xe600;</i>
                            <cite>房态设置</cite>
                        </a>
                    </li >
                </ul>
            </li>
           <c:if test="${staff.position=='MANAGER' or staff.dept=='MANAGEMENT'}">
            <li>
                <a href="javascript:;">
                    <i class="iconfont">&#xe612;</i>
                    <cite>员工管理</cite>

                </a>
                <ul class="sub-menu">
                    <li>
                        <a _href="staff_list">
                            <i class="iconfont">&#xe600;</i>
                            <cite>员工列表</cite>
                            
                        </a>
                    </li>
                </ul>
            </li>
           </c:if>
        </ul>
      </div>
    </div>
    <!-- <div class="x-slide_left"></div> -->
    <!-- 左侧菜单结束 -->
    <!-- 右侧主体开始 -->
    <div class="page-content">
        <div class="layui-tab tab" lay-filter="xbs_tab" lay-allowclose="false">
          <ul class="layui-tab-title">
            <li>我的桌面</li>
          </ul>
          <div class="layui-tab-content">
            <div class="layui-tab-item layui-show">
                <iframe src='https://tzecochan.wixsite.com/mysite' frameborder="0" scrolling="yes" class="x-iframe"></iframe>
            </div>
          </div>
        </div>
    </div>
    <div class="page-content-bg"></div>
    <!-- 右侧主体结束 -->
    <!-- 中部结束 -->
    <!-- 底部开始 -->
    <div class="footer">
        <div class="copyright">Copyright ©2018 All Rights Reserved</div>  
    </div>
    <!-- 底部结束 -->
    
</body>
</html>