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

    <jsp:include page="login.jsp"></jsp:include>

  </div>
</body>
</html>
