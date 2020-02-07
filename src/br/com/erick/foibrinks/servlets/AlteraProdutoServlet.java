/**
 * 
 */
package br.com.erick.foibrinks.servlets;

import java.io.IOException;
import java.util.Calendar;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.erick.foibrinks.bancodedados.ProdutoDao;
import br.com.erick.foibrinks.entidades.Produto;

/**
 * @author erick
 *
 */
@WebServlet("/alterarProduto")
public class AlteraProdutoServlet extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		Long codProduto = Long.parseLong(request.getParameter("codProduto"));
		String nomeProduto = request.getParameter("nomeProduto");
		String marcaProduto = request.getParameter("marcaProduto");
		String faixaEtaria = request.getParameter("faixaEtaria");
		Double alturaProduto = Double.parseDouble(request.getParameter("alturaProduto"));
		Double profundidadeProduto = Double.parseDouble(request.getParameter("profundidadeProduto"));
		Double larguraProduto = Double.parseDouble(request.getParameter("larguraProduto"));
		Double pesoProduto = Double.parseDouble(request.getParameter("pesoProduto"));
		Double precoProduto = Double.parseDouble(request.getParameter("precoProduto"));
		Calendar dataCadastro = Calendar.getInstance();

		Produto produto = new Produto();
		produto.setCodProduto(codProduto);
		produto.setNomeProduto(nomeProduto);
		produto.setMarcaProduto(marcaProduto);
		produto.setFaixaEtaria(faixaEtaria);
		produto.setAlturaProduto(alturaProduto);
		produto.setProfundidadeProduto(profundidadeProduto);
		produto.setLarguraProduto(larguraProduto);
		produto.setPesoProduto(pesoProduto);
		produto.setPrecoProduto(precoProduto);
		produto.setDataCadastro(dataCadastro);

		ProdutoDao dao = new ProdutoDao();
		dao.alteraProduto(produto);

		RequestDispatcher rd = request.getRequestDispatcher("listar-produtos.jsp");
		rd.forward(request, response);
	}
}