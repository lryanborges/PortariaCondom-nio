package controller.dto;

public class AnimalDTO {
	private int id;
	private String especie;
	private String nome;
	private String raca;
	private String cor;
	private int idMorador;
	private int apartamento;
	
	public AnimalDTO() {}
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

	public int getIdMorador() {
		return idMorador;
	}

	public void setIdMorador(int idMorador) {
		this.idMorador = idMorador;
	}

	public int getApartamento() {
		return apartamento;
	}

	public void setApartamento(int apartamento) {
		this.apartamento = apartamento;
	}
}
