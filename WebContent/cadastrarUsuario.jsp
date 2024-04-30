<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Página de Cadastro</title>
</head>
<body>

	<div align="center" style="margin-top: 100px;">

		<form action="ServletSalvarUsuario" method="post">

			<table border="1" cellpadding="5">
				<caption>
					<h2>Cadastrar Usuário</h2>
				</caption>

				<tr>
					<th>Nome:</th>
					<td><input type="text" id="nome" name="nome" size="45"
						 /></td>
				</tr>
				<tr>
					<th>Email:</th>
					<td><input type="email" id="email" name="email"
						size="45"  /></td>
				</tr>
				<tr>
					<th>Senha:</th>
					<td><input type="password" 
						id="senha" name="senha" size="45"  /></td>
				</tr>
				<tr>
					<th>Repita Senha:</th>
					<td><input type="password" 
						id="senha2" name="senha2" size="45"  /></td>
				</tr>
				<tr>
					<td colspan="2" align="center"><input type="submit"
						value="Cadastrar" /></td>
				</tr>

			</table>

		</form>
	</div>

   <div style="margin-top: 20px;"><a href="index.jsp" style="margin-left: 900px;">já tem uma conta?</a></div>
  <h3>${msg }</h3>
</body>
</html>