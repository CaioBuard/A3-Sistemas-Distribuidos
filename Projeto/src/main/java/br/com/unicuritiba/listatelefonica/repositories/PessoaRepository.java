package br.com.unicuritiba.listatelefonica.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.unicuritiba.listatelefonica.models.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Long>{

}
