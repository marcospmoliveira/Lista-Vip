package br.com.marcos.ListaVip.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.marcos.ListaVip.model.Convidado;
import br.com.marcos.ListaVip.service.ConvidadoService;
import br.com.marcos.enviadorEmail.service.EmailService;

@Controller
public class ConvidadoController {
	
	@Autowired
	private ConvidadoService service;

	@RequestMapping("/")
	public String index() {
		return "index";
	}

	@RequestMapping("listaconvidados")
	public String listaConvidados(Model model) {

		Iterable<Convidado> convidados = service.ObterTodos();
		model.addAttribute("convidados", convidados);
		return "listaconvidados";
	}

	@RequestMapping(value = "salvar", method = RequestMethod.POST)
	public String salvar(@RequestParam("nome") String nome, @RequestParam("email") String email,
			@RequestParam("telefone") String telefone) {
		Convidado novoConvidado = new Convidado(nome, email,telefone);
		service.Salvar(novoConvidado);
		new EmailService().Enviar(nome, email);

		return "redirect:/listaconvidados";
	}
}
