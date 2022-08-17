package br.edu.ifrs.restinga.monetizacao.projeto.controller;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import br.edu.ifrs.restinga.monetizacao.projeto.model.Cliente;
import br.edu.ifrs.restinga.monetizacao.projeto.model.Produto;
import br.edu.ifrs.restinga.monetizacao.projeto.model.Venda;
import br.edu.ifrs.restinga.monetizacao.projeto.service.ClienteService;
import br.edu.ifrs.restinga.monetizacao.projeto.service.ProdutoService;
import br.edu.ifrs.restinga.monetizacao.projeto.service.VendaService;

@RestController
@RequestMapping("/cliente")
public class ClienteController {
    
    @Autowired
    private ClienteService clienteService;
    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private ProdutoService produtoService;

    @Autowired
    private VendaService vendaService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Cliente salvar(@RequestBody Cliente cliente){
        return clienteService.salvarCliente(cliente);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Cliente> listaCliente(){
        return clienteService.listarCliente();
    }

    // @GetMapping("/{id}")
    // @ResponseStatus(HttpStatus.OK)
    // public Cliente buscarClientePorId(@PathVariable("id") Long id){
    //     return clienteService.pesquisarCliente(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    // }

    // @DeleteMapping("/{id}")
    // @ResponseStatus(HttpStatus.NO_CONTENT)
    // public void removerCliente(Long id){
    //     clienteService.pesquisarCliente(id)
    //         .map(cliente ->{
    //             clienteService.excluirPorId(cliente.getId());
    //             return Void.TYPE;
    //         }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado."));
    // }

    // @PutMapping("/{id}")
    // @ResponseStatus(HttpStatus.NO_CONTENT)
    // public void AtualizarCliente(@PathVariable("id") Long id, @RequestBody Cliente cliente){
    //     clienteService.pesquisarCliente(id)
    //     .map(clienteBase ->{
    //         modelMapper.map(cliente, clienteBase);
    //         return Void.TYPE;
    //     }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado."));
    // }

    // @RequestMapping(value = "/{cpf}", method = RequestMethod.POST)
    // public String compras(@PathVariable("cpf") long codigo, Produto produto) {
    //     Cliente cliente = clienteService.pesquisarCliente(codigo);
    //     produto.setCliente(cliente);
    //     produtoService.salvarProduto(produto);
    //     return "redirect:/{cpf}";
        
    // }

    //passei com o id o mesmo metodo de cima pois não consegui testar para ver qual funciona

    @RequestMapping(value = "/{id}", method = RequestMethod.POST)
    public String compras(@PathVariable("id") long id, Produto produto) {
        Cliente cliente = new Cliente();
        clienteService.pesquisarCliente(id);
        produto.setCliente(cliente);
        produtoService.salvarProduto(produto);
        return "redirect:/{id}";
        
    }

    @GetMapping("/inclui/{id_cliente}/{id_produto}")
    @ResponseBody
    public Produto registrarServico(@PathVariable ("id_cliente") Long id1, @PathVariable ("id_animal") int id2){
        List<Produto> produtos;
        Produto produto = new Produto();
        Cliente cliente = new Cliente();
        Venda venda = new Venda();
        
        cliente = clienteService.pesquisarCliente(id1);
        produtos = cliente.getProduto();

        for( int i=0; i < produtos.size(); i++ ){
            if(produtos.get(i).getId() == id2){
                produto = produtos.get(i);
                venda.setCliente(cliente);
                venda.setProduto(produto);
                vendaService.salvar(venda);
                return produto;
            }
        }
        return null;
    }
}
