<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

</head>
<body>


	<h4>请选择热门活动</h4>

	<s:form action="activity-savehotactivitys" method="post">

		<s:select list="#request.activitys" listKey="id"
			listValue="iteminput" name="id1" label="选择活动1："></s:select>
			
		<s:select list="#request.activitys" listKey="id"
			listValue="iteminput" name="id2" label="选择活动2："></s:select>
			
		<s:select list="#request.activitys" listKey="id"
			listValue="iteminput" name="id3" label="选择活动3："></s:select>
		<s:submit value="确定上传"></s:submit>
	</s:form>

</body>
</html>