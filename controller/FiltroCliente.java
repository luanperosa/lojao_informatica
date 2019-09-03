package br.com.TIO_lojao_informatica.controller;

import java.io.IOException;

import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//@WebFilter(dispatcherTypes = {
//				DispatcherType.REQUEST, 
//				DispatcherType.FORWARD
//		}
//					, urlPatterns = { "/venda1.do" })
public class FiltroCliente implements Filter {

    public FiltroCliente() {

    }

	public void destroy() {
		
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// Casting do HttpServlet Request
		HttpServletRequest httpServletRequest = (HttpServletRequest) request;
		
		//capturando a sessao
		HttpSession sessao = httpServletRequest.getSession(true);
	
		//esta logado?
		if (sessao.getAttribute("clienteLogado")!=null ){
			System.out.println("passou no if do filtro");
			chain.doFilter(request, response);
		}else {
			// redireciona para login
			((HttpServletResponse) response).sendRedirect("produto.jsp");
			
		}
	}


	public void init(FilterConfig fConfig) throws ServletException {

	}

}
