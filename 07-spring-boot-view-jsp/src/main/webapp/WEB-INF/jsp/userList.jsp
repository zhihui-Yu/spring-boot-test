<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table style="border: 1px black dashed;" align="center">
		<thead>
			<th>姓名</th>
			<th>密码</th>
			<th>年龄</th>
		</thead>
		<tbody>
			<c:forEach items="${list }" var="u">
				<tr>
					<td>${u.name }</td>
					<td>${u.pass }</td>
					<td>${u.age }</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>