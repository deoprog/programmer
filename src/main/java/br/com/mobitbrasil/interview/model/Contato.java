package br.com.mobitbrasil.interview.model;

import br.com.mobitbrasil.interview.json.JsonHelper;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Data;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

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
    @Expose(serialize = false)
    private Long id;

    @Column(length = 100)
    private String nome;

    @SerializedName("sobrenome")
    @Column(name = "sobrenome", length = 100)
    private String sobreNome;
    
    @Column(length = 11)
    private String cpf;
    
    @Email
    @Column(length = 100)
    private String email;

    @Embedded
    @AttributeOverrides(value = {
            @AttributeOverride(name = "logradouro", column = @Column(name = "end_logradouro")),
            @AttributeOverride(name = "bairro", column = @Column(name = "end_bairro")),
            @AttributeOverride(name = "cep", column = @Column(name = "end_cep")),
            @AttributeOverride(name = "cidade", column = @Column(name = "end_cidade")),
            @AttributeOverride(name = "uf", column = @Column(name = "end_uf")),
    })
    private Endereco endereco;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "contato_id")
    @Fetch(FetchMode.JOIN)
    private List<Telefone> telefones;

    @Override
    public String toString() {
        return JsonHelper.gson.toJson(this);
    }
}
