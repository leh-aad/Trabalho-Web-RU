package br.ufc.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import br.ufc.dao.AlunoDAO;
import br.ufc.dao.SecretarioDAO;
import br.ufc.model.Aluno;
import br.ufc.model.Secretario;
import br.ufc.model.Usuario;

@Transactional
public class GeneralInterceptor extends HandlerInterceptorAdapter {

	private static final String[] urisPublicas = { "/", "index", "login",
			"logout", "next-cardapio", "sobre", "about" };
	private static final String[] urisAdministrador = { "administrador", "administrador/index",
			"cadastrar-aluno", "aluno-cadastrar", "cadastrar-secretario",
			"secretario-cadastrar", "cadastrar-cardapio",
			"cardapio-cadastrar", "cadastrar/aluno", "cadastrar/cardapio", "cadastrar/secretario" };
	private static final String[] urisSecretario = { "secretario/index",
			"vender-ticket", "ticket/vender" };
	private static final String[] urisAluno = { "aluno/index" };
	private static final String[] urisRU = { "ticket/utilizar",
			"utilizar-ticket" };
	private static final String pastaResources = "resources";

	@Autowired
	private SecretarioDAO secretarioDAO;

	@Autowired
	private AlunoDAO alunoDAO;

	public boolean contemRequest(String[] uris, String requestURI) {
		for (String uri : uris) {
			if (requestURI.endsWith(uri))
				return true;
		}
		return false;
	}

	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {

		Usuario usuario = (Usuario) request.getSession()
				.getAttribute("usuario");

		String uri = request.getRequestURI();

		if (contemRequest(urisPublicas, uri) || uri.contains(pastaResources)) {
			return true;
		} else if (usuario != null) {
			String login = usuario.getLogin();

			if (contemRequest(urisAdministrador, uri)) {
				if (usuario.getTipoUsuario().equals("secretario")) {
					Secretario secretario = secretarioDAO
							.buscarSecretario(login);

					if (secretario != null && secretario.isAdministrador()) {
						return true;
					} else {
						response.sendRedirect("/Trabalho_Web_-_RU/");
						return false;
					}
				}
			} else if (contemRequest(urisAluno, uri)) {
				if (usuario.getTipoUsuario().equals("aluno")) {
					Aluno aluno = alunoDAO.buscarAluno(login);

					if (aluno != null) {
						return true;
					} else {
						response.sendRedirect("/Trabalho_Web_-_RU/");
						return false;
					}
				}
			} else if (contemRequest(urisSecretario, uri)) {
				if (usuario.getTipoUsuario().equals("secretario")) {
					Secretario secretario = secretarioDAO
							.buscarSecretario(login);

					if (secretario != null) {
						return true;
					} else {
						response.sendRedirect("/Trabalho_Web_-_RU/");
						return false;
					}
				}
			} else if (contemRequest(urisRU, uri)) {
				if (usuario.getTipoUsuario().equals("ru")) {
					return true;
				}
			}
		}

		response.sendRedirect("/Trabalho_Web_-_RU/");
		return false;
	}
}
