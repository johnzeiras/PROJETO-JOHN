package br.edu.ifrs.restinga.monetizacao.projeto.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifrs.restinga.monetizacao.projeto.model.Cliente;
import br.edu.ifrs.restinga.monetizacao.projeto.repository.ClienteRepository;


@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public Cliente salvarCliente(Cliente cliente){
        return clienteRepository.save(cliente);
    }

    public List<Cliente> listarCliente(){
        return clienteRepository.findAll();
    }

    public Optional<Cliente> pesquisarCliente(Long id){
        return clienteRepository.findById(id);
    }

    public void excluirPorId(Long id){
        clienteRepository.deleteById(id);
    }
}
