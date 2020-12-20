package br.com.mobitbrasil.interview.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
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

    @OneToMany
    @JoinColumn(name = "contato_id")
    private List<String> telefone;

    @ManyToOne(fetch = FetchType.LAZY)
    private Agenda agenda;
}
