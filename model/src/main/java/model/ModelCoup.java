package model;

import java.io.Serializable;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table(name="coup")
@Cacheable
@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
public class ModelCoup implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="COUP_ID")
	private int id;
	
	@ManyToOne
	@JoinColumn(name="COUP_TETRI_ID")
	private ModelTetrimino piece;
	
	@ManyToOne
	@JoinColumn(name="COUP_JOUEUR_ID")
	private ModelJoueur joueur;
	
	@ManyToOne
	@JoinColumn(name="COUP_PARTIE_ID")
	private ModelPartie partie;

	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public ModelTetrimino getPiece() {
		return piece;
	}

	public void setPiece(ModelTetrimino piece) {
		this.piece = piece;
	}

	public ModelJoueur getJoueur() {
		return joueur;
	}

	public void setJoueur(ModelJoueur joueur) {
		this.joueur = joueur;
	}

	public ModelPartie getPartie() {
		return partie;
	}

	public void setPartie(ModelPartie partie) {
		this.partie = partie;
	}

	
}
