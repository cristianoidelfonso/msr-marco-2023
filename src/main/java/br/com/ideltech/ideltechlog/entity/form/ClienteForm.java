package br.com.ideltech.ideltechlog.entity.form;

import lombok.Data;
import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor 
public class ClienteForm {
	
	@NotEmpty(message = "Preencha o campo 'Nome' corretamente.")
	@NotNull(message = "Preencha o camnpo 'Nome' corretamente.")
	@NotBlank(message = "O 'Nome' não pode ser vazio.")
	@Size(min = 3, max = 64, message = "O 'Nome' precisa ter entre {min} e {max} caracteres.")
	@Column(name = "nome", nullable = false)
	private String nome;
	
	@NotNull(message = "")
	@NotBlank(message = "")
	@Size(max = 64)
	@Email
	@Column(name = "email", nullable = false, unique = true)
	private String email;
	
	@NotNull
	@NotBlank
	@Size(max = 16)
	@Column(name = "telefone", nullable = false)
	private String telefone;

}
