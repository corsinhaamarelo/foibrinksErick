/**
 * 
 */
package br.com.erick.foibrinks.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.erick.foibrinks.bancodedados.ClienteDao;
import br.com.erick.foibrinks.entidades.Cliente;

/**
 * @author erick
 *
 */
@WebServlet("/adicionaCliente")
public class AdicionaClienteServlet extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		PrintWriter out = response.getWriter();
		String nome_Cliente = request.getParameter("nome_Cliente");
		String estado_Civil = request.getParameter("estado_Civil");
		String genero = request.getParameter("genero");
		String rua = request.getParameter("rua");
		String cep = request.getParameter("cep");
		String estado = request.getParameter("estado");
		String cidade = request.getParameter("cidade");
		String cpf = request.getParameter("cpf");
		String dataNascimentoEmTexto = request.getParameter("dataNascimento");
		Calendar dataCadastro = Calendar.getInstance();
		Calendar dataNascimento = null;
		try {
			Date data = new SimpleDateFormat("dd/MM/yyyy").parse(dataNascimentoEmTexto);
			dataNascimento = Calendar.getInstance();
			dataNascimento.setTime(data);
		} catch (java.text.ParseException e) {
			out.println("Erro na converso da data");
		}

		Cliente cliente = new Cliente();
		cliente.setNome_Cliente(nome_Cliente);
		cliente.setEstado_Civil(estado_Civil);
		cliente.setGenero(genero);
		cliente.setRua(rua);
		cliente.setCep(cep);
		cliente.setEstado(estado);
		cliente.setCidade(cidade);
		cliente.setEstado(estado);
		cliente.setCidade(cidade);
		cliente.setCpf(cpf);
		cliente.setDataCadastro(dataCadastro);
		cliente.setDataNascimento(dataNascimento);

		ClienteDao dao = new ClienteDao();
		dao.AdicionaCliente(cliente);

		RequestDispatcher rd = request.getRequestDispatcher("listar-clientes.jsp");
		rd.forward(request, response);
	}

}
