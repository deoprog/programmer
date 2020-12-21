package br.com.mobitbrasil.interview.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Max;
import java.io.Serializable;

@Data
@Entity
@Table(name = "telefones")
public class Telefone implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(name = "seq_telefones", sequenceName = "seq_telefones", allocationSize = 1)
    @GeneratedValue(generator = "seq_telefones", strategy =GenerationType.SEQUENCE)
    private Long id;

    @Max(value = 11, message = "Número maior que 11")
    @Column(precision = 11)
    private Long numero;
}
