package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="coup")
public class ModelCoup {
	
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

	@ManyToOne
	@JoinColumn(name="COU_ADM_ID")
	private ModelAdmin admin;
}
