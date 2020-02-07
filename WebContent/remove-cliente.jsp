<%@page import="br.com.erick.foibrinks.bancodedados.*"%>
<%@page import="br.com.erick.foibrinks.entidades.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Remove Cliente</title>
</head>
<body>
	<%
		Long id = Long.parseLong(request.getParameter("id"));
		Cliente cliente = new Cliente();
		cliente.setCod_Cliente(id);
		ClienteDao dao = new ClienteDao();
		dao.excluirCliente(cliente);
		
		RequestDispatcher rd = request.getRequestDispatcher("listar-clientes.jsp");
		rd.forward(request, response);
	%>
	
</body>
</html>