package model.services;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import controller.dto.VeiculoDTO;
import model.dao.BaseInterfaceDAO;
import model.dao.VeiculoDAO;
import model.entity.Veiculo;

public class VeiculoBO {
	BaseInterfaceDAO<Veiculo> dao = new VeiculoDAO();
	
	public int cadastrar(VeiculoDTO vDTO) {
		
		Veiculo v = Veiculo.converter(vDTO);
		
		ResultSet rs = dao.encontrar(v);
		try {
			if(rs==null || !(rs.next())) {
				int id = dao.criar(v);
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
	public boolean editar(VeiculoDTO vDTO) {
		Veiculo v = Veiculo.converter(vDTO);
        
        ResultSet rs = dao.encontrar(v);
        dao.atualizar(v);
		try {
			if(rs!=null || (rs.next())) {
				if(dao.atualizar(v) == true)
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

	public boolean apagar(VeiculoDTO vDTO) {
		Veiculo v = Veiculo.converter(vDTO);
        
        ResultSet rs = dao.encontrar(v);
		try {
			if(rs!=null || (rs.next())) {
				if(dao.excluir(v) == true)
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
	
	public List<VeiculoDTO> listar() {
		List<VeiculoDTO> veiculo = new ArrayList<VeiculoDTO>();
        ResultSet rs = dao.listar();

        try {

            while(rs.next()) {
            	VeiculoDTO vDTO = new VeiculoDTO();
                vDTO.setId(rs.getInt("id"));
                vDTO.setMarca(rs.getString("marca"));
                vDTO.setModelo(rs.getString("modelo"));
                vDTO.setCor(rs.getString("cor"));
                vDTO.setPlaca(rs.getString("placa"));
                vDTO.setId_MoradorP(rs.getInt("Id_MoradorP"));
                vDTO.setApartamento(rs.getInt("apartamento"));

               veiculo.add(vDTO);
            }
            return veiculo;
        } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
}
