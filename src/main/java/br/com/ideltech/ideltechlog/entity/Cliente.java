package br.com.ideltech.ideltechlog.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_clientes")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Include
	private Long id;
	
	@NotEmpty(message = "Preencha o campo 'Nome' corretamente.")
	@NotNull(message = "Preencha o 'Nome' corretamente.")
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
