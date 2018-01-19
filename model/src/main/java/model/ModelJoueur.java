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

	public ModelJoueur() {
		super();
	}

}
