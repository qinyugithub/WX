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

	<h2>热门文章上传：</h2>
	<s:form action="savearticle" method="post"
		enctype="multipart/form-data">
		<s:fielderror name="file"></s:fielderror>
		<s:actionerror />
		<s:file name="file" label="上传热门文章文件"></s:file>
		<s:submit value="确定上传"></s:submit>
	</s:form>

	<br>
	<h2>活动审核：</h2>
	<a href="activity-checkactivity?pass=0">待审核活动</a> &nbsp;
	<a href="activity-checkactivity?pass=1">已通过活动</a> &nbsp;
	<a href="activity-checkactivity?pass=-1">未通过活动</a>
	<br>
	<br>
	<h2>热门活动推荐：</h2>
	<a href="activity-listactivity">选择活动</a> &nbsp;

</body>
</html>