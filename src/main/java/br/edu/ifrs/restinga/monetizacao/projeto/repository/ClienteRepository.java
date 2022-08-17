package br.edu.ifrs.restinga.monetizacao.projeto.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.ifrs.restinga.monetizacao.projeto.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    
    
}
