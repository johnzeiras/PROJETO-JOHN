package br.edu.ifrs.restinga.monetizacao.projeto.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.ifrs.restinga.monetizacao.projeto.model.Produto;
import br.edu.ifrs.restinga.monetizacao.projeto.model.Venda;


@Repository
@Transactional
public interface VendaRepository extends JpaRepository<Venda, Long> {
    


}
