package com.unifacisa.SpringTest.entities;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("ALN")
public class Aluno extends Pessoa {

	public Aluno(String nome, String senha) {
		super(nome, senha);


	}

	public Aluno() {

	}
	}
