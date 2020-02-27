package br.senai.sp.informatica.pizzaweb.controle;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.senai.sp.informatica.pizzaweb.modelo.Pizza;
import br.senai.sp.informatica.pizzaweb.modelo.PizzaService;

@RestController
@RequestMapping("/api")
public class PizzaControle {
	@Autowired
	private PizzaService servico;
	
	@RequestMapping(path="/lista", produces="application/json;charset=UTF-8")
	public ResponseEntity<List<Pizza>> listaPizza() {
		return ResponseEntity.ok(servico.getPizzas());
	}
	
	@RequestMapping("/quantas")
	public ResponseEntity<Long> quantidade() {
		return ResponseEntity.ok(servico.quantidade());
	}
	
	@RequestMapping("/pizza/{numero}")
	public ResponseEntity<Pizza> getPizza(@PathVariable("numero") int id) {
		return ResponseEntity.ok(servico.getPizza(id));
	}
}
