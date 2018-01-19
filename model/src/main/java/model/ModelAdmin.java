package model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "admin")
@PrimaryKeyJoinColumn(name = "ADM_ID", referencedColumnName = "UTI_ID")
public class ModelAdmin extends ModelUtilisateur {

	@OneToMany(mappedBy="admin")
	private List<ModelTetrimino>tetrimino;
}
