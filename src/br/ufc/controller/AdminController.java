package br.ufc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdminController {

	@Autowired
	private UsuarioDAO usuarioDAO;

	@Autowired
	private AlunoDAO alunoDAO;

	@Autowired
	private SecretarioDAO secretarioDAO;

	@RequestMapping("/administrador")
	private String index(){
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

}
