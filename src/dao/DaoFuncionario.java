package dao;

import java.sql.Connection;

import conexao.SingleConnection;

/*Classe responsavel pelas operações no banco de dados*/
public class DaoFuncionario {

	private Connection connection;
	
	public DaoFuncionario() {
		
		connection = SingleConnection.getConnection();
	}
	
	
}
