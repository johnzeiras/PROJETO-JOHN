package br.edu.ifrs.restinga.monetizacao.projeto.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifrs.restinga.monetizacao.projeto.model.Produto;
import br.edu.ifrs.restinga.monetizacao.projeto.repository.ProdutoRepository;

@Service
public class ProdutoService {
    
    @Autowired
    private ProdutoRepository produtoRepository;

    public Produto salvarProduto(Produto produto){
        return produtoRepository.save(produto);
    }

    public List<Produto> listarProduto(){
        return produtoRepository.findAll();
    }

    public Optional<Produto> pesquisarProduto(Long id){
        return produtoRepository.findById(id);
    }

    public void removerProduto(Long id){
        produtoRepository.deleteById(id);
    }
}
