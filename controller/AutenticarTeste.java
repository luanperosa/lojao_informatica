package br.com.TIO_lojao_informatica.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.TIO_lojao_informatica.DAO.CadastroDAO;
import br.com.TIO_lojao_informatica.entidades.Cliente;

@WebServlet("/autenticarTeste.do")
public class AutenticarTeste extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public AutenticarTeste() {
        super();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Capturando dados da tela 
		String email = request.getParameter("txtemail");
		String senha = request.getParameter("txtsenha");
		
		//Constroi objeto Cliente para consulta
		Cliente cliente = new Cliente();
		cliente.setEmail(email);
		cliente.setSenha(senha);
		
		//busca no banco de dados
		CadastroDAO cadastroDAO = new CadastroDAO();
		
		Cliente clienteExiste = cadastroDAO.autenticarComSelect(cliente);
		
		if (clienteExiste != null){
			 //criando sessao
			HttpSession sessao = request.getSession();
			sessao.setMaxInactiveInterval(9000000);
			sessao.setAttribute("clienteLogado", clienteExiste);
			request.getRequestDispatcher("produtos.jsp").forward(request, response);
			System.out.println("logou servlet");
		}else {
			response.sendRedirect("comprar.jsp");
			System.out.println("fez nada servlet autenticar teste");
		}
	}

}
