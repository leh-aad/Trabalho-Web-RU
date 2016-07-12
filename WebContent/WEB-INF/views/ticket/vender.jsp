<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
	<link type="text/css" rel="stylesheet" href="resources/css/bootstrap.css">
	<link type="text/css" rel="stylesheet" href="resources/css/main.css">
	<script type="text/javascript" src="resources/js/venderTicket.js"></script>
	<title>Vender Ticket</title>
</head>
<body>

	<div class="navbar navbar-default navbar-static-top">
    <div class="navbar-header">
      <span class="navbar-brand">Tickets RU</span>
    </div>
    <ul class="nav navbar-nav navbar-left">
      <li><a href="secretario">Principal</a></li>
      <li><a href="next-cardapio">Cardapio do Proximo Dia</a></li>
      <li class="active"><a href="vender-ticket-form">Vender Ticket</a></li>
      <li><a href="logout">Sair</a></li>
    </ul>
  </div>

	<div class="container">

		<div class="col-md-8">
			<form id = "form-vender-ticket" class="col-md-10" action="vender-ticket" method="post">

				<div class="form-group">
				  <label for="login">Matricula:</label>
				  <input type="text" class="form-control" id="login" name="login">
				  <span class="erro" id="erro-login"></span>
				</div>

				<div class="form-group">
					<label for="quantidade">Quantidade:</label>
					<select id="quantidade" class="form-control" name="quantidade">
						<option value="1">1</option>
						<option value="2">2</option>
						<option value="3">3</option>
						<option value="4">4</option>
						<option value="5">5</option>
					</select>
				</div>
				
				<button class="btn btn-success btn-block" type="submit">Vender</button>
				<c:if test="${ not empty feedback_venda }">
				    <div class="erro">
				      <hr>
				      <span>${ feedback_venda }</span>
				    </div>
				 </c:if>
			</form>			
		</div>		
	</div>

	<jsp:include page="../rodape.jsp"/>

</body>
</html>
