<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM"
	crossorigin="anonymous">
<nav class="navbar navbar-expand-lg">
	<div class="container-fluid">
		<a class="navbar-brand" href="index.jsp"> <img 
			src='https://i.postimg.cc/yNKYF9hp/Carbone-e-Beige-Semplice-e-Circolare-Logo-Evento-di-Scacchi.png'
			border='0' alt='logo-removebg-preview' width="100" height="100"/>
		</a>
		<button class="navbar-toggler" type="button" data-bs-toggle="collapse"
			data-bs-target="#navbarSupportedContent"
			aria-controls="navbarSupportedContent" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon "></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<ul class="navbar-nav me-auto mb-2 mb-lg-0">
				<li class="nav-item"><a class="nav-link"
					href="battutaServlet">Random</a></li>
				<li class="nav-item"><a class="nav-link"
					href="listaBattuteServlet">Lista</a></li>
			</ul>
			<form class="d-flex" role="search" method="get" action="listaBattuteServlet">
				<input class="form-control me-2" type="search" placeholder="Cerca"
					aria-label="Search" name="q">
				<button style="height: max-content; margin-top: 0px;"
					class="btn btn-primary fw-bolder mb-7" type="submit">
					<svg xmlns="http://www.w3.org/2000/svg" width="26" height="26"
						fill="currentColor" class="bi bi-search" viewBox="0 0 15 15">
				<path
							d="M11.742 10.344a6.5 6.5 0 1 0-1.397 1.398h-.001c.03.04.062.078.098.115l3.85 3.85a1 1 0 0 0 1.415-1.414l-3.85-3.85a1.007 1.007 0 0 0-.115-.1zM12 6.5a5.5 5.5 0 1 1-11 0 5.5 5.5 0 0 1 11 0z" />
				</svg>
				</button>
			</form>
			
		</div>
	</div>
</nav>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz"
	crossorigin="anonymous"></script>