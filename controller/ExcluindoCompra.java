package br.com.TIO_lojao_informatica.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.TIO_lojao_informatica.DAO.CadastroDAO;
import br.com.TIO_lojao_informatica.entidades.Fatura;
import br.com.TIO_lojao_informatica.entidades.ItensProduto;
import br.com.TIO_lojao_informatica.entidades.Venda;

@WebServlet("/excluindoCompra.do")
public class ExcluindoCompra extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ExcluindoCompra() {
        super();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String codigoVenda = request.getParameter("txtvendaexcluir");
		String codigoItens = request.getParameter("txtitensexcluir");
		String codigoFatura = request.getParameter("txtfaturaexcluir");
		
		CadastroDAO cadastroDAO = new CadastroDAO();
		Venda venda = new Venda();
		Fatura fatura = new Fatura();
		ItensProduto itensProduto = new ItensProduto();
		
		venda.setCod_v(Integer.parseInt(codigoVenda));
		fatura.setNumero(Integer.parseInt(codigoFatura));
		itensProduto.setCodigo_it(Integer.parseInt(codigoItens));
		
		cadastroDAO.excluirVenda(venda);
		cadastroDAO.excluirFatura(fatura);
		cadastroDAO.excluirItensProduto(itensProduto);
		
		System.out.println("passou pelo deletando");
		response.sendRedirect("index.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
