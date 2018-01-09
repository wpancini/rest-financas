package br.com.cwmconsultoria.entidade;

import java.sql.Date;

public class Lancamento {

	private int id;
	private int idtipoLacto;
	private int idmotivolancto;
	private String desctipolancto;
	private String descmotivolancto;
	private Date datalancto;
	private Date dataevento;
	private Double valorcredito;
	private Double valordebito;
	private String comentario;
	
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
	public Date getDataevento() {
		return dataevento;
	}
	public void setDataevento(Date dataevento) {
		this.dataevento = dataevento;
	}
	public int getIdmotivolancto() {
		return idmotivolancto;
	}
	public void setIdmotivolancto(int idmotivolancto) {
		this.idmotivolancto = idmotivolancto;
	}
	public Date getDatalancto() {
		return datalancto;
	}
	public void setDatalancto(Date datalancto) {
		this.datalancto = datalancto;
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
	
}
