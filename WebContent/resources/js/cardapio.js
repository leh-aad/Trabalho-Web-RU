/**
 * 
 */

var mensagens_erro = {
  'obrigatorio': 'Campo obrigatorio'
};

var formulario;

window.onload = function(){
	formulario = document.getElementById("form-cardapio");
	
	formulario.addEventListener("submit", validarFormulario, false);
}

function validarFormulario(event){
	limparMensagens();
	
	var valido = true;
	
	var campos = ["principal", "vegetariano", "acompanhamento", "guarnicao", "sobremesa", "suco", "fruta"];	
	
	for (var id in campos){
		var valor = document.getElementById(campos[id]).value;
		
		if (isVazio(valor)){
			exibeMensagens(campos[id], mensagens_erro["obrigatorio"]);
			valido = false;
		}
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
  document.getElementById(id + '-erro').innerHTML = mensagem;
}

function isVazio(campo) {
  return campo.length == 0;
}
