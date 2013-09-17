package br.exemplosxtream.testes;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

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
import br.exemplosxtreams.modelo.Disciplinas;
import br.exemplosxtreams.modelo.Filiacao;
import br.exemplosxtreams.modelo.Matricula;

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
		
		Aluno aluno = new Aluno();
		aluno.setNome("Alisson Araújo");
		aluno.setCpf("00441033369");
		
		Filiacao filiacao = new Filiacao();
		filiacao.setMae("Maria do Desterro");
		filiacao.setPai("Francisco Araujo");
		
		aluno.setFiliacao(filiacao);
		
		
		List<Contato> lista = new ArrayList<Contato>();
		
		Contato contato = new Contato();

		lista.add(contato.setTipoDeContato("telefone"));
		lista.add(contato.setContato("8999993232"));
		lista.add(contato.setTipoDeContato("Email"));
		lista.add(contato.setContato("alisson@alisson.com"));
		aluno.setContato(lista);
	
		Departamento dep = new Departamento();
		dep.setCodigo("dep001");
		dep.setNome("CCHL");
		
		
		Disciplina disciplina = new Disciplina();
		disciplina.setCodigo("dis001");
		disciplina.setNome("Ingles");
		disciplina.setCodigo("dis002");
		disciplina.setNome("Matematica");
		disciplina.setDepartamento(dep);
		
		Disciplinas disciplinas = new Disciplinas();
		disciplinas.setDisciplina(disciplina);
		
		
		Curso curso = new Curso();
		curso.setNome("Sistema para internet");
		curso.setDescricao("Curso voltado para sistema que rodam na web");
		curso.setDisciplinas(disciplinas);
		

		
		Matricula matricula = new Matricula();
		matricula.setCodigo("001");
		matricula.setCurso(curso);
		aluno.setMatricula(matricula);
		
		
		PrintWriter out = response.getWriter();
		
       String alunoEmXML = xstream.toXML(aluno);
		
		
		out.println(alunoEmXML);
		

		
		
	}

}
