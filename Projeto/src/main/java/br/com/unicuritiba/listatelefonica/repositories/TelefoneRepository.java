package br.com.unicuritiba.listatelefonica.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.unicuritiba.listatelefonica.models.Telefone;

public interface TelefoneRepository extends JpaRepository<Telefone, Long>{

}
