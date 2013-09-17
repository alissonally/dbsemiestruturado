package br.exemplosxtreams.modelo;


public class Disciplina {
	@SuppressWarnings("unused")
	private String codigo, nome;
	private Departamento departamento;
	
	public Disciplina(){
		
	}
	
	public Disciplina(String codigo, String nome){
		this.codigo = codigo;
		this.nome = nome;
	}

	public Disciplina(String codigo, String nome, Departamento departamento) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.departamento = departamento;
	}
	
	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

	public Departamento getDepartamento() {
		return departamento;
	}	

}