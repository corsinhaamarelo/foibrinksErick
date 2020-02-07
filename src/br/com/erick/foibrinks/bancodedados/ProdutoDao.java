/**
 * 
 */
package br.com.erick.foibrinks.bancodedados;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.com.erick.foibrinks.entidades.Produto;

/**
 * @author erick
 * 
 */
public class ProdutoDao {
	private Connection conexao;

	public ProdutoDao() {
		conexao = new ConnectionFactory().getConnection();
	}

	public void AdicionaProduto(Produto produto) {
		String query = "INSERT INTO `produtos`(`codProduto`, `nome_produto`, "
				+ "`marcaProduto`, `faixaEtaria`, `alturaProduto`, "
				+ "`profundidadeProduto`, `pesoProduto`, "
				+ "`precoProduto`, `dataCadastro`, precoDesconto, volume, largura) VALUES "
				+ "(?,?,?,?,?,?,?,?,?,?,?,?)";
		try {
			PreparedStatement preparing = (PreparedStatement) conexao
					.prepareStatement(query);
			preparing.setLong(1, produto.getCodProduto());
			preparing.setString(2, produto.getNomeProduto());
			preparing.setString(3, produto.getMarcaProduto());
			preparing.setString(4, produto.getFaixaEtaria());
			preparing.setDouble(5, produto.getAlturaProduto());
			preparing.setDouble(6, produto.getProfundidadeProduto());
			preparing.setDouble(7, produto.getPesoProduto());
			preparing.setDouble(8, produto.getPrecoProduto());
			preparing.setDate(9, new Date(produto.getDataCadastro()
					.getTimeInMillis()));
			preparing.setDouble(10, produto.getPrecoComDesconto());
			preparing.setDouble(11, produto.getVolume());
			preparing.setDouble(12, produto.getLarguraProduto());
			preparing.execute();
			preparing.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void alteraProduto(Produto produto) {
		String query = "UPDATE produtos SET `nome_produto`=?,`marcaProduto`=?,`faixaEtaria`=?,`alturaProduto`=?,"
				+ "`profundidadeProduto`=?,`pesoProduto`=?,`precoProduto`=?, precoDesconto=?, volume=?, largura=? WHERE `codproduto`=?";
		try {
			PreparedStatement preparing = conexao.prepareStatement(query);
			preparing.setString(1, produto.getNomeProduto());
			preparing.setString(2, produto.getMarcaProduto());
			preparing.setString(3, produto.getFaixaEtaria());
			preparing.setDouble(4, produto.getAlturaProduto());
			preparing.setDouble(5, produto.getProfundidadeProduto());
			preparing.setDouble(6, produto.getPesoProduto());
			preparing.setDouble(7, produto.getPrecoProduto());
			preparing.setDouble(8, produto.getPrecoComDesconto());
			preparing.setDouble(9, produto.getVolume());
			preparing.setDouble(10, produto.getLarguraProduto());
			preparing.setLong(11, produto.getCodProduto());

			preparing.execute();
			preparing.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}

	public void excluirProduto(Produto produto) {
		try {
			java.sql.PreparedStatement stmt = conexao
					.prepareStatement("delete from produtos where codProduto=?");
			stmt.setLong(1, produto.getCodProduto());

			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public List<Produto> listar() {
		try {
			List<Produto> produtos = new ArrayList<Produto>();
			java.sql.PreparedStatement stmt = this.conexao
					.prepareStatement("SELECT * FROM `produtos`");

			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				// criando o objeto Produto
				Produto produto = new Produto();
				produto.setCodProduto(rs.getLong("codProduto"));
				produto.setNomeProduto(rs.getString("nome_produto"));
				produto.setMarcaProduto(rs.getString("marcaProduto"));
				produto.setFaixaEtaria(rs.getString("faixaEtaria"));
				produto.setAlturaProduto(rs.getDouble("alturaProduto"));
				produto.setProfundidadeProduto(rs
						.getDouble("profundidadeProduto"));
				produto.setPrecoProduto(rs.getDouble("precoProduto"));
				produto.setPesoProduto(rs.getDouble("pesoProduto"));
				produto.setLarguraProduto(rs.getDouble("largura"));

				// montando a data atravÃ©s do Calendar
				Calendar dataCadastro = Calendar.getInstance();
				dataCadastro.setTime(rs.getDate("dataCadastro"));
				produto.setDataCadastro(dataCadastro);

				produtos.add(produto);
			}
			rs.close();
			stmt.close();
			return produtos;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public Produto getProdutoById(String id) {
		Produto produto = new Produto();
		try {
			PreparedStatement preparing = conexao
					.prepareStatement("SELECT * FROM produtos WHERE codProduto = ?");
			preparing.setLong(1, Long.parseLong(id));
			ResultSet rs = preparing.executeQuery();
			while (rs.next()) {
				produto.setCodProduto(rs.getLong("codProduto"));
				produto.setNomeProduto(rs.getString("nome_produto"));
				produto.setMarcaProduto(rs.getString("marcaProduto"));
				produto.setFaixaEtaria(rs.getString("faixaEtaria"));
				produto.setProfundidadeProduto(rs
						.getDouble("profundidadeProduto"));
				produto.setPesoProduto(rs.getDouble("pesoProduto"));
				produto.setPrecoProduto(rs.getDouble("precoProduto"));
				produto.setLarguraProduto(rs.getDouble("largura"));
				// montando a data através do Calendar
				Calendar dataCadastro = Calendar.getInstance();
				dataCadastro.setTime(rs.getDate("dataCadastro"));
				produto.setDataCadastro(dataCadastro);
			}

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

		return produto;
	}

	public List<Produto> listarProdutosFrete() {
		try {
			List<Produto> produtos = new ArrayList<Produto>();
			java.sql.PreparedStatement stmt = this.conexao
					.prepareStatement("SELECT * FROM `produtos` order by produtos.volume desc");

			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				// criando o objeto Produto
				Produto produto = new Produto();
				produto.setNomeProduto(rs.getString("nome_produto"));
				produto.setFaixaEtaria(rs.getString("faixaEtaria"));
				produto.setPrecoProduto(rs.getDouble("precoProduto"));
				produto.setPrecoComDesconto(rs.getDouble("PrecoDesconto"));
				produto.setVolume(rs.getDouble("volume"));

				produtos.add(produto);
			}
			rs.close();
			stmt.close();
			return produtos;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public List<Produto> listaDesconto() {
		try {
			List<Produto> produtos = new ArrayList<Produto>();
			java.sql.PreparedStatement stmt = this.conexao
					.prepareStatement("SELECT * FROM produtos ORDER BY  precoDesconto DESC LIMIT 4;");

			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				// criando o objeto listarDesconto
				Produto produto = new Produto();
				produto.setNomeProduto(rs.getString("nome_produto"));
				produto.setPrecoProduto(rs.getDouble("precoProduto"));
				produto.setPesoProduto(rs.getDouble("pesoProduto"));
				produto.setPrecoComDesconto(rs.getDouble("precoDesconto"));
				produtos.add(produto);
			}
			rs.close();
			stmt.close();
			return produtos;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
