package model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.Table;

@Entity
@Table(name = "utilisateur")
@Inheritance //(strategy = InheritanceType.JOINED)
public class ModelUtilisateur implements Serializable  {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "UTI_ID")
	private int id;
	
	@Column(name = "UTI_LOG")
	private String login;
	
	@Column(name = "UTI_PSW")
	private String password;

	public ModelUtilisateur() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
