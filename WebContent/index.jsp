<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>crud jsp</title>
</head>
<body>

<div align="center" style="margin-top: 150px;">

		<form action="ServletLogin" method="post">
		
		   <input type="hidden" value="<%= request.getParameter("url") %>" name="url">

			<table border="1" cellpadding="5">

				<br/>
				
				<h2>Login Usuário Sistema JSP</h2>
				
				<br/>

				<tr>
					<th>Email:</th>
					<td><input type="email" name="email" id="email" size="45" required="required" /></td>
				</tr>
				<tr>
					<th>Senha:</th>
					<td><input type="password" name="senha" id="senha" size="45" /></td>
				</tr>
				<tr>
					<td colspan="2" align="center"><input type="submit"
						value="Logar" />
				</tr>
			</table>
		</form>
	</div>
    <div style="margin-top: 20px;"><a href="cadastrarUsuario.jsp" style="margin-left: 920px;">Cadastre-se</a></div>
    
     <h3>${msg }</h3>
</body>
</html>