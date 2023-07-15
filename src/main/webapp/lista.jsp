<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="jakarta.tags.core" prefix="c"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="style.css">
<title>Lista</title>
</head>
<body>
	<%@ include file="navbar.jsp"%>
	<h1 id= "h1">Chuck Norris</h1>
	<div id="div" class="container text-center-mt-5">
		<div class="row">
			<c:if test="${ empty requestScope.battute}">
				<div class="container text-center mt-5">
					<div class="row justify-content-center-my-4">
						<div class="col-my-4">
								<p>Non sono ancora state salvate le battute.</p>
						</div>
					</div>
				</div>
			</c:if>
			<c:if test="${not empty requestScope.battute}">
				<table class="table table-success table-striped">
					<thead>
						<tr>
							<th id= "ct" scope="col">ID</th>
							<th id= "ct" scope="col">VALUE</th>
							<th id= "ct" scope="col">UPDATED_AT</th>
						</tr>
					</thead>
					<c:forEach var="battuta" items="${requestScope.battute}">
						<tbody>
							<tr>
								<td id= "ct" scope="row">${battuta.id}</td>
								<td id= "ct" scope="row">${battuta.value}</td>
								<td id= "ct" scope="row">${battuta.updatedAt}</td>
							</tr>
						</tbody>
					</c:forEach>
				</table>
			</c:if>
		</div>
	</div>
	<%@ include file="footer.jsp"%>
</body>
</html>