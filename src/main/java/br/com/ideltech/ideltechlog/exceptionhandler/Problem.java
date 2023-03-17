package br.com.ideltech.ideltechlog.exceptionhandler;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@JsonInclude(Include.NON_NULL)
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Problem {

	private Integer status;
	private LocalDateTime dataHora;
	private String titulo;
	private List<Campo> campos;
	
	
	@Getter
	@AllArgsConstructor
	public static class Campo {

		private String nome;
		private String messagem;
	
	}
	
}
