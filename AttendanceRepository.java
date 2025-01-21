package com.student_attendance.attendance.attendancesheet;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AttendanceRepository extends JpaRepository<Attendance, Integer>{

	public List<Attendance>findByBranch(String branch); 
}
