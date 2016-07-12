package br.ufc.controller;

import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;

import br.ufc.dao.CardapioDAO;
import br.ufc.model.Cardapio;

@Transactional
@Controller
public class HomeController {

	@Autowired
	private CardapioDAO cardapioDAO;
	
	@RequestMapping("/aluno")
	public String aluno(HttpSession session){
		Calendar hoje = Calendar.getInstance();
		int day_week = hoje.get(Calendar.DAY_OF_WEEK);
		List<Cardapio> cardapios = cardapioDAO.getCardapio(day_week);			
		
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

		return "aluno/index";
	}
	
	@RequestMapping("/secretario")
	public String secretario(HttpSession session){
		Calendar hoje = Calendar.getInstance();
		int day_week = hoje.get(Calendar.DAY_OF_WEEK);
		List<Cardapio> cardapios = cardapioDAO.getCardapio(day_week);
		
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
	
		return "secretario/index";
	}
	
	@RequestMapping("/about")
	public String about() {
		return "sobre";
	}	

	@RequestMapping("/")
	public String index(HttpSession session){

		Calendar hoje = Calendar.getInstance();
		int day_week = hoje.get(Calendar.DAY_OF_WEEK);
		List<Cardapio> cardapios = cardapioDAO.getCardapio(day_week);			
		
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

		return "index";
	}

	@RequestMapping("/next-cardapio")
	public String exibirProximoCardapio(HttpSession session) {

		Calendar hoje = Calendar.getInstance();
		int day_week = (hoje.get(Calendar.DAY_OF_WEEK) + 1) % 6;
		List<Cardapio> cardapios = cardapioDAO.getCardapio(day_week);

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


		return "cardapio/next-cardapio";
	}
}
