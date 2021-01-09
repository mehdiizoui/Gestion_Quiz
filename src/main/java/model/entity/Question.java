package model.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the question database table.
 * 
 */
@Entity
@NamedQuery(name="Question.findAll", query="SELECT q FROM Question q")
public class Question implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int questionID;

	private String libelle;

	private String qt1;

	private String qt2;

	private String qt3;

	private String qt4;

	private int reponse;

	//bi-directional many-to-one association to Quiz
	@ManyToOne
	@JoinColumn(name="quizID")
	private Quiz quiz;

	//bi-directional many-to-one association to Reponse
	@OneToMany(mappedBy="question")
	private List<Reponse> reponses;

	public Question() {
	}

	public int getQuestionID() {
		return this.questionID;
	}

	public void setQuestionID(int questionID) {
		this.questionID = questionID;
	}

	public String getLibelle() {
		return this.libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public String getQt1() {
		return this.qt1;
	}

	public void setQt1(String qt1) {
		this.qt1 = qt1;
	}

	public String getQt2() {
		return this.qt2;
	}

	public void setQt2(String qt2) {
		this.qt2 = qt2;
	}

	public String getQt3() {
		return this.qt3;
	}

	public void setQt3(String qt3) {
		this.qt3 = qt3;
	}

	public String getQt4() {
		return this.qt4;
	}

	public void setQt4(String qt4) {
		this.qt4 = qt4;
	}

	public int getReponse() {
		return this.reponse;
	}

	public void setReponse(int reponse) {
		this.reponse = reponse;
	}

	public Quiz getQuiz() {
		return this.quiz;
	}

	public void setQuiz(Quiz quiz) {
		this.quiz = quiz;
	}

	public List<Reponse> getReponses() {
		return this.reponses;
	}

	public void setReponses(List<Reponse> reponses) {
		this.reponses = reponses;
	}

	public Reponse addRepons(Reponse repons) {
		getReponses().add(repons);
		repons.setQuestion(this);

		return repons;
	}

	public Reponse removeRepons(Reponse repons) {
		getReponses().remove(repons);
		repons.setQuestion(null);

		return repons;
	}

}