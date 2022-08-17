package br.edu.ifrs.restinga.monetizacao.projeto.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.ifrs.restinga.monetizacao.projeto.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
    


}
