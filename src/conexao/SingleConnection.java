package conexao;
/* Classe de Conex�o com banco de dados*/
import java.sql.Connection;
import java.sql.DriverManager;

public class SingleConnection {
	
	private static String url = "jdbc:postgresql://localhost:5432/crud4?autoReconnect=true";
	private static String user = "postgres";
	private static String password = "admin";
	private static Connection connection = null;
	
	static {
		
		conectar();
	}
	
	public SingleConnection() {
		
		conectar();
	}
	
	private static void conectar() {
		
		try {
			
			if(connection == null) {
				
				Class.forName("org.postgresql.Driver");
				connection = DriverManager.getConnection(url, user, password);
				connection.setAutoCommit(false);
			}
			
		} catch (Exception e) {
			
			e.printStackTrace(); // imprime a pilha de erros
		}
	}
	
	public static Connection getConnection() {
		
		return connection;
	}
}
