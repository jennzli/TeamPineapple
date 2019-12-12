package com.neha.bean;

import java.io.Serializable;
import java.sql.Timestamp;

public class SurveyPO implements Serializable {

	
	private int id;
	private String name;
	private String department;
	private String description;
	private String restriction;
	private String urlLinks;
	private String owner;
	private Timestamp datecreated;


	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getRestriction() {
		return restriction;
	}
	public void setRestriction(String restriction) {
		this.restriction = restriction;
	}
	public String getUrlLinks() {
		return urlLinks;
	}
	public void setUrlLinks(String urlLinks) {
		this.urlLinks = urlLinks;
	}
	
	public String getOwner() {
		return owner;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}
	public Timestamp getDatecreated() {
		return datecreated;
	}
	public void setDatecreated(Timestamp datecreated) {
		this.datecreated = datecreated;
	}
	@Override
	public String toString() {
		return "SurveyPO [id=" + id + ", name=" + name + ", department=" + department + ", description=" + description
				+ ", restriction=" + restriction + ", urlLinks=" + urlLinks + ", owner=" + owner + ", datecreated="
				+ datecreated + "]";
	}
	
	
	
	

}
