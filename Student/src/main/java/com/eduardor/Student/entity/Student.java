package com.eduardor.Student.entity;


import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Student {
	
	private @Id @GeneratedValue Long id;
    private String name;
    private double gpa;
    private String gender;
    
    Student(){}
    
    public Student(String name, double gpa, String gender) {
    	
    this.name = name;
    this.gpa = gpa;
    this.gender = gender;
    }
    
    public Long getId() {
        return this.id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
	
    public String getName() {
		return name;
	}
	
    public void setName(String name) {
		this.name = name;
	}
	
    public String getGender() {
		return gender;
	}
	
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	public double getGpa() {
		return gpa;
	}
	
	public void setGpa(double gpa) {
		this.gpa = gpa;
	}
	 @Override
	  public boolean equals(Object o) {

	    if (this == o)
	      return true;
	    if (!(o instanceof Student))
	      return false;
	    Student student = (Student) o;
	    return Objects.equals(this.id, student.id) && Objects.equals(this.name, student.name)&& Objects.equals(this.gpa, student.gpa)
	        && Objects.equals(this.gender, student.gender);
	  }

	  @Override
	  public int hashCode() {
	    return Objects.hash(this.id, this.name, this.gender, this.gpa);
	}
	  
	  @Override
	  public String toString() {
	        return "Student [id=" + id + ",name=" + name + ",gpa=" + gpa + ",gender="
	                + gender + "]";
	}
}
