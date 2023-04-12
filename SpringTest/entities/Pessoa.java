package com.unifacisa.SpringTest.entities;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.DiscriminatorType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
@DiscriminatorColumn(discriminatorType = DiscriminatorType.STRING, name = "tipo", length = 5)
public abstract class Pessoa{
	
	@Id
	private String email;

	private String senha;
	
	@Column(name = "tipo", insertable = false, updatable = false)
	private String tipo;
	

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Pessoa() {
		
	}
	
	public Pessoa(String email, String senha) {
		super();
		this.email = email;
		this.senha = senha;	
	}


	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha= senha;
	}

	@Override
	public String toString() {
		return "Pessoa [email=" + email + ", senha=" + senha + "]";
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
