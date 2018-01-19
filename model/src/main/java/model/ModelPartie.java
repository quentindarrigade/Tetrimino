package model;

import java.io.Serializable;
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
@Table(name="partie")
public class ModelPartie implements Serializable {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="PARTIE_ID")
	private int id;
	
	@OneToMany(mappedBy="partie")
	private List<ModelCoup> coups;
	
	@ManyToOne
	@JoinColumn(name="PARTIE_JOUEUR_ID")
	private ModelJoueur joueur;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<ModelCoup> getCoups() {
		return coups;
	}

	public void setCoups(List<ModelCoup> coups) {
		this.coups = coups;
	}

	public ModelJoueur getJoueur() {
		return joueur;
	}

	public void setJoueur(ModelJoueur joueur) {
		this.joueur = joueur;
	}
}
