package br.com.erick.foibrinks.bancodedados;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.com.erick.foibrinks.entidades.Cliente;

public class ClienteDao {
	private Connection conexao;

	public ClienteDao() {
		conexao = new ConnectionFactory().getConnection();
	}

	public void AdicionaCliente(Cliente cliente) {
		String query = "INSERT INTO `clientes`(`nome_Cliente`, `estado_Civil`, " + "`genero`, `rua`, `bairro`, "
				+ "`cep`, `estado`, " + "`cidade`, `cpf`, `dataNascimento`, `dataCadastro`) VALUES "
				+ "(?,?,?,?,?,?,?,?,?,?,?)";
		try {
			PreparedStatement preparing = conexao.prepareStatement(query);
			preparing.setString(1, cliente.getNome_Cliente());
			preparing.setString(2, cliente.getEstado_Civil());
			preparing.setString(3, cliente.getGenero());
			preparing.setString(4, cliente.getRua());
			preparing.setString(5, cliente.getBairro());
			preparing.setString(6, cliente.getCep());
			preparing.setString(7, cliente.getEstado());
			preparing.setString(8, cliente.getCidade());
			preparing.setString(9, cliente.getCpf());
			preparing.setDate(10, new Date(cliente.getDataNascimento().getTimeInMillis()));
			preparing.setDate(11, new Date(cliente.getDataCadastro().getTimeInMillis()));

			preparing.execute();
			preparing.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void alteraCliente(Cliente cliente) {
		String query = "UPDATE `clientes` SET ,`nome_Cliente`=?,`estado_Civil`=?,`genero`=?,`rua`=?,"
				+ "`bairro`=?,`cep`=?,`estado`=?,`cidade`=?,`cpf`=?,`dataNascimento`=?,`dataCadastro`=?"
				+ " WHERE `codCliente`=?";
		try {
			PreparedStatement preparing = conexao.prepareStatement(query);
			preparing.setString(1, cliente.getNome_Cliente());
			preparing.setString(2, cliente.getEstado_Civil());
			preparing.setString(3, cliente.getGenero());
			preparing.setString(4, cliente.getRua());
			preparing.setString(5, cliente.getBairro());
			preparing.setString(6, cliente.getCep());
			preparing.setString(7, cliente.getEstado());
			preparing.setString(8, cliente.getCidade());
			preparing.setString(9, cliente.getCpf());
			preparing.setDate(10, new Date(cliente.getDataNascimento().getTimeInMillis()));
			preparing.setDate(11, new Date(cliente.getDataCadastro().getTimeInMillis()));
			preparing.setLong(12, cliente.getCod_Cliente());

			preparing.execute();
			preparing.close();

		} catch (SQLException e) {
			// TODO: handle exception
		}

	}

	public void excluirCliente(Cliente cliente) {
		try {
			PreparedStatement stmt = conexao.prepareStatement("delete from clientes where codCliente=?");
			stmt.setLong(1, cliente.getCod_Cliente());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public List<Cliente> listar() {
		try {
			List<Cliente> clientes = new ArrayList<Cliente>();
			PreparedStatement stmt = this.conexao.prepareStatement("SELECT * FROM `clientes`");

			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				// criando o objeto Cliente
				Cliente cliente = new Cliente();
				cliente.setCod_Cliente(rs.getLong("codCliente"));
				cliente.setNome_Cliente(rs.getString("nome_Cliente"));
				cliente.setEstado_Civil(rs.getString("estado_Civil"));
				cliente.setGenero(rs.getString("genero"));
				cliente.setRua(rs.getString("rua"));
				cliente.setBairro(rs.getString("bairro"));
				cliente.setCep(rs.getString("cep"));
				cliente.setEstado(rs.getString("estado"));
				cliente.setCidade(rs.getString("cidade"));
				cliente.setCpf(rs.getString("cpf"));

				// montando a data através do Calendar
				Calendar dataNascimento = Calendar.getInstance();
				Calendar dataCadastro = Calendar.getInstance();
				dataNascimento.setTime(rs.getDate("dataNascimento"));
				dataCadastro.setTime(rs.getDate("dataCadastro"));

				cliente.setDataNascimento(dataNascimento);
				cliente.setDataCadastro(dataCadastro);

				clientes.add(cliente);
			}
			rs.close();
			stmt.close();
			return clientes;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public Cliente getClienteById(String id) {
		Cliente cliente = new Cliente();
		try {
			PreparedStatement preparing = conexao.prepareStatement("SELECT * FROM clientes WHERE codCliente = ?");
			preparing.setLong(1, Long.parseLong(id));
			ResultSet rs = preparing.executeQuery();
			while (rs.next()) {
				cliente.setCod_Cliente(rs.getLong("codCliente"));
				cliente.setNome_Cliente(rs.getString("nome_Cliente"));
				cliente.setEstado_Civil(rs.getString("estado_Civil"));
				cliente.setGenero(rs.getString("genero"));
				cliente.setRua(rs.getString("rua"));
				cliente.setBairro(rs.getString("bairro"));
				cliente.setCep(rs.getString("cep"));
				cliente.setEstado(rs.getString("estado"));
				cliente.setCidade(rs.getString("cidade"));
				cliente.setCpf(rs.getString("cpf"));

				// montando a data através do Calendar
				Calendar dataNascimento = Calendar.getInstance();
				Calendar dataCadastro = Calendar.getInstance();
				dataNascimento.setTime(rs.getDate("dataNascimento"));
				dataCadastro.setTime(rs.getDate("dataCadastro"));

				cliente.setDataNascimento(dataNascimento);
				cliente.setDataCadastro(dataCadastro);
			}

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

		return cliente;
	}
	public List<Cliente> buscarAniversariantesDoMes(String mes) {
		try {
			List<Cliente> clientes = new ArrayList<Cliente>();
			PreparedStatement stmt = this.conexao.prepareStatement("SELECT * FROM clientes WHERE MONTH(clientes.dataNascimento) = ?");
			stmt.setString(1, mes);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				// criando o objeto Cliente
				Cliente cliente = new Cliente();
				cliente.setCod_Cliente(rs.getLong("codCliente"));
				cliente.setNome_Cliente(rs.getString("nome_Cliente"));
				cliente.setEstado_Civil(rs.getString("estado_Civil"));
				cliente.setGenero(rs.getString("genero"));
				cliente.setRua(rs.getString("rua"));
				cliente.setBairro(rs.getString("bairro"));
				cliente.setCep(rs.getString("cep"));
				cliente.setEstado(rs.getString("estado"));
				cliente.setCidade(rs.getString("cidade"));
				cliente.setCpf(rs.getString("cpf"));

				// montando a data através do Calendar
				Calendar dataNascimento = Calendar.getInstance();
				Calendar dataCadastro = Calendar.getInstance();
				dataNascimento.setTime(rs.getDate("dataNascimento"));
				dataCadastro.setTime(rs.getDate("dataCadastro"));

				cliente.setDataNascimento(dataNascimento);
				cliente.setDataCadastro(dataCadastro);

				clientes.add(cliente);
			}
			rs.close();
			stmt.close();
			return clientes;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	public List<Cliente> buscarNovatos(String mes, String ano) {
		try {
			List<Cliente> clientes = new ArrayList<Cliente>();
			PreparedStatement stmt = this.conexao.prepareStatement("SELECT * FROM clientes WHERE MONTH(clientes.dataCadastro) = ? AND YEAR(clientes.dataCadastro) = ?");
			stmt.setString(1, mes);
			stmt.setString(2, ano);

			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				// criando o objeto Cliente
				Cliente cliente = new Cliente();
				cliente.setCod_Cliente(rs.getLong("codCliente"));
				cliente.setNome_Cliente(rs.getString("nome_Cliente"));
				cliente.setEstado_Civil(rs.getString("estado_Civil"));
				cliente.setGenero(rs.getString("genero"));
				cliente.setRua(rs.getString("rua"));
				cliente.setBairro(rs.getString("bairro"));
				cliente.setCep(rs.getString("cep"));
				cliente.setEstado(rs.getString("estado"));
				cliente.setCidade(rs.getString("cidade"));
				cliente.setCpf(rs.getString("cpf"));

				// montando a data através do Calendar
				Calendar dataNascimento = Calendar.getInstance();
				Calendar dataCadastro = Calendar.getInstance();
				dataNascimento.setTime(rs.getDate("dataNascimento"));
				dataCadastro.setTime(rs.getDate("dataCadastro"));

				cliente.setDataNascimento(dataNascimento);
				cliente.setDataCadastro(dataCadastro);

				clientes.add(cliente);
			}
			rs.close();
			stmt.close();
			return clientes;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}