<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
	rel="stylesheet">
<meta charset="ISO-8859-1">
<title>Restaurante</title>
</head>
<body>
	<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
		<div class="container-fluid">
			<ul class="navbar-nav">
				<li class="nav-item"><a class="nav-link active" href="/">Restaurante</a></li>
				<li class="nav-item"><a class="nav-link" href="/pedido/listagem">Pedidos</a></li>
				<li class="nav-item"><a class="nav-link" href="/comida/listagem">Comidas</a></li>
				<li class="nav-item"><a class="nav-link" href="/bebida/listagem">Bebidas</a></li>
				<li class="nav-item"><a class="nav-link" href="/endereco/listagem">Endereços</a></li>

				<li class="nav-item"><a class="nav-link" href="/estado/listagem">Estados</a></li>
			</ul>

			<form class="d-flex" action="/municipio/listagem" method="get">
            	<select class="form-control me-2" name="uf">
            		<c:forEach var="estado" items="${estados}">
            			<option value="${estado.id}">${estado.nome} - ${estado.sigla}</option>
            		</c:forEach>
            	</select>
            	<button class="btn btn-primary" type="submit">Municípios</button>
            </form>

		</div>
	</nav>

	<div class="container mt-3">

		<span class="badge rounded-pill bg-primary">Pedido:
			${qtdePedido}</span> <span class="badge rounded-pill bg-secondary">Comida:
			${qtdeComida}</span> <span class="badge rounded-pill bg-success">Bebida:
			${qtdeBebida}</span>
			<span class="badge rounded-pill bg-warning">Endereço:${qtdeEndereco}</span>

		<c:if test="${not empty listagem}">
			<h2>Restaurante</h2>
			<p>Gestão de pedidos:</p>
			<table class="table">
				<thead class="table-dark">
					<tr>
						<th>${titulo}</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="item" items="${listagem}">
						<tr>
							<td>${item}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</c:if>

		<c:if test="${empty listagem}">
			<div class="container mt-5">
		        <div class="card mx-auto" style="width: 18rem;">
		            <img src="https://media.licdn.com/dms/image/D4D03AQH-DMAKNUbmZw/profile-displayphoto-shrink_800_800/0/1708022087161?e=1723075200&v=beta&t=4ys4BrqA2P-AnnnZ-4U5xLQNpgSCnaONWXKwbtYWO7o" class="card-img-top" alt="Foto do Desenvolvedor">
		            <div class="card-body">
		                <h5 class="card-title">Matheus Moraes</h5>
		                <p class="card-text"><strong>Telefone:</strong> (21) 97431-5091</p>
		                <p class="card-text">Atuo como desenvolvedor Java.</p>
		                <a href="https://github.com/devmatheusmoraes/restaurante" class="btn btn-primary" target="_blank">GitHub do Projeto</a>
		                <a href="https://www.linkedin.com/in/matheus-moraes-ti/" class="btn btn-secondary" target="_blank">LinkedIn</a>
		            </div>
		        </div>
		    </div>
	    </c:if>

	</div>
    <!-- Bootstrap JS and dependencies -->
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/5.3.0/js/bootstrap.min.js"></script>
</body>
</html>