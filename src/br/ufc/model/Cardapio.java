package br.ufc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name = "cardapio")
public class Cardapio {

	@Id
	@GeneratedValue
	private Long id;

	//0 = almoco, 1 = jantar
	@Column(name = "tipo")
	private int tipo;

	//data eh o dia da semana, domingo = 1 ... 7
	@Column(name = "data")
	private int data;

	@Column(name = "principal")
	private String principal;

	@Column(name = "vegetariano")
	private String vegetariano;

	@Column(name = "acompanhamento")
	private String acompanhamento;

	@Column(name = "guarnicao")
	private String guarnicao;

	@Column(name = "sobremesa")
	private String sobremesa;

	@Column(name = "suco")
	private String suco;

	@Column(name = "fruta")
	private String fruta;

	public int getTipo() {
		return tipo;
	}

	public int getData() {
		return data;
	}

	public String getPrincipal() {
		return principal;
	}

	public String getVegetariano() {
		return vegetariano;
	}

	public String getAcompanhamento() {
		return acompanhamento;
	}

	public String getGuarnicao() {
		return guarnicao;
	}

	public String getSobremesa() {
		return sobremesa;
	}

	public String getSuco() {
		return suco;
	}

	public String getFruta() {
		return fruta;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}

	public void setData(int data) {
		this.data = data;
	}

	public void setPrincipal(String principal) {
		this.principal = principal;
	}

	public void setVegetariano(String vegetariano) {
		this.vegetariano = vegetariano;
	}

	public void setAcompanhamento(String acompanhamento) {
		this.acompanhamento = acompanhamento;
	}

	public void setGuarnicao(String guarnicao) {
		this.guarnicao = guarnicao;
	}

	public void setSobremesa(String sobremesa) {
		this.sobremesa = sobremesa;
	}

	public void setSuco(String suco) {
		this.suco = suco;
	}

	public void setFruta(String fruta) {
		this.fruta = fruta;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	
}
