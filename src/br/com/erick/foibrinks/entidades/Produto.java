/**
 * 
 */
package br.com.erick.foibrinks.entidades;

import java.util.Calendar;

/**
 * Classe criada para entidade de modelo do banco de dados para Produtos.
 * 
 * @author erick
 * 
 */
public class Produto {
	// Declaracao de Atributos
	private long codProduto;
	private String nomeProduto = "Não informado";
	private String marcaProduto = "Não informado";
	private String faixaEtaria = "Não informado";
	private double alturaProduto;
	private double profundidadeProduto;
	private double pesoProduto;
	private double precoProduto;
	private Calendar dataCadastro;
	private double PrecoComDesconto;
	private double volume;
	private double larguraProduto;

	public double getLarguraProduto() {
		return larguraProduto;
	}

	public void setLarguraProduto(double larguraProduto) {
		this.larguraProduto = larguraProduto;
	}

	public double getVolume() {
		return alturaProduto * profundidadeProduto * larguraProduto;
	}

	public void setVolume(double volume) {
		this.volume = volume;
	}

	public long getCodProduto() {
		return codProduto;
	}

	public void setCodProduto(long codProduto) {
		this.codProduto = codProduto;
	}

	public String getNomeProduto() {
		return nomeProduto;
	}

	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}

	public String getMarcaProduto() {
		return marcaProduto;
	}

	public void setMarcaProduto(String marcaProduto) {
		this.marcaProduto = marcaProduto;
	}

	public String getFaixaEtaria() {
		return faixaEtaria;
	}

	public void setFaixaEtaria(String faixaEtaria) {
		this.faixaEtaria = faixaEtaria;
	}

	public double getAlturaProduto() {
		return alturaProduto;
	}

	public void setAlturaProduto(double alturaProduto) {
		this.alturaProduto = alturaProduto;
	}

	public double getProfundidadeProduto() {
		return profundidadeProduto;
	}

	public void setProfundidadeProduto(double profundidadeProduto) {
		this.profundidadeProduto = profundidadeProduto;
	}

	public double getPesoProduto() {
		return pesoProduto;
	}

	public void setPesoProduto(double pesoProduto) {
		this.pesoProduto = pesoProduto;
	}

	public double getPrecoProduto() {
		return precoProduto;
	}

	public void setPrecoProduto(double precoProduto) {
		this.precoProduto = precoProduto;
	}

	public Calendar getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Calendar dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public double getPrecoComDesconto() {
		double porcentagem = 3.018735;
		double resultado; 
		resultado = (this.precoProduto) * (1 - (porcentagem/100));
		return resultado;
	}

	public void setPrecoComDesconto(double precoComDesconto) {
		PrecoComDesconto = precoComDesconto;
	}
	public double cauculaFreteLua() {
		return 123456.00 * volume;
	}
}