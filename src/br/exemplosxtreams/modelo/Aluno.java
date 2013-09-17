package br.exemplosxtreams.modelo;

import java.util.ArrayList;
import java.util.List;

public class Aluno {
	private String nome;
	private String cpf;
	private Filiacao filiacao;
	@SuppressWarnings("rawtypes")
	private List contato = new ArrayList();
	private Matricula matricula;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public Filiacao getFiliacao() {
		return filiacao;
	}
	public void setFiliacao(Filiacao filiacao) {
		this.filiacao = filiacao;
	}
	
	@SuppressWarnings("unchecked")
	public void setContato(Contato contatos){
		contato.add(contatos);
	}
	
	@SuppressWarnings("rawtypes")
	public List getContato(){
		return this.contato;
	}
	public Matricula getMatricula() {
		return matricula;
	}
	public void setMatricula(Matricula matricula) {
		this.matricula = matricula;
	}
	
}
