package model.services;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import controller.dto.MoradorPrincipalDTO;
import model.dao.BaseInterfaceDAO;
import model.dao.MoradorPrincipalDAO;
import model.entity.MoradorPrincipal;

public class MoradorPrincipalBO {
	
	BaseInterfaceDAO<MoradorPrincipal> dao = new MoradorPrincipalDAO();
	
	public int cadastrar(MoradorPrincipalDTO mpDTO) {
		
		MoradorPrincipal mp = MoradorPrincipal.converter(mpDTO);
	      
		ResultSet rs = dao.encontrar(mp);
		try {
			if(rs==null || !(rs.next())) {
				int id = dao.criar(mp);
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
	
	public boolean editar(MoradorPrincipalDTO mpDTO) {
		MoradorPrincipal mp = MoradorPrincipal.converter(mpDTO);
        
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
	
	public boolean apagar(MoradorPrincipalDTO mpDTO) {
		MoradorPrincipal mp = MoradorPrincipal.converter(mpDTO);
        
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
	
	public List<MoradorPrincipalDTO> listar() {
		
		List<MoradorPrincipalDTO> moradoresPrincipais = new ArrayList<MoradorPrincipalDTO>();
        ResultSet rs = dao.listar();

        try {

            while(rs.next()) {
            	MoradorPrincipalDTO mpDTO = new MoradorPrincipalDTO();
                mpDTO.setId(rs.getInt("id"));
                mpDTO.setNome(rs.getString("nome"));
                mpDTO.setCpf(rs.getString("cpf"));
                mpDTO.setApartamento(rs.getInt("apartamento"));
                mpDTO.setBloco(rs.getString("bloco"));
                mpDTO.setCategoria(rs.getString("categoria"));
                mpDTO.setRg(rs.getString("rg"));
                mpDTO.setDataNasc(rs.getString("nascimento"));
                mpDTO.setEmail(rs.getString("email"));
                mpDTO.setTelResidencial(rs.getString("telefoneResidencial"));
                mpDTO.setTelComercial(rs.getString("telefoneComercial"));
                mpDTO.setTelCelular(rs.getString("celular"));
                mpDTO.setAutorizarZap(rs.getBoolean("podeZap"));

                moradoresPrincipais.add(mpDTO);
            }
            return moradoresPrincipais;
        } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	public List<MoradorPrincipalDTO> listarDados(MoradorPrincipalDTO dto) {
			
			List<MoradorPrincipalDTO> moradoresPrincipais = new ArrayList<MoradorPrincipalDTO>();
			MoradorPrincipal mp = MoradorPrincipal.converter(dto);
	        ResultSet rs = dao.listarDados(mp);
	
	        try {
	
	            while(rs.next()) {
	            	MoradorPrincipalDTO mpDTO = new MoradorPrincipalDTO();	// MUDAR AS COLUNAS DE ACORDO COM O SQL
	                mpDTO.setId(rs.getInt("id"));
	                mpDTO.setNome(rs.getString("nome"));
	                mpDTO.setCpf(rs.getString("cpf"));
	                mpDTO.setApartamento(rs.getInt("apartamento"));
	                mpDTO.setBloco(rs.getString("bloco"));
	                mpDTO.setCategoria(rs.getString("categoria"));
	                mpDTO.setRg(rs.getString("rg"));
	                mpDTO.setDataNasc(rs.getString("nascimento"));
	                mpDTO.setEmail(rs.getString("email"));
	                mpDTO.setTelResidencial(rs.getString("telefoneResidencial"));
	                mpDTO.setTelComercial(rs.getString("telefoneComercial"));
	                mpDTO.setTelCelular(rs.getString("celular"));
	                mpDTO.setAutorizarZap(rs.getBoolean("podeZap"));
	                
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