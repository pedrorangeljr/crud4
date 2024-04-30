<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cadastro de Funcionários</title>
</head>
<body>

	<center>
		<h1>Cadastro de Funcinários</h1>

	</center>
	<div align="center">

		<form action="<%=request.getContextPath()%>/ServletFuncionario" method="post">

			<table border="1" cellpadding="5">

				<input type="hidden" name="id"  />

				<tr>
					<th>ID:</th>
					<td><input type="text" name="id" id="id" placeholder="ID" readonly="readonly"
						size="45" value="" /></td>
				</tr>
				<tr>
					<th>Nome:</th>
					<td><input type="text" name="nome" size="45"
						value="" /></td>
				</tr>
				<tr>
					<th>Matricula:</th>
					<td><input type="text" name="matricula" size="45"
						value="" /></td>
				</tr>
				<tr>
					<th>Profissão:</th>
					<td><input type="text" name="profissao" size="45"
						value="" /></td>
				</tr>
				<tr>
					<td colspan="2" align="center"><input type="submit"
						value="Cadastrar" />
				</tr>
				
			</table>
		</form>
	</div>

	<br />
	<br />


</body>
</html>