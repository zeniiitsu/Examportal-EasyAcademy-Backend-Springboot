/**
 * 
 */
package com.exam.examportal.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

import java.util.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author Bhavesh
 *
 */

@Entity
public class Quiz {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long qid;
	private String title;
	private String description;
	private String maxMarks;
	private String numberOfQuestions;
	private boolean active = false;
	
	@ManyToOne(fetch = FetchType.EAGER)
	private Category category;
	
	@OneToMany(mappedBy="quiz", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JsonIgnore
	private Set<Question> questions= new HashSet<>();
	
	/**
	 * @param title
	 * @param description
	 * @param maxMarks
	 * @param numberOfQuestions
	 * @param active
	 */
	public Quiz(String title, String description, String maxMarks, String numberOfQuestions, boolean active) {
		super();
		this.title = title;
		this.description = description;
		this.maxMarks = maxMarks;
		this.numberOfQuestions = numberOfQuestions;
		this.active = active;
	}
	/**
	 * @return the qid
	 */
	public Long getQid() {
		return qid;
	}
	/**
	 * @param qid the qid to set
	 */
	public void setQid(Long qid) {
		this.qid = qid;
	}
	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	/**
	 * @return the maxMarks
	 */
	public String getMaxMarks() {
		return maxMarks;
	}
	/**
	 * @param maxMarks the maxMarks to set
	 */
	public void setMaxMarks(String maxMarks) {
		this.maxMarks = maxMarks;
	}
	/**
	 * @return the numberOfQuestions
	 */
	public String getNumberOfQuestions() {
		return numberOfQuestions;
	}
	/**
	 * @param numberOfQuestions the numberOfQuestions to set
	 */
	public void setNumberOfQuestions(String numberOfQuestions) {
		this.numberOfQuestions = numberOfQuestions;
	}
	/**
	 * @return the active
	 */
	public boolean isActive() {
		return active;
	}
	/**
	 * @param active the active to set
	 */
	public void setActive(boolean active) {
		this.active = active;
	}
	
	
	
	/**
	 * @return the questions
	 */
	public Set<Question> getQuestions() {
		return questions;
	}
	/**
	 * @param questions the questions to set
	 */
	public void setQuestions(Set<Question> questions) {
		this.questions = questions;
	}
	/**
	 * 
	 */
	public Quiz() {
		super();
	}
	/**
	 * @return the category
	 */
	public Category getCategory() {
		return category;
	}
	/**
	 * @param category the category to set
	 */
	public void setCategory(Category category) {
		this.category = category;
	}
	@Override
	public String toString() {
		return "Quiz [qid=" + qid + ", title=" + title + ", description=" + description + ", maxMarks=" + maxMarks
				+ ", numberOfQuestions=" + numberOfQuestions + ", active=" + active + "]";
	}
	
	
	

}
