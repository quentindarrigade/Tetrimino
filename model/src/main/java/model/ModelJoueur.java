package model;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "joueur")
@PrimaryKeyJoinColumn(name = "JOU_ID", referencedColumnName = "UTI_ID")
public class ModelJoueur extends ModelUtilisateur {

}
