package br.com.ideltech.ideltechlog.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DestinatarioDTO {

	private String nome;
	private String logradouro;
	private String numero;
	private String complemento;
	private String bairro;
	
}
