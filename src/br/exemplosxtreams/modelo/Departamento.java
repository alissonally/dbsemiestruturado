package br.exemplosxtreams.modelo;

public class Departamento {
	private String codigo, nome;

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public Departamento() {	
	}

	public Departamento(String codigo, String nome) {
		super();
		this.codigo = codigo;
		this.nome = nome;
	}
	
	

}
