package br.com.softblue.bluefood.domain.usuario;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import br.com.softblue.bluefood.util.StringUtils;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@MappedSuperclass
@SuppressWarnings("serial")
public class Usuario implements Serializable{

	@NotBlank(message = "O nome não pode ser vázio!")
	@Size(max = 80, message = "O nome é muito grande!")
	public String nome;
	
	@Size(max = 80, message = "O e-mail é muito grande!")
	@Email(message = "O formato do e-mail está incorreto!")
	public String email;
	
	@NotBlank(message = "O telefone não pode ser vazio!")
	//@Pattern(regexp = "[0-9] {11}", message ="O telefone possui formato errado!")
	@Column(length=11,nullable=false)
	@Size(max = 11, message = "O número de telefone é muito grande")
	public String telefone;
	
	@Column(nullable=false)
	@NotBlank(message = "A senha não pode ser vazia!")
	@Size(max=80, message = "A senha é muito grande!")
	public String senha;
	
	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer id;
	
	
	public void encryptPassword()
	{
		this.senha = StringUtils.encrypt(this.senha);
	}
	
	
}
