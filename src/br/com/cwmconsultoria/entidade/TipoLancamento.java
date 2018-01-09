package br.com.cwmconsultoria.entidade;

public class TipoLancamento {

	private int id;
	private String descricao;
	private String debitocredito;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getDebitocredito() {
		return debitocredito;
	}
	public void setDebitocredito(String debitocredito) {
		this.debitocredito = debitocredito;
	}
	
}
