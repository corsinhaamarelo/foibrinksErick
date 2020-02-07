<%@page import="java.text.SimpleDateFormat"%>
<%@page import="br.com.erick.foibrinks.entidades.*"%>
<%@page import="java.util.*"%>
<%@page import="br.com.erick.foibrinks.bancodedados.*"%>
<html>
<head>
<meta charset="utf-8">
</head>
<body>
	<table border=1>
		<tr>
			<td>Código</td>
			<td>Nome Produto</td>
			<td>Marca Produto</td>
			<td>Faixa Etária</td>
			<td>Altura do Produto</td>
			<td>Profundidade do Produto</td>
			<td>Peso Produto</td>
			<td>Largura</td>
			<td>Preço</td>
			<td>Data</td>
			<td>Remover</td>
			<td>Alterar</td>
		</tr>
		<%
			SimpleDateFormat dataCadastro = new SimpleDateFormat("dd/MM/yyyy");
			ProdutoDao dao = new ProdutoDao();
			List <Produto> produtos = dao.listar();
			for (Produto p : produtos ) {
		%>
		<tr>
			<td><%=p.getCodProduto()%></td>
			<td><%=p.getNomeProduto()%></td>
			<td><%=p.getMarcaProduto()%></td>
			<td><%=p.getFaixaEtaria()%></td>
			<td><%=p.getAlturaProduto()%></td>
			<td><%=p.getProfundidadeProduto()%></td>
			<td><%=p.getPesoProduto()%></td>
			<td><%=p.getLarguraProduto() %></td>
			<td><%=p.getPrecoProduto()%></td>
			<td><%=dataCadastro.format(p.getDataCadastro().getTime())%></td>
			<td><a href="remove-produto.jsp?id=<%=p.getCodProduto()%>">
					Remover </a></td>
			<td><a href="alterar-produto.jsp?id=<%=p.getCodProduto()%>">
					Alterar </a></td>
		</tr>
		<%
			}
		%>
	</table>
</body>
</html>