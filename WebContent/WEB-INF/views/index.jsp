<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"/>
  <link type="text/css" rel="stylesheet" href="resources/css/bootstrap.css"/>
  <link type="text/css" rel="stylesheet" href="resources/css/main.css"/>

  <title>Tickets RU</title>
</head>
<body>

  <div class="navbar navbar-default navbar-static-top">
    <div class="navbar-header">
      <span class="navbar-brand">Tickets RU</span>
    </div>
    <ul class="nav navbar-nav navbar-left">
      <li class="active"><a href="#">Principal</a></li>
      <li><a href="next-cardapio">Cardapio do Proximo Dia</a></li>
      <li><a href="about">Sobre</a></li>
    </ul>
  </div>

  <div class="container">

    <div class="col-md-8">
      <jsp:include page="cardapio/cardapio.jsp"/>
    </div>

    <div class="col-md-4">
      <div class="login-form">
        <form id="form-login" action="login" method="post">
          <div class="form-group">
            <label for="login">Usuario:</label>
            <input class="form-control" id="login" type="text" name="login"/>
            <span class="erro" id="login-erro"></span>
          </div>
          <div class="form-group">
            <label for="senha">Senha:</label>
            <input class="form-control" id="senha" type="password" name="senha"/>
          </div>
          <button class="btn btn-success btn-block" type="submit">Login</button>
        </form>
      </div>

			<c:if test="${ not empty feedback_login }">
				<div class="erro">
					<hr>
					<span>${ feedback_login }</span>
				</div>
			</c:if>
		</div>

  </div>
</body>
</html>
