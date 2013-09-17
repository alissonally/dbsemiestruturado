package br.exemplosxtreams.modelo;

import java.util.ArrayList;
import java.util.List;

public class Curso {
	private String nome, descricao;
	private Turma turma;
	@SuppressWarnings("rawtypes")
	private List disciplinas = new ArrayList();

	
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Turma getTurma() {
		return turma;
	}

	public void setTurma(Turma turma) {
		this.turma = turma;
	}
	
	@SuppressWarnings("unchecked")
	public void setDisciplina(Disciplina disciplina){
		disciplinas.add(disciplina);
	}
	
	@SuppressWarnings("rawtypes")
	public List getDisciplina(){
		return this.disciplinas;
	}
	
	
}
