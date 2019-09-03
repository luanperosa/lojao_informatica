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
import br.com.TIO_lojao_informatica.entidades.Pr_login;

@WebServlet("/autenticarcliente.do")
public class Autenticar extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Autenticar() {
        super();
 
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Capturando dados da tela 
		String email = request.getParameter("txtemail");
		String senha = request.getParameter("txtsenha");
		
		//Constroi objeto Cliente para consulta
		Pr_login pr_login = new Pr_login();
		pr_login.setEmail_l(email);
		pr_login.setSenha_l(senha);
		
		//busca no banco de dados
		CadastroDAO cadastroDAO = new CadastroDAO();
		
		Pr_login clienteRetorno = CadastroDAO.autenticar(pr_login);
		if (clienteRetorno!=null){
			 //criando sessao
			HttpSession sessao = request.getSession();
			sessao.setMaxInactiveInterval(9000000);
			sessao.setAttribute("clienteLogado", clienteRetorno);
			request.getRequestDispatcher("produtos.jsp").forward(request, response);
			System.out.println("fez nada 1");
		}else {
			response.sendRedirect("comprar.jsp");
			System.out.println("fez nada");
		}
	}

}
