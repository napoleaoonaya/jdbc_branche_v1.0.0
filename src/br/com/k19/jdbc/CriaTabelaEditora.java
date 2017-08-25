package br.com.k19.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CriaTabelaEditora {

	public static void main(String[] args) {

		// Atributos de conexão
		String url = "jdbc:mysql://localhost:3306";
		String user = "root";
		String password = "napoleao";

		Connection connection;

		try {

			connection = null;

			// Exibindo a abertura da conexão
			System.out.println("Abrindo conexão com o banco de dados...");
			// Criando o objeto de conexão
			connection = DriverManager.getConnection(url, user, password);
			//Usando o banco de dados
			String sql = "USE livraria";
			PreparedStatement pstmt = connection.prepareStatement(sql);
			// Persistindo no banco de dados
			pstmt.execute();
			// Fechando o objeto de persistência
			pstmt.close();
			// Apagando a tabela editora e criando a mesma se não existir
			System.out.println("Apagando a tabela editora...");
			sql = "DROP TABLE IF EXISTS editora";
			// Criando o objeto de persistência
			pstmt = connection.prepareStatement(sql);
			// Persistindo no banco de dados
			pstmt.execute();
			// Fechando o objeto de persistência
			pstmt.close();

			// Criando a tabela editora no banco
			System.out.println("Criando a tabela editora..");
			sql = "CREATE TABLE editora("
					+ "id bigint not null auto_increment,"
					+ "nome varchar(255)not null,"
					+ "email varchar(255)not null, "
					+ "primary key(id))engine=InnoDB charset=latin1";
			// Criando o objeto de persistência
			pstmt = connection.prepareStatement(sql);
			// Persistindo no banco de dados
			pstmt.execute();
			// Fechando o objeto de persistência
			pstmt.close();
			// Operação finalizada
			System.out.println("Criando tabela no banco de dados...");
			
			connection.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}

}
