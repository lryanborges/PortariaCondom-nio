package model.services;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import controller.dto.AnimalDTO;
import model.dao.BaseInterfaceDAO;
import model.dao.AnimalDAO;
import model.entity.Animal;

public class AnimalBO {
BaseInterfaceDAO<Animal> dao = new AnimalDAO();
	
	public int cadastrar(AnimalDTO msDTO) {
		
		Animal a = Animal.converter(msDTO);
		
		ResultSet rs = dao.encontrar(a);
		try {
			if(rs==null || !(rs.next())) {
				int id = dao.criar(a);
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
	
	public boolean editar(AnimalDTO aDTO) {
		Animal a = Animal.converter(aDTO);
        
        ResultSet rs = dao.encontrar(a);
		try {
			if(rs!=null && (rs.next())) {
				if(dao.atualizar(a) == true)
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
	
	public boolean apagar(AnimalDTO aDTO) {
		Animal a = Animal.converter(aDTO);
        
        ResultSet rs = dao.encontrar(a);
		try {
			if(rs!=null && (rs.next())) {
				if(dao.excluir(a) == true)
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
	
	public List<AnimalDTO> listar() {
		List<AnimalDTO> animais = new ArrayList<AnimalDTO>();
        ResultSet rs = dao.listar();

        try {

            while(rs.next()) {
            	AnimalDTO aDTO = new AnimalDTO();
                aDTO.setId(rs.getInt("id"));
                aDTO.setNome(rs.getString("Nome"));
                aDTO.setApartamento(rs.getInt("Apartamento"));
                aDTO.setCor(rs.getString("Cor"));
                aDTO.setEspecie(rs.getString("Especie"));
                aDTO.setIdMorador(rs.getInt("Id_MoradorP"));
                aDTO.setRaca(rs.getString("Raca"));
                animais.add(aDTO);
                
            }
            return animais;
        } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
}
