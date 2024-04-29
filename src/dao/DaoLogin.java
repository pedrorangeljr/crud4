package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import conexao.SingleConnection;
import model.ModelLogin;

public class DaoLogin {

	private Connection connection;
	
	public DaoLogin() {
		
		connection = SingleConnection.getConnection();
	}
	
	/*Metodo que verifca usuario cadastrado no banco de dados*/
	
	public boolean validarAutenticacao(ModelLogin modelLogin) throws Exception {
		
		String sql = "select * from  \"modelLogin\" where upper(email) = upper(?) and upper(senha) = upper(?)";
		PreparedStatement select = connection.prepareStatement(sql);
		select.setString(1, modelLogin.getEmail());
		select.setString(2, modelLogin.getSenha());
		
		ResultSet resultado = select.executeQuery();
		
		if(resultado.next()) {
			
			return true;
		}
		
		return false;
	}
}
