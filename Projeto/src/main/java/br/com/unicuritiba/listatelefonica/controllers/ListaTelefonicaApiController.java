package br.com.unicuritiba.listatelefonica.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RestController;

import br.com.unicuritiba.listatelefonica.models.Telefone;
import br.com.unicuritiba.listatelefonica.repositories.TelefoneRepository;

@CrossOrigin(origins = "*")
@RestController
public class ListaTelefonicaApiController {
	@Autowired
	private TelefoneRepository repositorio;
	
	@GetMapping("/telefones")
	public ResponseEntity<List<Telefone>> getTelefones() 
	{
		List<Telefone> telefones = repositorio.findAll();
		return ResponseEntity.ok (telefones);
	} 
	
	@GetMapping("/telefone/{id}")
	public ResponseEntity<Optional<Telefone>> getTelefone(@PathVariable ("id") long id) 
	{
		Optional<Telefone> telefone = repositorio.findById(id);
		return ResponseEntity.ok (telefone);
	} 
	
    @PostMapping("/telefone")
    public Telefone postTelefone(@RequestBody Telefone telefone)
    {
        return repositorio.save(telefone);
    }
   
	@DeleteMapping("/telefone/{id}")
	public ResponseEntity<Long> deleteTelefone(@PathVariable ("id") long id) 
	{
		repositorio.deleteById(id);	
		return ResponseEntity.ok (id);
	}
	
		
	 @PutMapping("/telefone/{id}")
	 public ResponseEntity<Telefone> putTelefone(@PathVariable("id") long id, @RequestBody Telefone telefoneAtualizado) 
	 {
        Optional<Telefone> telefoneRepo = repositorio.findById(id);
        
        Telefone telefone = telefoneRepo.get();
        String numeroAtualizado = telefoneAtualizado.getNumero();
    	String dddAtualizado = telefoneAtualizado.getDdd();
    	int idPessoaAtualizaco = telefoneAtualizado.getIdPessoa();
    	
    	if (ValidaAlteracao(String.valueOf(numeroAtualizado))) {
    		telefone.setNumero(numeroAtualizado);
    	};
    	
    	if (ValidaAlteracao(String.valueOf(dddAtualizado))) {
    		telefone.setDdd(dddAtualizado);
    	};
    	
    	if (ValidaAlteracao(String.valueOf(idPessoaAtualizaco))) {
    		telefone.setIdPessoa(idPessoaAtualizaco);
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

