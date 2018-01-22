package model;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "model_tetrimino")
public class ModelTetrimino implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "TETRI_ID")
	private int id;

	@Column(name = "TETRI_NOM")
	private String nom;

	@Column(name = "TETRI_COULEUR")
	private String couleur;

	@Column(name = "TETRI_00")
	private String Tetrimino00;

	@Column(name = "TETRI_90")
	private String Tetrimino90;

	@Column(name = "TETRI_180")
	private String Tetrimino180;

	@Column(name = "TETRI_270")
	private String Tetrimino270;

	@Column(name = "TETRI_TAILLE")
	private int taille;

	@ManyToOne
	@JoinColumn(name = "TETRI_ADMIN_ID")
	private ModelAdmin admin;

	@OneToMany(mappedBy = "piece")
	private List<ModelCoup> coups;

	public ModelTetrimino(String Tetrimino00) {

	}

	public ModelTetrimino() {

	}

	// @Column(name="TETRI_COMPO")
	// private String compo;
	//
	// public String getCompo() {
	// return compo;
	// }
	//
	// public void setCompo(String compo) {
	// this.compo = compo;
	// }

	public ModelAdmin getAdmin() {
		return admin;
	}

	public void setAdmin(ModelAdmin admin) {
		this.admin = admin;
	}

	public List<ModelCoup> getCoups() {
		return coups;
	}

	public void setCoups(List<ModelCoup> coups) {
		this.coups = coups;
	}

	public int getTaille() {
		return taille;
	}

	public void setTaille(int taille) {
		this.taille = taille;
	}

	public void ModelTetrimino() {

	}

	public void Rotation(String str) {
		String reponse = "";
		String[] t1 = str.split("/");
		int hauteur = t1.length;
		int largeur = t1[0].split(",").length;
		String[][] l2 = new String[hauteur][largeur];
		for (int i = 0; i < hauteur; i++) {
			String[] t = t1[i].split(",");
			for (int j = 0; j < largeur; j++) {
				l2[i][j] = t[j];
			}
		}

		for (int i = 0; i < largeur; i++) {
			for (int j = 0; j < hauteur; j++) {
				reponse = reponse + l2[hauteur - j - 1][i] + ",";
			}
			reponse += "/";
		}

	}

	public String getTetrimino00() {
		return Tetrimino00;
	}

	public void setTetrimino00(String tetrimino00) {
		this.Tetrimino00 = tetrimino00;
	}

	public String getTetrimino90() {
		return Tetrimino90;
	}

	public void setTetrimino90(String tetrimino90) {
		Tetrimino90 = tetrimino90;
	}

	public String getTetrimino180() {
		return Tetrimino180;
	}

	public void setTetrimino180(String tetrimino180) {
		Tetrimino180 = tetrimino180;
	}

	public String getTetrimino270() {
		return Tetrimino270;
	}

	public void setTetrimino270(String tetrimino270) {
		Tetrimino270 = tetrimino270;
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
