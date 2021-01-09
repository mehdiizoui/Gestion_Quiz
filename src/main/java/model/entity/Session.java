package model.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the session database table.
 * 
 */
@Entity
@NamedQuery(name="Session.findAll", query="SELECT s FROM Session s")
public class Session implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int sessionID;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dateCreation;

	//bi-directional many-to-one association to Reponse
	@OneToMany(mappedBy="session")
	private List<Reponse> reponses;

	//bi-directional many-to-one association to Membre
	@ManyToOne
	@JoinColumn(name="membreID")
	private Membre membre;

	//bi-directional many-to-one association to Quiz
	@ManyToOne
	@JoinColumn(name="quizID")
	private Quiz quiz;

	//bi-directional one-to-one association to Sessionnote
	@OneToOne(mappedBy="session")
	private Sessionnote sessionnote;

	public Session() {
	}

	public int getSessionID() {
		return this.sessionID;
	}

	public void setSessionID(int sessionID) {
		this.sessionID = sessionID;
	}

	public Date getDateCreation() {
		return this.dateCreation;
	}

	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}

	public List<Reponse> getReponses() {
		return this.reponses;
	}

	public void setReponses(List<Reponse> reponses) {
		this.reponses = reponses;
	}

	public Reponse addRepons(Reponse repons) {
		getReponses().add(repons);
		repons.setSession(this);

		return repons;
	}

	public Reponse removeRepons(Reponse repons) {
		getReponses().remove(repons);
		repons.setSession(null);

		return repons;
	}

	public Membre getMembre() {
		return this.membre;
	}

	public void setMembre(Membre membre) {
		this.membre = membre;
	}

	public Quiz getQuiz() {
		return this.quiz;
	}

	public void setQuiz(Quiz quiz) {
		this.quiz = quiz;
	}

	public Sessionnote getSessionnote() {
		return this.sessionnote;
	}

	public void setSessionnote(Sessionnote sessionnote) {
		this.sessionnote = sessionnote;
	}

}