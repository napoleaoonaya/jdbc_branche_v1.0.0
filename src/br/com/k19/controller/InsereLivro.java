package br.com.k19.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import br.com.k19.model.Livro;

public class InsereLivro {

	public static void main(String[] args) {
		
		Connection connection;

		String url = "jdbc:mysql://localhost:3306/livraria";
		String user = "root";
		String password = "napoleao";
		
		try {
			
			Scanner teclado = new Scanner(System.in);
			
			Livro livro = new Livro();
			
			connection = null;
			
			connection = DriverManager.getConnection(url, user, password);
			
			String sql =" insert into livro (titulo,preco,codigo_editora_id) values (?,?,?)";
			
			PreparedStatement pstmt = connection.prepareStatement(sql);
			
			System.out.println("Digite o titulo do livro: ");
			livro.setTitulo(teclado.nextLine());
			
			System.out.println("Digite o preco do livro: ");
			livro.setPreco(teclado.nextDouble());
			
			teclado.nextLine();
			
			System.out.println("Digite o codigo_editora_id do livro: ");
			livro.setCodigo_editora_id(teclado.nextLong());
			
			pstmt.setString(1,livro.getTitulo());
			pstmt.setDouble(2,livro.getPreco());
			pstmt.setLong(3,livro.getCodigo_editora_id());
			
			System.out.println("Inserindo livro");
			
			pstmt.execute();
			
			pstmt.close();
			
			connection.close();
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}

}
