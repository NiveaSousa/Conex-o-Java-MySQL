package com.unifacisa.SpringTest.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unifacisa.SpringTest.entities.Admin;
import com.unifacisa.SpringTest.entities.Aluno;
import com.unifacisa.SpringTest.entities.Pessoa;
import com.unifacisa.SpringTest.repositories.PessoaRepository;

@Service
public class PessoaService {

	@Autowired
	PessoaRepository pessoaRepositorio;

	public String addPessoa(String email, String senha, boolean admin) {
		try {
			if(admin == true) {
				Admin adm = new Admin(email, senha);
				pessoaRepositorio.save(adm);
				return "Administrador Salvo";
			} else if(admin == false) {
				Aluno alun = new Aluno(email,senha);
				pessoaRepositorio.save(alun);
				return "Aluno Salvo";
			}
				
			
		} catch (Exception e) {
			System.out.println();
		}
		return "Error";
	}

	public boolean pessoaExiste(String email) {

		Optional<Pessoa> pessoa = pessoaRepositorio.findById(email);
		
		if (pessoa.isPresent()) {

			return true;
		}

		return false;
	}
	
	public boolean pessoaEAdmin(String email) {

			Pessoa pessoa = pessoaRepositorio.findById(email).get();
			if (pessoa.getTipo().equals("ADM")) {
				return true;
			} else {
				return false;
			}
		}
		

	public Pessoa pessoaCriadora(String email) {

		Pessoa pessoa = pessoaRepositorio.findById(email).get();

		return pessoa;

	}

}
