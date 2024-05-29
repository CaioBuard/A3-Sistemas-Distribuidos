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

import br.com.unicuritiba.listatelefonica.models.Pessoa;
import br.com.unicuritiba.listatelefonica.models.Telefone;
import br.com.unicuritiba.listatelefonica.repositories.PessoaRepository;
import br.com.unicuritiba.listatelefonica.repositories.TelefoneRepository;

@CrossOrigin(origins = "*")
@RestController
public class PessoaApiController {
	@Autowired
	private PessoaRepository repositorio;
	
	@GetMapping("/pessoas")
	public ResponseEntity<List<Pessoa>> getPessoas() 
	{
		List<Pessoa> pessoas= repositorio.findAll();
		return ResponseEntity.ok (pessoas);
	} 
	
	@GetMapping("/pessoa/{id}")
	public ResponseEntity<Optional<Pessoa>> getPessoa(@PathVariable ("id") long id) 
	{
		Optional<Pessoa> pessoa = repositorio.findById(id);
		return ResponseEntity.ok (pessoa);
	} 
	
    @PostMapping("/pessoa")
    public Pessoa postPessoa(@RequestBody Pessoa pessoa)
    {
        return repositorio.save(pessoa);
    }
   
	@DeleteMapping("/pessoa/{id}")
	public ResponseEntity<Long> deletePessoa(@PathVariable ("id") long id) 
	{
		repositorio.deleteById(id);	
		return ResponseEntity.ok (id);
	}
	
		
	 @PutMapping("/pessoa/{id}")
	 public ResponseEntity<Pessoa> putPessoa(@PathVariable("id") long id, @RequestBody Pessoa pessoaAtualizado) 
	 { 
        Optional<Pessoa> optionalPessoa = repositorio.findById(id);
        Pessoa pessoa = optionalPessoa.get();
        
        String nome = pessoaAtualizado.getNome();
        String cpfOuCnpj = pessoaAtualizado.getCpfOuCnpj();
        
    	if (ValidaAlteracao(String.valueOf(nome))) {
    		pessoa.setNome(nome);
    	};
    	
    	if (ValidaAlteracao(String.valueOf(cpfOuCnpj))) {
    		pessoa.setCpfOuCnpj(cpfOuCnpj);
    	};
    	
    	repositorio.save(pessoa);
    	return new ResponseEntity<Pessoa>(pessoa, HttpStatus.OK);
	 }
	 
	 public boolean ValidaAlteracao(String parametro) {
	 if (parametro != null && !parametro.isEmpty()){
		 return true;
	 }
		 return false;		 		 
	 }
	
}

