<%@page import="br.com.erick.foibrinks.bancodedados.ProdutoDao"%>
<%@page import="br.com.erick.foibrinks.entidades.Produto"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Remove Produto</title>
</head>
<body><%
Long id = Long.parseLong(request.getParameter("id"));
Produto produto = new Produto();
produto.setCodProduto(id);
ProdutoDao dao = new ProdutoDao();
dao.excluirProduto(produto);

RequestDispatcher rd = request.getRequestDispatcher("listar-produtos.jsp");
rd.forward(request, response);
%>

</body>
</html>