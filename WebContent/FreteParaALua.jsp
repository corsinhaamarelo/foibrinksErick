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
			<td>Peso Produto</td>
			<td>Volume</td>
			<td>Preço Produto</td>
			<td>Frete Para A Lua</td>
		</tr>
		<%
			SimpleDateFormat dataCadastro = new SimpleDateFormat("dd/MM/yyyy");
			ProdutoDao dao = new ProdutoDao();
			List <Produto> produtos = dao.listar();
			for (Produto p : produtos ) {
		%>
		<tr>
			<td><%=p.getCodProduto()%></td>
			<td><%=p.getNomeProduto() %>
			<td><%=p.getPesoProduto()%></td>
			<td><%=p.getVolume()%></td>
			<%
			double valorFrete = 123456 * p.getPrecoProduto();
			%>
			<td><%=p.getPrecoProduto()%></td>
			<td><%=valorFrete%></td>
		</tr>
		<%
			}
		%>
	</table>
</body>
</html>