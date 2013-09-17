package br.exemplosxtream.testes;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.exemplosxtreams.modelo.Aluno;
import br.exemplosxtreams.modelo.Contato;
import br.exemplosxtreams.modelo.Curso;
import br.exemplosxtreams.modelo.Departamento;
import br.exemplosxtreams.modelo.Disciplina;
import br.exemplosxtreams.modelo.Filiacao;
import br.exemplosxtreams.modelo.Matricula;
import br.exemplosxtreams.modelo.Turma;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

/**
 * Servlet implementation class listaContato
 */
@WebServlet("/listaContato")
public class listaContato extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public listaContato() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		XStream xstream = new XStream(new DomDriver());
		xstream.alias("aluno", Aluno.class);//cria alias para a raiz xml
		xstream.alias("contatos", Contato.class);//cria alias para a raiz xml
		xstream.alias("disciplina", Disciplina.class);//cria alias para a raiz xml
		
		Aluno aluno = new Aluno();
		aluno.setNome("Alisson");
		aluno.setCpf("004410333-69");
		
		//Seta Filiacao
		Filiacao filiacao = new Filiacao();
		filiacao.setNomeDaMae("Maria de Desterro");
		filiacao.setNomeDoPai("Francisco Araújo");		
		aluno.setFiliacao(filiacao);//aluno recebe filiacao

		//seta contatos
		aluno.setContato(new Contato("Telefone", "99212842"));
		aluno.setContato(new Contato("Email", "alissonaraujo@gmail.com"));
		
		//matricula
		Matricula matricula = new Matricula();
		matricula.setCodigo("44002255");
		
		Curso curso = new Curso();
		curso.setNome("Sistema para internet");
		curso.setDescricao("Curso voltado para sistema que rodam na web");
			
		curso.setDisciplina(new Disciplina("004", "Programação para internet", new Departamento("DPCOM", "Departamento de Computação")));
		curso.setDisciplina(new Disciplina("003", "Banco de Dados Semi estruturados", new Departamento("DPDADOS", "Departamento de banco de dados")));
		
		Turma turma = new Turma();		
		turma.setCodigo("0001");
		turma.setDescricao("Turma 4 período");
		
		curso.setTurma(turma);//curso recebe a turma	
		matricula.setCurso(curso);//matricula recebe o curso
		aluno.setMatricula(matricula); //aluno recebe matricula
		
		response.setContentType("text/xml");//seta a tipo de saída do documento
		PrintWriter out = response.getWriter();		
        String alunoEmXML = xstream.toXML(aluno);
		out.println(alunoEmXML);

		
	}

}
