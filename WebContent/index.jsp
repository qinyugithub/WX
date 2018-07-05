<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
 	<h4>管理员登录</h4>

	<s:form action="adm-check" method="post">
			<s:textfield name="name" label="姓名"></s:textfield>
			<s:password name="password" label="密码"></s:password>
			<s:submit value="登录"></s:submit>
	</s:form>	

</body>
</html>