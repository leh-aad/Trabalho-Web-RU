package br.ufc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.ufc.dao.AlunoDAO;
import br.ufc.dao.SecretarioDAO;
import br.ufc.dao.UsuarioDAO;
import br.ufc.model.Aluno;
import br.ufc.model.Cardapio;
import br.ufc.model.Secretario;
import br.ufc.model.Usuario;

@Controller
public class AdminController {

	@Autowired
	private UsuarioDAO usuarioDAO;

	@Autowired
	private AlunoDAO alunoDAO;

	@Autowired
	private SecretarioDAO secretarioDAO;

	@RequestMapping("/administrador")
	public String index(){
		return "administrador/index";
	}

	@RequestMapping("/cadastrar/aluno")
	public String cadastrarAluno() {
		return "administrador/cadastrar-aluno";
	}

	@RequestMapping("/cadastrar/secretario")
	public String cadastrarSecretario() {
		return "administrador/cadastrar-secretario";
	}
	
	@RequestMapping("/cadastrar/cardapio")
	public String cadastrarCardapio() {
		return "administrador/cadastrar-cardapio";
	}

	@RequestMapping("/aluno-cadastrar")
	public String cadastrarAluno(Aluno aluno, Model model) {

		if (aluno != null) {

			Usuario usuario = new Usuario();
			usuario.setLogin(aluno.getMatricula());
			usuario.setSenha(aluno.getMatricula());
			usuario.setTipoUsuario("aluno");

			if (usuarioDAO.inserir(usuario)) {
				alunoDAO.inserir(aluno);
				model.addAttribute("feedback-cadastro", "Aluno cadastrado com sucesso!");
				return "cadastrar/aluno";
			}
		}

		model.addAttribute("feedback-cadastro", "Aluno nao pode ser cadastrado!");
		return "cadastrar/aluno";
	}

	@RequestMapping("/secretario-cadastrar")
	public String cadastrarSecretario(Secretario secretario, Model model) {

		if (secretario != null) {

			Usuario usuario = new Usuario();
			usuario.setLogin(secretario.getMatricula());
			usuario.setSenha(secretario.getMatricula());
			usuario.setTipoUsuario("secretario");

			if (usuarioDAO.inserir(usuario)) {
				secretarioDAO.inserir(secretario);
				model.addAttribute("feedback-cadastro", "Secretario cadastrado com sucesso!");
				return "cadastrar/secretario";
			}
		}

		model.addAttribute("feedback-cadastro", "Secretario nao pode ser cadastrado!");
		return "cadastrar/secretario";
	}

	@RequestMapping("cardapio-cadastrar")
	public String cadastrarCardapio(Cardapio cardapio) {
		
		
		return "cadastrar/cardapio";
	}
	
}
