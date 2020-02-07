/**
 * 
 */
package br.com.erick.foibrinks.entidades;

import java.util.Calendar;

/**
 * * Classe criada para entidade de modelo do banco de dados para Cliente.
 * @author erick
 *
 */
public class Cliente {
	//Declara√ß√£o de Atributos
	private long codCliente;
	private String nome_Cliente = "N„o informado";
	private String estado_Civil = "N„o informado";
	private String genero = "N„o informado";
	private String rua = "N„o informado";
	private String bairro = "N„o informado";
	private String cep = "N„o informado";
	private String estado = "N„o informado";
	private String cidade = "N„o informado";
	private String cpf = "N„o informado";
	private Calendar dataNascimento;
	private Calendar dataCadastro;

	public long getCod_Cliente() {
		return codCliente;
	}

	public void setCod_Cliente(long cod_Cliente) {
		this.codCliente = cod_Cliente;
	}

	public String getNome_Cliente() {
		return nome_Cliente;
	}

	public void setNome_Cliente(String nome_Cliente) {
		this.nome_Cliente = nome_Cliente;
	}

	public String getEstado_Civil() {
		return estado_Civil;
	}

	public void setEstado_Civil(String estado_Civil) {
		this.estado_Civil = estado_Civil;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Calendar getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Calendar dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public Calendar getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Calendar dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

}
