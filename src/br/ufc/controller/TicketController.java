package br.ufc.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
	
	@RequestMapping("/vender-ticket-form")
	public String telaVender() {
		return "ticket/vender";
	}

	@RequestMapping("/utilizar-ticket-form")
	public String telaUtilizar() {
		return "ticket/utilizar";
	}

	@RequestMapping("/vender-ticket")
	public String vender(@RequestParam(value = "login") String login, @RequestParam(value = "quantidade") int quantidade, HttpSession session) {

		boolean erro = false;

		if (quantidade > 5 || quantidade < 0) {
			session.setAttribute("feedback_venda", "A quantidade tem que estar entre 1 e 5 tickets!");
			return "redirect:vender-ticket-form";
		}

		Usuario usuario = usuarioDAO.buscarUsuario(login);

		if (usuario != null) {
			switch (usuario.getTipoUsuario()) {
			case "aluno":
				Aluno aluno = alunoDAO.buscarAluno(usuario.getLogin());
				if (aluno != null) {
					aluno.setCredito(aluno.getCredito() + quantidade);
					alunoDAO.alterar(aluno);
					
					session.setAttribute("feedback_venda", "Venda realizada com sucesso!");
				} else
					erro = true;
				break;

			case "secretario":
				Secretario secretario = secretarioDAO.buscarSecretario(usuario.getLogin());
				if (secretario != null) {
					secretario.setCredito(secretario.getCredito() + quantidade);
					secretarioDAO.alterar(secretario);
					session.setAttribute("feedback_venda", "Venda realizada com sucesso!");
				} else
					erro = true;
				break;
			}
		} else {
			session.setAttribute("feedback_venda", "Venda nao concretizada! Usuario nao existe!");
		}

		if (erro)
			session.setAttribute("feedback_venda", "Venda nao concretizada!");

		return "redirect:vender-ticket-form";
	}

	@RequestMapping("/utilizar-ticket")
	public String utilizar(String login, String senha, HttpSession session) {

		boolean erro = false;

		Usuario usuario = usuarioDAO.autenticar(login, senha);

		if (usuario != null) {
			switch (usuario.getTipoUsuario()) {
			case "aluno":
				Aluno aluno = alunoDAO.buscarAluno(usuario.getLogin());
				if (aluno != null) {
					if (aluno.getCredito() == 0) {
						session.setAttribute("feedback_login", "Usuario com credito insuficiente!");
						return "redirect:utilizar-ticket-form";
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
						session.setAttribute("feedback_login", "Usuario com credito insuficiente!");
						return "redirect:utilizar-ticket-form";
					} else {
						secretario.setCredito(secretario.getCredito() - 1);
						secretarioDAO.alterar(secretario);
					}
				} else
					erro = true;
				break;
			}
		} else {
			session.setAttribute("feedback_login", "Usuario nao cadastrado!");
		}

		if (erro)
			session.setAttribute("feedback_login", "Usuario nao existe!");
		else
			session.setAttribute("feedback_login", "Tenha uma boa refeicao!");

		return "redirect:utilizar-ticket-form";
	}
}
