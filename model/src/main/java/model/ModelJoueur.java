package model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Id;


@Entity
@Table(name = "joueur")
@PrimaryKeyJoinColumn(name = "JOU_ID", referencedColumnName = "UTI_ID")
public class ModelJoueur extends ModelUtilisateur {

	@OneToMany(mappedBy = "joueur")
	private List<ModelCoup> coup;
	
	@OneToMany(mappedBy="joueur")
	private List<ModelPartie> parties;

	public List<ModelCoup> getCoup() {
		return coup;
	}

	public void setCoup(List<ModelCoup> coup) {
		this.coup = coup;
	}

	public List<ModelPartie> getParties() {
		return parties;
	}

	public void setParties(List<ModelPartie> parties) {
		this.parties = parties;
	}

	public ModelJoueur() {
		super();
	}

}
