var mensagens_erro = {
  'obrigatorio': 'Campo obrigatorio'
  , 'codigo': 'matricula so pode conter numeros!'
  , 'nome': 'nome nao pode estar em branco!'
  , 'email': 'email invalido!'
};

function limparMensagens() {
  var erro = document.getElementsByClassName('erro');
  for (var i in erro) {
    erro[i].innerHTML = '';
  }
}

function exibeMensagens(id, mensagem) {
  document.getElementById('erro-' + id).innerHTML = mensagem;
}

function isVazio(campo) {
  return campo.length == 0;
}

var cadastroAluno = function () {

};

var cadastroFuncionario = function () {

};
