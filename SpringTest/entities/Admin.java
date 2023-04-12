package com.unifacisa.SpringTest.entities;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("ADM")
public class Admin extends Pessoa{	


	public Admin(String nome, String senha) {
		super(nome, senha);
		
	}
	
	public Admin() {
		
	}

}
