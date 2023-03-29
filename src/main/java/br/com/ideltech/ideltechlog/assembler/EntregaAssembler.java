package br.com.ideltech.ideltechlog.assembler;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import br.com.ideltech.ideltechlog.dto.EntregaDTO;
import br.com.ideltech.ideltechlog.dto.input.EntregaInput;
import br.com.ideltech.ideltechlog.entity.Entrega;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Component
public class EntregaAssembler {

	private ModelMapper modelMapper;
	
	public EntregaDTO toModel(Entrega entrega) {
		
		return modelMapper.map(entrega, EntregaDTO.class);
		
	}
	
	public List<EntregaDTO> toCollectionModel(List<Entrega> entregas) {
		
		return entregas.stream().map(this::toModel).collect(Collectors.toList());
		
	}
	
	public Entrega toEntity(EntregaInput entregaInput) {
		
		return modelMapper.map(entregaInput, Entrega.class);
	
	}
	
}
