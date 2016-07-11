package br.ufc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.ufc.dao.AlunoDAO;
import br.ufc.dao.SecretarioDAO;
import br.ufc.dao.UsuarioDAO;
import br.ufc.model.Aluno;
import br.ufc.model.Secretario;
import br.ufc.model.Usuario;

@Transactional
@Controller
public class TicketController {

	@Autowired
	private UsuarioDAO usuarioDAO;
	
	@Autowired
	private AlunoDAO alunoDAO;
	
	@Autowired
	private SecretarioDAO secretarioDAO;
	
	@RequestMapping("/ticket/vender")
	public String telaVender() {
		return "ticket/vender";
	}

	@RequestMapping("/ticket/utilizar")
	public String telaUtilizar() {
		return "ticket/utilizar";
	}

	@RequestMapping("/vender-ticket")
	public String vender(String login, int quantidade, Model model) {

		boolean erro = false;

		if (quantidade > 5 || quantidade < 0) {
			model.addAttribute("feedback_venda", "A quantidade tem que estar entre 1 e 5 tickets!");
			return "ticket/vender";
		}

		Usuario usuario = usuarioDAO.buscarUsuario(login);

		if (usuario != null) {
			switch (usuario.getTipoUsuario()) {
			case "aluno":
				Aluno aluno = alunoDAO.buscarAluno(usuario.getLogin());
				if (aluno != null) {
					aluno.setCredito(aluno.getCredito() + quantidade);
					alunoDAO.alterar(aluno);
					model.addAttribute("feedback_venda", "Venda realizada com sucesso!");
				} else
					erro = true;
				break;

			case "secretario":
				Secretario secretario = secretarioDAO.buscarSecretario(usuario.getLogin());
				if (secretario != null) {
					secretario.setCredito(secretario.getCredito() + quantidade);
					secretarioDAO.alterar(secretario);
					model.addAttribute("feedback_venda", "Venda realizada com sucesso!");
				} else
					erro = true;
				break;
			}
		} else {
			model.addAttribute("feedback_venda", "Venda nao concretizada! Usuario nao existe!");
		}

		if (erro)
			model.addAttribute("feedback_venda", "Venda nao concretizada!");

		return "ticket/vender";
	}

	@RequestMapping("/utilizar-ticket")
	public String utilizar(String login, String senha, Model model) {

		boolean erro = false;

		Usuario usuario = usuarioDAO.autenticar(login, senha);

		if (usuario != null) {
			switch (usuario.getTipoUsuario()) {
			case "aluno":
				Aluno aluno = alunoDAO.buscarAluno(usuario.getLogin());
				if (aluno != null) {
					if (aluno.getCredito() == 0) {
						model.addAttribute("feedback_login", "Usuario com credito insuficiente!");
						return "ticket/utilizar";
					} else {
						aluno.setCredito(aluno.getCredito() - 1);
						alunoDAO.alterar(aluno);
					}
				} else
					erro = true;
				break;

			case "secretario":
				Secretario secretario = secretarioDAO.buscarSecretario(usuario.getLogin());
				if (secretario != null) {
					if (secretario.getCredito() == 0) {
						model.addAttribute("feedback_login", "Usuario com credito insuficiente!");
						return "ticket/utilizar";
					} else {
						secretario.setCredito(secretario.getCredito() - 1);
						secretarioDAO.alterar(secretario);
					}
				} else
					erro = true;
				break;
			}
		} else {
			model.addAttribute("feedback_login", "Usuario nao cadastrado!");
		}

		if (erro)
			model.addAttribute("feedback_venda", "Usuario nao existe!");
		else
			model.addAttribute("feedback_venda", "Tenha uma boa refeicao!");

		return "ticket/utilizar";
	}

}
