<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML>
<html>
  <head>
    <base href="<%=basePath%>">
    <meta charset="utf-8">
    <title>注册用户</title>
	<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
  </head>
  
  <body>
  
  <div class="jumbotron">
  <form action="addUser"  method="post" enctype="multipart/form-data" >
  	<fieldset>
  	<legend>用户注册</legend>
  	<div class="form-group">
  	<label for="username">姓名:</label><input type="text" id="username" name="username" class="form-control">
  	</div>
  	<div class="form-group">
  	<label for="password">密码:</label><input type="password" id="password" name="password" class="form-control">
  	</div>
  	<div class="form-group">
  	<label for="qq">QQ:</label><input type="number" id="qq" name="qq" class="form-control">
  	</div>
  	<div class="form-group">
  	男性:<input type="radio" checked="checked" name="sex" value="0">
  	</div>
  	<div class="form-group">
  	女性:<input type="radio" checked="checked" name="sex" value="1">
  	</div>
  	<div class="form-group">
  		<label for="email">E-mail:</label><input type="email" id="email" name="email" class="form-control">
  	</div>
  	<div class="form-group">
  	<label for="phone">Phone:</label><input type="tel" id="phone" name="phone" class="form-control">
  	</div>
  	<div class="form-group">
  	<span><input type="file" name="image" title="上传"></span>
   </div>
   
   <div class="form-group">
  	<input type="submit"  value="提交" class="btn btn-primary btn-lg btn-block">
   </div>
  	</fieldset>
  
  </form>
  </div>
  </body>
</html>
