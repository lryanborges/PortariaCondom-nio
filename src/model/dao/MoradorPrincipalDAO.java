package model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.entity.MoradorPrincipal;


public class MoradorPrincipalDAO extends ConexaoDAO implements BaseInterfaceDAO<MoradorPrincipal>{

	@Override
	public int criar(MoradorPrincipal mp) {

		String sql = "INSERT INTO Morador_Principal (nome, cpf, apartamento, bloco, categoria, rg, nascimento, email,"+
					" telefoneResidencial, telefoneComercial, celular, podeZap) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
		
		try {
			
			PreparedStatement ps = getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, mp.getNome());
			ps.setString(2, mp.getCpf());
			ps.setInt(3, mp.getApartamento());
			ps.setString(4, mp.getBloco());
			ps.setString(5, mp.getCategoria());
			ps.setString(6, mp.getRg());
			ps.setString(7, mp.getDataNasc());
			ps.setString(8, mp.getEmail());
			ps.setString(9, mp.getTelResidencial());
			ps.setString(10, mp.getTelComercial());
			ps.setString(11, mp.getTelCelular());
			ps.setBoolean(12, mp.isAutorizarZap());
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
	public boolean atualizar(MoradorPrincipal mp) { 
			String sql = "UPDATE Morador_Principal SET nome=?, cpf=?, apartamento=?, bloco=?, categoria=?, rg=?, nascimento=?,"+
					" email=?, telefoneResidencial=?, telefoneComercial=?, celular=?, podeZap=? WHERE id=?";

			try {
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setString(1, mp.getNome());
			ps.setString(2, mp.getCpf());
			ps.setInt(3, mp.getApartamento());
			ps.setString(4, mp.getBloco());
			ps.setString(5, mp.getCategoria());
			ps.setString(6, mp.getRg());
			ps.setString(7, mp.getDataNasc());
			ps.setString(8, mp.getEmail());
			ps.setString(9, mp.getTelResidencial());
			ps.setString(10, mp.getTelComercial());
			ps.setString(11, mp.getTelCelular());
			ps.setBoolean(12, mp.isAutorizarZap());
			ps.setInt(13, mp.getId());
			ps.executeUpdate();

			return true;		
		
		} catch (SQLException e) {
			e.printStackTrace();

			return false;

		}	
	}

	@Override
	public boolean excluir(MoradorPrincipal mp) {
		String sql = "DELETE FROM Morador_Principal WHERE id=?;";

		try {
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setInt(1, mp.getId());

			return ps.execute();

		} catch (SQLException e) {
			e.printStackTrace();

			return false;

		}
	}

	public ResultSet listar() {
		String sql = "SELECT * FROM Morador_Principal;";
		try {
			PreparedStatement pst = getConnection().prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			return rs;

		} catch (SQLException ex) {
			ex.printStackTrace();

			return null;
			
		}
	}
	
	public ResultSet encontrar(MoradorPrincipal mp){
        String sql = "SELECT * FROM Morador_Principal WHERE id=?;";

        try {
            PreparedStatement ps = getConnection().prepareStatement(sql);
            ps.setInt(1, mp.getId());
            
            ResultSet rs = ps.executeQuery();
            return rs;
        } catch(SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }

	@Override
	public ResultSet listarDados(MoradorPrincipal mp) {
		String sql = "SELECT * FROM Morador_Principal WHERE cpf=? OR nome=? OR apartamento=? OR bloco=?;";

        try {
            PreparedStatement ps = getConnection().prepareStatement(sql);
            ps.setString(1, mp.getCpf());
            ps.setString(2, mp.getNome());
            ps.setInt(3, mp.getApartamento());
            ps.setString(4,  mp.getBloco());

            ResultSet rs = ps.executeQuery();
            return rs;
        } catch(SQLException ex) {
            ex.printStackTrace();
            return null;
        }
	}
	
}
