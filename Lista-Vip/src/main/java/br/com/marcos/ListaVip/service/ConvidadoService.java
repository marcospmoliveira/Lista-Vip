package br.com.marcos.ListaVip.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.marcos.ListaVip.model.Convidado;
import br.com.marcos.ListaVip.repository.ConvidadoRepository;

@Service
public class ConvidadoService {

	@Autowired
	private ConvidadoRepository repository;
	
	public Iterable<Convidado> ObterTodos(){
		
		Iterable<Convidado> convidados = repository.findAll();
		return convidados;
	}
	
	public void Salvar(Convidado convidado) {
		repository.save(convidado);
	}
}
