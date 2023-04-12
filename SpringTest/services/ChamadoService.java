package com.unifacisa.SpringTest.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unifacisa.SpringTest.entities.Chamado;
import com.unifacisa.SpringTest.entities.Pessoa;
import com.unifacisa.SpringTest.repositories.ChamadoRepository;

@Service
public class ChamadoService {

	@Autowired
	ChamadoRepository chamadoRepositorio;

	public String addChamado(Pessoa criador, String conteudo) {
		try {
			Chamado c = new Chamado(criador, conteudo);
			chamadoRepositorio.save(c);
			return "Manifestação Salva";
		} catch (Exception e) {
			System.out.println();
		}
		return "Error";
	}

	public void listartodos() {

		ArrayList<Chamado> lista = (ArrayList<Chamado>) chamadoRepositorio.findAll();
		if (lista.isEmpty()) {
			System.out.println("Não existem chamados cadastrados");
		} else {
			for (Chamado chamado : lista) {
					System.out.println(chamado.toString());
				
			}
		}
	}

	public void listarApenasCriador(String criador) {

		ArrayList<Chamado> lista = (ArrayList<Chamado>) chamadoRepositorio.findAll();
		try {
			for (Chamado chamado : lista) {
				if (chamado.getCriador().getEmail().equals(criador)) {
					System.out.println(chamado.toString());
				}
			}
		} catch (Exception e) {
			System.out.println("Não existem chamados cadastrados");
		}
	}

	public void deletar(int id) {
		listartodos();
		ArrayList<Chamado> lista = (ArrayList<Chamado>) chamadoRepositorio.findAll();
		for (Chamado chamado : lista) {
			if (chamado.getCodigo() == id) {
				chamadoRepositorio.delete(chamado);
			}
			}

	}

}
