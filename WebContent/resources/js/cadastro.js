var mensagens_erro = {
  'obrigatorio': 'Campo obrigatorio'
  , 'numero': 'Este campo so pode conter numeros!'
  , 'nome': 'Nome nao pode conter apenas numeros!'
  , 'email': 'Email invalido!'
};

var formulario;

window.onload = function(){
	formulario = document.getElementById("form-secretario");
	
	formulario.addEventListener("submit", validarFormulario, false);
}

function validarFormulario(event){
	limparMensagens();
	
	var valido = true;
	
	var campos = ["matricula", "nome", "email"];	
	
	for (var id in campos){
		var valor = document.getElementById(campos[id]).value;
		
		if (isVazio(valor)){
			exibeMensagens(campos[id], mensagens_erro["obrigatorio"]);
			valido = false;
		}
	}
	
	var nome = document.getElementById("nome");
	if (!isNaN(nome)){
		exibeMensagens("nome", mensagens_erro["nome"]);
		valido = false;
	}
		
	var valorMatricula = document.getElementById("matricula").value;	
	if (isNaN(valorMatricula)){
		exibeMensagens("matricula", mensagens_erro["numero"]);
		valido = false;
	}
	
	var email = document.getElementById("email");	
	if(email.indexOf("@") == -1 || email.indexOf(".") == -1){
        exibeMensagens("email", messages["email"]);
        valido = false;
    }
	
	if (!valido){
		event.preventDefault();
		return false;
	}
	
	return true;
}

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