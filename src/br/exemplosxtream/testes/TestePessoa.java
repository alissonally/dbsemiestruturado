package br.exemplosxtream.testes;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.exemplosxtreams.modelo.Endereco;
import br.exemplosxtreams.modelo.Pessoa;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

/**
 * Servlet implementation class TestePessoa
 */
@WebServlet("/TestePessoa")
public class TestePessoa extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
static void salvaArquivo(String xml)throws IOException {
		
		OutputStream os = new FileOutputStream("pessoa.xml");
		OutputStreamWriter osw = new OutputStreamWriter(os);
		BufferedWriter bw = new BufferedWriter(osw);
		bw.write(xml);
		bw.flush();
		bw.close();
		
	}
    public TestePessoa() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		XStream xstream = new XStream(new DomDriver());
		xstream.alias("pessoa", Pessoa.class);//cria alias para a raiz xml
		PrintWriter out = response.getWriter();
		
		Pessoa pessoa = new Pessoa();
		pessoa.setCpf("00441033369");
		pessoa.setNome("Alisson");
		pessoa.setRg("2124615");
		
		Endereco endereco = new Endereco();		
		endereco.setRua("Rua Crescencio ferreira");
		endereco.setBairro("Morada do Sol");
		endereco.setCidade("Teresina");
		endereco.setEstado("PI");
		endereco.setCep("64465-440");
		endereco.setNumero(3915);
		pessoa.setEndereco(endereco);
		String pessoaEmXML = xstream.toXML(pessoa);
		
		salvaArquivo(pessoaEmXML);
		
		out.println(pessoaEmXML);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}
	
	
}
