<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div>

  <h2 class="text-success">Alunos Cadastrados</h2>

  <table class="table table-striped">
    <thead>
      <tr>
        <td>Matricula</td>
        <td>Nome</td>
        <td>Email</td>
        <td>Curso</td>
      </tr>
    </thead>
    <c:if test="${ not empty alunos }">
      <tbody>
        <c:forEach var="a" items="${alunos}">
          <tr>
            <td>${ a.matricula }</td>
            <td>${ a.nome }</td>
            <td>${ a.email }</td>
            <td>${ a.curso }</td>
          </tr>
        </c:forEach>
      </tbody>
    </c:if>
  </table>
  <c:if test="${ empty alunos }">
    <h4 class="text-danger col-md-offset-2">Nenhum aluno cadastrado no sistema!</h4>
  </c:if>

</div>
