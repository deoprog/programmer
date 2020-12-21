package br.com.mobitbrasil.interview.domains;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Getter
@Setter
public class AgendaDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    @NotEmpty(message = "Titulo vazio")
    @NotNull(message = "O titulo deve ser informado")
    private String titulo;
}
