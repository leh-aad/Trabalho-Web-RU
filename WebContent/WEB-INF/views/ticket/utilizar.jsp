<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
	<link type="text/css" rel="stylesheet" href="resources/css/bootstrap.css">
	<link type="text/css" rel="stylesheet" href="resources/css/main.css">
	<title>RU - Refeicao</title>
</head>
<body>
	<div class="col-md-4 col-md-offset-4">

		<form id="form-ticket-utilizar" action="utilizar-ticket" method="post">
			<div class="form-group">
				<label for="login">Login:</label>
				<input id="login"	class="form-control" type="text" name="login">
			</div>

			<div class="form-group">
				<label for="senha">Senha:</label>
				<input id="senha"	class="form-control" type="password" name="senha">
			</div>
			<input class="btn btn-success btn-block" type="submit" value="Ok">
		</form>

		<c:if test="${ not empty feedback_login }">
			<div class="erro">
				<hr>
				<span>${ feedback_login }</span>
			</div>
		</c:if>

	</div>

	<jsp:include page="../rodape.jsp"/>

</body>
</html>
