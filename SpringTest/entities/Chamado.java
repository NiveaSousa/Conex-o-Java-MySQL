package com.unifacisa.SpringTest.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Chamado {
	@ManyToOne
	private Pessoa criador;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codigo;
    private String conteudo;
    
    public Chamado(){
        
    }
    
    public Chamado(Pessoa criador, String conteudo){
    	this.criador = criador;
        this.conteudo = conteudo;
    }

    public Pessoa getCriador() {
		return criador;
	}

	public void setCriador(Pessoa criador) {
		this.criador = criador;
	}   
	
	public int getCodigo() {
        return codigo;
    }


	public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    
    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }    
    
    @Override 
    public String toString() {
        String retorno = "Conteúdo: " + this.conteudo + "| Id : " + this.codigo + "| Criador : " + this.criador;
        return retorno;
    }
}

