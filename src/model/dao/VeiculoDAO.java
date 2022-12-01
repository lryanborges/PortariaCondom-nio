package model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.entity.MoradorPrincipal;
import model.entity.Veiculo;

public class VeiculoDAO extends ConexaoDAO implements BaseInterfaceDAO<Veiculo>{

	@Override
	public int criar(Veiculo v) {		
		String sql = "INSERT INTO Veiculo (marca, modelo, cor, placa, id_moradorP, apartamento) VALUES (?,?,?,?,?,?)";
		
		try {
			PreparedStatement ps = getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			
			ps.setString(1, v.getMarca());
			ps.setString(2, v.getModelo());
			ps.setString(3, v.getCor());
			ps.setString(4, v.getPlaca());
			ps.setInt(5, v.getId_MoradorP());
			ps.setInt(6, v.getApartamento());
			ps.execute();
			
			ResultSet rs = ps.getGeneratedKeys();
			
			int id = 0;
			
			id = rs.getInt(1);
			

			
			return id;	
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			return 0;
		}
			

	}

	@Override
	public boolean atualizar(Veiculo v) {
		String sql = "UPDATE Veiculo SET marca=?, modelo=?, cor=?, placa=? WHERE id=?;";
		
		try {
		PreparedStatement ps = getConnection().prepareStatement(sql);
		ps.setString(1, v.getMarca());
		ps.setString(2, v.getModelo());
		ps.setString(3, v.getCor());
		ps.setString(4, v.getPlaca());
		ps.setInt(5, v.getId());
		ps.executeUpdate();

		return true;		
	
	} catch (SQLException e) {
		e.printStackTrace();

		return false;

	}	

	}

	@Override
	public boolean excluir(Veiculo v) {
		String sql = "DELETE FROM Veiculo WHERE id=?;";

		try {
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setInt(1, v.getId());

			return ps.execute();

		} catch (SQLException e) {
			e.printStackTrace();

			return false;

		}

	}

	@Override
	public ResultSet encontrar(Veiculo v) {
		String sql = "SELECT * FROM Veiculo WHERE id=? ;";

        try {
            PreparedStatement ps = getConnection().prepareStatement(sql);
            ps.setInt(1, v.getId());

            ResultSet rs = ps.executeQuery();
            return rs;
            
        } catch(SQLException ex) {
            ex.printStackTrace();
            return null;
        }

	}

	@Override
	public ResultSet listar() {
		String sql = "SELECT * FROM Veiculo;";
		try {
			PreparedStatement pst = getConnection().prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			return rs;

		} catch (SQLException ex) {
			ex.printStackTrace();

			return null;
			
		}

	}

	@Override
	public ResultSet listarDados(MoradorPrincipal mp) {
		// TODO Auto-generated method stub
		return null;
	}

}
