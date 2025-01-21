package com.student_attendance.attendance.attendancesheet;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Service;

import jakarta.validation.Valid;

@Service
public class AttendanceService {
	
	private static int count=0;

	private static List<Attendance> attedances=new ArrayList<>();
	static {
		attedances.add(new Attendance("cst", ++count, "Biswajit Sahoo", LocalDate.now().plusYears(0), true));
		attedances.add(new Attendance("cst", ++count, "Sahil Deo", LocalDate.now().plusYears(0), true));
		attedances.add(new Attendance("cst", ++count, "Mangaraj Das", LocalDate.now().plusYears(0), true));
	}
	 List<Attendance> findByBranch(String branch) {
		 Predicate<? super Attendance> predicate=attendance ->attendance.getBranch().equalsIgnoreCase(branch);
		return attedances.stream().filter(predicate).toList();
	}
	 public void addstudents(String name,String branch,LocalDate date,boolean done) {
		 Attendance attendance=new Attendance(branch, ++count, name, date, done);
		 attedances.add(attendance);
	 }
	 public void absentByrollno(int rollno) {
		 Predicate<? super Attendance> predicate=attendance ->attendance.getRollno()==rollno;
		attedances.removeIf(predicate);
	 }
	public Attendance findByrollno(int rollno) {
		 Predicate<? super Attendance> predicate=attendance ->attendance.getRollno()==rollno;
		 Attendance attendance = attedances.stream().filter(predicate).findFirst().get();
		return attendance;
	}
	public void updatestudents(@Valid Attendance attendance) {
		absentByrollno(attendance.getRollno());
		attedances.add(attendance);
		
	}
}
