package br.com.TIO_lojao_informatica.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.TIO_lojao_informatica.DAO.CadastroDAO;
import br.com.TIO_lojao_informatica.entidades.Venda;

@WebServlet("/venda2.do")
public class Venda2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Venda2() {
        super();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String parcelas = request.getParameter("txtparcela");
		String codItemMax = request.getParameter("txtMaxItem");
		String codFatuMax = request.getParameter("txtMaxFat");
		
		Venda venda = new Venda();
		venda.setQ_parcela(Double.parseDouble(parcelas));
		
		CadastroDAO cadastroDAO = new CadastroDAO();
		cadastroDAO.inserindoParcelas(venda);
		
		Integer ultimaFatura =  Integer.parseInt(codFatuMax) + 1;
		
		response.sendRedirect("prodcontroller.do?acao=fatu&vovei="+ultimaFatura+"&voveitem="+codItemMax);
	}

}
