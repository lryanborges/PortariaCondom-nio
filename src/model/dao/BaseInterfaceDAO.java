package model.dao;

import java.sql.ResultSet;

import model.entity.MoradorPrincipal;

public interface BaseInterfaceDAO<entity> {
	
	public int criar(entity e);
	public boolean atualizar(entity e);
	public boolean excluir(entity e);
	public ResultSet encontrar(entity e);
	public ResultSet listar();
	public ResultSet listarDados(MoradorPrincipal mp);
	
}
