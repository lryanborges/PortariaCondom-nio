package model.services;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import controller.dto.EmpregadoDTO;
import controller.dto.MoradorPrincipalDTO;
import controller.dto.MoradorSecundarioDTO;
import model.dao.BaseInterfaceDAO;
import model.dao.EmpregadoDAO;
import model.dao.MoradorSecundarioDAO;
import model.entity.Empregados;
import model.entity.MoradorPrincipal;
import model.entity.MoradorSecundario;

public class EmpregadoBO {

	BaseInterfaceDAO<Empregados> dao = new EmpregadoDAO();
	
	public int cadastrar(EmpregadoDTO msDTO) {
		
		Empregados ms = Empregados.converter(msDTO);
		
		ResultSet rs = dao.encontrar(ms);
		try {
			if(rs==null || !(rs.next())) {
				int id = dao.criar(ms);
		        System.out.println(id);
				if(id >= 0)
					return id;
					else return 0;
			}
			else return 0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
		
	}
	
	public boolean editar(EmpregadoDTO mpDTO) {
		Empregados mp = Empregados.converter(mpDTO);
        
        ResultSet rs = dao.encontrar(mp);
        dao.atualizar(mp);
		try {
			if(rs!=null || (rs.next())) {
				if(dao.atualizar(mp) == true)
					return true;
					else return false;
			}
			else return false;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean apagar(EmpregadoDTO mpDTO) {
		Empregados mp = Empregados.converter(mpDTO);
        
        ResultSet rs = dao.encontrar(mp);
		try {
			if(rs!=null || (rs.next())) {
				if(dao.excluir(mp) == true)
					return true;
					else return false;
			}
			else return false;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	
	public List<EmpregadoDTO> listar() {
		List<EmpregadoDTO> moradoresPrincipais = new ArrayList<EmpregadoDTO>();
        ResultSet rs = dao.listar();

        try {

            while(rs.next()) {
            	EmpregadoDTO mpDTO = new EmpregadoDTO();
                mpDTO.setId(rs.getInt("id"));
                mpDTO.setNome(rs.getString("nome"));
                mpDTO.setApartamento(rs.getInt("cargo"));
                mpDTO.setTurno(rs.getString("turno"));
                mpDTO.setRg(rs.getString("rg"));
                mpDTO.setIdMoradorP(rs.getInt("id_MoradorP"));
                mpDTO.setApartamento(rs.getInt("apartamento"));
                
                moradoresPrincipais.add(mpDTO);
            }
            return moradoresPrincipais;
        } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
}
