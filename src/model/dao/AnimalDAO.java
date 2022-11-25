package model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.entity.Animal;

public class AnimalDAO extends ConexaoDAO implements BaseInterfaceDAO<Animal> {
	@Override
	public int criar(Animal a) {

		String sql = "INSERT INTO Animal (Especie,Nome,Raca,Cor,Id_MoradorP,Apartamento) VALUES (?,?,?,?,?,?)";
		
		try {
			
			PreparedStatement ps = getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, a.getEspecie());
			ps.setString(2, a.getNome());
			ps.setString(3, a.getRaca());
			ps.setString(4, a.getCor());
			ps.setInt(5, a.getIdMorador());
			ps.setInt(6, a.getApartamento());
			ps.execute();
		
			ResultSet rs = ps.getGeneratedKeys();
			
			int id = 0;
			if(rs.next()) {
				id = rs.getInt(1);
			}
			
			return id;
		}  
		catch (SQLException e) {
			e.printStackTrace();

			return 0;

		}
	}

	@Override
	public boolean atualizar(Animal a) { 
			String sql = "UPDATE Animal SET Especie=?, Nome=?, Raca=?, Cor=?, Id_Morador=?, Apartamento=? WHERE Id=?;";
		
			try {
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setString(1, a.getEspecie());
			ps.setString(2, a.getNome());
			ps.setString(3, a.getRaca());
			ps.setString(4, a.getCor());
			ps.setInt(5, a.getIdMorador());
			ps.setInt(6, a.getApartamento());
			ps.setInt(7, a.getId());
			ps.executeUpdate();

			return true;		
		
		} catch (SQLException e) {
			e.printStackTrace();

			return false;

		}	
	}

	@Override
	public boolean excluir(Animal a) {
		String sql = "DELETE FROM Animal WHERE Id=?;";

		try {
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setInt(1, a.getId());

			return ps.execute();

		} catch (SQLException e) {
			e.printStackTrace();

			return false;

		}
	}

	public ResultSet listar() {
		String sql = "SELECT * FROM Animal;";
		try {
			PreparedStatement pst = getConnection().prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			return rs;

		} catch (SQLException ex) {
			ex.printStackTrace();

			return null;
			
		}
	}
	
	public ResultSet encontrar(Animal a){
        String sql = "SELECT * FROM Animal WHERE Id=? ;";

        try {
            PreparedStatement ps = getConnection().prepareStatement(sql);
            ps.setInt(1, a.getId());

            ResultSet rs = ps.executeQuery();
            return rs;
        } catch(SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }
}
