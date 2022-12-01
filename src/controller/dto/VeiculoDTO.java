package controller.dto;

public class VeiculoDTO {
	private int id;
	private String marca;
	private String modelo;
	private String cor;
	private String placa;
	private int id_MoradorP;
	private int apartamento;
	
	public VeiculoDTO() {}
	
	public VeiculoDTO(String marca, String modelo, String cor, String placa) {
		setMarca(marca);
		setModelo(modelo);
		setCor(cor);
		setPlaca(placa);
	}
	
	public VeiculoDTO(String marca, String cor, String placa) {
		setMarca(marca);
		setModelo("Não especificado");
		setCor(cor);
		setPlaca(placa);
	}
	
	public VeiculoDTO(String marca, String placa) {
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
			System.out.println("Marca "+ marca +" n�o � valido.");
		} else this.marca = marca;
	}
	
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		if(modelo == null || modelo == " " || modelo == "0") {
			System.out.println("Modelo "+ modelo +" n�o � valido.");
		} else this.modelo = modelo;
	}
	
	public String getCor() {
		return cor;
	}
	public void setCor(String cor) {
		if(cor == null || cor == " " || cor == "0") {
			System.out.println("Cor "+ cor +" n�o � valido.");
		} else this.cor = cor;
	}
	
	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		if(placa == null || placa == " " || placa == "0") {
			System.out.println("Placa "+ placa +" n�o � valido.");
		} else this.placa = placa;
	}
	public int getId_MoradorP() {
		return id_MoradorP;
	}

	public void setId_MoradorP(int id_MoradorP) {
		this.id_MoradorP = id_MoradorP;
	}

	public int getApartamento() {
		return apartamento;
	}

	public void setApartamento(int apartamento) {
		this.apartamento = apartamento;
	}
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
