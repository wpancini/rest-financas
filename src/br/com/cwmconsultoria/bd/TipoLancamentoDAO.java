package br.com.cwmconsultoria.bd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.cwmconsultoria.entidade.TipoLancamento;
import br.com.cwmconsultoria.bd.DBConfig;

public class TipoLancamentoDAO {

	public void criarTipoLancamento(TipoLancamento tl) throws Exception{
		
		Connection conexao = DBConfig.getConnection();
		
		String sql = "INSERT INTO TB_TIPOLANCAMENTO (descricao, debitocredito) VALUES (?,?)";
		
		PreparedStatement statement = conexao.prepareStatement(sql);
		statement.setString(1, tl.getDescricao());
		statement.setString(2, tl.getDebitocredito());
		statement.execute();
	}

	public List<TipoLancamento> listarTiposLancamento() throws Exception{
		List<TipoLancamento> lista = new ArrayList<>();
		
		Connection conexao = DBConfig.getConnection();
		String sql = "SELECT * FROM TB_TIPOLANCAMENTO";
		
		PreparedStatement statement = conexao.prepareStatement(sql);
		ResultSet rs = statement.executeQuery();
		
		while(rs.next()) {
			TipoLancamento tl = new TipoLancamento();
			
			tl.setId(rs.getInt("id"));
			tl.setDescricao(rs.getString("descricao"));
			tl.setDebitocredito(rs.getString("debitocredito"));
			
			lista.add(tl);
		}
		return lista;
	}
	public void editarTipoLancamento(TipoLancamento tl) throws Exception{
		
		Connection conexao = DBConfig.getConnection();
		
		String sql = "UPDATE TB_TIPOLANCAMENTO SET DESCRICAO = ? , DEBITOCREDITO = ? WHERE ID = ?";
		
		PreparedStatement statement = conexao.prepareStatement(sql);
		statement.setString(1, tl.getDescricao());
		statement.setString(2, tl.getDebitocredito());
		statement.setInt(3, tl.getId());
		statement.execute();
	}
	public void excluirTipoLancamento(TipoLancamento tl) throws Exception{
		Connection conexao = DBConfig.getConnection();
		
		String sql = "DELETE FROM TB_TIPOLANCAMENTO WHERE ID = ?";
		
		PreparedStatement statement = conexao.prepareStatement(sql);
		statement.setInt(1, tl.getId());
		statement.execute();
	}
}
