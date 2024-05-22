package br.com.unicuritiba.listatelefonica.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RestController;

import br.com.unicuritiba.listatelefonica.models.Telefone;
import br.com.unicuritiba.listatelefonica.repositories.TelefoneRepository;

@RestController
public class ListaTelefonicaApiController {
	
	@Autowired
	private TelefoneRepository repositorio;
	
	@GetMapping("/listaTelefones")
	public ResponseEntity<List<Telefone>> getTelefones() 
	{
		List<Telefone> telefones = repositorio.findAll();
		return ResponseEntity.ok (telefones);
	} 
	
   @PostMapping("/insereTelefone")
    public Telefone Post(@RequestBody Telefone telefone)
    {
        return repositorio.save(telefone);
    }
   
	@DeleteMapping("/remover/{id}")
	public ResponseEntity<Long> Delete(@PathVariable ("id") long id) 
	{
		repositorio.deleteById(id);	
		return ResponseEntity.ok (id);
	}
	
	 @PutMapping("/atualizar/{id}")
	 public ResponseEntity<Telefone> Put(@PathVariable("id") long id, @RequestBody Telefone telefoneAtualizado) 
	 {
		 
        Optional<Telefone> telefoneRepo = repositorio.findById(id);
        
        
        Telefone telefone = telefoneRepo.get();
        String nomeAtualizado = telefoneAtualizado.getNome();
        String sobrenomeAtualizado = telefoneAtualizado.getSobrenome();
        int numeroAtualizado = telefoneAtualizado.getNumero();
    	int dddAtualizado = telefoneAtualizado.getDdd();
    	
    	
    	if (ValidaAlteracao(nomeAtualizado)) {
    		telefone.setNome(nomeAtualizado);
    	};
    	
    	if (ValidaAlteracao(sobrenomeAtualizado)) {
    		telefone.setSobrenome(sobrenomeAtualizado);
    	};
    	
    	if (ValidaAlteracao(String.valueOf(numeroAtualizado))) {
    		telefone.setNumero(numeroAtualizado);
    	};
    	
    	if (ValidaAlteracao(String.valueOf(numeroAtualizado))) {
    		telefone.setDdd(dddAtualizado);
    	};
    	
    	repositorio.save(telefone);
    	return new ResponseEntity<Telefone>(telefone, HttpStatus.OK);
	 }
	 
	 public boolean ValidaAlteracao(String parametro) {
	 if (parametro != null && !parametro.isEmpty()){
		 return true;
	 }
		 return false;		 		 
	 }
	 
}

