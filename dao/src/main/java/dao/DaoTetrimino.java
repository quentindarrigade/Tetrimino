package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import model.ModelTetrimino;

@Repository
public class DaoTetrimino {

	@Autowired
	private DataSource datasource;
	
	
	
	public java.sql.Connection getConn() {
		try {
			return this.datasource.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
	}
	
	public ModelTetrimino getPieceById(int id ) {
		ModelTetrimino mt = new ModelTetrimino();
		try {
			ResultSet rs= datasource.getConnection().createStatement().executeQuery("SELECT * FROM tetrimino WHERE id ="+id);
			rs.next();
			mt.setId(id);
			mt.setNom(rs.getString(2));
			mt.setCouleur(rs.getString(3));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mt;
		
		
	}
	
	public ArrayList<ModelTetrimino> getAllPiece() {
		
		ArrayList<ModelTetrimino> a = new ArrayList<ModelTetrimino>();
		
		try {
			ResultSet rs = datasource.getConnection().createStatement().executeQuery("select * from tetrimino");
			while(rs.next()) {
				ModelTetrimino mt = new ModelTetrimino();
				mt.setId(rs.getInt(1));
				mt.setNom(rs.getString(2));
				mt.setCouleur(rs.getString(3));
				a.add(mt);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 	a;
		
	}
	
	public void ajouterPiece(ModelTetrimino mt) {
		try {
			datasource.getConnection().createStatement().executeUpdate("INSERT INTO tetrimino(nom, couleur) VALUES ('" + mt.getNom() + "','" + mt.getCouleur() + "')" );
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
