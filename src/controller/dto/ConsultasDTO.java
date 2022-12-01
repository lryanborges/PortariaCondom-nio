package controller.dto;

public class ConsultasDTO {

	private int id;
	private String nome;
	private String moradorS;
	private String veiculo;
	private String empregado;
	private String animal;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getMoradorS() {
		return moradorS;
	}
	public void setMoradorS(String moradorS) {
		this.moradorS = moradorS;
	}
	public String getVeiculo() {
		return veiculo;
	}
	public void setVeiculo(String veiculo) {
		this.veiculo = veiculo;
	}
	public String getAnimal() {
		return animal;
	}
	public void setAnimal(String animal) {
		this.animal = animal;
	}
	public String getEmpregado() {
		return empregado;
	}
	public void setEmpregado(String empregado) {
		this.empregado = empregado;
	}
	
}
