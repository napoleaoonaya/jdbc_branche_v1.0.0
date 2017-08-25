package br.com.k19.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.k19.model.Editora;

public class ListaEditora {

	public static void main(String[] args) {
		
		Connection connection;

		String url = "jdbc:mysql://localhost:3306/livraria";
		String user = "root";
		String password = "napoleao";
		
		try {
			
			connection = null;
			
			connection = DriverManager.getConnection(url, user, password);
			
			String sql = "select *from editora";
			
			PreparedStatement pstmt = connection.prepareStatement(sql);
			
			ResultSet rst = pstmt.executeQuery();
			
			
			ArrayList<Editora> editoraLista = new ArrayList<Editora>();
			
			while (rst.next()) {
				
				Editora editora = new Editora();
				
				editora.setId(rst.getLong("id"));
				editora.setNome(rst.getString("nome"));
				editora.setEmail(rst.getString("email"));
				
				editoraLista.add(editora);
				
			}
			
			for(Editora editora : editoraLista){
				System.out.println("Listando editoras");
				System.out.println("Id: "+editora.getId());
				System.out.println("Nome: "+editora.getNome());
				System.out.println("Email: "+editora.getEmail());
			}
			
			pstmt.close();
			connection.close();
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}

}
