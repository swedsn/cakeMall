<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<html>

	<head lang="en">
		<meta charset="UTF-8">
		<title>登录</title>
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">
		<meta name="format-detection" content="telephone=no">
		<meta name="renderer" content="webkit">
		<meta http-equiv="Cache-Control" content="no-siteapp" />

		<link rel="stylesheet" href="static/css/amazeui.css" />
		<link href="static/css/dlstyle.css" rel="stylesheet" type="text/css">
		<style type="text/css">
			.login-form label img{
				width: 40px;
    			height: 36px;
			}
			.login-form input{
				outline:none;
			}
		</style>
	</head>
	
	
	
	<body>

		<div class="login-boxtitle" style="height: 100px;">
			<div class="logoBig">
				<img src="static/images/logo.png" style="margin-left: 0px ; height: 100px;">
			</div>
		</div>

		<div class="login-banner">
			<div class="login-main" >
				<div class="login-banner-bg"><span></span><img src="static/images/big.jpg" /></div>
				<div class="login-box" style="margin-top: 20px;" id="container">

					<h3 class="title">登录商城</h3>
					<div class="clear"></div>
					<form action="" method="post">
						<div>${msg}</div>
						<div class="login-form"  style="background: none; margin-top: 15px;">
								<div class="user-name"  style="margin-top: 20px;">
									<label for="user">
										<img src="static/img/user.png"/>
									</label>
									<input id="username" type="text" name="username"  placeholder="邮箱/手机/用户名">
								</div>
								<div class="user-pass"  style="margin-top: 20px;">
									<label for="password">
										<img src="static/img/password.png"/>
									</label>
									<input id="password" type="password" name="password"  placeholder="请输入密码">
								</div>
								<div class="user-pass"  style="margin-top: 20px;display: flex;">
									<label for="code">
										<img src="static/img/code.png"/>
									</label>
									<input id="code" type="text" name="code"  placeholder="请输入验证码">
									<!-- 点击切换验证码 -->
									<img onclick="changeCode()" id="codeImg" style="width: 150px;height:40px" src="GetCodeServlet"/>
								</div>
						</div>
						<div class="am-cf">
							<!-- type设置submit,默认提交form，而不会执行点击事件的异步请求 -->
							<input id="loginBtn" type="button"  value="登 录" class="am-btn am-btn-primary am-btn-sm">
						</div>
						<div class="am-cf">
							<a  href="register.jsp"  class="am-btn am-btn-primary am-btn-sm">注册</a>
						</div>
					</form>
					<div class="partner">
						
					</div>

				</div>
			</div>
		</div>

		<div class="footer ">
			<div class="footer-hd ">

			</div>
			<div class="footer-bd ">
				<p>
					<a href="# ">联系我们</a>
					<a href="# ">网站地图</a>
				</p>
			</div>
		</div>
		
		
	</body>
	<!-- 先导入jquery -->
	<script src="static/jquery/jquery-3.6.0.min.js"></script>
	<script>
		function changeCode(){
			// jquery 使用  this   $(this)
			$("#codeImg").attr("src","GetCodeServlet?time="+new Date().getTime())
		}
		//点击登录按钮才做登录验证
		$("#loginBtn").click(function(){
			//阻止submit按钮提交默认的form表单
			//event.preventDefault();
			//使用异步无刷新页面向后端发登录请求
			$.ajax({
				type:"post",//请求方式
				url:"loginServlet",//请求的后端servlet的地址
				data:{    //请求时携带的参数
					username:$("#username").val(),
					password:$("#password").val(),
					code:$("#code").val()
				},success:function(res){ //success:请求成功后的回调函数(后端不报错)
					//res:后端返回的结果
					alert(res);
					if(res=="验证码输入错误"){
						//刷新验证码
						changeCode();
					}else if(res=="账号或者密码输入错误"){
						//刷新验证码
						changeCode();
					}else{
						//上一个页面的链接
						var prevUrl = document.referrer;
						if(prevUrl==""){
							window.location.href="index";
						}else{
							//判断prevUrl中是否包含register
							//"abc".indexOf("1")   判断一个字符串中是否存在某字符，如果存在，返回下标 如果不存在，返回固定值-1
							if(prevUrl.indexOf("register")==-1){
								window.location.href=prevUrl;
							}else{
								window.location.href="/index.jsp";
							}
						}
					}
				}
			})
		})
	</script>
</html>