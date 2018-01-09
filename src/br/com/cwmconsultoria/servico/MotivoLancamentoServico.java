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

import br.com.cwmconsultoria.bd.MotivoLancamentoDAO;
import br.com.cwmconsultoria.entidade.MotivoLancamento;

@Path("/motivolancamento")
public class MotivoLancamentoServico {

private MotivoLancamentoDAO mlDAO;
	
	private static final String CHARSET_UTF8 = ";charset=utf-8";
	
	@PostConstruct
	private void init() {
		mlDAO = new MotivoLancamentoDAO();
	}
	
	@GET
	@Path("/")
	@Produces(MediaType.APPLICATION_JSON)
	public List<MotivoLancamento> ListaMotivosLancamento(){
		List<MotivoLancamento> lista = null;
		try {
			lista = mlDAO.listarMotivosLancamento();
		}catch (Exception e){
			e.printStackTrace();
		}
		return lista;
	}
	@POST
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON + CHARSET_UTF8)
	@Produces(MediaType.TEXT_PLAIN)
	public String criaMotivoLancamento(MotivoLancamento ml) {
		
		String retorno = "";		
		
		try {
			mlDAO.criarMotivoLancamento(ml);
			retorno = "Motivo Lançamento incluído com sucesso!";
		}catch (Exception e) {
			retorno = "Erro ao incluir Motivo Lançamento!";
			e.printStackTrace();
		}
		return retorno;	
	}
	@PUT
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON + CHARSET_UTF8)
	@Produces(MediaType.TEXT_PLAIN)
	public String editarMotivoLancamento(MotivoLancamento ml) {
		String retorno = "";	
		try {
			mlDAO.editarMotivoLancamento(ml);
			retorno = "Motivo Lançamento editado com sucesso!";
		}catch (Exception e){
			retorno = "Erro ao editar Motivo Lançamento!";
			e.printStackTrace();
		}
		return retorno;
	}
	@DELETE
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON + CHARSET_UTF8)
	@Produces(MediaType.TEXT_PLAIN)
	public String excluiMotivoLancamento (MotivoLancamento ml) {
		String retorno = "";
		try {
			mlDAO.excluirMotivoLancamento(ml);
			retorno = "Motivo Lançamento excluído com sucesso!";
		}catch (Exception e){
			retorno = "Erro ao excluir Motivo Lançamento!";
			e.printStackTrace();
		}
		return retorno;
	}

}
