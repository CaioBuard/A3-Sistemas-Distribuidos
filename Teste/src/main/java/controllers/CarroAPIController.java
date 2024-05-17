package controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import Models.Carro;
import repositories.CarroRepository;

@RestController
public class CarroAPIController {
	
	@Autowired
	private CarroRepository repositorio;
	
	@GetMapping("/carros")
	public ResponseEntity<List<Carro>> getCarros() {
		List<Carro> carros = repositorio.findAll();
		 
		return ResponseEntity.ok (carros);
		// retorna uma responseEntity do tipo lista com a lista de carros do BD
		// .ok representa que a requisição deu certo
	} 
}
