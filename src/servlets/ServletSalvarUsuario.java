package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DaoLogin;
import model.ModelLogin;


@WebServlet("/ServletSalvarUsuario")
public class ServletSalvarUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	DaoLogin daoLogin = new DaoLogin();
   
    public ServletSalvarUsuario() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			
			String nome = request.getParameter("nome");
			String email = request.getParameter("email");
			String senha = request.getParameter("senha");
			String senha2 = request.getParameter("senha2");
			
			if(senha != null && !senha.isEmpty() && senha2 != null && !senha2.isEmpty()) {
				
				ModelLogin modelLogin = new ModelLogin();
				modelLogin.setNome(nome);
				modelLogin.setEmail(email);
				modelLogin.setSenha(senha);
				
				if(senha != senha2) {
					
					daoLogin.salvarUsuarios(modelLogin);
					
					request.setAttribute("msg", "Usuario salvo com sucesso");
					RequestDispatcher dispatcher = request.getRequestDispatcher("cadastrarUsuario.jsp");
					dispatcher.forward(request, response);
				}
				else {
					
					request.setAttribute("msg", "Senha Invalida, Preencha a senha corretamente");
					RequestDispatcher dispatcher = request.getRequestDispatcher("cadastrarUsuario.jsp");
					dispatcher.forward(request, response);
				}
			}
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}

}
