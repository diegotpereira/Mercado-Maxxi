package Model.DAO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Control.Factory.Conex�o;
import Model.Produto;


public class ProdutoDAO {
	public static ResultSet importarProduto(long codigoBarra) {
		ResultSet rs;
		Conex�o c = new Conex�o();
		String sql = "select * from produto where codigoProduto=? and qtdEstoque>0;";
		PreparedStatement stmt;
		try {
			stmt = c.getCon().prepareStatement(sql);
			stmt.setLong(1, codigoBarra);
			rs = stmt.executeQuery();
		}catch (SQLException e) {
			System.out.println("Falha na conex�o ao seu servidor!");
			rs= null;
		}
		return rs;
	    }

	public static boolean cadastrarProduto(Produto produtoCadastro) {
		
		Conex�o c = new Conex�o(); 
		String sql="insert into produto values(?, ?, ?, ?)";
		PreparedStatement stmt;
		try {
			stmt = c.getCon().prepareStatement(sql);
			stmt.setLong(1, produtoCadastro.getCodigoProduto());	
			stmt.setString(2, produtoCadastro.getNomeProduto());
			stmt.setInt(3, produtoCadastro.getQtdEstoque());
			stmt.setDouble(4, produtoCadastro.getValorUnid());
			        
			stmt.execute();
		} catch (SQLException e) {
			return false;
		} 	 
		return true;	
		    
	}
}
