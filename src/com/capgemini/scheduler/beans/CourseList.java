package com.capgemini.scheduler.beans;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

//Bean Entity Class which represents the table structure from which data is to be fetched

@Entity
@Table(name="ScheduledSessions") //name of the table from which data is fetched
public class CourseList {
@Id
int id; 						 //Primary Key Involved in the table 
String name;
int duration;
String faculty;
String mode1;
//Getters and Setters for the members variables of the bean entity class
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
public int getDuration() {
	return duration;
}
public void setDuration(int duration) {
	this.duration = duration;
}
public String getFaculty() {
	return faculty;
}
public void setFaculty(String faculty) {
	this.faculty = faculty;
}
public String getMode1() {
	return mode1;
}
public void setMode1(String mode1) {
	this.mode1 = mode1;
}

}
