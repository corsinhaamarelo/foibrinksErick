<%@page import="br.com.erick.foibrinks.entidades.Produto"%>
<%@page import="br.com.erick.foibrinks.bancodedados.ProdutoDao"%>
<%@page import="br.com.erick.foibrinks.bancodedados.ClienteDao"%>
<%@page import="br.com.erick.foibrinks.entidades.Cliente"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta charset="UTF-8">
<title>Cadastro Clientes</title>
</head>
<body>
	<form action="alterarProduto">
		<%
			SimpleDateFormat dataformatada = new SimpleDateFormat("dd/MM/yyyy");
			ProdutoDao dao = new ProdutoDao();
			String id = request.getParameter("id");
			Produto produto = dao.getProdutoById(id);
		%>

		<fieldset>
			<legend>Alterar Dados do Produto</legend>
			<p>
				ID: <input type="text" name="codProduto"
					value="<%=produto.getCodProduto()%>" />
			</p>
			<p>
				Nome Produto: <input type="text" name="nomeProduto"
					value="<%=produto.getNomeProduto()%>" />
			</p>
			<p>
				Marca Produto: <input type="text" name="marcaProduto"
					value="<%=produto.getMarcaProduto()%>" />
			</p>
			<p>
				Faixa Étaria: <input type="text" name="faixaEtaria"
					value="<%=produto.getFaixaEtaria()%>" />
			</p>
			<p>
				Altura Produto: <input type="text" name="alturaProduto"
					value="<%=produto.getAlturaProduto()%>" />
			</p>
			<p>
				Profundidade do Produto: <input type="text"
					name="profundidadeProduto"
					value="<%=produto.getProfundidadeProduto()%>" />
			</p>
			<p>
				Largura do Produto: <input type="text" name="larguraProduto"
					value="<%=produto.getLarguraProduto()%>" />
			</p>
			<p>
				Preco do Produto: <input type="text" name="precoProduto"
					value="<%=produto.getPrecoProduto()%>" />
			</p>
			<p>
				Peso do Produto: <input type="text" name="pesoProduto"
					value="<%=produto.getPrecoProduto()%>" />
			</p>
			<p>
				<input type="submit" value="Alterar" />
			</p>

		</fieldset>
	</form>


</body>
</html>