package br.exemplosxtreams.modelo;

public class Curso {
	private String nome;
	private String descricao;
	private Turma turma;
	private Disciplinas disciplinas;
	public Turma getTurma() {
		return turma;
	}
	public void setTurma(Turma turma) {
		this.turma = turma;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Disciplinas getDisciplinas() {
		return disciplinas;
	}
	public void setDisciplinas(Disciplinas disciplinas) {
		this.disciplinas = disciplinas;
	}
	
}
