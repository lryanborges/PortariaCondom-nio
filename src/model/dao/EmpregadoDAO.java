package model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.entity.Empregados;

public class EmpregadoDAO extends ConexaoDAO implements BaseInterfaceDAO<Empregados>{

	@Override
	public int criar(Empregados ms) {
		
		String sql = "INSERT INTO Empregado (nome, cargo, turno, rg, id_moradorP, apartamento) VALUES (?,?,?,?,?,?)";
		
		try {
			PreparedStatement ps = getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			
			ps.setString(1, ms.getNome());
			ps.setString(2, ms.getCargo());
			ps.setString(3, ms.getTurno());
			ps.setString(4, ms.getRg());
			ps.setInt(5, ms.getIdMoradorP());
			ps.setInt(6, ms.getApartamento());
			ps.execute();
			
			ResultSet rs = ps.getGeneratedKeys();
			
			if(rs.next()) {
				int id = 0;
				
				id = rs.getInt(1);
				return id;	
			}
			
			return 999;	
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			return 0;
		}
			
	}

	@Override
	public boolean atualizar(Empregados ms) {
		String sql = "UPDATE Empregado SET nome=?, cargo=?, rg=?, turno=? WHERE id=?;";
		
		try {
		PreparedStatement ps = getConnection().prepareStatement(sql);
		ps.setString(1, ms.getNome());
		ps.setString(2, ms.getCargo());
		ps.setString(3, ms.getRg());
		ps.setString(4, ms.getTurno());
		ps.setInt(5, ms.getId());
		ps.executeUpdate();

		return true;		
	
	} catch (SQLException e) {
		e.printStackTrace();

		return false;

	}	
	}

	@Override
	public boolean excluir(Empregados ms) {
		String sql = "DELETE FROM Empregado WHERE id=?;";

		try {
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setInt(1, ms.getId());

			return ps.execute();

		} catch (SQLException e) {
			e.printStackTrace();

			return false;

		}
	}

	@Override
	public ResultSet encontrar(Empregados ms) {
		String sql = "SELECT * FROM Empregado WHERE id=? ;";

        try {
            PreparedStatement ps = getConnection().prepareStatement(sql);
            ps.setInt(1, ms.getId());

            ResultSet rs = ps.executeQuery();
            return rs
            		;
        } catch(SQLException ex) {
            ex.printStackTrace();
            return null;
        }
	}

	@Override
	public ResultSet listar() {
		String sql = "SELECT * FROM Empregado;";
		try {
			PreparedStatement pst = getConnection().prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			return rs;

		} catch (SQLException ex) {
			ex.printStackTrace();

			return null;
			
		}
	}
	
}		