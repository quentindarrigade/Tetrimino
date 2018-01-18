package model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="model_tetrimino")
public class ModelTetrimino {
	
	private int id;
	private String nom;
	private String couleur;
	
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
