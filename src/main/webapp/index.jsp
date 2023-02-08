<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- New line below to use the JSP Standard Tag Library -->
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>  

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

	<!-- for Bootstrap CSS -->
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
	<!-- YOUR own local CSS -->
	<link rel="stylesheet" href="/css/style.css"/>
	<!-- For any Bootstrap that uses JS or jQuery-->
	<script src="/webjars/jquery/jquery.min.js"></script>
	<script type="text/javascript" src="/script/script.js" defer></script>
<title>MVC</title>
</head>

<body>
	<div class="container col-9 bg-light rounded p-5">
		<table class="table table-striped">
			<thead>
				<tr>
					<th>Name</th>
					<th>Vendor</th>
					<th>Amount</th>
					<th>Action</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="e" items="${expenses}">
					<tr>
						<td><a class="link-primary" href="/expenses/view/${e.id}">${e.name}</a></td>
						<td>${e.vendor}</td>
						<td>${String.format("%.2f" , e.amount)}</td>
						<td>
							<div class="d-flex gap-2 align-items-center">
							<a class="link-primary" href="/expenses/edit/${e.id}">Edit</a>
							
							<form:form action="/expenses/delete/${e.id}" method="POST">
									<input type="hidden" name="_method" value="DELETE"/>
									<button class="btn btn-outline-danger btn-sm" type="submit">Delete</button>
							</form:form>
							</div>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<hr>
		<form:form action="/expenses/create" method="POST" modelAttribute="expense">
			<div class="from-control">
				<form:label path="name">Name</form:label>
				<form:errors path="name" class="text-danger" />
				<form:input class="form-control" type="text" path="name"/>
			</div>
			<div class="from-control">
				<form:label path="vendor">Vendor</form:label>
				<form:errors path="vendor" class="text-danger" />
				<form:input class="form-control" type="text" path="vendor"/>
			</div>
			<div class="from-control">
				<form:label path="amount">Amount</form:label>
				<form:errors path="amount" class="text-danger" />
				<form:input class="form-control" type="text" path="amount"/>
			</div>
			<div class="from-control">
				<form:label path="description">Description</form:label>
				<form:errors path="description" class="text-danger" />
				<form:textarea class="form-control" rows="10" path="description"/>
			</div>
				<button type="submit" class="btn btn-primary col-12 my-3">Submit</button>
		</form:form>
	</div>
</body>
</html>