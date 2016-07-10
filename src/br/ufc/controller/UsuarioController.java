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

@Controller
@Transactional
public class UsuarioController {

	@Autowired
	private UsuarioDAO usuarioDAO;

	@Autowired
	private AlunoDAO alunoDAO;

	@Autowired
	private SecretarioDAO secretarioDAO;

	public boolean adicionarUsuario(Usuario usuario) {
		return usuarioDAO.inserir(usuario);
	}

	@RequestMapping("/adicionar-aluno")
	public String adicionarAluno(Aluno aluno, Model model) {

		Usuario u = new Usuario();
		u.setLogin(aluno.getMatricula());
		u.setSenha(aluno.getMatricula());
		u.setTipoUsuario("aluno");

		if (adicionarUsuario(u) && alunoDAO.inserir(aluno)) {
			model.addAttribute("erro", "Usuario adicionado com sucesso!");
			return "usuario/cadastrar-aluno";
		}

		model.addAttribute("erro", "Usuario nao foi adicionado!");
		return "usuario/cadastrar-aluno";
	}

	@RequestMapping("/adicionar-secretario")
	public String adicionarSecretario(Secretario secretario, Model model) {
		Usuario u = new Usuario();
		u.setLogin(secretario.getMatricula());
		u.setSenha(secretario.getMatricula());
		u.setTipoUsuario("secretario");

		if (adicionarUsuario(u) && secretarioDAO.inserir(secretario)) {
			model.addAttribute("erro", "Usuario adicionado com sucesso!");
			return "usuario/cadastrar-secretario";
		}
		model.addAttribute("erro", "Usuario nao foi adicionado!");
		return "usuario/cadastrar-secretario";
	}

}