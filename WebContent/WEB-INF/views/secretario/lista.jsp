<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div>

  <h2 class="text-success">Secretarios Cadastrados</h2>

  <table class="table table-striped">
    <thead>
      <tr>
        <td>Matricula</td>
        <td>Nome</td>
        <td>Email</td>
        <td>Administrador</td>
      </tr>
    </thead>
    <c:if test="${ not empty secretarios }">
      <tbody>
        <c:forEach var="s" items="${secretarios}">
          <tr>
            <td>${ s.matricula }</td>
            <td>${ s.nome }</td>
            <td>${ s.email }</td>
            <td>${ s.administrador }</td>
          </tr>
        </c:forEach>
      </tbody>
    </c:if>
  </table>
  <c:if test="${ empty secretarios }">
    <h4 class="text-danger col-md-offset-2">Nenhum Secretario cadastrado no sistema!</h4>
  </c:if>

</div>
