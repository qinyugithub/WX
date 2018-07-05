<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>check activity</title>

</head>
<body>

	<h2>待审核活动详情：</h2>

	<s:if test="#request.url == null || #request.url.size() == 0">
		文件上传失败
	</s:if>
	<s:else>
	文件上传成功！文件地址：	
<s:property value="#request.url" />
	</s:else>

</body>
</html>