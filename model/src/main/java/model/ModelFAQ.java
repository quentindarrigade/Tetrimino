package model;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;


@Entity
@Table(name = "faq")
@Cacheable
@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
public class ModelFAQ {
	@Override
	public String toString() {
		return "ModelFAQ [id=" + id + ", questions=" + questions + ", reponses=" + reponses + "]";
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "FAQ_ID")
	private int id;
	
	@Column(name = "FAQ_QUE")
	@NotEmpty(message = "Tu as oublié de rentrer la question!!")
	@Size(max=50)
	private String questions;
	
	@Column(name = "FAQ_REP")
	@NotEmpty(message = "Ba alors? Y'a pas de réponses?")
	private String reponses;
	
	@ManyToOne
	@JoinColumn(name="FAQ_ADMIN_ID")
	private ModelAdmin admin;

	public ModelFAQ() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getQuestions() {
		return questions;
	}

	public void setQuestions(String questions) {
		this.questions = questions;
	}

	public String getReponses() {
		return reponses;
	}

	public void setReponses(String reponses) {
		this.reponses = reponses;
	}

	public ModelAdmin getAdmin() {
		return admin;
	}

	public void setAdmin(ModelAdmin admin) {
		this.admin = admin;
	}


	
	
	
	

}
