package br.com.mobitbrasil.interview.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import java.io.Serializable;

@Data
@Entity
@Table(name = "contatos")
public class Contato  implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(name = "seq_contato", sequenceName = "seq_contato", allocationSize = 1)
    @GeneratedValue(generator = "seq_contato", strategy =GenerationType.SEQUENCE)
    private Long id;

    @Column(length = 100)
    private String nome;

    @Max(value = 11, message = "Tamanho maximo 11 números")
    @Column(precision = 11)
    private Long numero;

    @Email
    private String email;

    @ManyToOne(fetch = FetchType.LAZY)
    private Agenda agenda;
}
