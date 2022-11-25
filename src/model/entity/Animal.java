package model.entity;

public class Animal {
	
	private int id;
	private String especie;
	private String nome;
	private String raca;
	private String cor;
	
	public Animal() {}
	
	public Animal(int id, String especie, String nome, String raca, String cor) {
		setId(id);
		setEspecie(especie);
		setNome(nome);
		setRaca(raca);
		setCor(cor);
	}
	
	public Animal(String especie, String nome, String raca, String cor) {
		setEspecie(especie);
		setNome(nome);
		setRaca(raca);
		setCor(cor);
	}
	
	public Animal(int id, String especie, String nome, String cor) {
		setId(id);
		setEspecie(especie);
		setNome(nome);
		setRaca("Não especificado");
		setCor(cor);
	}
	
	public Animal(String especie, String nome, String cor) {
		setEspecie(especie);
		setNome(nome);
		setRaca("Não especificado");
		setCor(cor);
	}
	
	// Getters e Setters

	public int getId() {
		return id;
	}

	public void setId(int id) {
		if(id <= 0) {
			System.out.println("ID "+ id +" não é válido.");
		} else this.id = id;
	}
	
	public String getEspecie() {
		return especie;
	}

	public void setEspecie(String especie) {
		if(especie == null || especie == " " || especie == "0") {
			System.out.println("Espécie "+ especie +" não é válido.");
		} else this.especie = especie;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		if(nome == null || nome == " " || nome == "0") {
			System.out.println("Nome "+ nome +" não é válido.");
		} else this.nome = nome;
	}
	
	public String getRaca() {
		return raca;
	}
	public void setRaca(String raca) {
		if(raca == null || raca == " " || raca == "0") {
			System.out.println("Raça "+ raca +" não é válido.");
		} else this.raca = raca;
	}
	
	public String getCor() {
		return cor;
	}
	public void setCor(String cor) {
		if(cor == null || cor == " " || cor == "0") {
			System.out.println("Cor "+ cor +" não é válido.");
		} else this.cor = cor;
	}
	
}