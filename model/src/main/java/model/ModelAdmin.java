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

	@OneToMany(mappedBy = "admin")
	private List<ModelTetrimino> tetrimino;

	@OneToMany(mappedBy = "admin")
	private List<ModelFAQ> faq;

	public ModelAdmin() {
		super();
	}

	public List<ModelTetrimino> getTetrimino() {
		return tetrimino;
	}

	public void setTetrimino(List<ModelTetrimino> tetrimino) {
		this.tetrimino = tetrimino;
	}

	public List<ModelFAQ> getFaq() {
		return faq;
	}

	public void setFaq(List<ModelFAQ> faq) {
		this.faq = faq;
	}
	

}
