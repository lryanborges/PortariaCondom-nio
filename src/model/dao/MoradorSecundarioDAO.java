package model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.entity.MoradorPrincipal;
import model.entity.MoradorSecundario;

public class MoradorSecundarioDAO extends ConexaoDAO implements BaseInterfaceDAO<MoradorSecundario>{

	@Override
	public int criar(MoradorSecundario ms) {
		
		String sql = "INSERT INTO Morador_Secundario (nome, parentesco, nascimento, id_moradorP, apartamento) VALUES (?,?,?,?,?)";
		
		try {
			PreparedStatement ps = getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			
			ps.setString(1, ms.getNome());
			ps.setString(2, ms.getParentesco());
			ps.setString(3, ms.getDataNasc());
			ps.setInt(4, ms.getIdMoradorP());
			ps.setInt(5, ms.getApartamento());
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
	public boolean atualizar(MoradorSecundario ms) {
		String sql = "UPDATE Morador_Secundario SET nome=?, parentesco=?, nascimento=? WHERE id=?;";
		
		try {
		PreparedStatement ps = getConnection().prepareStatement(sql);
		ps.setString(1, ms.getNome());
		ps.setString(2, ms.getDataNasc());
		ps.setString(3, ms.getParentesco());
		ps.setInt(4, ms.getId());
		ps.executeUpdate();

		return true;		
	
	} catch (SQLException e) {
		e.printStackTrace();

		return false;

	}	
	}

	@Override
	public boolean excluir(MoradorSecundario ms) {
		String sql = "DELETE FROM Morador_Secundario WHERE id=?;";

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
	public ResultSet encontrar(MoradorSecundario ms) {
		String sql = "SELECT * FROM Morador_Secundario WHERE id=? ;";

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
		String sql = "SELECT * FROM Morador_Secundario;";
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