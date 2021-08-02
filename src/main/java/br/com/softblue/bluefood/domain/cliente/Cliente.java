package br.com.softblue.bluefood.domain.cliente;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import br.com.softblue.bluefood.domain.usuario.Usuario;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;


@SuppressWarnings("serial")
@Entity
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper=true)
public class Cliente extends Usuario{

	@Column(nullable=false, length=11)
	@NotBlank(message="O CPF não pode ser vazio!")
	@Pattern(regexp = "{11} [0,9]", message = "O CPF possuí formato inválido!") 
	public String CPF;
	
	
	@NotBlank(message= "O CEP não pode ser vazio!")
	@Pattern(regexp = "[0-9] {8}", message = "O CEP possuí tamanho inválido!")
	@Column(nullable=false, length=11)
	public String CEP;
	
	//TODO Verificar o porque de o Pattern estar invalidando todo text inserido nos campos.
	

	
}
