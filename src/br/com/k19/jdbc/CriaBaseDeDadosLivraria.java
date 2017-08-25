package br.com.k19.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CriaBaseDeDadosLivraria {

	public static void main(String[] args) {
		
		//Atributos de conexão
		String url = "jdbc:mysql://localhost:3306";
		String user = "root";
		String password = "napoleao";
		
		Connection connection;
		
		try {
			
			connection = null;
			
			//Exibindo a abertura da conexão
			System.out.println("Abrindo conexão com o banco de dados...");
			//Criando o objeto de conexão
			connection = DriverManager.getConnection(url, user, password);
			//Apagando a livraria e criando a mesma se não existir
			System.out.println("Apagando a livraria...");
			String sql = "DROP DATABASE IF EXISTS livraria";
			//Criando o objeto de persistência
			PreparedStatement pstmt = connection.prepareStatement(sql);
			//Persistindo no banco de dados
			pstmt.execute();
			//Fechando o objeto de persistência
			pstmt.close();
			
			//Criando o banco de dados
			System.out.println("Criando o banco de dados...");
			sql = "CREATE DATABASE livraria";
			//Criando o objeto de persistência
			pstmt = connection.prepareStatement(sql);
			//Persistindo no banco de dados
			pstmt.execute();
			//Fechando o objeto de persistência
			pstmt.close();
			//Operação finalizada
			System.out.println("Banco de dados criado...");
			
		} catch (SQLException e ) {
			throw new RuntimeException(e);
		}
		
	}

}
