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
			<td>Nome Completo</td>
			<td>Estado Civil</td>
			<td>Gênero</td>
			<td>Rua</td>
			<td>Bairro</td>
			<td>CEP</td>
			<td>Estado</td>
			<td>Cidade</td>
			<td>CPF</td>
			<td>Data de Nascimento</td>
			<td>Remover</td>
			<td>Alterar</td>
		</tr>
		<%
			SimpleDateFormat dataNascimento = new SimpleDateFormat("dd/MM/yyyy");
			ClienteDao dao = new ClienteDao();
			List<Cliente> clientes = dao.listar();
			for (Cliente c : clientes ) {
		%>
		<tr>
			<td><%=c.getCod_Cliente()%></td>
			<td><%=c.getNome_Cliente()%></td>
			<td><%=c.getEstado_Civil()%></td>
			<td><%=c.getGenero()%></td>
			<td><%=c.getRua()%></td>
			<td><%=c.getBairro()%></td>
			<td><%=c.getCep()%></td>
			<td><%=c.getEstado()%></td>
			<td><%=c.getCidade()%></td>
			<td><%=c.getCpf()%></td>
			<td><%=dataNascimento.format(c.getDataNascimento().getTime()) %></td>
			<td><a href="remove-cliente.jsp?id=<%=c.getCod_Cliente()%>"> Remover </a></td>
			<td><a href="alterar-cliente.jsp?id=<%=c.getCod_Cliente()%>"> Alterar </a></td>
		</tr>
		<% 
			}
		%>
	</table>
</body>
</html>