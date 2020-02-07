<%@page import="java.text.SimpleDateFormat"%>
<%@page import="br.com.erick.foibrinks.entidades.*"%>
<%@page import="java.util.*"%>
<%@page import="br.com.erick.foibrinks.bancodedados.*"%>
<html>
<head>
<meta charset="utf-8">
</head>
<body>
<h1>Aniversariantes do Mês</h1><br>
	<table border=1>
		<tr>
			<td>Nome Completo</td>
			<td>Data de Nascimento</td>
		</tr>
		<%
			SimpleDateFormat dataNascimento = new SimpleDateFormat("dd/MM/yyyy");
			ClienteDao dao = new ClienteDao();
			String mes = request.getParameter("mes_nascimento");
			List<Cliente> clientes = dao.buscarAniversariantesDoMes(mes);
			for (Cliente c : clientes ) {
		%>
		<tr>
			<td><%=c.getNome_Cliente()%></td>
			<td><%=dataNascimento.format(c.getDataNascimento().getTime()) %></td>
		</tr>
		<% 
			}
		%>
	</table>
</body>
</html>