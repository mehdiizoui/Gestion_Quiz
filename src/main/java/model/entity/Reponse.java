package model.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the reponse database table.
 * 
 */
@Entity
@NamedQuery(name="Reponse.findAll", query="SELECT r FROM Reponse r")
public class Reponse implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int reponseID;

	private byte valide;

	//bi-directional many-to-one association to Question
	@ManyToOne
	@JoinColumn(name="questionID")
	private Question question;

	//bi-directional many-to-one association to Session
	@ManyToOne
	@JoinColumn(name="sessionID")
	private Session session;

	public Reponse() {
	}

	public int getReponseID() {
		return this.reponseID;
	}

	public void setReponseID(int reponseID) {
		this.reponseID = reponseID;
	}

	public byte getValide() {
		return this.valide;
	}

	public void setValide(byte valide) {
		this.valide = valide;
	}

	public Question getQuestion() {
		return this.question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

	public Session getSession() {
		return this.session;
	}

	public void setSession(Session session) {
		this.session = session;
	}

}