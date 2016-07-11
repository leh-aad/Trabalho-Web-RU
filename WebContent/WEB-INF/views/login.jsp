<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="col-md-4">
  <div class="form">
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
