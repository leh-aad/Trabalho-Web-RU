package br.ufc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.ufc.model.Usuario;

@Transactional
@Controller
public class TicketController {
	
	@RequestMapping("/ticket/vender")
	public String telaVender() {
		return "ticket/vender";
	}
	
	@RequestMapping("/ticket/utilizar")
	public String telaUtilizar() {
		return "ticket/utilizar";
	}
	
	@RequestMapping("/vender-ticket")
	public String vender(Usuario usuario, int qntTicket, Model model) {
		
		return "ticket/vender";
	}
	
	@RequestMapping("/utilizar-ticket")
	public String utilizar(Usuario usuario, Model model) {
		
		model.addAttribute("erro_login", "fsaf");
		return "ticket/utilizar";
	}
	
}
