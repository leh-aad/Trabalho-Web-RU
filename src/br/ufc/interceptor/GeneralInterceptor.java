package br.ufc.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import br.ufc.dao.SecretarioDAO;
import br.ufc.model.Secretario;
import br.ufc.model.Usuario;

@Transactional
public class GeneralInterceptor extends HandlerInterceptorAdapter{
	
	@Autowired
	private SecretarioDAO secretarioDAO;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		Usuario usuario = (Usuario) request.getSession().getAttribute("usuario");
		String uri = request.getRequestURI();
		
		if (uri.contains("/administrador")){
			if (usuario.getTipoUsuario().equals("secretario")){
				Secretario secretario = secretarioDAO.getSecretarioPorLogin(usuario.getLogin());
							
				if (secretario != null && secretario.isAdministrador()){
					request.getSession().setAttribute("dadosUsuario", secretario);
					return true;
				}
				else
					response.sendRedirect("/ru/");				
			}
		}
		
		return true;
	}
}
