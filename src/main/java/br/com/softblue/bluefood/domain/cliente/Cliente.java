package br.com.softblue.bluefood.domain.cliente;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
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
@Table(name="cliente")
public class Cliente extends Usuario{

	@Column(nullable=false, length=11)
	@NotBlank(message="O CPF n�o pode ser vazio!")
	//@Pattern(regexp = "{11} [0,9]", message = "O CPF possu� formato inv�lido!") 
	public String CPF;
	
	
	@NotBlank(message= "O CEP n�o pode ser vazio!")
	//@Pattern(regexp = "[0-9] {8}", message = "O CEP possu� tamanho inv�lido!")
	@Column(nullable=false, length=11)
	public String CEP;
	

	
}
