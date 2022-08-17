package br.edu.ifrs.restinga.monetizacao.projeto.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity

public class Produto implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "nomeProduto", nullable = false)
    private String nomeProduto;

    @Column(name = "codigoProduto", nullable = false)
    private String codigoProduto;
    
    @Column(name = "valorProduto", nullable = false)
    private Double valorProduto;

    @ManyToOne
    private Cliente cliente;
    
    @ManyToMany
    @JoinTable(name= "VENDAS")
    @JoinColumns({@JoinColumn(name = "codigo_Produto", referencedColumnName = "codigoProduto"),
    @JoinColumn(name = "cpfCliente", referencedColumnName = "cpf")})
    private List<Venda> venda;
    
}
