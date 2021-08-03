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

	@NotBlank(message = "O nome n�o pode ser v�zio!")
	@Size(max = 80, message = "O nome � muito grande!")
	public String nome;
	
	@Size(max = 80, message = "O e-mail � muito grande!")
	@Email(message = "O formato do e-mail est� incorreto!")
	public String email;
	
	@NotBlank(message = "O telefone n�o pode ser vazio!")
	//@Pattern(regexp = "[0-9] {11}", message ="O telefone possui formato errado!")
	@Column(length=11,nullable=false)
	@Size(max = 11, message = "O n�mero de telefone � muito grande")
	public String telefone;
	
	@Column(nullable=false)
	@NotBlank(message = "A senha n�o pode ser vazia!")
	@Size(max=80, message = "A senha � muito grande!")
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
