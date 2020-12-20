package br.com.mobitbrasil.interview.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.io.Serializable;
import java.util.List;

@Data
@Entity
@Table(name = "contatos")
public class Contato implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(name = "seq_contato", sequenceName = "seq_contato", allocationSize = 1)
    @GeneratedValue(generator = "seq_contato", strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(length = 100)
    private String nome;

    @Column(length = 100)
    private String sobreNome;
    
    @Column(length = 11)
    private String cpf;
    
    @Email
    @Column(length = 100)
    private String email;
    
    private Endereco endereco;

    @ManyToOne(fetch = FetchType.LAZY)
    private Agenda agenda;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "catato_id")
    private List<Telefone> telefones;
}
