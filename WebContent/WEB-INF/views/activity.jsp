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

	<s:if
		test="#request.activitys == null || #request.activitys.size() == 0">
		暂时没有需要审核的活动！
	</s:if>
	<s:else>
		<table border="2" cellpadding="2" cellspacing="0" >
			<tr>
				<td >ID</td>
				<td >图片</td>
				<td >活动主题</td>
				<td >主办方</td>
				<td >承办方</td>
				<td >活动类型</td>
				<td >活动地址</td>
				<td >开始时间</td>
				<td >截止时间</td>
				<td >联系电话</td>
				<td >宣传语</td>
				<td >活动详情</td>
				<td >活动奖励</td>
				<td >最少人数</td>
				<td >预计花费</td>
				<td >活动规则</td>
				<td >用户名</td>
				<td >所在城市</td>
				<td >经度</td>
				<td >纬度</td>
				<td >审核通过</td>
				<td >审核不通过</td>

			</tr>
			<s:iterator value="#request.activitys">
				<tr>
					<td>${id }</td>
					<td>${img }</td>
					<td>${iteminput }</td>
					<td>${maininput }</td>
					<td>${chenginput }</td>
					<td>${etype }</td>
					<td>${address }</td>
					<td><s:date name="timeinputone" format="yyyy-MM-dd hh:mm:ss" /></td>
					<td><s:date name="timeinputtwo" format="yyyy-MM-dd hh:mm:ss" /></td>
					<td>${lphone }</td>
					<td>${eventwords }</td>
					<td>${eventdetail }</td>
					<td>${eventwards }</td>
					<td>${minpeo }</td>
					<td>${money }</td>
					<td>${costre }</td>
					<td>${username }</td>
					<td>${city }</td>
					<td>${longitude }</td>
					<td>${latitude }</td>
	                <td><a href="activity-pass?id=${id }">通过</a></td>
					<td> <a href="activity-notpass?id=${id }">未通过</a></td>
				</tr>
			</s:iterator>
		</table>
	</s:else>

</body>
</html>