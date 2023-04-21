package com.systemsaberpro.app.entity;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection="ratings")
public class Ratings {
	@Id
	private String id;
	private int totalScore;
	private int writtenCommunication;
	private int quantitativeReasoning;
	private int criticalReading;
	private int citizenCompetences;
	private int english;
	private int math;
	private int softwareDesign;
	private String studentId;
	
	public Ratings() {}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getTotalScore() {
		return totalScore;
	}
	public void setTotalScore(int totalScore) {
		this.totalScore = totalScore;
	}
	public int getWrittenCommunication() {
		return writtenCommunication;
	}
	public void setWrittenCommunication(int writtenCommunication) {
		this.writtenCommunication = writtenCommunication;
	}
	public int getQuantitativeReasoning() {
		return quantitativeReasoning;
	}
	public void setQuantitativeReasoning(int quantitativeReasoning) {
		this.quantitativeReasoning = quantitativeReasoning;
	}
	public int getCriticalReading() {
		return criticalReading;
	}
	public void setCriticalReading(int criticalReading) {
		this.criticalReading = criticalReading;
	}
	public int getCitizenCompetences() {
		return citizenCompetences;
	}
	public void setCitizenCompetences(int citizenCompetences) {
		this.citizenCompetences = citizenCompetences;
	}
	public int getEnglish() {
		return english;
	}
	public void setEnglish(int english) {
		this.english = english;
	}
	public int getMath() {
		return math;
	}
	public void setMath(int math) {
		this.math = math;
	}
	public int getSoftwareDesign() {
		return softwareDesign;
	}
	public void setSoftwareDesign(int softwareDesign) {
		this.softwareDesign = softwareDesign;
	}

	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	
	
}
