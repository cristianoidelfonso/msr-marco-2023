package br.com.ideltech.ideltechlog.dto;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

import br.com.ideltech.ideltechlog.entity.StatusEntrega;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EntregaDTO {
	
	private Long id;
	private ClienteResumoModel cliente;
	private DestinatarioDTO destinatario;
	private BigDecimal taxa;
	private StatusEntrega status;
	private OffsetDateTime dataPedido;
	private OffsetDateTime dataFinalizacao;

}
