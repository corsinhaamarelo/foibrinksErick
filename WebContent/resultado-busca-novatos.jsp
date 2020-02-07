<%@page import="java.text.SimpleDateFormat"%>
<%@page import="br.com.erick.foibrinks.entidades.*"%>
<%@page import="java.util.*"%>
<%@page import="br.com.erick.foibrinks.bancodedados.*"%>
<html>
<head>
<meta charset="utf-8">
</head>
<body>
<h1>Clientes Novatos</h1><br>
	<table border=1>
		<tr>
			<td>Código</td>
			<td>Nome Completo</td>
			<td>Data de Nascimento</td>
			<td>Data de Cadastro</td>
		</tr>
		<%
			SimpleDateFormat dataFormatada = new SimpleDateFormat("dd/MM/yyyy");
			ClienteDao dao = new ClienteDao();
			String mes = request.getParameter("mes_cadastro");
			String ano = request.getParameter("ano_cadastro");
			List<Cliente> clientes = dao.buscarNovatos(mes, ano);
			for (Cliente c : clientes ) {
		%>
		<tr>
			<td><%=c.getCod_Cliente()%></td>
			<td><%=c.getNome_Cliente()%></td>
			<td><%=dataFormatada.format(c.getDataNascimento().getTime()) %></td>
			<td><%=dataFormatada.format(c.getDataCadastro().getTime()) %></td>
		</tr>
		<% 
			}
		%>
	</table>
</body>
</html>