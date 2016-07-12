package br.ufc.controller;

import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;

import br.ufc.dao.AlunoDAO;
import br.ufc.dao.CardapioDAO;
import br.ufc.dao.SecretarioDAO;
import br.ufc.dao.UsuarioDAO;
import br.ufc.model.Aluno;
import br.ufc.model.Cardapio;
import br.ufc.model.Secretario;
import br.ufc.model.Usuario;

@Controller
@Transactional
public class AdminController {

	@Autowired
	private UsuarioDAO usuarioDAO;

	@Autowired
	private AlunoDAO alunoDAO;

	@Autowired
	private SecretarioDAO secretarioDAO;
	
	@Autowired
	private CardapioDAO cardapioDAO;

	@RequestMapping("/administrador")
	public String index(HttpSession session) {
		List<Aluno> alunos = alunoDAO.listar();
		List<Secretario> secretarios = secretarioDAO.listar();
		
		session.setAttribute("alunos", alunos);
		session.setAttribute("secretarios", secretarios);

		Calendar hoje = Calendar.getInstance();
		int day_week = hoje.get(Calendar.DAY_OF_WEEK);
		List<Cardapio> cardapios = cardapioDAO.getCardapio(day_week);
		
		System.out.println(day_week);
		
		if (cardapios.size() > 0) {			
			Cardapio c1 = cardapios.get(0);					
			session.setAttribute("almoco", c1);
			
			if (cardapios.size() > 1){
				Cardapio c2 = cardapios.get(1);
				session.setAttribute("jantar", c2);
			}
			else{				
				session.removeAttribute("jantar");
			}
		}
		else{
			session.removeAttribute("almoco");
		}

		
		return "administrador/index";
	}

	@RequestMapping("/cadastrar-aluno-form")
	public String cadastrarAluno() {
		return "administrador/cadastrar-aluno";
	}

	@RequestMapping("/cadastrar-secretario-form")
	public String cadastrarSecretario() {
		return "administrador/cadastrar-secretario";
	}

	@RequestMapping("/cadastrar-cardapio-form")
	public String cadastrarCardapio() {
		return "administrador/cadastrar-cardapio";
	}

	@RequestMapping("/cadastrar-aluno")
	public String cadastrarAluno(Aluno aluno, HttpSession session) {

		if (aluno != null) {

			Usuario usuario = new Usuario();
			usuario.setLogin(aluno.getMatricula());
			usuario.setSenha(aluno.getMatricula());
			usuario.setTipoUsuario("aluno");

			if (usuarioDAO.inserir(usuario)) {
				alunoDAO.inserir(aluno);
				session.setAttribute("feedback-cadastro",
						"Aluno cadastrado com sucesso!");
				return "redirect:cadastrar-aluno-form";
			}
		}

		session.setAttribute("feedback-cadastro",
				"Aluno nao pode ser cadastrado!");
		return "redirect:cadastrar-aluno-form";
	}

	@RequestMapping("/cadastrar-secretario")
	public String cadastrarSecretario(Secretario secretario, HttpSession session) {

		if (secretario != null) {

			Usuario usuario = new Usuario();
			usuario.setLogin(secretario.getMatricula());
			usuario.setSenha(secretario.getMatricula());
			usuario.setTipoUsuario("secretario");

			if (usuarioDAO.inserir(usuario)) {
				secretarioDAO.inserir(secretario);
				session.setAttribute("feedback_cadastro",
						"Secretario cadastrado com sucesso!");
				return "redirect:cadastrar-secretario-form";
			}
		}

		session.setAttribute("feedback_cadastro",
				"Secretario nao pode ser cadastrado!");
		return "redirect:cadastrar-secretario-form";
	}

	@RequestMapping("/cadastrar-cardapio")
	public String cadastrarCardapio(Cardapio cardapio, HttpSession session) {		
		List<Cardapio> cardapios = cardapioDAO.getCardapio(cardapio.getData());
		
		for (Cardapio c : cardapios){			
			if (c.getTipo() == cardapio.getTipo())
				cardapioDAO.remover(cardapios.get(0).getId());																
		}
				
		if (cardapio != null && cardapioDAO.inserir(cardapio))
			session.setAttribute("feedback_cadastro", "Cardapio cadastrado com sucesso!");
		else
			session.setAttribute("feedback_cadastro", "Cardapio nao pode ser cadastrado!");
		
					
		return "redirect:cadastrar-cardapio-form";
	}
}
