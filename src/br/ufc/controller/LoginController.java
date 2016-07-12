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
public class LoginController {

	@Autowired
	private UsuarioDAO usuarioDAO;

	@Autowired
	private AlunoDAO alunoDAO;

	@Autowired
	private SecretarioDAO secretarioDAO;
	@Autowired
	private CardapioDAO cardapioDAO;
	
	@RequestMapping("/login")
	public String login(Usuario usuario, HttpSession session) {
		if (usuario != null) {
			Usuario usr = usuarioDAO.autenticar(usuario.getLogin(), usuario.getSenha());

			if (usr != null) {
				session.setAttribute("usuario", usr);
				
				Calendar hoje = Calendar.getInstance();
				int day_week = hoje.get(Calendar.DAY_OF_WEEK);
				List<Cardapio> cardapios = cardapioDAO.getCardapio(day_week);

				if (cardapios.size() >= 2) {
					Cardapio c1 = cardapios.get(0);
					Cardapio c2 = cardapios.get(1);

					session.setAttribute("almoco", c1);
					session.setAttribute("jantar", c2);
				}

				switch (usr.getTipoUsuario()) {
				case "aluno":
					Aluno aluno = alunoDAO.buscarAluno(usr.getLogin());
					session.setAttribute("aluno", aluno);					
					return "redirect:aluno";
				case "secretario":
					Secretario secretario = secretarioDAO.buscarSecretario(usr.getLogin());
					if (secretario.isAdministrador())
						return "redirect:administrador";
						
					session.setAttribute("secretario", secretario);
					return "redirect:secretario";
				case "ru":
					return "redirect:utilizar-ticket-form";
				}
			}
		}
		
		session.setAttribute("feedback_login", "Usuario e/ou senha invalidos!");
		return "redirect:/";
	}

	@RequestMapping("/logout")
	public String logout(HttpSession session){

		session.invalidate();
		return "redirect:/";
	}
}
