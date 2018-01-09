package br.com.cwmconsultoria.servico;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.cwmconsultoria.bd.LancamentoDAO;
import br.com.cwmconsultoria.entidade.Lancamento;

public class LancamentoServico {

 private LancamentoDAO lDAO;
	
	private static final String CHARSET_UTF8 = ";charset=utf-8";
	
	@PostConstruct
	private void init() {
		lDAO = new LancamentoDAO();
	}
	
	@GET
	@Path("/")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Lancamento> ListarLancamentos(){
		List<Lancamento> lista = null;
		try {
			lista = lDAO.listarLancamentos();
		}catch (Exception e){
			e.printStackTrace();
		}
		return lista;
	}
	@POST
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON + CHARSET_UTF8)
	@Produces(MediaType.TEXT_PLAIN)
	public String criaLancamento(Lancamento ml) {
		
		String retorno = "";		
		
		try {
			lDAO.criarLancamento(ml);
			retorno = " Lançamento incluído com sucesso!";
		}catch (Exception e) {
			retorno = "Erro ao incluir  Lançamento!";
			e.printStackTrace();
		}
		return retorno;	
	}
	@PUT
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON + CHARSET_UTF8)
	@Produces(MediaType.TEXT_PLAIN)
	public String editarLancamento(Lancamento ml) {
		String retorno = "";	
		try {
			lDAO.editarLancamento(ml);
			retorno = " Lançamento editado com sucesso!";
		}catch (Exception e){
			retorno = "Erro ao editar  Lançamento!";
			e.printStackTrace();
		}
		return retorno;
	}
	@DELETE
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON + CHARSET_UTF8)
	@Produces(MediaType.TEXT_PLAIN)
	public String excluiLancamento (Lancamento ml) {
		String retorno = "";
		try {
			lDAO.excluirLancamento(ml);
			retorno = " Lançamento excluído com sucesso!";
		}catch (Exception e){
			retorno = "Erro ao excluir Lançamento!";
			e.printStackTrace();
		}
		return retorno;
	}	
	
}
