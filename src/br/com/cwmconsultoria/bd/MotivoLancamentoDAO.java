package br.com.cwmconsultoria.bd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.cwmconsultoria.bd.DBConfig;
import br.com.cwmconsultoria.entidade.MotivoLancamento;


public class MotivoLancamentoDAO {

	public void criarMotivoLancamento(MotivoLancamento ml) throws Exception{
		
		Connection conexao = DBConfig.getConnection();
		
		String sql = "INSERT INTO TB_MOTIVOLANCAMENTO (descricao) VALUES (?)";
		
		PreparedStatement statement = conexao.prepareStatement(sql);
		statement.setString(1, ml.getDescricao());
		statement.execute();
	}

	public List<MotivoLancamento> listarMotivosLancamento() throws Exception{
		List<MotivoLancamento> lista = new ArrayList<>();
		
		Connection conexao = DBConfig.getConnection();
		String sql = "SELECT * FROM TB_MOTIVOLANCAMENTO";
		
		PreparedStatement statement = conexao.prepareStatement(sql);
		ResultSet rs = statement.executeQuery();
		
		while(rs.next()) {
			MotivoLancamento ml = new MotivoLancamento();
			
			ml.setId(rs.getInt("id"));
			ml.setDescricao(rs.getString("descricao"));
			
			lista.add(ml);
		}
		return lista;
	}
	public void editarMotivoLancamento(MotivoLancamento ml) throws Exception{
		
		Connection conexao = DBConfig.getConnection();
		
		String sql = "UPDATE TB_MOTIVOLANCAMENTO SET DESCRICAO = ? WHERE ID = ?";
		
		PreparedStatement statement = conexao.prepareStatement(sql);
		statement.setString(1, ml.getDescricao());
		statement.setInt(2, ml.getId());
		statement.execute();
	}
	public void excluirMotivoLancamento(MotivoLancamento ml) throws Exception{
		Connection conexao = DBConfig.getConnection();
		
		String sql = "DELETE FROM TB_MOTIVOLANCAMENTO WHERE ID = ?";
		
		PreparedStatement statement = conexao.prepareStatement(sql);
		statement.setInt(1, ml.getId());
		statement.execute();
	}

}
