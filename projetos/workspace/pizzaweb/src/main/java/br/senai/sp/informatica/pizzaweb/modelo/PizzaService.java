package br.senai.sp.informatica.pizzaweb.modelo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PizzaService {
	@Autowired
	private PizzaRepo repo;
	
	public List<Pizza> getPizzas() {
		return repo.findAll();
	}
	
	public long quantidade() {
		return repo.count();
	}
	
	public Pizza getPizza(int id) {
		return repo.findById(id).orElse(null);
	}
}
