package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import conexao.SingleConnection;
import model.ModelFuncionario;

/*Classe responsavel pelas operações no banco de dados*/
public class DaoFuncionario {

	private Connection connection;
	
	public DaoFuncionario() {
		
		connection = SingleConnection.getConnection();
	}
	
	/*Medoto salvar usuario*/
	public void salvarFuncionario(ModelFuncionario funcionario) {
		
		try {
			
			String sql = "insert into \"funcionario\"(nome,matricula,profissao)values(?,?,?)";
			PreparedStatement insert = connection.prepareStatement(sql);
			
			insert.setString(1, funcionario.getNome());
			insert.setLong(2, funcionario.getMatricula());
			insert.setString(3, funcionario.getProfissao());
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
}
