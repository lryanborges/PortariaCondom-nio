package model.entity;

public class Empregados {
	
	private String nome;
	private String cargo;
	private String rg;
	private String turno;
	
	public Empregados() {}
	
	public Empregados(String nome, String cargo, String rg, String turno) {
		setNome(nome);
		setCargo(cargo);
		setRg(rg);
		setTurno(turno);
	}
	
	public Empregados(String cargo, String rg, String turno) {
		setNome("Porteiro");
		setCargo(cargo);
		setRg(rg);
		setTurno(turno);
	}
	
	public Empregados(String cargo, String turno) {
		setNome("Porteiro substituto");
		setCargo(cargo);
		setRg("Não cadastrado");
		setTurno(turno);
	}
	
	// Getters e Setters
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		if(nome == null || nome == " " || nome == "0") {
			System.out.println("Nome "+ nome +" não é válido.");
		} else this.nome = nome;
	}
	
	public String getCargo() {
		return cargo;
	}
	public void setCargo(String cargo) {
		if(cargo == null || cargo == " " || cargo == "0") {
			System.out.println("Cargo "+ cargo +" não é válido.");
		} else this.cargo = cargo;
	}
	
	public String getRg() {
		return rg;
	}
	public void setRg(String rg) {
		if(rg == null || rg == " " || rg == "0") {
			System.out.println("RG "+ rg +" não é válido.");
		} else this.rg = rg;
	}
	
	public String getTurno() {
		return turno;
	}
	public void setTurno(String turno) {
		if(turno == null || turno == " " || turno == "0") {
			System.out.println("Turno "+ turno +" não é válido.");
		} else this.turno = turno;
	}
	
}