package model.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the membre database table.
 * 
 */
@Entity
@NamedQuery(name="Membre.findAll", query="SELECT m FROM Membre m")
public class Membre implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int membreID;

	@Temporal(TemporalType.DATE)
	private Date dateNaissance;

	private String email;

	private String nom;

	private String passwordm;

	private String prenom;

	//bi-directional many-to-one association to Session
	@OneToMany(mappedBy="membre")
	private List<Session> sessions;

	public Membre() {
	}

	public int getMembreID() {
		return this.membreID;
	}

	public void setMembreID(int membreID) {
		this.membreID = membreID;
	}

	public Date getDateNaissance() {
		return this.dateNaissance;
	}

	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPasswordm() {
		return this.passwordm;
	}

	public void setPasswordm(String passwordm) {
		this.passwordm = passwordm;
	}

	public String getPrenom() {
		return this.prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public List<Session> getSessions() {
		return this.sessions;
	}

	public void setSessions(List<Session> sessions) {
		this.sessions = sessions;
	}

	public Session addSession(Session session) {
		getSessions().add(session);
		session.setMembre(this);

		return session;
	}

	public Session removeSession(Session session) {
		getSessions().remove(session);
		session.setMembre(null);

		return session;
	}

}