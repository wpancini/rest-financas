package br.com.cwmconsultoria.bd;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;

import br.com.cwmconsultoria.entidade.Lancamento;

public class LancamentoDAO {

	SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
	
	public void criarLancamento(Lancamento l) throws Exception {
		
		Connection conexao = DBConfig.getConnection();
		
		String sql = "INSERT INTO tb_lancamento` (`idTipoLacto`," + 
												"`idmotivolancto`," + 
												"`datalancto`," + 
												"`dataevento`," +
												"`valorcredito`," + 
												"`valordebito`," + 
												"`comentario," +
											    "`idlanctoparcelapai`,"+
												"`parcela`)" + 
												"VALUES(?,?,?,?,?,?,?,?,?);";
		
		PreparedStatement statement = conexao.prepareStatement(sql);
		statement.setInt(1, l.getIdtipoLacto());
		statement.setInt(2, l.getIdmotivolancto());
		statement.setDate(3, formataTextoData(l.getDatalancto()));
		statement.setDate(4,formataTextoData(l.getDataevento()));
		statement.setDouble(5, l.getValorcredito());
		statement.setDouble(6, l.getValordebito());
		statement.setString(7, l.getComentario());
		statement.setInt(8, l.getIdlanctoparcelapai());
		statement.setInt(9, l.getParcela());
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
			l.setDatalancto(formataDataTexto(rs.getDate("datalancto")));
			l.setDataevento(formataDataTexto(rs.getDate("dataevento")));
			l.setValorcredito(rs.getDouble("valorcredito")); 
			l.setValordebito(rs.getDouble("valordebito"));
			l.setComentario(rs.getString("comentario"));	
			l.setIdlanctoparcelapai(rs.getInt("idlanctoparcelapai"));
			l.setParcela(rs.getInt("parcela"));
			lista.add(l);
		}
		return lista;
	}
		 
	public void editarLancamento(Lancamento l) throws Exception{
	
			Connection conexao = DBConfig.getConnection();
			
			String sql = "UPDATE tb_lancamento SET idTipoLacto=?,idmotivolancto=?,datalancto=?,dataevento=?,valorcredito=?,valordebito=?,comentario=?,idlanctoparcelapai=?,parcela=? WHERE id=?";
			
			PreparedStatement statement = conexao.prepareStatement(sql);
			statement.setInt(1, l.getIdtipoLacto());
			statement.setInt(2, l.getIdmotivolancto());
			statement.setDate(3, Date.valueOf(l.getDatalancto()));
			statement.setDate(4,Date.valueOf(l.getDataevento()));
			statement.setDouble(5, l.getValorcredito());
			statement.setDouble(6, l.getValordebito());
			statement.setString(7,l.getComentario());
			statement.setInt(8, l.getId()); 
			statement.setInt(8, l.getIdlanctoparcelapai());
			statement.setInt(9, l.getParcela());
			statement.execute();
	}
	
	 public void excluirLancamento(Lancamento l) throws Exception{
			Connection conexao = DBConfig.getConnection();
			
			String sql = "DELETE FROM TB_LANCAMENTO WHERE ID = ?";
			
			PreparedStatement statement = conexao.prepareStatement(sql);
			statement.setInt(1, l.getId());
			statement.execute();
	}
	 // Converte uma texto no formato dd/mm/aaaa para uma Data
	 public Date formataTextoData(String data) throws Exception { 
		System.out.println("entrou na função formataTextoData");	
		 
		 if (data == null || data.equals(""))
				return null;
	        Date dataSQL = null;
	        try {   	
//	        Date sqlDate = new Date(data);  

	        } catch (ParseException e) {            
	            throw e;
	        }
	        System.out.println("saiu na função formataTextoData");
	        System.out.println(dataSQL.toString());
	        return dataSQL;
		}
	 // Converte uma Data em um texto no formato dd/mm/aaaa

	 public String formataDataTexto (Date dt) {
	
		SimpleDateFormat sdf = new SimpleDateFormat();
	
		sdf.applyPattern("dd/MM/yyyy");

		return sdf.format(dt);
		
	}
}
