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
<form action="adicionaCliente">
	
		<fieldset>
			<legend>Dados do Cliente</legend>
			<p>
				Nome Completo: <input type="text" name="nome_Cliente" />
			</p>
			<p>
				Estado Civil: <input type="text" name="estado_Civil" />
			</p>
			<p>
				Genero: <input type="text" name="genero" />
			</p>
			<p>
				Rua: <input type="text" name="rua" />
			</p>
			<p>
				Bairro: <input type="text" name="bairro" />
			</p>
			<p>
				CEP: <input type="text" name="cep" />
			</p>
			<p>
				Estado: <input type="text" name="estado" />
			</p>
			<p>
				Cidade: <input type="text" name="cidade" />
			</p>
			<p>
				CPF: <input type="text" name="cpf" />
			</p>
			<p>
				Data Nascimento: <input type="text" name="dataNascimento" />
			</p>
			<p>
				<input type="submit" value="Gravar" />
			</p>
		</fieldset>
	</form>


</body>
</html>