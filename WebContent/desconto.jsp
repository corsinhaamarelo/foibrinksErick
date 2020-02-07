	<%@page import="java.text.DecimalFormat"%>
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
			<td>Nome Produto</td>
			<td>Preço</td>
			<td>PrecoComDesconto</td>
		</tr>
		<%
			SimpleDateFormat dataCadastro = new SimpleDateFormat("dd/MM/yyyy");
			DecimalFormat decimal = new DecimalFormat("0.00");
			ProdutoDao dao = new ProdutoDao();
			List <Produto> produtos = dao.listaDesconto();
			for (Produto p : produtos ) {
		%>
		<tr>
			<td><%=p.getNomeProduto()%></td>
			<td><%=p.getPrecoProduto() %></td>
			<td><%=decimal.format(p.getPrecoComDesconto())%></td>
		</tr>
		<%
			}
		%>
	</table>
</body>
</html>