package dao;

import java.sql.Connection;

import conexao.SingleConnection;

/*Classe responsavel pelas opera��es no banco de dados*/
public class DaoFuncionario {

	private Connection connection;
	
	public DaoFuncionario() {
		
		connection = SingleConnection.getConnection();
	}
	
	
}
