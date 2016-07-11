package br.ufc.controller;

import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.ufc.dao.CardapioDAO;
import br.ufc.model.Cardapio;

@Transactional
@Controller
public class HomeController {

	@Autowired
	private CardapioDAO cardapioDAO;

	@RequestMapping("/")
	public String index(Model model){

		Calendar hoje = Calendar.getInstance();
		int day_week = hoje.get(Calendar.DAY_OF_WEEK);
		List<Cardapio> cardapios = cardapioDAO.getCardapio(day_week);

		if (cardapios.size() >= 2) {
			Cardapio c1 = cardapios.get(0);
			Cardapio c2 = cardapios.get(1);

			model.addAttribute("almoco", c1);
			model.addAttribute("jantar", c2);
		}

		return "index";
	}

	@RequestMapping("/next-cardapio")
	public String exibirProximoCardapio(Model model) {
		
		Calendar hoje = Calendar.getInstance();
		int next_day_week = hoje.get(Calendar.DAY_OF_WEEK) + 1;
		List<Cardapio> cardapios;
		if (next_day_week > 7) cardapios = cardapioDAO.getCardapio(1);
		else cardapios = cardapioDAO.getCardapio(next_day_week);

		if (cardapios.size() >= 2) {
			Cardapio c1 = cardapios.get(0);
			Cardapio c2 = cardapios.get(1);

			model.addAttribute("almoco", c1);
			model.addAttribute("jantar", c2);
		}

		return "next-cardapio";
	}

	@RequestMapping("/about")
	public String about() {
		return "sobre";
	}

}
