package br.com.k19.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.k19.model.Livro;

public class ListaLivro {

	public static void main(String[] args) {
		
		Connection connection;

		String url = "jdbc:mysql://localhost:3306/livraria";
		String user = "root";
		String password = "napoleao";
		
		try {
			
			connection = null;
			
			connection = DriverManager.getConnection(url, user, password);
			
			String sql = "select *from livro";
			
			PreparedStatement pstmt = connection.prepareStatement(sql);
			
			ResultSet rst = pstmt.executeQuery();
			
			
			ArrayList<Livro> livroLista = new ArrayList<Livro>();
			
			while (rst.next()) {
				
				Livro livro = new Livro();
				
				livro.setId(rst.getLong("id"));
				livro.setTitulo(rst.getString("titulo"));
				livro.setPreco(rst.getDouble("preco"));
				livro.setCodigo_editora_id(rst.getLong("codigo_editora_id"));
				
				livroLista.add(livro);
				
			}
			
			for(Livro livro : livroLista){
				System.out.println("Listando livros");
				System.out.println("Id: "+livro.getId());
				System.out.println("Titulo: "+livro.getTitulo());
				System.out.println("Preco: "+livro.getPreco());
				System.out.println("Codigo_editora_id: "+livro.getCodigo_editora_id());
			}
			
			pstmt.close();
			connection.close();
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}

}
