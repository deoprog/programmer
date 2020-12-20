package br.com.mobitbrasil.interview.model;

import javax.persistence.Entity;
import javax.persistence.Table;

import br.com.mobitbrasil.interview.enums.Uf;

@Entity
@Table(name = "endereco")
public class Endereco {

	private String logradouro;
	
	private String bairro;
	
	private Uf uf;
	
	private String cidade;
	
	private String cep;
	
}
