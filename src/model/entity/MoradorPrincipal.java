package model.entity;

import controller.dto.MoradorPrincipalDTO;

public class MoradorPrincipal {
	
	//private x foto; ?
	private int id;
	private int apartamento;
	private String bloco;
	private String categoria;
	private String nome;
	private String cpf;
	private String rg;
	private String dataNasc;
	private String email;
	private String telResidencial;
	private String telComercial;
	private String telCelular;
	private boolean autorizarZap;
	
	public MoradorPrincipal() {}
	
	public MoradorPrincipal(int apartamento, String bloco, String categoria, String nome, String cpf,
			String rg, String dataNasc, String email, String telResidencial, String telComercial,
			String telCelular, boolean autorizarZap) {
		setCpf(cpf);
		setNome(nome);
		setApartamento(apartamento);
		setBloco(bloco);
		setCategoria(categoria);
		setRg(rg);
		setDataNasc(dataNasc);
		setEmail(email);
		setTelResidencial(telResidencial);
		setTelComercial(telComercial);
		setTelCelular(telCelular);
		setAutorizarZap(autorizarZap);
	}
	
	public MoradorPrincipal(int apartamento, String bloco, String categoria, String nome, String cpf,
			String rg, String dataNasc, String email,
			String telCelular, boolean autorizarZap) {
		setCpf(cpf);
		setNome(nome);
		setApartamento(apartamento);
		setBloco(bloco);
		setCategoria(categoria);
		setRg(rg);
		setDataNasc(dataNasc);
		setEmail(email);
		setTelResidencial("Não possui");
		setTelComercial("Não possui");
		setTelCelular(telCelular);
		setAutorizarZap(autorizarZap);
		
	}
	
	public MoradorPrincipal(int apartamento, String bloco, String categoria, String nome, String cpf,
			String rg, String dataNasc, String email,
			String telCelular) {
		setCpf(cpf);
		setNome(nome);
		setApartamento(apartamento);
		setBloco(bloco);
		setCategoria(categoria);
		setRg(rg);
		setDataNasc(dataNasc);
		setEmail(email);
		setTelResidencial("Não possui");
		setTelComercial("Não possui");
		setTelCelular(telCelular);
		setAutorizarZap(false);
	}
	
	public MoradorPrincipal(int apartamento, String bloco, String categoria, String nome, String cpf,
			String rg, String email,
			String telCelular) {
		setCpf(cpf);
		setNome(nome);
		setApartamento(apartamento);
		setBloco(bloco);
		setCategoria(categoria);
		setRg(rg);
		setDataNasc("Prefere não informar");
		setEmail(email);
		setTelResidencial("Não possui");
		setTelComercial("Não possui");
		setTelCelular(telCelular);
		setAutorizarZap(false);
	}
	
	// Getters e Setters
	
	public int getApartamento() {
		return apartamento;
	}
	public void setApartamento(int apartamento) {
		if(apartamento <= 0) {
			System.out.println("Apartamento "+ apartamento +" não existe.");
		} else this.apartamento = apartamento;
	}
	
	public String getBloco() {
		return bloco;
	}
	public void setBloco(String bloco) {
		if(bloco == null) {
			System.out.println("Bloco "+ bloco +" não existe.");
		} else this.bloco = bloco;
	}
	
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		if(!(categoria.equalsIgnoreCase("Proprietario") || categoria.equalsIgnoreCase("Locatario"))) {
			System.out.println("Categoria "+ categoria +" não existe.");
		} else this.categoria = categoria;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		if(nome == null || nome == " " || nome == "0") {
			System.out.println("Nome "+ nome +" não é válido.");
		} else this.nome = nome;
	}
	
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		if(cpf == null || cpf == " " || cpf == "0") {
			System.out.println("CPF "+ cpf +" não é válido.");
		} else this.cpf = cpf;
	}
	
	public String getRg() {
		return rg;
	}
	public void setRg(String rg) {
		if(rg == null || rg == " " || rg == "0") {
			System.out.println("RG "+ rg +" não é válido.");
		} else this.rg = rg;
	}
	
	public String getDataNasc() {
		return dataNasc;
	}
	public void setDataNasc(String dataNasc) {
		if(dataNasc == null || dataNasc == " " || dataNasc == "0") {
			System.out.println("Data de Nascimento "+ dataNasc +" não é válida.");
		} else this.dataNasc = dataNasc;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		if(email == null || email == " " || email == "0") {
			System.out.println("E-mail "+ email +" não é válido.");
		} else this.email = email;
	}
	
	public String getTelResidencial() {
		return telResidencial;
	}
	public void setTelResidencial(String telResidencial) {
		if(telResidencial == null || telResidencial == " " || telResidencial == "0") {
			System.out.println("Telefone Residencial "+ telResidencial +" não é válido.");
		} else this.telResidencial = telResidencial;
	}
	
	public String getTelComercial() {
		return telComercial;
	}
	public void setTelComercial(String telComercial) {
		if(telComercial == null || telComercial == " " || telComercial == "0") {
			System.out.println("Telefone Comercial "+ telComercial +" não é válido.");
		} else this.telComercial = telComercial;
	}
	
	public String getTelCelular() {
		return telCelular;
	}
	public void setTelCelular(String telCelular) {
		if(telCelular == null || telCelular == " " || telCelular == "0") {
			System.out.println("Telefone Celular "+ telCelular +" não é válido.");
		} else this.telCelular = telCelular;
	}
	
	public boolean isAutorizarZap() {
		return autorizarZap;
	}
	public void setAutorizarZap(boolean autorizarZap) {
		this.autorizarZap = autorizarZap;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public static MoradorPrincipal converter(MoradorPrincipalDTO mpDTO) {
		MoradorPrincipal mp = new MoradorPrincipal();
		
		mp.setId(mpDTO.getId());
		mp.setNome(mpDTO.getNome());
		mp.setCpf(mpDTO.getCpf());
		mp.setApartamento(mpDTO.getApartamento());
		mp.setBloco(mpDTO.getBloco());
		mp.setCategoria(mpDTO.getCategoria());
		mp.setRg(mpDTO.getRg());
		mp.setDataNasc(mpDTO.getDataNasc());
		mp.setTelResidencial(mpDTO.getTelResidencial());
		mp.setTelComercial(mpDTO.getTelComercial());
		mp.setTelCelular(mpDTO.getTelCelular());
		mp.setAutorizarZap(mpDTO.isAutorizarZap());
		mp.setEmail(mpDTO.getEmail());
		
		return mp;
	}

}
