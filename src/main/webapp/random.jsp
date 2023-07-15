<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="jakarta.tags.core" prefix="c"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Random</title>
<link rel="stylesheet" href="style.css">
</head>
<body>
	<%@ include file="navbar.jsp"%>
	<h1 id="h1">Chuck Norris</h1>
	<div id="div" class="container text-center-my-5"
		style="border: 3px solid #302EBB; padding: 50px;">
		<div class="row-my-4">
			<div class="col-my-4">
				<table class="table table-success table-striped">
					<thead>
						<tr>
							<th id="ct" class="header">Value</th>
							<th id="ct" class="header">Updated_At</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td id="ct" scope="row">${joke}</td>
							<td id="ct" scope="row">${formattedDate}</td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>
		<div id="row" class="row">
			<div class="column">
				<form method="get" action="contaParolaServlet">
					<p>Vuoi sapere quante volte è possibile comporre la parola
						chuck da questa battuta?</p>
					<input type="hidden" name="idBattuta" value="${battuta.id}">
					<button type="submit" class="btn btn-primary"
						style="vertical-align: middle"
						${not empty totaleParola ? 'disabled' : ''}>
						<span>Scopri</span>
					</button>
				</form>
				<div>
					<p>
						<c:out value="${totaleParola}" />
					</p>
				</div>
			</div>
		</div>
	</div>
	<%@ include file="footer.jsp"%>
</body>
</html>