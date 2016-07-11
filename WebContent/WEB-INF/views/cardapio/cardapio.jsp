<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div>

  <h2 class="text-success">Almoco</h2>

  <table class="table table-striped">
    <thead>
      <tr>
        <td>Principal</td>
        <td>Vegetariano</td>
        <td>Acompanhamento</td>
        <td>Guarnicao</td>
        <td>Sobremesa</td>
        <td>Suco</td>
        <td>Fruta</td>
      </tr>
    </thead>
    <c:if test="${ not empty almoco }">
      <tbody>
        <tr>
          <td>${ almoco.principal }</td>
          <td>${ almoco.vegetariano }</td>
          <td>${ almoco.acompanhamento }</td>
          <td>${ almoco.guarnicao }</td>
          <td>${ almoco.sobremesa }</td>
          <td>${ almoco.suco }</td>
          <td>${ almoco.fruta }</td>
        </tr>
      </tbody>
    </c:if>
  </table>
  <c:if test="${ empty almoco }">
    <h2 class="text-warning col-md-offset-2">Cardapio nao cadastrado para hoje!</h2>
  </c:if>

  <h2 class="text-success">Janta</h2>

  <table class="table table-striped">
    <thead>
      <tr>
        <td>Principal</td>
        <td>Vegetariano</td>
        <td>Acompanhamento</td>
        <td>Guarnicao</td>
        <td>Sobremesa</td>
        <td>Suco</td>
        <td>Fruta</td>
      </tr>
    </thead>
    <tbody>
      <tr>
        <c:if test="${ not empty jantar }">
          <td>${ jantar.principal }</td>
          <td>${ jantar.vegetariano }</td>
          <td>${ jantar.acompanhamento }</td>
          <td>${ jantar.guarnicao }</td>
          <td>${ jantar.sobremesa }</td>
          <td>${ jantar.suco }</td>
          <td>${ jantar.fruta }</td>
        </c:if>
      </tr>
    </tbody>
  </table>
  <c:if test="${ empty jantar }">
    <h2 class="text-warning col-md-offset-2">Cardapio nao cadastrado para hoje!</h2>
  </c:if>

</div>
