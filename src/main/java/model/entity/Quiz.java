package model.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the quiz database table.
 * 
 */
@Entity
@NamedQuery(name="Quiz.findAll", query="SELECT q FROM Quiz q")
public class Quiz implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int quizid;

	private String libelle;

	private int membreID;

	private String typequiz;

	//bi-directional many-to-one association to Question
	@OneToMany(mappedBy="quiz")
	private List<Question> questions;

	//bi-directional many-to-one association to Session
	@OneToMany(mappedBy="quiz")
	private List<Session> sessions;

	public Quiz() {
	}

	public int getQuizid() {
		return this.quizid;
	}

	public void setQuizid(int quizid) {
		this.quizid = quizid;
	}

	public String getLibelle() {
		return this.libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public int getMembreID() {
		return this.membreID;
	}

	public void setMembreID(int membreID) {
		this.membreID = membreID;
	}

	public String getTypequiz() {
		return this.typequiz;
	}

	public void setTypequiz(String typequiz) {
		this.typequiz = typequiz;
	}

	public List<Question> getQuestions() {
		return this.questions;
	}

	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}

	public Question addQuestion(Question question) {
		getQuestions().add(question);
		question.setQuiz(this);

		return question;
	}

	public Question removeQuestion(Question question) {
		getQuestions().remove(question);
		question.setQuiz(null);

		return question;
	}

	public List<Session> getSessions() {
		return this.sessions;
	}

	public void setSessions(List<Session> sessions) {
		this.sessions = sessions;
	}

	public Session addSession(Session session) {
		getSessions().add(session);
		session.setQuiz(this);

		return session;
	}

	public Session removeSession(Session session) {
		getSessions().remove(session);
		session.setQuiz(null);

		return session;
	}

}