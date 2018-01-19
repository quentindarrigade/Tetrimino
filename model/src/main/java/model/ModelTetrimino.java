package model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="model_tetrimino")
public class ModelTetrimino implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="TETRI_ID")
	private int id;
	
	
	@Column(name="TETRI_NOM")
	private String nom;
	
	@Column(name="TETRI_COULEUR")
	private String couleur;
	
	@Column(name="TETRI_TAILLE")
	private String taille;
	
	public void ModelTetrimino() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getCouleur() {
		return couleur;
	}

	public void setCouleur(String couleur) {
		this.couleur = couleur;
	}

	
	public String toString() {
		return "ModelTetrimino [id=" + id + ", nom=" + nom + ", couleur=" + couleur + "]";
	}
	
	

}
