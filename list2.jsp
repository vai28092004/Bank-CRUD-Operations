<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>

<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h3>List Of Employees</h3>

<c:if test="${requestScope.message !=null}">
	NOTE : ${ message}
</c:if>	

<c:if test="${requestScope.empList!=null and 
 not empty requestScope.empList}">	
	
<table border="1" cellpadding="3">
	<tr>
		<td>Reg Number</td>
		<td>First Name</td>
		<td>Password</td>
		<td>Balance</td>
		<td>&nbsp;</td>
		</tr>
		
<c:forEach items="${requestScope.empList }" var="e">
	<tr>
		<td>${e.regNo }</td>
		<td>${e.custName }</td>
		<td>${e.password }</td>
		<td>${e.accbal }</td>
	</tr>
	</c:forEach>		
</table></c:if>
</body>
</html>