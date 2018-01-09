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

import br.com.cwmconsultoria.bd.TipoLancamentoDAO;
import br.com.cwmconsultoria.entidade.TipoLancamento;


@Path("/tipolancamento")
public class TipoLancamentoServico {

	private TipoLancamentoDAO tlDAO;
	
	private static final String CHARSET_UTF8 = ";charset=utf-8";
	
	@PostConstruct
	private void init() {
		tlDAO = new TipoLancamentoDAO();
			
	}
	
	@GET
	@Path("/")
	@Produces(MediaType.APPLICATION_JSON)
	public List<TipoLancamento> ListaTiposLancamento(){
		List<TipoLancamento> lista = null;
		try {
			lista = tlDAO.listarTiposLancamento();
		}catch (Exception e){
			e.printStackTrace();
		}
		return lista;
	}
	
	@POST
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON + CHARSET_UTF8)
	@Produces(MediaType.TEXT_PLAIN)
	public String criaTipoLancamento(TipoLancamento tl) {
		
		String retorno = "";		
		
		try {
			tlDAO.criarTipoLancamento(tl);
			retorno = "Tipo Lançamento incluído com sucesso!";
		}catch (Exception e) {
			retorno = "Erro ao incluir Tipo Lançamento!";
			e.printStackTrace();
		}
		return retorno;	
	}
	@PUT
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON + CHARSET_UTF8)
	@Produces(MediaType.TEXT_PLAIN)
	public String editarTipoLancamento(TipoLancamento tl) {
		String retorno = "";	
		try {
			tlDAO.editarTipoLancamento(tl);
			retorno = "Tipo Lançamento editado com sucesso!";
		}catch (Exception e){
			retorno = "Erro ao editar Tipo Lançamento!";
			e.printStackTrace();
		}
		return retorno;
	}
	@DELETE
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON + CHARSET_UTF8)
	@Produces(MediaType.TEXT_PLAIN)
	public String excluiTipoLancamento (TipoLancamento tl) {
		String retorno = "";
		try {
			tlDAO.excluirTipoLancamento(tl);
			retorno = "Tipo Lançamento excluído com sucesso!";
		}catch (Exception e){
			retorno = "Erro ao excluir Tipo Lançamento!";
			e.printStackTrace();
		}
		return retorno;
	}
}
