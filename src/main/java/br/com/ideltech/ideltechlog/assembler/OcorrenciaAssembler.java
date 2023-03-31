package br.com.ideltech.ideltechlog.assembler;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.ideltech.ideltechlog.dto.OcorrenciaDTO;
import br.com.ideltech.ideltechlog.entity.Ocorrencia;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Component
public class OcorrenciaAssembler {

	@Autowired
	private ModelMapper modelMapper;
	
	public OcorrenciaDTO toModel(Ocorrencia ocorrencia) {
		
		return modelMapper.map(ocorrencia, OcorrenciaDTO.class);
		
	}
	
	public List<OcorrenciaDTO> toCollectionDTO(List<Ocorrencia> ocorrencias) {
		
		return ocorrencias.stream().map(this::toModel).collect(Collectors.toList());
	}
	
}
