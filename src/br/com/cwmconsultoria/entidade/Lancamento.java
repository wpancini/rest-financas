package br.com.cwmconsultoria.entidade;


public class Lancamento {

	private int id;
	private int idtipoLacto;
	private int idmotivolancto;
	private String desctipolancto;
	private String descmotivolancto;
	private String datalancto;
	private String dataevento;
	private Double valorcredito;
	private Double valordebito;
	private String comentario;
	private int idlanctoparcelapai;
	private int parcela;

	public String getDatalancto() {
		return datalancto;
	}
	public void setDatalancto(String datalancto) {
		this.datalancto = datalancto;
	}
	public String getDataevento() {
		return dataevento;
	}
	public void setDataevento(String dataevento) {
		this.dataevento = dataevento;
	}	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getIdtipoLacto() {
		return idtipoLacto;
	}
	public void setIdtipoLacto(int idtipoLacto) {
		this.idtipoLacto = idtipoLacto;
	}
	public int getIdmotivolancto() {
		return idmotivolancto;
	}
	public void setIdmotivolancto(int idmotivolancto) {
		this.idmotivolancto = idmotivolancto;
	}
	public Double getValorcredito() {
		return valorcredito;
	}
	public void setValorcredito(Double valorcredito) {
		this.valorcredito = valorcredito;
	}
	public Double getValordebito() {
		return valordebito;
	}
	public void setValordebito(Double valordebito) {
		this.valordebito = valordebito;
	}
	public String getComentario() {
		return comentario;
	}
	public void setComentario(String comentario) {
		this.comentario = comentario;
	}
	public String getDesctipolancto() {
		return desctipolancto;
	}
	public void setDesctipolancto(String desctipolancto) {
		this.desctipolancto = desctipolancto;
	}
	public String getDescmotivolancto() {
		return descmotivolancto;
	}
	public void setDescmotivolancto(String descmotivolancto) {
		this.descmotivolancto = descmotivolancto;
	}
	public int getIdlanctoparcelapai() {
		return idlanctoparcelapai;
	}
	public void setIdlanctoparcelapai(int idlanctoparcelapai) {
		this.idlanctoparcelapai = idlanctoparcelapai;
	}
	public int getParcela() {
		return parcela;
	}
	public void setParcela(int parcela) {
		this.parcela = parcela;
	}
	
}
