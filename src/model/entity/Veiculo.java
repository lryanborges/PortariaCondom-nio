package model.entity;

public class Veiculo {
	
	private String marca;
	private String modelo;
	private String cor;
	private String placa;
	
	public Veiculo() {}
	
	public Veiculo(String marca, String modelo, String cor, String placa) {
		setMarca(marca);
		setModelo(modelo);
		setCor(cor);
		setPlaca(placa);
	}
	
	public Veiculo(String marca, String cor, String placa) {
		setMarca(marca);
		setModelo("Não especificado");
		setCor(cor);
		setPlaca(placa);
	}
	
	public Veiculo(String marca, String placa) {
		setMarca(marca);
		setModelo("Não especificado");
		setCor("Não especificado");
		setPlaca(placa);
	}
	
	// Getters e Setters
	
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		if(marca == null || marca == " " || marca == "0") {
			System.out.println("Marca "+ marca +" não é válido.");
		} else this.marca = marca;
	}
	
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		if(modelo == null || modelo == " " || modelo == "0") {
			System.out.println("Modelo "+ modelo +" não é válido.");
		} else this.modelo = modelo;
	}
	
	public String getCor() {
		return cor;
	}
	public void setCor(String cor) {
		if(cor == null || cor == " " || cor == "0") {
			System.out.println("Cor "+ cor +" não é válido.");
		} else this.cor = cor;
	}
	
	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		if(placa == null || placa == " " || placa == "0") {
			System.out.println("Placa "+ placa +" não é válido.");
		} else this.placa = placa;
	}
	
}