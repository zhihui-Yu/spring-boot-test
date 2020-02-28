<html>
<head>
<meta charset="UTF-8"/>
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
		<#list list as u >
			<tr>
				<td>${u.name }</td>
				<td>${u.pass }</td>
				<td>${u.age }</td>
			</tr>
		</#list>
		</tbody>
	</table>
</body>
</html>