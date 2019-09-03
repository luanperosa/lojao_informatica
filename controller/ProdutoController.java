package br.com.TIO_lojao_informatica.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.TIO_lojao_informatica.DAO.CadastroDAO;
import br.com.TIO_lojao_informatica.entidades.Produtos;
import br.com.TIO_lojao_informatica.entidades.VwFatura;
import br.com.TIO_lojao_informatica.entidades.VwItens;



@WebServlet("/prodcontroller.do")
public class ProdutoController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ProdutoController() {
        super();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
			String acao = request.getParameter("acao");
			//visualizar produto
			if(acao!=null && acao.equals("bprod")){
			//captura parametro da tela
			CadastroDAO cadastroDAO = new CadastroDAO();
			Integer codMaxItens = cadastroDAO.buscarCodMax();
			String cod = request.getParameter("v_prod");
			Produtos produtos = cadastroDAO.buscarPorId(Integer.parseInt(cod));
			// seta atributos do request com objeto usuario 
			request.setAttribute("produtos", produtos);
			request.setAttribute("codMaxItens", codMaxItens);
			// encaminha objeto usuario para tela
			RequestDispatcher saida = request.getRequestDispatcher("Computador_HP.jsp");
			saida.forward(request, response);
			
		}
			
		//visualisar fatura
			if(acao!=null && acao.equals("fatu")){
			// Obter a lista
			String fatura = request.getParameter("vovei");
			String itens = request.getParameter("voveitem");
			
			CadastroDAO cadastroDAO = new CadastroDAO();
			VwFatura vwfatura = cadastroDAO.buscarPorFatura(Integer.parseInt(fatura));

			List<VwItens> vwitens = cadastroDAO.buscarItensPorId(Integer.parseInt(itens));
			//engavetamento no request a lista 
			request.setAttribute("vwfatura", vwfatura);
			request.setAttribute("vwitens", vwitens);
			//Encaminhamento ao jsp
			RequestDispatcher saida = request.getRequestDispatcher("comprar3.jsp");
			saida.forward(request, response);
		
			}
			//visualizar tela de confirmação de compras
		if(acao!=null && acao.equals("conf")){
			CadastroDAO cadastroDAO = new CadastroDAO();
		    Integer codMaxItens = cadastroDAO.buscarCodMax();
		    Integer codMaxFatura = cadastroDAO.buscarCodMaxFatura();
		    Integer codMaxVenda = cadastroDAO.buscarCodMaxVenda();
			String itens = request.getParameter("voveitem");
			List<VwItens> vwitens = cadastroDAO.buscarItensPorId(Integer.parseInt(itens));
			//engavetamento no request a lista 
			request.setAttribute("vwitens", vwitens);
			request.setAttribute("codMaxItens", codMaxItens);
			request.setAttribute("codMaxFatura", codMaxFatura);
			request.setAttribute("codMaxVenda", codMaxVenda);
			//Encaminhamento ao jsp
			RequestDispatcher saida = request.getRequestDispatcher("comprar2.jsp");
			saida.forward(request, response);
		
			}

	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
	}
	
}
