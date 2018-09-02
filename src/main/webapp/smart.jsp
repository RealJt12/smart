<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="shortcut icon" href="images/favicon.ico" />
<title>${applicationScope["application.name"]}</title>
</head>
<body>
	<h1>Hello RealJt</h1>

	<h2>Welcome to ${applicationScope["application.name"]} Project</h2>

	<form action="<%=request.getContextPath()%>/upload" method="post"
		enctype="multipart/form-data">
		<table>
			<tr>
				<td>文件:</td>
				<td><input type="file" name="file" /></td>
			</tr>
			<tr>
				<td>描述:</td>
				<td><input type="text" name="description" value="" /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="upload" /></td>
			</tr>
		</table>
	</form>

</body>
</html>