package br.ufc.controller;

import javax.servlet.http.HttpSession;

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

@Controller
@Transactional
public class LoginController {

	@Autowired
	private UsuarioDAO usuarioDAO;

	@Autowired
	private AlunoDAO alunoDAO;

	@Autowired
	private SecretarioDAO secretarioDAO;

	@RequestMapping("/login")
	public String tentativaLogin(Usuario usuario, HttpSession session, Model model) {
		if (usuario != null) {
			Usuario usr = usuarioDAO.autenticar(usuario.getLogin(), usuario.getSenha());

			if (usr != null) {
				session.setAttribute("usuario", usr);

				switch (usr.getTipoUsuario()) {
				case "aluno":
					Aluno aluno = alunoDAO.getAlunoPorLogin(usr.getLogin());
					model.addAttribute("aluno", aluno);
					return "aluno/index";
				case "secretario":
					Secretario secretario = secretarioDAO.getSecretarioPorLogin(usr.getLogin());
					model.addAttribute("secretario", secretario);
					return "secretario/index";
				case "ru":
					return "ticket/utilizar";
				}
			}
		}
		model.addAttribute("feedback_login", "Usuario e/ou senha invalidos!");
		return "index";
	}

	@RequestMapping("/logout")
	public String logout(HttpSession session){

		session.invalidate();
		return "index";
	}
}
