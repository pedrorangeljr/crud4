package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import conexao.SingleConnection;
import model.ModelLogin;

public class DaoLogin {

	private Connection connection;
	
	public DaoLogin() {
		
		connection = SingleConnection.getConnection();
	}
	
	/*Metodo gravar Usuario*/
	
	public void salvarUsuarios(ModelLogin modelLogin) {
		
		try {
			
			String sql = "insert into \"modelLogin\"(nome,email,senha)values(?,?,?)";
			PreparedStatement insert = connection.prepareStatement(sql);
			
			insert.setString(1, modelLogin.getNome());
			insert.setString(2, modelLogin.getEmail());
			insert.setString(3, modelLogin.getSenha());
			insert.execute();
			
			connection.commit();
			
		} catch (Exception e) {
			
			try {
				
				connection.rollback();
				
			} catch (SQLException e1) {


				e1.printStackTrace();
			}
			
			e.printStackTrace();
		}
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
