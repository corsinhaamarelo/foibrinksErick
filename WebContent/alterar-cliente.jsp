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
	<form action="alterarCliente">
		<%
			SimpleDateFormat dataformatada = new SimpleDateFormat("dd/MM/yyyy");
			ClienteDao dao = new ClienteDao();
			String id = request.getParameter("id");
			Cliente cliente = dao.getClienteById(id);
		%>

		<fieldset>
			<legend>Alterar Dados do Cliente</legend>
			<p>
				ID: <input type="text" name="codCliente"
					value="<%=cliente.getCod_Cliente()%>" />
			</p>
			<p>
				Nome Completo: <input type="text" name="nome_Cliente"
					value="<%=cliente.getNome_Cliente()%>" />
			</p>
			<p>
				Estado Civil: <input type="text" name="estado_Civil"
					value="<%=cliente.getEstado_Civil()%>" />
			</p>
			<p>
				Genero: <input type="text" name="genero"
					value="<%=cliente.getGenero()%>" />
			</p>
			<p>
				Rua: <input type="text" name="rua" value="<%=cliente.getRua()%>" />
			</p>
			<p>
				Bairro: <input type="text" name="bairro"
					value="<%=cliente.getBairro()%>" />
			</p>
			<p>
				CEP: <input type="text" name="cep" value="<%=cliente.getCep()%>" />
			</p>
			<p>
				Estado: <input type="text" name="estado"
					value="<%=cliente.getEstado()%>" />
			</p>
			<p>
				Cidade: <input type="text" name="cidade"
					value="<%=cliente.getCidade()%>" />
			</p>
			<p>
				CPF: <input type="text" name="cpf" value="<%=cliente.getCpf()%>" />
			</p>
			<p>
				Data Nascimento: <input type="text" name="dataNascimento"
					value="<%=dataformatada.format(cliente.getDataNascimento().getTime())%>" />
			</p>
			<p>
				<input type="submit" value="Alterar" />
			</p>
		</fieldset>
	</form>


</body>
</html>