package br.com.k19.model;

public class Livro {

	//Atributos da classe Editora
	private Long id;
	private String titulo;
	private double preco;
	private Long codigo_editora_id;
	
	//Encapsulamento
	public Long getId(){
		return id;
	}
	public void setId(Long id){
		this.id = id;
	}
	public String getTitulo(){
		return titulo;
	}
	public void setTitulo(String titulo){
		this.titulo = titulo;
	}
	public double getPreco(){
		return preco;
	}
	public void setPreco(Double preco){
		this.preco = preco;
	}
	public Long getCodigo_editora_id(){
		return codigo_editora_id;
	}
	public void setCodigo_editora_id(Long codigo_editora_id){
		this.codigo_editora_id = codigo_editora_id;
	}
}
