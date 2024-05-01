package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DaoFuncionario;
import model.ModelFuncionario;

/**
 * Servlet implementation class ServletFuncionario
 */
@WebServlet("/ServletFuncionario")
public class ServletFuncionario extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private DaoFuncionario daoFuncionario = new DaoFuncionario();
   
    public ServletFuncionario() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			
			String acao = request.getParameter("acao");
			
			if(acao.equalsIgnoreCase("listarTodos")) {
				
				RequestDispatcher dispatcher = request.getRequestDispatcher("paginas/funcionario.jsp");
				request.setAttribute("funcionarios", daoFuncionario.listar());
				dispatcher.forward(request, response);
			}
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			
			String id = request.getParameter("id");
			String nome = request.getParameter("nome");
			String matricula = request.getParameter("matricula");
			String profissao = request.getParameter("profissao");
			
			ModelFuncionario funcionario = new ModelFuncionario();
			funcionario.setId(!id.isEmpty() ? Long.parseLong(id) : 0);
			funcionario.setNome(nome);
			funcionario.setMatricula(Integer.parseInt(matricula));
			funcionario.setProfissao(profissao);
			
			if(id == null || id.isEmpty()) {
				
				daoFuncionario.salvarFuncionario(funcionario);
			}
			
			request.setAttribute("msg", "Funcionario salvo com sucesso");
			RequestDispatcher dispatcher = request.getRequestDispatcher("paginas/funcionario.jsp");
			request.setAttribute("funcionarios", daoFuncionario.listar());
			dispatcher.forward(request, response);
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}

}
