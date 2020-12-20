package br.com.mobitbrasil.interview.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Data
@Entity
@Table(name = "agendas")
public class Agenda implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(name = "seq_agenda", sequenceName = "seq_agenda", allocationSize = 1)
    @GeneratedValue(generator = "seq_agenda", strategy =GenerationType.SEQUENCE)
    private Long id;

    @Column(length = 100)
    private String titulo;

    private String descricao;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "agenda_id")
    private List<Contato> contato;
}
