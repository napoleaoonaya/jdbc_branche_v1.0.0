package br.com.k19.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import br.com.k19.model.Livro;

public class DeletaLivro {

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
			
			String sql =" delete from livro where id=?";
			
			PreparedStatement pstmt = connection.prepareStatement(sql);
			
			System.out.println("Digite o id do livro: ");
			livro.setId(teclado.nextLong());
			
			pstmt.setLong(1,livro.getId());
			
			System.out.println("Livro deletado");
			
			pstmt.execute();
			
			pstmt.close();
			
			connection.close();
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}

}
