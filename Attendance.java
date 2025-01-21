package com.student_attendance.attendance.attendancesheet;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Size;

@Entity
public class Attendance {
	
	public Attendance() {
		
	}

	public Attendance(String branch, int rollno, String name, LocalDate date, boolean present) {
		super();
		this.branch = branch;
		this.rollno = rollno;
		this.name = name;
		this.date = date;
		this.present = present;
	}
	private String branch;
	@Id
	@GeneratedValue
	private int rollno;
	
	@Size(min = 2, message = "Enter name with surname ! ")
	private String name;
	private LocalDate date;
	private boolean present;
	
	public String getBranch() {
		return branch;
	}
	public void setBranch(String branch) {
		this.branch = branch;
	}
	public int getRollno() {
		return rollno;
	}
	public void setRollno(int rollno) {
		this.rollno = rollno;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public boolean isPresent() {
		return present;
	}
	public void setDone(boolean present) {
		this.present = present;
	}
	@Override
	public String toString() {
		return "Attendance [branch=" + branch + ", rollno=" + rollno + ", name=" + name + ", date=" + date + ", present="
				+ present + "]";
	}
	
	
}
