package model.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the sessionnote database table.
 * 
 */
@Entity
@NamedQuery(name="Sessionnote.findAll", query="SELECT s FROM Sessionnote s")
public class Sessionnote implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int sessionID;

	private double note;

	//bi-directional one-to-one association to Session
	@OneToOne
	@JoinColumn(name="sessionID")
	private Session session;

	public Sessionnote() {
	}

	public int getSessionID() {
		return this.sessionID;
	}

	public void setSessionID(int sessionID) {
		this.sessionID = sessionID;
	}

	public double getNote() {
		return this.note;
	}

	public void setNote(double note) {
		this.note = note;
	}

	public Session getSession() {
		return this.session;
	}

	public void setSession(Session session) {
		this.session = session;
	}

}