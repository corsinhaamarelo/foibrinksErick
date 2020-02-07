<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta charset="UTF-8">
<title>Cadastro dos Produtos!</title>
</head>
<body>

	<form action="adicionaProduto">
		<fieldset>
			<legend>Dados do Produto</legend>
			<p>
				Nome Produto: <input type="text" name="nomeProduto" />
			</p>
			<p>
				Marca Produto: <input type="text" name="marcaProduto" />
			</p>
			<p>
				Faixa Etária: <input type="text" name="faixaEtaria" />
			</p>
			<p>
				Altura do Produto: <input type="text" name="alturaProduto" />
			</p>
			<p>
				Profundidade do Produto: <input type="text"
					name="profundidadeProduto" />
			</p>
			<p>
				Largura do Produto: <input type="text"
					name="larguraProduto" />
			</p>
			<p>
				Peso do Produto: <input type="text" name="pesoProduto" />
			</p>
			<p>
				Preço: <input type="text" name="precoProduto" />
			</p>
			<p>
				<input type="submit" value="Gravar" />
			</p>
		</fieldset>
	</form>

</body>
</html>