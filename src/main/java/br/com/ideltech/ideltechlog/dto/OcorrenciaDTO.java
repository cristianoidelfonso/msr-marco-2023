package br.com.ideltech.ideltechlog.dto;

import java.time.OffsetDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class OcorrenciaDTO {

	private Long id;
	
	private String descricao;
	
	private OffsetDateTime dataRegistro;
	
}
