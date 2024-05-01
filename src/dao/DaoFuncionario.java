package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
	
	/*Metodo Listar todos */
	public List<ModelFuncionario> listar() throws Exception{
		
		List<ModelFuncionario> listar = new ArrayList<ModelFuncionario>();
		
		String sql = "select * from \"funcionario\" order by id asc";
		PreparedStatement select = connection.prepareStatement(sql);
		ResultSet resultado = select.executeQuery();
		
		while(resultado.next()) {
			
			ModelFuncionario funcionario = new ModelFuncionario();
			
			funcionario.setId(resultado.getLong("id"));
			funcionario.setNome(resultado.getString("nome"));
			funcionario.setMatricula(resultado.getInt("matricula"));
			funcionario.setProfissao(resultado.getString("profissao"));
			
			listar.add(funcionario);
		}
		
		return listar;
	}
}
