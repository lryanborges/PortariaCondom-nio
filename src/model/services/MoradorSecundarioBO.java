package model.services;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import controller.dto.MoradorPrincipalDTO;
import controller.dto.MoradorSecundarioDTO;
import model.dao.BaseInterfaceDAO;
import model.dao.MoradorSecundarioDAO;
import model.entity.MoradorPrincipal;
import model.entity.MoradorSecundario;

public class MoradorSecundarioBO {

	BaseInterfaceDAO<MoradorSecundario> dao = new MoradorSecundarioDAO();
	
	public int cadastrar(MoradorSecundarioDTO msDTO) {
		
		MoradorSecundario ms = MoradorSecundario.converter(msDTO);
		
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
	
	public boolean editar(MoradorSecundarioDTO mpDTO) {
		MoradorSecundario mp = MoradorSecundario.converter(mpDTO);
        
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
	
	public boolean apagar(MoradorSecundarioDTO mpDTO) {
		MoradorSecundario mp = MoradorSecundario.converter(mpDTO);
        
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
	
	public List<MoradorSecundarioDTO> listar() {
		List<MoradorSecundarioDTO> moradoresPrincipais = new ArrayList<MoradorSecundarioDTO>();
        ResultSet rs = dao.listar();

        try {

            while(rs.next()) {
            	MoradorSecundarioDTO mpDTO = new MoradorSecundarioDTO();
                mpDTO.setId(rs.getInt("id"));
                mpDTO.setNome(rs.getString("nome"));
                mpDTO.setApartamento(rs.getInt("apartamento"));
                mpDTO.setDataNasc(rs.getString("nascimento"));
                mpDTO.setIdMoradorP(rs.getInt("id_MoradorP"));
                mpDTO.setParentesco(rs.getString("parentesco"));

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
