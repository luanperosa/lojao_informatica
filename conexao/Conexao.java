package br.com.TIO_lojao_informatica.conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

	public Connection con;
	
	public static void main(String[] args) {
//		con = DriverManager.getConnection("oracle.jdbc.driver.OracleDriver"
		Connection con;
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost/cjweb1",	"root", "");
			System.out.println("Conectado no mysql");
			con.close();
		} catch (SQLException e) {
			System.out.println("Problema com conexao!");
			e.printStackTrace();
		}
		
		try {
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "oracle");
			System.out.println("Conectado no oracle");
			con.close();
		} catch (SQLException e) {
			System.out.println("Problema com conexao!");
			e.printStackTrace();
		}

	}

	public Connection getConnection() {
		try {
			try {    				
				 Class.forName("org.gjt.mm.mysql.Driver");  
				// Class.forName("oracle.jdbc.driver.OracleDriver"); 
			} catch (ClassNotFoundException e) {
		
				e.printStackTrace();
			}
			this.con = DriverManager.getConnection("jdbc:mysql://localhost/fazendo","root", "");
			//con = DriverManager.getConnection("jdbc:mysql://localhost/cjweb1",	"root", "");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Driver de conexao nao encontrado poxa vida!");
		}
		return con;
	}
	
	public Connection getConnectionOracle() {
		try {
			try {    				
				 Class.forName("oracle.jdbc.driver.OracleDriver"); 
			} catch (ClassNotFoundException e) {
		
				e.printStackTrace();
			}
			this.con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "oracle");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Driver de conexao nao encontrado!");
		}
		return con;
	}

	
	public static void getConection2() {
		Connection con;
		try {
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "oracle");
			System.out.println("Conectado no oracle");
			con.close();
		} catch (SQLException e) {
			System.out.println("Problema com conexao!");
			e.printStackTrace();
		}
		
	}
	
	public static void getConection3() {
		Connection con;
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost/cjweb1",	"root", "");
			System.out.println("Conectado no myslq");
			con.close();
		} catch (SQLException e) {
			System.out.println("Problema com conexao!");
			e.printStackTrace();
		}
		
	}
}
