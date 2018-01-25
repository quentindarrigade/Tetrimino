package dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import model.ModelJoueur;

public interface IJoueurDAO extends JpaRepository< ModelJoueur, Integer> {


	@Query("select j from ModelJoueur j where j.login=:reference1 and j.password=:reference2")
	public ModelJoueur authJoueur(@Param("reference1") String ref1, @Param("reference2") String ref2);
	
}
