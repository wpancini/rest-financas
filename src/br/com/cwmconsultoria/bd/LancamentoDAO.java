package br.com.cwmconsultoria.bd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.cwmconsultoria.entidade.Lancamento;

public class LancamentoDAO {

	
	public void criarLancamento(Lancamento l) throws Exception {
		
		Connection conexao = DBConfig.getConnection();
		
		String sql = "INSERT INTO tb_lancamento` (`idTipoLacto`," + 
												"`idmotivolancto`," + 
												"`datalancto`," + 
												"`dataevento`," +
												"`valorcredito`," + 
												"`valordebito`," + 
												"`comentario`)" + 
												"VALUES(?,?,?,?,?,?,?);";
		
		PreparedStatement statement = conexao.prepareStatement(sql);
		statement.setInt(1, l.getIdtipoLacto());
		statement.setInt(2, l.getIdmotivolancto());
		statement.setDate(3, l.getDatalancto());
		statement.setDate(4,l.getDataevento());
		statement.setDouble(5, l.getValorcredito());
		statement.setDouble(6, l.getValordebito());
		statement.setString(7, l.getComentario());
		statement.execute();
		
	}
	public List<Lancamento> listarLancamentos() throws Exception{
		List<Lancamento> lista = new ArrayList<>();
		
		Connection conexao = DBConfig.getConnection();
		String sql = "SELECT * FROM TB_LANCAMENTO";
		
		PreparedStatement statement = conexao.prepareStatement(sql);
		ResultSet rs = statement.executeQuery();
		
		while(rs.next()) {
			Lancamento l = new Lancamento();
			
			l.setId(rs.getInt("id"));
			l.setIdtipoLacto(rs.getInt("idTipoLacto")); 
			l.setIdmotivolancto(rs.getInt("idmotivolancto")); 
			l.setDatalancto(rs.getDate("datalancto"));
			l.setDataevento(rs.getDate("dataevento"));
			l.setValorcredito(rs.getDouble("valorcredito")); 
			l.setValordebito(rs.getDouble("valordebito"));
			l.setComentario(rs.getString("comentario"));	
			
			lista.add(l);
		}
		return lista;
	}
		 
	public void editarLancamento(Lancamento l) throws Exception{
	
			Connection conexao = DBConfig.getConnection();
			
			String sql = "UPDATE tb_lancamento SET idTipoLacto=?,idmotivolancto=?,datalancto=?,dataevento=?,valorcredito=?,valordebito=?,comentario=? WHERE id=?";
			
			PreparedStatement statement = conexao.prepareStatement(sql);
			statement.setInt(1, l.getIdtipoLacto());
			statement.setInt(2, l.getIdmotivolancto());
			statement.setDate(3, l.getDatalancto());
			statement.setDate(4, l.getDataevento());
			statement.setDouble(5, l.getValorcredito());
			statement.setDouble(6, l.getValordebito());
			statement.setString(7,l.getComentario());
			statement.setInt(8, l.getId()); 
			statement.execute();
	}
	
	 public void excluirLancamento(Lancamento l) throws Exception{
			Connection conexao = DBConfig.getConnection();
			
			String sql = "DELETE FROM TB_LANCAMENTO WHERE ID = ?";
			
			PreparedStatement statement = conexao.prepareStatement(sql);
			statement.setInt(1, l.getId());
			statement.execute();
	}
		 
}
