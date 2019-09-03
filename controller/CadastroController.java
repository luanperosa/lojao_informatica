package br.com.TIO_lojao_informatica.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sun.org.mozilla.javascript.internal.json.JsonParser.ParseException;
import br.com.TIO_lojao_informatica.DAO.CadastroDAO;
import br.com.TIO_lojao_informatica.entidades.Cliente;
import br.com.TIO_lojao_informatica.entidades.Endereco;
import br.com.TIO_lojao_informatica.entidades.Telefone;

@WebServlet("/cadastrocontroller.do")
public class CadastroController extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//recebendo dados da tela 
		String nomeCli = request.getParameter("txtnomecli");
		String cpf = request.getParameter("txtcpf");
		String email = request.getParameter("txtemail");
		String senha = request.getParameter("txtsenha");
		String dataNasc1 = request.getParameter("txtdataNasc");
		String sexo = request.getParameter("txtsexo");
		String tipoEnd = request.getParameter("txtendtipo");
		String tipoLog = request.getParameter("txtlogadouro");
		String endereco = request.getParameter("txtendereco");
		String numero = request.getParameter("txtnumero");
		String complemento = request.getParameter("txtcomplemento");
		String bairro = request.getParameter("txtbairro");
		String cidade = request.getParameter("txtcidade");
		String uf = request.getParameter("txtuf");
		String cep = request.getParameter("txtcep");
		String movel = request.getParameter("txtmovel");
		String residencial = request.getParameter("txtresidencia");
		String comercial = request.getParameter("txtcomercial");
		Calendar dataNascimento = null;
		
		// fazendo a conversão da data
        try {
            Date date = new SimpleDateFormat("dd/MM/yyyy").parse(dataNasc1);
            dataNascimento = Calendar.getInstance();
            dataNascimento.setTime(date);
        } catch (java.text.ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//cria objeto Cliente e seta valores vindos da tela
		Cliente cliente = new Cliente();
		cliente.setNome(nomeCli);
		cliente.setCpf(cpf);
		cliente.setEmail(email);
		cliente.setSenha(senha);
		cliente.setData_n(dataNascimento);
		cliente.setSex(Integer.parseInt(sexo));
		
		Endereco endereco1 = new Endereco();
		endereco1.setT_ende(Integer.parseInt(tipoEnd));
		endereco1.setT_logra(Integer.parseInt(tipoLog));
		endereco1.setEnde(endereco);
		endereco1.setNum(Integer.parseInt(numero));
		endereco1.setComple(complemento);
		endereco1.setBair(bairro);
		endereco1.setCid(cidade);
		endereco1.setUf(Integer.parseInt(uf));
		endereco1.setCep(cep);
		
		Telefone telefone = new Telefone();
		telefone.setMovel_tf(movel);
		telefone.setResid_tf(residencial);
		telefone.setComer_tf(comercial);
		
		// pede usuariodao cadastrar no banco 
		CadastroDAO cadastroDAO = new CadastroDAO();
		cadastroDAO.cadastrando(cliente);
		cadastroDAO.cadastrandoEnd(endereco1);
		cadastroDAO.cadastrandoTelefone(telefone);
		// Saida ao navegador
		response.sendRedirect("comprar2_2.jsp");
		
	}

	
}
