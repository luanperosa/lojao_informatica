package br.com.TIO_lojao_informatica.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.TIO_lojao_informatica.DAO.CadastroDAO;
import br.com.TIO_lojao_informatica.entidades.ItensProduto;


@WebServlet("/venda1.do")
public class Venda1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Venda1() {
        super();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String codProd = request.getParameter("txtcodprod");
		String quantidade = request.getParameter("txtquantidade");
		String preco = request.getParameter("txtpreco");
		String maxCodigoVenda = request.getParameter("txtMaxCod");
		
		ItensProduto itensProduto = new ItensProduto();
		itensProduto.setCodigo_it(Integer.parseInt(codProd));
		itensProduto.setQuant_it(Double.parseDouble(quantidade));
		itensProduto.setValor_pr(Double.parseDouble(preco));
		
		
		CadastroDAO cadastroDAO = new CadastroDAO();
		cadastroDAO.cadastrandoItensProduto(itensProduto);
		
		response.sendRedirect("prodcontroller.do?acao=conf&voveitem="+maxCodigoVenda);
}

}
