package br.edu.ifrs.restinga.monetizacao.projeto.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifrs.restinga.monetizacao.projeto.model.Venda;
import br.edu.ifrs.restinga.monetizacao.projeto.repository.VendaRepository;

@Service
public class VendaService {
    

    @Autowired
    private VendaRepository vendaRepository;

    public Venda salvar(Venda venda){
        return vendaRepository.save(venda);
    }

    public List<Venda> listarAnimais(){
        return vendaRepository.findAll();
    }

    public Venda buscarPorId(Long id){
        return vendaRepository.findById(id).get();
    }
    public Venda buscarAnimalPorId(Long id){
        return vendaRepository.findById(id).get();
    }

    // public void removerPorId(Long id){
    //     VendaRepository.deleteById(id);
    // }

    // public void removerObj(Venda venda){
    //     VendaRepository.delete(venda);
    // }
}
